package io.lambdacloud.util;

import io.lambdacloud.BytecodeSupport;

public class ObjectArray {
	public Object[][] data;

	public ObjectArray() {
		
	}
	
	public ObjectArray(int m, int n) {
		data = new Object[m][n];
	}

	public ObjectArray(Object[][] data) {
		this.data = data;
	}
	
	/**
	 * 
	 * @param data
	 * @param n - number of columns
	 */
	public ObjectArray(Object[] data, int n) {
		int m = data.length/n;
		this.data = new Object[m][n];
		int idx=0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				this.data[i][j] = data[idx++];
			}
		}
	}

	public Object get(int m, int n) {
		return data[m][n];
	}
	
	public ObjectArray getAsObjectArray(int m, int n) {
		return new ObjectArray(new Object[][] {{data[m][n]}});
	}
	
	public ObjectArray set(int m, int n, Object v) {
		data[m][n] = v;
		return this;
	}

	public ObjectArray getAs1DArray(int start, int end) {
		Object[][] d = this.to1DArray().data;
		int N = end - start;
		Object[][] rlt = new Object[1][N];
		for(int i=0; i<N; i++) {
			rlt[0][i] = d[0][start+i];
		}
		return new ObjectArray(rlt);
	}
	
	public ObjectArray setAs1DArray(int start, int end, Object v) {
		Object[] d = this.getColumnPackedCopy();
		int N = end - start + 1;
		for(int i=0; i<N; i++) {
			d[start+i] = v;
		}
		ObjectArray rlt = new ObjectArray(d, this.getColumnDimension());
		this.data = rlt.data;
		return this;
	}
	
	public ObjectArray setAs1DArray(int start, int end, ObjectArray ary) {
		Object[] d = this.getColumnPackedCopy();
		Object[] d2 = ary.getColumnPackedCopy();
		int N = end - start + 1;
		for(int i=0; i<N; i++) {
			d[start+i] = d2[i];
		}
		ObjectArray rlt = new ObjectArray(d, this.getColumnDimension());
		this.data = rlt.data;
		return this;
	}

	public Object get(int idx) {
		int m = data.length;
		int n = 0;
		if (data.length > 0)
			n = data[0].length;

		if (m == 1) {
			return get(0, idx);
		} else if (n == 1) {
			return get(idx, 0);
		} else {
			return get(idx % m, idx / m);
		}
	}
	
	public ObjectArray getAsObjectArray(int idx) {
		return new ObjectArray(new Object[][]{{get(idx)}});
	}

	public ObjectArray set(int idx, ObjectArray v) {
		return set(idx, (Object)v);
	}
	
	public ObjectArray set(int idx, Object v) {
		if(data == null) {
			Object[] newData = new Object[idx+1];
			newData[idx] = v;
			ObjectArray newAry = ObjectArray.newObjectArray(newData);
			data = newAry.data;
		} else if(this.getRowDimension()*this.getColumnDimension() <= idx) {
			Object[] newData = new Object[idx+1];
			System.arraycopy(this.getColumnPackedCopy(), 0, newData, 0, data.length);
			newData[idx] = v;
			ObjectArray newAry = ObjectArray.newObjectArray(newData);
			data = newAry.data;
		}
		int m = data.length;
		int n = 0;
		if (data.length > 0)
			n = data[0].length;

		if (m == 1) {
			return set(0, idx, v);
		} else if (n == 1) {
			return set(idx, 0, v);
		} else {
			return set(idx % m, idx / m, v);
		}
	}

	public ObjectArray get(int ms, int me, int ns, int ne) {
		int row = me - ms + 1;
		int col = ne - ns + 1;
		Object[][] rlt = new Object[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				rlt[i][j] = data[ms + i][ns + j];
			}
		return new ObjectArray(rlt);
	}

	public ObjectArray set(int ms, int me, int ns, int ne, Object v) {
		int row = me - ms + 1;
		int col = ne - ns + 1;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				data[ms + i][ns + j] = v;
			}
		return this;
	}
	
	public ObjectArray set(int ms, int me, int ns, int ne, ObjectArray ary) {
		int row = me - ms + 1;
		int col = ne - ns + 1;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				data[ms + i][ns + j] = ary.data[i][j];
			}
		return this;
	}

	public ObjectArray get(int ms, int me, int ns, int ne, ObjectArray ary) {
		int row = me - ms + 1;
		int col = ne - ns + 1;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				data[ms + i][ns + j] = ary.data[i][j];
			}
		return this;
	}

	
	public ObjectArray get(int ms, int me, int[] aryn) {
		int row = me - ms + 1;
		int col = aryn.length;
		Object[][] rlt = new Object[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				rlt[i][j] = data[ms + i][aryn[j]];
			}
		return new ObjectArray(rlt);
	}

	public ObjectArray set(int ms, int me, int[] aryn, ObjectArray ary) {
		int row = me - ms + 1;
		int col = aryn.length;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				data[ms + i][aryn[j]] = ary.data[i][j];
			}
		return this;
	}

	public ObjectArray get(int[] arym, int ns, int ne) {
		int row = arym.length;
		int col = ne - ns + 1;
		Object[][] rlt = new Object[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				rlt[i][j] = data[arym[i]][ns + j];
			}
		return new ObjectArray(rlt);
	}

	public ObjectArray set(int[] arym, int ns, int ne, ObjectArray ary) {
		int row = arym.length;
		int col = ne - ns + 1;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				data[arym[i]][ns + j] = ary.data[i][j];
			}
		return this;
	}

	public ObjectArray get(int[] arym, int[] aryn) {
		int row = arym.length;
		int col = aryn.length;
		Object[][] rlt = new Object[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				rlt[i][j] = data[arym[i]][aryn[j]];
			}
		}
		return new ObjectArray(rlt);
	}

	public ObjectArray set(int[] arym, int[] aryn, Object v) {
		int row = arym.length;
		int col = aryn.length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[arym[i]][aryn[j]] = v;
			}
		}
		return this;
	}

	public ObjectArray set(int[] arym, int[] aryn, ObjectArray ary) {
		int row = arym.length;
		int col = aryn.length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[arym[i]][aryn[j]] = ary.data[i][j];
			}
		}
		return this;
	}
	
	public ObjectArray get(int[] arym, int[] aryn, ObjectArray ary) {
		int row = arym.length;
		int col = aryn.length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[arym[i]][aryn[j]] = ary.data[i][j];
			}
		}
		return this;
	}

	public ObjectArray to1DArray() {
		int m = this.getRowDimension();
		int n = this.getColumnDimension();
		int N = m*n;
		int idx = 0;
		Object[][] rlt = new Object[1][N];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				rlt[0][idx++] = this.data[i][j];
			}
		}
		return new ObjectArray(rlt);
	}

	public ObjectArray set(Jama.Matrix idx, Object v) {
		int nRow=getRowDimension();
		for(int i=idx.getRowDimension()-1; i>=0; i--) {
			for(int j=idx.getColumnDimension()-1; j>=0; j--) {
				int index = ((int)idx.get(i, j))-1;
				set(index%nRow, index/nRow, v);
			}
		}
		return this;
	}
	
	public ObjectArray set(Jama.Matrix idx, ObjectArray ary) {
		//auto increment of the size of the array
		if(null == data) {
			data = new Object[idx.getRowDimension()][idx.getColumnDimension()]; //TODO???
		}
		int nRow=getRowDimension();
		if(ary.getRowDimension() == 1 && ary.getColumnDimension() == 1) {
			for(int i=idx.getRowDimension()-1; i>=0; i--) {
				for(int j=idx.getColumnDimension()-1; j>=0; j--) {
					int index = ((int)idx.get(i, j))-1;
					set(index%nRow, index/nRow, ary.data[0][0]);
				}
			}
		} else {
			for(int i=idx.getRowDimension()-1; i>=0; i--) {
				for(int j=idx.getColumnDimension()-1; j>=0; j--) {
					int index = ((int)idx.get(i, j))-1;
					set(index%nRow, index/nRow, ary.data[i][j]);
				}
			}
		}
		return this;
	}
	
	public int getRowDimension() {
		return data.length;
	}

	public int getColumnDimension() {
		if (data.length == 0)
			return 0;
		return data[0].length;
	}

	/**
	 * Return a ObjectArray that composed of the given array of 
	 * ObjectArray (like sub-matrix) and the the number of rows of 
	 * the sub-ObjectArray.
	 * For example: 
	 * {A B C} => AA=[A,B,C], nRow=1
	 * {A; B; C} => AA=[A,B,C], nRow=3
	 * {A B; C D} => AA=[A,B,C,D], nRow=2
	 * 
	 * @param AA
	 * @param nRow
	 * @return
	 */
	public static ObjectArray getObjectArray(ObjectArray[] AA, int nRow) {
		int nCol = AA.length / nRow;
		int M = 0; // rows
		int N = 0; // columns
		for (int row = 0; row < nRow; row++) {
			M += AA[row * nCol].getRowDimension();
		}
		for (int col = 0; col < nCol; col++) {
			N += AA[col].getColumnDimension();
		}

		Object[][] data = new Object[M][N];

		int curRow = 0, curCol = 0;
		for (int row = 0; row < nRow; row++) {
			curCol = 0;
			for (int col = 0; col < nCol; col++) {
				ObjectArray m = AA[row * nCol + col];
				int mRow = m.getRowDimension();
				int mCol = m.getColumnDimension();
				for (int i = 0; i < mRow; i++) {
					for (int j = 0; j < mCol; j++) {
						data[curRow + i][curCol + j] = m.get(i, j);
					}
				}
				curCol += AA[col].getColumnDimension();
			}
			curRow += AA[row * nCol].getRowDimension();
		}

		return new ObjectArray(data);
	}

	/**
	 * Initialize a cell with syntax like 
	 * {A,B,C;D}
	 * The element will be converted as the parameters 
	 * AA={A,B,C,D} 
	 * nCols={3,1}
	 * 
	 * @param AA
	 * @param nCols
	 * @return
	 */
	public static ObjectArray getObjectArray(ObjectArray[] AA, int[] nCols) {
		int nIdx = 0;
		ObjectArray[] blockRows = new ObjectArray[nCols.length];
		for (int i = 0; i < nCols.length; i++) {
			ObjectArray[] blockRow = new ObjectArray[nCols[i]];
			for (int j = 0; j < nCols[i]; j++) {
				blockRow[j] = AA[nIdx++];
			}
			blockRows[i] = getObjectArray(blockRow, 1);
		}
		return getObjectArray(blockRows, nCols.length);
	}

	public ObjectArray get(Jama.Matrix Idx) {
		Object[][] dataA = this.to1DArray().data;
		double[] dataIdx = Idx.getColumnPackedCopy();
		Object[][] ret = new Object[1][dataIdx.length];
		for(int i=0; i<dataIdx.length; i++) {
			ret[0][i] = dataA[0][(int)dataIdx[i]-1];
		}
		return new ObjectArray(ret);
	}
	
	public Object[] getColumnPackedCopy() {
		int m = this.getRowDimension();
		int n = this.getColumnDimension();
		int N = m*n;
		int idx = 0;
		Object[] rlt = new Object[N];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				rlt[idx++] = this.data[i][j];
			}
		}
		return rlt;
	}
	
	public ObjectArray reshape(int m, int n) {
		ObjectArray r = new ObjectArray(getColumnPackedCopy(), m);
		return r;
	}
	
	public ObjectArray repmat(int n) {
		return repmat(n,n);
	}
	
	public ObjectArray repmat(int m, int n) {
		Object[] newData = new Object[getRowDimension()*getColumnDimension()*m*n];
		int destPos = 0;
		for(int k=0; k<n; k++) {
			for(int j=0; j<data.length; j++) {
				for(int i=0; i<m; i++) {
					System.arraycopy(data[j], 0, newData, destPos, data[j].length);
					destPos += data[j].length;
				}
			}
		}
		return new ObjectArray(newData, getRowDimension()*m);
	}
	public static int numel(ObjectArray m) {
		return m.getRowDimension()*m.getColumnDimension();
	}
	
//	public static void main(String[] args) {
//		Object o = "abc";
//		System.out.println(o.getClass().getName());
//		String s = (String)o;
//	}
	
	
	public CSList getCSList() {
		return new CSList(this.getColumnPackedCopy());
	}
	
	public static ObjectArray newObjectArray(Object[] objects) {
		ObjectArray ary = new ObjectArray(1, objects.length);
		ary.data = new Object[1][];
		ary.data[0] = objects;
		return ary;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int  m = this.getRowDimension();
		int n = this.getColumnDimension();
		sb.append("{\n");
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				sb.append(data[i][j].toString()).append(" ");
			}
			sb.append("\n");
		}
		sb.append("}");
		return sb.toString();
	}
}
