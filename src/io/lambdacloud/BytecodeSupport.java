package io.lambdacloud;

import java.util.ArrayList;
import java.util.List;

public class BytecodeSupport {
	public static String getMyName() {
		return BytecodeSupport.class.getName().replaceAll("\\.", "/");
	}
	
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void print(String o) {
		System.out.print(o);
	}
	public static void print(int o) {
		System.out.print(o);
	}
	public static void print(double o) {
		System.out.print(o);
	}
	public static void print(long o) {
		System.out.print(o);
	}
	public static void print(boolean o) {
		System.out.print(o);
	}
	public static void print() {
	}
	
	
	//------------------
	public static void println() {
		//DO Nothing
	}
	
	public static Object println(Object o) {
		if(o instanceof double[]) {
			double[] a = (double[])o;
			System.out.print("[");
			for(double d : a)
				System.out.print(d+", ");
			System.out.println("]");
		} else if(o instanceof int[]) {
			int[] a = (int[])o;
			System.out.print("[");
			for(int d : a)
				System.out.print(d+", ");
			System.out.println("]");
		} else if(o instanceof Jama.Matrix) {
			((Jama.Matrix)o).print(8, 2);
		}
		else {
			System.out.println(o);
		}
		return o;
	}

	public static Jama.Matrix println(Jama.Matrix o) {
		if(null != o) {
			o.print(8, 2);
		}
		return o;
	}
	
	public static Jama.Matrix[] println(Jama.Matrix[] o) {
		System.out.print("[");
		for(Jama.Matrix m : o) {
			if(null != m) {
				m.print(8, 2);
			}
		}
		System.out.print("]");
		return o;
	}
	
	public static String println(String o) {
		System.out.println(o);
		return o;
	}
	public static int println(int o) {
		System.out.println(o);
		return o;
	}
	
	public static int[] println(int[] o) {
		System.out.print("array: [");
		for(int d : o)
			System.out.print(d+" ");
		System.out.println("]");
		return o;
	}
	
	public static long println(long o) {
		System.out.println(o);
		return o;
	}
	public static double println(double o) {
		System.out.println(o);
		return o;
	}

	public static double[] println(double[] o) {
		System.out.print("array: [");
		for(double d : o)
			System.out.print(d+" ");
		System.out.println("]");
		return o;
	}

	public static boolean println(boolean o) {
		System.out.println(o);
		return o;
	}
	
	public static void print(String format, Object ...params) {
		//TODO
	}
	
	//-----------------------
	public static int[] range(int s, int shift) {
		int[] ret = new int[s];
		for(int i=0; i<s; i++) {
			ret[i] = i-shift;
		}
		return ret;
	}
	
	//[s,e)
	public static int[] range(int s, int e, int shift) {
		int[] ret = new int[e-s];
		for(int i=s; i<e; i++) {
			ret[i-s] = i-shift;
		}
		return ret;
	}

	//[s : step : e)
	public static int[] range(int s, int step, int e, int shift) {
		int n = (e-s)/step;
		int rem = (e-s)%step;
		n = (rem==0) ? n : n+1;

		int[] ret = new int[n];
		for(int i=0; i<n; i++, s+=step) {
			ret[i] = s-shift;
		}
		return ret;
	}
	
	//[s,e]
	public static int[] range2(int s, int e, int shift) {
		int[] ret = new int[e-s+1];
		for(int i=s; i<=e; i++) {
			ret[i-s] = i-shift;
		}
		return ret;
	}

	//[s : step : e]
	public static int[] range2(int s, int step, int e, int shift) {
		int n = 1 + (e-s)/step;
		int[] ret = new int[n];
		for(int i=0; i<n; i++, s+=step) {
			ret[i] = s-shift;
		}
		return ret;
	}
	
	public static double[] range(double s, double step, double e, int shift) {
		List<Double> ret = new ArrayList<Double>();
		if(s <= e) {
			for(double i=s; i<=e; i+=step) {
				ret.add(i-shift);
			}
		} else {
			for(double i=s; i>=e; i+=step) {
				ret.add(i-shift);
			}
		}
		
		double[] dret = new double[ret.size()];
		for(int i=0; i<ret.size(); i++)
			dret[i] = ret.get(i);
		return dret;
	}
	
