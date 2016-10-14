package io.lambdacloud.util;

public class ObjectArray {
	public Object[][] data;

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

	public Object get(int idx) {
		int m = data.length;
		int n = 0;
		if (data.length > 0)
			n = data[0].length;

		if (m == 1) {
			return get(0, n);
		} else if (n == 1) {
			return get(n, 0);
		} else {
			return get(idx % m, idx / m);
		}
	}

	public ObjectArray get(int ms, int me, int ns, int ne) {
		int row = me - ms;
		int col = ne - ns;
		Object[][] rlt = new Object[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				rlt[i][j] = data[ms + i][ns + j];
			}
		return new ObjectArray(rlt);
	}

	public ObjectArray get(int ms, int me, int[] aryn) {
		int row = me - ms;
		int col = aryn.length;
		Object[][] rlt = new Object[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				rlt[i][j] = data[ms + i][aryn[j]];
			}
		return new ObjectArray(rlt);
	}

	public ObjectArray get(int[] arym, int ns, int ne) {
		int row = arym.length;
		int col = ne - ns;
		Object[][] rlt = new Object[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				rlt[i][j] = data[arym[i]][ns + j];
			}
		return new ObjectArray(rlt);
	}

	public ObjectArray get(int[] arym, int[] aryn) {
		int row = arym.length;
		int col = aryn.length;
		Object[][] rlt = new Object[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				rlt[i][j] = data[arym[i]][aryn[j]];
			}
		return new ObjectArray(rlt);
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
}