	public static double[] range2(double s, double step, double e, int shift) {
		return range(s, step, e, shift);
	}
	public static double[] range2(double s, double e, int shift) {
		if(s <= e)
			return range(s, 1.0, e, shift);
		else
			return range(s, -1.0, e, shift);
	}
	
	public static int sum(int[] args) {
		int  ret = 0;
		for(int i : args) {
			ret+=i;
		}
		return ret;
	}
	public static double sum(List<?> args) {
		double ret = 0.0;
		if(null == args || args.size() == 0)
			return ret;
		Object e = args.get(0);
		if(e instanceof Double) {
			for(Object i : args) {
				ret += (Double)i;
			}
		} else if(e instanceof Integer) {
			for(Object i : args) {
				ret += (Integer)i;
			}
		} else {
			throw new RuntimeException("type error in sum");
		}
		return ret;
	}
	
	public static int len(List<?> l) {
		return l.size();
	}
	
	public static double pow(double base, double pow) {
		return Math.pow(base, pow);
	}
	public static double pow(double base, int pow) {
		return Math.pow(base, pow);
	}
	public static double pow(int base, double pow) {
		return Math.pow(base, pow);
	}
	public static int pow(int base, int pow) {
		return (int)Math.pow(base, pow);
	}
	////////////////////////////////////////
	
	public static void setMatrix(Jama.Matrix A, int[] r, int[] c, double v) {
		Jama.Matrix t = new Jama.Matrix(r.length, c.length, v);
		A.setMatrix(r, c, t);
	}
	public static void setMatrix(Jama.Matrix A, int[] r, int j0, int j1, double v) {
		Jama.Matrix t = new Jama.Matrix(r.length, j1-j0+1, v);
		A.setMatrix(r, j0, j1, t);
	}
	public static void setMatrix(Jama.Matrix A, int i0, int i1, int[] c, double v) {
		Jama.Matrix t = new Jama.Matrix(i1-i0+1, c.length, v);
		A.setMatrix(i0, i1, c, t);
	}
	public static void setMatrix(Jama.Matrix A, int i0, int i1, int j0, int j1, double v) {
		Jama.Matrix t = new Jama.Matrix(i1-i0+1, j1-j0+1, v);
		A.setMatrix(i0, i1, j0, j1, t);
	}
	
	
	//////////
	public static double zeros() {
		return 0.0;
	}
	public static Jama.Matrix zeros(int m, int n) {
		return new Jama.Matrix(m,n,0.0);
	}
	public static Jama.Matrix zeros(int n) {
		return new Jama.Matrix(n,n,0.0);
	}
	public static Jama.Matrix zeros(Jama.Matrix A) {
		return new Jama.Matrix(A.getRowDimension(),A.getColumnDimension(),0.0);
	}
	
	public static double ones() {
		return 1.0;
	}
	public static Jama.Matrix ones(int m, int n) {
		return new Jama.Matrix(m,n,1.0);
	}
	public static Jama.Matrix ones(int n) {
		return new Jama.Matrix(n,n,1.0);
	}
	public static Jama.Matrix ones(Jama.Matrix A) {
		return new Jama.Matrix(A.getRowDimension(),A.getColumnDimension(),1.0);
	}
	public static Jama.Matrix eye(int m, int n) {
		Jama.Matrix r = new Jama.Matrix(m,n,0.0);
		int min = m>n?n:m;
		for(int i=0;i<min;i++)
			r.set(i, i, 1.0);
		return r;
	}
	public static Jama.Matrix eye(int  n) {
		Jama.Matrix r = new Jama.Matrix(n,n,0.0);
		for(int i=0;i<n;i++)
			r.set(i, i, 1.0);
		return r;
	}
	/**
	 * A(:)
	 * @param m
	 * @return
	 */
	public static Jama.Matrix matToVec(Jama.Matrix m) {
		double []data = m.getColumnPackedCopy();
		Jama.Matrix r = new Jama.Matrix(data, data.length);
		return r;
	}
	public static Jama.Matrix size(Jama.Matrix m) {
		Jama.Matrix r = new Jama.Matrix(new double[]{m.getRowDimension(), m.getColumnDimension()},2).transpose();
		return r;
	}
	public static Jama.Matrix size(double a) {
		Jama.Matrix r = new Jama.Matrix(new double[]{1},1).transpose();
		return r;
	}
	public static int length(Jama.Matrix m) {
		return Math.max(m.getRowDimension(), m.getColumnDimension());
	}
	public static int numel(Jama.Matrix m) {
		return m.getRowDimension()*m.getColumnDimension();
	}
	public static Jama.Matrix reshape(Jama.Matrix A, int m, int n) {
		Jama.Matrix r = new Jama.Matrix(A.getColumnPackedCopy(), m);
		return r;
	}
	public static Jama.Matrix repmat(Jama.Matrix A, int n) {
		return repmat(A,n,n);
	}
	public static Jama.Matrix repmat(Jama.Matrix A, int m, int n) {
		double[][] data = A.transpose().getArray();
		double[] newData = new double[A.getRowDimension()*A.getColumnDimension()*m*n];
		int destPos = 0;
		for(int k=0; k<n; k++) {
			for(int j=0; j<data.length; j++) {
				for(int i=0; i<m; i++) {
					System.arraycopy(data[j], 0, newData, destPos, data[j].length);
					destPos += data[j].length;
				}
			}
		}
		return new Jama.Matrix(newData, A.getRowDimension()*m);
	}
	
	public static Jama.Matrix full(Jama.Matrix A) {
		return A;
	}
	
	/**
	 * exp(A)
	 * @param A
	 * @return
	 */
	public static Jama.Matrix exp(Jama.Matrix A) {
		double[][] data = A.getArrayCopy();
		for(int i=data.length; i>=0; i--) {
			for(int j=data[i].length-1; j>=0; j--)
				data[i][j] = Math.exp(data[i][j]);
		}
		return new Jama.Matrix(data);
	}
	/**
	 * Ruby syntax
	 * exp!(A)
	 * 
	 * @param A
	 * @return
	 */
	public static Jama.Matrix exp_(Jama.Matrix A) {
		double[][] data = A.getArray();
		for(int i=data.length; i>=0; i--) {
			for(int j=data[i].length-1; j>=0; j--)
				data[i][j] = Math.exp(data[i][j]);
		}
		return A;
	}
	
	public static boolean isempty(Jama.Matrix A) {
		if(A.getRowDimension()*A.getColumnDimension() == 0) return true;
		else return false;
	}
	
	public static Jama.Matrix rand(int m, int n) {
		return Jama.Matrix.random(m, n);
	}
	public static Jama.Matrix rand(int n) {
		return Jama.Matrix.random(n, n);
	}
	public static Jama.Matrix linspace(int d1, int d2, int n) {
		double[] data = range2((double)d1, (double)n, (double)d2, 0);
		Jama.Matrix r = new Jama.Matrix(data, data.length);
		return r.transpose();
	}
	public static Jama.Matrix linspace(int d1, int d2, double n) {
		double[] data = range2((double)d1, (double)n, (double)d2, 0);
		Jama.Matrix r = new Jama.Matrix(data, data.length);
		return r.transpose();
	}
	
	public static Jama.Matrix plus(Jama.Matrix A, double d) {
		Jama.Matrix r = new Jama.Matrix(A.getRowDimension(), A.getColumnDimension(), d);
		return A.plus(r);
	}
	public static Jama.Matrix minus(Jama.Matrix A, double d) {
		Jama.Matrix r = new Jama.Matrix(A.getRowDimension(), A.getColumnDimension(), d);
		return A.minus(r);
	}
	public static Jama.Matrix times(Jama.Matrix A, double d) {
		return A.times(d);
	}
	public static Jama.Matrix rem(Jama.Matrix A, Jama.Matrix B) {
		double[][] r = new double[A.getRowDimension()][A.getColumnDimension()];
		for(int i=r.length-1; i>=0; i--)
			for(int j=r[0].length-1; j>=0; j--) {
				r[i][j] = A.get(i, j)%B.get(i, j);
			}
		return new Jama.Matrix(r);
	}
	public static Jama.Matrix rem(Jama.Matrix A, double d) {
		double[][] r = new double[A.getRowDimension()][A.getColumnDimension()];
		for(int i=r.length-1; i>=0; i--)
			for(int j=r[0].length-1; j>=0; j--) {
				r[i][j] = A.get(i, j)%d;
			}
		return new Jama.Matrix(r);
	}
	public static Jama.Matrix rem(double d, Jama.Matrix A) {
		double[][] r = new double[A.getRowDimension()][A.getColumnDimension()];
		for(int i=r.length-1; i>=0; i--)
			for(int j=r[0].length-1; j>=0; j--) {
				r[i][j] = d%A.get(i, j);
			}
		return new Jama.Matrix(r);
	}
	public static double triu(double a) {
		return 0;
	}
	public static Jama.Matrix eye(double a) {
		return eye((int)a);
	}
	public static Jama.Matrix zeros(double a) {
		return zeros((int)a);
	}
	public static Jama.Matrix triu(Jama.Matrix A) {
		double[][] data = A.getArrayCopy();
		int n = A.getRowDimension();
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				data[i][j] = 0;
			}
		}
		return new Jama.Matrix(data);
	}
	
	public static void disp(String s) {
		System.out.println(s);
	}
	
	//////////////////////
	
	public static double floor(double x) {
		return Math.floor(x);
	}
	public static double ceil(double x) {
		return Math.ceil(x);
	}
	public static long round(double x) {
		return Math.round(x);
	}
	public static double fix(double x) {
		if(x > 0)
			return Math.floor(x);
		else
			return Math.ceil(x);
	}
	public static double rem(double x, double y) {
		if(y == 0.0) return Double.NaN;;
		return x % y;
	}
	public static double mod(double x, double y) {
		if(y == 0.0) return x;
		return x % y;
	}
	public static double mod(int x, int y) {
		if(y == 0.0) return x;
		return x % y;
	}
	public static double mod(double x, int y) {
		if(y == 0.0) return x;
		return x % y;
	}
	public static double mod(int x, double y) {
		if(y == 0.0) return x;
		return x % y;
	}
	
	/**
%               @plus           Plus
%               @minus          Minus
%               @times          Array multiply
%               @rdivide        Right array divide
%               @ldivide        Left array divide
%               @power          Array power
%               @max            Binary maximum
%               @min            Binary minimum
%               @rem            Remainder after division
%               @mod            Modulus after division
%               @atan2	        Four-quadrant inverse tangent; result in radians
%               @atan2d	        Four-quadrant inverse tangent; result in dgrees
%               @hypot	        Square root of sum of squares
%               @eq             Equal
%               @ne             Not equal
%               @lt             Less than
%               @le             Less than or equal
%               @gt             Greater than
%               @ge             Greater than or equal
%               @and            Element-wise logical AND
%               @or             Element-wise logical OR
%               @xor            Logical EXCLUSIVE OR
	 * @param funcHandle
	 * @param a
	 * @param b
	 * @return
	 */
	public static Jama.Matrix bsxfun(String funcHandle, Jama.Matrix a, Jama.Matrix b) {
		if(funcHandle.equals("plus")) {
			if(a.getRowDimension() == b.getRowDimension() && a.getColumnDimension() == b.getColumnDimension())
				return a.plus(b);
			else {
				int maxRow = Math.max(a.getRowDimension(), b.getRowDimension());
				int minRow = Math.min(a.getRowDimension(), b.getRowDimension());
				
				int maxCol = Math.max(a.getColumnDimension(), b.getColumnDimension());
				int minCol = Math.min(a.getColumnDimension(), b.getColumnDimension());
				
				int repRow = maxRow/minRow;
				int repCol = maxCol/minCol;
				
				if(a.getRowDimension() == minRow) {
					a = repmat(a, repRow, 1);
				}
				if(b.getRowDimension() == minRow) {
					b = repmat(b, repRow, 1);
				}
				if(a.getColumnDimension() == minRow) {
					a = repmat(a, 1, repCol);
				}
				if(b.getColumnDimension() == minRow) {
					b = repmat(b, 1, repCol);
				}
				return a.plus(b);
			}
				
		}else if(funcHandle.equals("minus")) {
			return a.minus(b);
		}else if(funcHandle.equals("times")) {
			return a.times(b);
		}else if(funcHandle.equals("rdivide")) {
			return a.plus(b);
		}else if(funcHandle.equals("ldivide")) {
			return a.plus(b);
		}else if(funcHandle.equals("max")) {
			return a.plus(b);
		}else if(funcHandle.equals("min")) {
			return a.plus(b);
		}else if(funcHandle.equals("rem")) {
			return a.plus(b);
		}else if(funcHandle.equals("mod")) {
			return a.plus(b);
		}else if(funcHandle.equals("atan2")) {
			return a.plus(b);
		}else if(funcHandle.equals("hypot")) {
			return a.plus(b);
		}else if(funcHandle.equals("eq")) {
			return a.plus(b);
		}else if(funcHandle.equals("ne")) {
			return a.plus(b);
		}else if(funcHandle.equals("lt")) {
			return a.plus(b);
		}else if(funcHandle.equals("le")) {
			return a.plus(b);
		}else if(funcHandle.equals("gt")) {
			return a.plus(b);
		}else if(funcHandle.equals("ge")) {
			return a.plus(b);
		}else if(funcHandle.equals("and")) {
			return a.plus(b);
		}else if(funcHandle.equals("or")) {
			return a.plus(b);
		}else if(funcHandle.equals("xor")) {
			return a.plus(b);
		}else{
			throw new UnsupportedOperationException();
		}
	}

	public static boolean isnumeric(Jama.Matrix m) {
		return true;
	}
	public static boolean isnumeric(double d) {
		return true;
	}
	public static boolean isnumeric(int d) {
		return true;
	}
	public static boolean isnumeric(long d) {
		return true;
	}
	public static boolean isnumeric(String s) {
		return false;
	}
	
	public static void error(String s) {
		System.err.println(s);
	}
	
	public static String message(String s) {
		return "Message: "+s;
	}
	
	public static void warning(String s) {
		System.out.println(s);
	}
	
	public static double conj(double d) {
		return d;
	}
	public static long conj(long d) {
		return d;
	}
	public static int conj(int  d) {
		return d;
	}
	public static Jama.Matrix conj(Jama.Matrix d) {
		return d;
	}
	//ISEQUALN True if arrays are numerically equal, treating NaNs as equal.
	public static boolean isequaln(double a, double b) {
		if(Math.abs(a-b) < 1e-6) return true;
		return false;
	}
	public static boolean isequaln(Jama.Matrix a, Jama.Matrix b) {
		if(a.minus(b).norm2() <= 1e-6) return true;
		return false;
	}
	
	public static int[] convert(Jama.Matrix m) {
		double[] ary = m.getColumnPackedCopy();
		return convert(ary);
	}
	public static int[] convert(double[] ary) {
		int[] r = new int[ary.length];
		for(int i=0; i<ary.length; i++) {
			r[i] = (int)ary[i];
		}
		return r;
	}
	
	public static Jama.Matrix getMatrix(Jama.Matrix A, Jama.Matrix Idx) {
		double[] dataA = A.getColumnPackedCopy();
		double[] dataIdx = Idx.getColumnPackedCopy();
		double[] ret = new double[dataIdx.length];
		for(int i=0; i<ret.length; i++) {
			ret[i] = dataA[(int)dataIdx[i]-1];
		}
		return new Jama.Matrix(ret, Idx.getRowDimension());
	}
	//A(B)=C
	public static Jama.Matrix setMatrix(Jama.Matrix A, Jama.Matrix Idx, Jama.Matrix C) {
		int m=A.getRowDimension();
		for(int i=0; i<Idx.getRowDimension(); i++) {
			for(int j=0; j<Idx.getColumnDimension(); j++) {
				int index = ((int)Idx.get(i, j))-1;
				A.set(index%m, index/m, C.get(i, j));
			}
		}
		return A;
	}
	//A(B)=c
	public static Jama.Matrix setMatrix(Jama.Matrix A, Jama.Matrix Idx, double c) {
		int m=A.getRowDimension();
		for(int i=Idx.getRowDimension()-1; i>=0; i--) {
			for(int j=Idx.getColumnDimension()-1; j>=0; j--) {
				int index = ((int)Idx.get(i, j))-1;
				A.set(index%m, index/m, c);
			}
		}
		return A;
	}	
	public static Jama.Matrix getMatrix(Jama.Matrix[] AA, int nRow) {
		int nCol = AA.length/nRow;
		int M=0; //rows
		int N=0; //columns
		for(int row=0; row<nRow; row++) {
			M += AA[row*nCol].getRowDimension();
		}
		for(int col=0; col<nCol; col++) {
			N += AA[col].getColumnDimension();
		}
		
		double[][] data = new double[M][N];
		
		int curRow = 0, curCol = 0;
		for(int row=0; row<nRow; row++) {
			curCol = 0;
			for(int col=0; col<nCol; col++) {
				Jama.Matrix m = AA[row*nCol+col];
				int mRow = m.getRowDimension();
				int mCol = m.getColumnDimension();
				for(int i=0; i<mRow; i++) {
					for(int j=0; j<mCol; j++) {
						data[curRow+i][curCol+j] = m.get(i, j);
					}
				}
				curCol += AA[col].getColumnDimension();
			}
			curRow += AA[row*nCol].getRowDimension();
		}
		
		return new Jama.Matrix(data);
	}
	
	public static void main(String[] args) {
		Jama.Matrix a11 = new Jama.Matrix(new double[][]{{1, 2},{3, 4}});
		Jama.Matrix a12 = new Jama.Matrix(new double[][]{{5, 6},{7, 8},{9, 10}}).transpose();
		Jama.Matrix a21 = new Jama.Matrix(new double[][]{{10, 20},{30, 40}});
		Jama.Matrix a22 = new Jama.Matrix(new double[][]{{50, 60},{70, 80},{90, 100}}).transpose();
		Jama.Matrix a31 = new Jama.Matrix(new double[][]{{100, 200},{300, 400}});
		Jama.Matrix a32 = new Jama.Matrix(new double[][]{{500, 600},{700, 800},{900, 1000}}).transpose();
		Jama.Matrix[] AA = new Jama.Matrix[]{a11,a12,a21,a22,a31,a32};
		getMatrix(AA,3).print(8, 2);
		
	}
	
	public static boolean isrow(Jama.Matrix m) {
		if(m.getRowDimension() == 1)
			return true;
		else
			return false;
	}
	
	public static double getElement(Jama.Matrix A, int n) {
		if(A.getRowDimension() == 1) {
			return A.get(0, n);
		} else if(A.getColumnDimension() == 1){
			return A.get(n, 0);
		} else {
			return A.get(n/A.getColumnDimension(), n%A.getColumnDimension());
		}
	}
	public static void setElement(Jama.Matrix A, int n, double val) {
		if(A.getRowDimension() == 1) {
			A.set(0, n, val);
		} else if(A.getColumnDimension() == 1){
			A.set(n, 0, val);
		} else {
			A.set(n/A.getColumnDimension(), n%A.getColumnDimension(), val);
		}
	}
	public static Jama.Matrix getMatrix(Jama.Matrix A, int s, int e) {
		double[] ret = new double[e-s];
		int idx = 0;
		for(int i=s; i<e; i++) {
			ret[idx++] = getElement(A, i);
		}
		return new Jama.Matrix(ret, ret.length);
	}

}
