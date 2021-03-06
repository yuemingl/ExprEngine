package io.lambdacloud;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import io.lambdacloud.node.FuncDefNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.node.matrix.MatrixAccessNode;
import io.lambdacloud.util.CSList;
import io.lambdacloud.util.LogicalArray;
import io.lambdacloud.util.ObjectArray;
import io.lambdacloud.util.Struct;

public class BytecodeSupport {
	public static String getMyName() {
		return BytecodeSupport.class.getName().replaceAll("\\.", "/");
	}
	
	public static double sin(double d) {
		return Math.sin(d);
	}
	
	public static void print(Object o) {
		if(o instanceof double[]) {
			double[] a = (double[])o;
			System.out.print("[");
			for(double d : a)
				System.out.print(d+", ");
			System.out.print("]");
		} else if(o instanceof int[]) {
			int[] a = (int[])o;
			System.out.print("[");
			for(int d : a)
				System.out.print(d+", ");
			System.out.print("]");
		} else if(o instanceof Jama.Matrix) {
			((Jama.Matrix)o).print(8, 2);
		} else {
			System.out.print(o);
		}
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
	
	public static void println2(Object o) {
		System.out.println(o);
	}
	
	public static CSList println(CSList o) {
		System.out.println(o.toString());
		return o;
	}
	
	public static LogicalArray println(LogicalArray o) {
		if(null != o) {
			int  m = o.getRowDimension();
			int n = o.getColumnDimension();
			System.out.println("[");
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					System.out.print( (((Boolean)o.data[i][j]).booleanValue()?1:0)+" ");
				}
				System.out.println();
			}
			System.out.println("]");
		} else {
			System.out.println("null (LogicalArray)");
		}
		return o;
	}
	
	public static Object[] println(Object[] ary) {
		System.out.println("[");
		for(Object o : ary) {
			System.out.println(o);
		}
		System.out.println("]");
		return ary;
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
		} else {
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

	public static ObjectArray println(ObjectArray o) {
		if(null != o) {
			int  m = o.getRowDimension();
			int n = o.getColumnDimension();
			System.out.println("{");
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					print((Object)o.data[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
			System.out.println("}");
		} else {
			System.out.println("null (ObjectArray)");
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
	public static Struct println(Struct o) {
		System.out.println(o.toString());
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
	public static Jama.Matrix pow(Jama.Matrix base, Jama.Matrix pow) {
		double[][] data = new double[base.getRowDimension()][base.getColumnDimension()];
		for(int i=0; i<data.length; i++)
			for(int j=0; j<data[0].length; j++)
				data[i][j] = Math.pow(base.get(i, j), pow.get(i, j));
		return new Jama.Matrix(data);
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
		if(A.getRowDimension() <= i1 || A.getColumnDimension() <= j1) {
			Jama.Matrix newA = new Jama.Matrix(i1+1,j1+1);
			if(A.getRowDimension() > 0 && A.getColumnDimension() > 0)
				newA.setMatrix(0, A.getRowDimension()-1, 0, A.getColumnDimension()-1, A);
			A.setMatrix(newA);
		}
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
	public static Jama.Matrix zeros(int m, int n, String typename) {
		return new Jama.Matrix(m,n,0.0);
	}
	public static Jama.Matrix zeros(int n) {
		return new Jama.Matrix(n,n,0.0);
	}
	public static Jama.Matrix zeros(double a) {
		return zeros((int)a);
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
		Jama.Matrix r = new Jama.Matrix(new double[][]{{1},{1}}).transpose();
		return r;
	}
	public static Jama.Matrix size(int a) {
		Jama.Matrix r = new Jama.Matrix(new double[][]{{1},{1}}).transpose();
		return r;
	}
	public static Jama.Matrix size(long a) {
		Jama.Matrix r = new Jama.Matrix(new double[][]{{1},{1}}).transpose();
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
	public static Jama.Matrix linspace(int d1, int d2) {
		return linspace(d1,d2,100);
	}
	public static Jama.Matrix linspace(int d1, int d2, int n) {
		double[] data = range2((double)d1, (double)(d2-d1)/n, (double)d2, 0);
		Jama.Matrix r = new Jama.Matrix(data, data.length);
		return r.transpose();
	}
	public static Jama.Matrix linspace(int d1, int d2, double n) {
		return linspace(d1,d2,(int)n);
	}
	
	public static Jama.Matrix plus(Jama.Matrix A, double d) {
		Jama.Matrix r = new Jama.Matrix(A.getRowDimension(), A.getColumnDimension(), d);
		return A.plus(r);
	}
	public static Jama.Matrix plus(double d, Jama.Matrix A) {
		Jama.Matrix r = new Jama.Matrix(A.getRowDimension(), A.getColumnDimension(), d);
		return A.plus(r);
	}
	public static Jama.Matrix minus(Jama.Matrix A, double d) {
		Jama.Matrix r = new Jama.Matrix(A.getRowDimension(), A.getColumnDimension(), d);
		return A.minus(r);
	}
	public static Jama.Matrix minus(double d, Jama.Matrix A) {
		Jama.Matrix r = new Jama.Matrix(A.getRowDimension(), A.getColumnDimension(), d);
		return r.minus(A);
	}
	public static Jama.Matrix times(Jama.Matrix A, double d) {
		return A.times(d);
	}
	public static Jama.Matrix times(double d, Jama.Matrix A) {
		return A.times(d);
	}
	public static Object div(Jama.Matrix a, double b) {
		return a.times(1.0/b);
	}
	public static Object div(double a, Jama.Matrix b) {
		return b.inverse().times(a);
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
	public static int[] convert_m1(Jama.Matrix m) {
		double[] ary = m.getColumnPackedCopy();
		return convert_m1(ary);
	}
	public static int[] convert(double[] ary) {
		int[] r = new int[ary.length];
		for(int i=0; i<ary.length; i++) {
			r[i] = (int)ary[i];
		}
		return r;
	}
	public static int[] convert_m1(double[] ary) {
		int[] r = new int[ary.length];
		for(int i=0; i<ary.length; i++) {
			r[i] = (int)ary[i]-1;
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
		return new Jama.Matrix(ret, ret.length);
	}
	
	public static Jama.Matrix getMatrix(Jama.Matrix A, CSList args) {
		Object[] data = args.getData();
		if(data.length == 2) {
			int[] rows = null;
			int[] cols = null;
			if(data[0] instanceof String && ":".equalsIgnoreCase((String)data[0])) {
				rows = Tools.getIndex(0, A.getRowDimension()-1);
			} else if(data[0] instanceof Number) {
				Number num = (Number)data[0];
				rows = new int[] { num.intValue() };
			} else if(data[0] instanceof Jama.Matrix) {
				rows = Tools.matrix2index((Jama.Matrix)data[0]);
			} else {
				throw new RuntimeException("unknown args: "+data[0]);
			}
			if(data[1] instanceof String && ":".equalsIgnoreCase((String)data[1])) {
				cols = Tools.getIndex(0, A.getColumnDimension()-1);
			} else if(data[1] instanceof Number) {
				Number num = (Number)data[1];
				cols = new int[] { num.intValue() };
			} else if(data[1] instanceof Jama.Matrix) {
				cols = Tools.matrix2index((Jama.Matrix)data[1]);
			} else {
				throw new RuntimeException("unknown args: "+data[1]);
			}
			return A.getMatrix(rows, cols);
		}
		return A;
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
	//A(s:e)=C
	public static Jama.Matrix setMatrix(Jama.Matrix A, int start, int end, Jama.Matrix C) {
		double[] data = C.getColumnPackedCopy();
		int idx = start;
		int nRow = A.getRowDimension();
		for(int i=0; i<data.length; i++) {
			A.set(idx%nRow, idx/nRow, data[i]);
			idx++;
		}
		return A;
	}
	//A(B)=c
	public static Jama.Matrix setMatrix(Jama.Matrix A, Jama.Matrix idxA, double c) {
		int nRow=A.getRowDimension();
		for(int i=idxA.getRowDimension()-1; i>=0; i--) {
			for(int j=idxA.getColumnDimension()-1; j>=0; j--) {
				int index = ((int)idxA.get(i, j))-1;
				A.set(index%nRow, index/nRow, c);
			}
		}
		return A;
	}
	
	/**
	 * Return a matrix that composed of the given array of matrix (sub-matrix) and 
	 * the the number of rows of the sub-matrix
	 * for example:
	 * [A B C]
	 * [A; B; C]
	 * [A B; C D]
	 * [A B; C] ???
	 * @param AA
	 * @param nRow
	 * @return
	 */
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
	
	/**
	 * For example:
	 * [A,B,C;D]
	 *   AA=[A,B,C,D]
	 *   nCols=[3,1]
	 * @param AA
	 * @param nCols 
	 * @return
	 */
	public static Jama.Matrix getMatrix(Jama.Matrix[] AA, int[] nCols) {
		int nIdx = 0;
		Jama.Matrix[] blockRows = new Jama.Matrix[nCols.length];
		for(int i=0; i<nCols.length; i++) {
			Jama.Matrix[] blockRow = new Jama.Matrix[nCols[i]];
			for(int j=0; j<nCols[i]; j++) {
				blockRow[j] = AA[nIdx++];
			}
			blockRows[i] = getMatrix(blockRow, 1);
		}
		return getMatrix(blockRows, nCols.length);
	}
	
	public static void main(String[] args) {
		Jama.Matrix a11 = new Jama.Matrix(new double[][]{{1, 2},{3, 4}});
		Jama.Matrix a12 = new Jama.Matrix(new double[][]{{5, 6},{7, 8},{9, 10}}).transpose();
		Jama.Matrix a21 = new Jama.Matrix(new double[][]{{10, 20},{30, 40}});
		Jama.Matrix a22 = new Jama.Matrix(new double[][]{{50, 60},{70, 80},{90, 100}}).transpose();
		Jama.Matrix a31 = new Jama.Matrix(new double[][]{{100, 200},{300, 400}});
		Jama.Matrix a32 = new Jama.Matrix(new double[][]{{500, 600},{700, 800},{900, 1000}}).transpose();
		Jama.Matrix[] AA = new Jama.Matrix[]{a11,a12,a21,a22,a31,a32};
		Jama.Matrix rlt1 = getMatrix(AA,3);
		rlt1.print(8, 2);
		
		Jama.Matrix[] BB = new Jama.Matrix[]{a11,a12,rlt1};
		Jama.Matrix rlt2 = getMatrix(BB, new int[]{2,1});
		rlt2.print(8, 2);
		
	}
	
	public static boolean isrow(Jama.Matrix m) {
		if(m.getRowDimension() == 1)
			return true;
		else
			return false;
	}
	
	public static double getElement(Jama.Matrix A, int n) {
		int nRow = A.getRowDimension();
		if(nRow == 1) {
			return A.get(0, n);
		} else if(A.getColumnDimension() == 1){
			return A.get(n, 0);
		} else {
			return A.get(n%nRow, n/nRow);
		}
	}
	
	public static void setElement(Jama.Matrix A, int n, double val) {
		if(A.getRowDimension() == 1) {
			A.set(0, n, val);
		} else if(A.getColumnDimension() == 1){
			A.set(n, 0, val);
		} else {
			A.set(n%A.getRowDimension(), n/A.getRowDimension(), val);
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
	
	public static Jama.Matrix horzcat(Jama.Matrix A, Jama.Matrix B) {
		if(A.getRowDimension() != B.getRowDimension())
			throw new RuntimeException("Dimensions of matrices being concatenated are not consistent.");
		double[] dataA = A.getColumnPackedCopy();
		double[] dataB = B.getColumnPackedCopy();
		double[] data = new double[dataA.length+dataB.length];
		System.arraycopy(dataA, 0, data, 0, dataA.length);
		System.arraycopy(dataB, 0, data, dataA.length, dataB.length);
		return new Jama.Matrix(data, A.getRowDimension());
	}
	
	public static Jama.Matrix vertcat(Jama.Matrix A, Jama.Matrix B) {
		if(A.getColumnDimension() != B.getColumnDimension())
			throw new RuntimeException("Dimensions of matrices being concatenated are not consistent.");
		double[][] dataA = A.getArray();
		double[][] dataB = B.getArray();
		double[][] data = new double[A.getRowDimension()+B.getRowDimension()][A.getColumnDimension()];
		int idx = 0;
		for(int i=0;i<dataA.length;i++)
			System.arraycopy(dataA[i], 0, data[idx++], 0, A.getColumnDimension());
		for(int i=0;i<dataB.length;i++)
			System.arraycopy(dataB[i], 0, data[idx++], 0, A.getColumnDimension());
		
		return new Jama.Matrix(data);
	}
	
	public static Jama.Matrix size(ObjectArray m) {
		Jama.Matrix r = new Jama.Matrix(new double[]{m.getRowDimension(), m.getColumnDimension()},2).transpose();
		return r;
	}
	public static int length(ObjectArray m) {
		return Math.max(m.getRowDimension(), m.getColumnDimension());
	}
	public static int numel(ObjectArray m) {
		return m.getRowDimension()*m.getColumnDimension();
	}
	
	public static Struct struct(Object key, Object val) {
		Struct s = new Struct();
		s.put(key, val);
		return s;
	}
	
	public static int object2int(Object o) {
		Integer i = (Integer)o;
		return i.intValue();
	}
	public static double object2double(Object o) {
		Double i = (Double)o;
		return i.doubleValue();
	}
	public static long object2long(Object o) {
		Long i = (Long)o;
		return i.longValue();
	}
	public static boolean object2boolean(Object o) {
		Boolean i = (Boolean)o;
		return i.booleanValue();
	}
	
	//////////////////////
	public static Object plus(Object a, Object b) {
		if(a instanceof String && b instanceof String) {
			return ((String)a)+((String)b);
		} else if(a instanceof Number && b instanceof Number) {
			return ((Number)a).doubleValue()+((Number)b).doubleValue();
			
		} else if(a instanceof Jama.Matrix && b instanceof Jama.Matrix) {
			return ((Jama.Matrix)a).plus((Jama.Matrix)b);
		} else if(a instanceof Jama.Matrix && b instanceof Number) {
			return plus((Jama.Matrix)a, ((Number)b).doubleValue());
		} else if(a instanceof Number && b instanceof Jama.Matrix) {
			return plus(((Number)a).doubleValue(),(Jama.Matrix)b);
		
		} else
			return null;
	}
	public static Object minus(Object a, Object b) {
		if(a instanceof Number && b instanceof Number) {
			return ((Number)a).doubleValue()-((Number)b).doubleValue();
			
		} else if(a instanceof Jama.Matrix && b instanceof Jama.Matrix) {
			return ((Jama.Matrix)a).minus((Jama.Matrix)b);
		} else if(a instanceof Jama.Matrix && b instanceof Number) {
			return minus((Jama.Matrix)a, ((Number)b).doubleValue());
		} else if(a instanceof Number && b instanceof Jama.Matrix) {
			return minus(((Number)a).doubleValue(),(Jama.Matrix)b);
		
		} else
			return null;
	}
	public static Object times(Object a, Object b) {
		if(a instanceof Number && b instanceof Number) {
			return ((Number)a).doubleValue()*((Number)b).doubleValue();
			
		} else if(a instanceof Jama.Matrix && b instanceof Jama.Matrix) {
			return ((Jama.Matrix)a).times((Jama.Matrix)b);
		} else if(a instanceof Jama.Matrix && b instanceof Number) {
			return times((Jama.Matrix)a, ((Number)b).doubleValue());
		} else if(a instanceof Number && b instanceof Jama.Matrix) {
			return times(((Number)a).doubleValue(),(Jama.Matrix)b);
		
		} else
			return null;
	}
	
	public static Object div(Object a, Object b) {
		if(a instanceof Number && b instanceof Number) {
			return ((Number)a).doubleValue()/((Number)b).doubleValue();
		} else if(a instanceof Jama.Matrix && b instanceof Jama.Matrix) {
			return ((Jama.Matrix)a).solve((Jama.Matrix)b);
		} else if(a instanceof Jama.Matrix && b instanceof Number) {
			return times((Jama.Matrix)a, 1.0/((Number)b).doubleValue());
		} else if(a instanceof Number && b instanceof Jama.Matrix) {
			return ((Jama.Matrix)b).inverse().times(((Number)a).doubleValue());
		
		} else
			return null;
	}
		
	public static Jama.Matrix inv(Jama.Matrix m) {
		return m.inverse();
	}
	public static Jama.Matrix sum(Jama.Matrix m) {
		double[] rlt = new double[m.getColumnDimension()];
		for(int i=0; i<m.getRowDimension(); i++) {
			for(int j=0; j<m.getColumnDimension(); j++) {
				rlt[j] += m.get(i, j); 
			}
		}
		return new Jama.Matrix(rlt, 1);
	}
	
	public static Jama.Matrix sum(Jama.Matrix m, int dim) {
		if(dim == 1) return sum(m);
		double[] rlt = new double[m.getRowDimension()];
		for(int i=0; i<m.getColumnDimension(); i++) {
			for(int j=0; j<m.getRowDimension(); j++) {
				rlt[j] += m.get(j, i); 
			}
		}
		return new Jama.Matrix(rlt, m.getRowDimension());
	}
	
	public static Jama.Matrix sqrt(Jama.Matrix m) {
		double[][] data = m.getArrayCopy();
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[0].length; j++)
				data[i][j] = Math.sqrt(data[i][j]);
		}
		return new Jama.Matrix(data);
	}
	
	public static boolean ismatrix(Jama.Matrix o) {
		return true;
	}
	public static boolean ismatrix(Object o) {
		if(o instanceof Jama.Matrix)
			return true;
		return false;
	}
	public static boolean isscalar(Object o) {
		if(o instanceof Number || o instanceof String)
			return true;
		return false;
	}
	public static boolean isscalar(int o) {
		return true;
	}
	public static boolean isscalar(long o) {
		return true;
	}
	public static boolean isscalar(double o) {
		return true;
	}
	public static boolean isscalar(String o) {
		return true;
	}
	
	public static boolean isvector(Object o) {
		if(o instanceof Jama.Matrix) {
			Jama.Matrix m = (Jama.Matrix)o;
			if(m.getRowDimension()==1 || m.getColumnDimension() == 1)
				return true;
		}
		return false;
	}
	public static boolean isvector(Jama.Matrix o) {
		if(o.getRowDimension()==1 || o.getColumnDimension() == 1)
			return true;
		return false;
	}
	public static boolean isvector(int o) {
		return false;
	}
	public static boolean isvector(long o) {
		return false;
	}
	public static boolean isvector(double o) {
		return false;
	}
	public static boolean isvector(String o) {
		return false;
	}
	
	public static boolean isempty(Object o) {
		if(o instanceof Jama.Matrix) {
			Jama.Matrix m = (Jama.Matrix)o;
			if(m.getRowDimension()==0 || m.getColumnDimension() == 0)
				return true;
		}
		return false;
	}
	public static boolean isempty(int o) {
		return false;
	}
	public static boolean isempty(long o) {
		return false;
	}
	public static boolean isempty(double o) {
		return false;
	}
	public static boolean isempty(String o) {
		return false;
	}

	public static boolean islogical(Object o) {
		if(o instanceof LogicalArray)
			return true;
		return false;
	}
	public static boolean islogical(LogicalArray o) {
		return true;
	}
	public static boolean islogical(int o) {
		return false;
	}
	public static boolean islogical(long o) {
		return false;
	}
	public static boolean islogical(double o) {
		return false;
	}
	public static boolean islogical(String o) {
		return false;
	}
	public static boolean islogical(boolean o) {
		return true;
	}

	
	public static Jama.Matrix diag(Jama.Matrix m) {
		int len = Math.min(m.getRowDimension(), m.getColumnDimension());
		double[] data = new double[len];
		for(int i=0; i<data.length; i++) {
			data[i] = m.get(i, i);
		}
		return new Jama.Matrix(data, data.length);
	}
	
	public static LogicalArray false1(int n) {
		LogicalArray ary = new LogicalArray(new Object[n][n]);
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				ary.data[i][j] = false;
		return ary;
	}
	public static LogicalArray false1(int m, int n) {
		LogicalArray ary = new LogicalArray(new Object[m][n]);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ary.data[i][j] = false;
		return ary;
	}
	public static LogicalArray true1(int n) {
		LogicalArray ary = new LogicalArray(new Object[n][n]);
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				ary.data[i][j] = true;
		return ary;
	}
	public static LogicalArray true1(int m, int n) {
		LogicalArray ary = new LogicalArray(new Object[m][n]);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ary.data[i][j] = true;
		return ary;
	}
	public static int nargin1(String funcName) {
		String className = Tools.getClassName(funcName);
		String methodName = Tools.getMethodName(funcName);
		FuncDefNode fnode = ExprTreeBuildWalker.funcMap.get(methodName);
		if(null == fnode) {
			try {
				if(null == className) className = BytecodeSupport.class.getName();
				Class<?> c = Class.forName(className);
				Method[] ms = c.getDeclaredMethods();
				for(Method m : ms) {
					if(methodName.equals(m.getName()))
						return m.getParameterTypes().length;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return fnode.paramNames.size();
		}
		return 0;
	}

	//----------------------------------------------
	
	public static LogicalArray GT(Jama.Matrix a, double b) {
		int m = a.getRowDimension();
		int n = a.getColumnDimension();
		LogicalArray ret = new LogicalArray(m, n);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ret.data[i][j] = new Boolean(a.get(i, j) > b);
		return ret;
	}
	public static LogicalArray GT(Jama.Matrix a, long b) {
		return GT(a, (double)b);
	}
	public static LogicalArray GT(Jama.Matrix a, int b) {
		return GT(a, (double)b);
	}
	public static LogicalArray GT(double a, Jama.Matrix b) {
		return LE(b, a);
	}
	public static LogicalArray GT(long a, Jama.Matrix b) {
		return LE(b, a);
	}
	public static LogicalArray GT(int a, Jama.Matrix b) {
		return LE(b, a);
	}
	
	public static LogicalArray GT(Jama.Matrix a, Jama.Matrix b) {
		if(a.getRowDimension() != b.getRowDimension())
			throw new RuntimeException("Row dimension mismatch!");
		if(a.getColumnDimension() != b.getColumnDimension())
			throw new RuntimeException("Column dimension mismatch!");
		int m = a.getRowDimension();
		int n = a.getColumnDimension();
		LogicalArray ret = new LogicalArray(m, n);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ret.data[i][j] = new Boolean(a.get(i, j) > b.get(i, j));
		return ret;
	}
	
	
	public static LogicalArray GE(Jama.Matrix a, Jama.Matrix b) {
		if(a.getRowDimension() != b.getRowDimension())
			throw new RuntimeException("Row dimension mismatch!");
		if(a.getColumnDimension() != b.getColumnDimension())
			throw new RuntimeException("Column dimension mismatch!");
		int m = a.getRowDimension();
		int n = a.getColumnDimension();
		LogicalArray ret = new LogicalArray(m, n);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ret.data[i][j] = new Boolean(a.get(i, j) >= b.get(i, j));
		return ret;
	}
	public static LogicalArray GE(Jama.Matrix a, double b) {
		int m = a.getRowDimension();
		int n = a.getColumnDimension();
		LogicalArray ret = new LogicalArray(m, n);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ret.data[i][j] = new Boolean(a.get(i, j) >= b);
		return ret;
	}
	public static LogicalArray GE(Jama.Matrix a, long b) {
		return GE(a, (double)b);
	}
	public static LogicalArray GE(Jama.Matrix a, int b) {
		return GE(a, (double)b);
	}
	public static LogicalArray GE(double a, Jama.Matrix b) {
		return LT(b, a);
	}
	public static LogicalArray GE(long a, Jama.Matrix b) {
		return LT(b, a);
	}
	public static LogicalArray GE(int a, Jama.Matrix b) {
		return LT(b, a);
	}
	
	public static LogicalArray LT(Jama.Matrix a, Jama.Matrix b) {
		if(a.getRowDimension() != b.getRowDimension())
			throw new RuntimeException("Row dimension mismatch!");
		if(a.getColumnDimension() != b.getColumnDimension())
			throw new RuntimeException("Column dimension mismatch!");
		int m = a.getRowDimension();
		int n = a.getColumnDimension();
		LogicalArray ret = new LogicalArray(m, n);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ret.data[i][j] = new Boolean(a.get(i, j) < b.get(i, j));
		return ret;
	}
	public static LogicalArray LT(Jama.Matrix a, double b) {
		int m = a.getRowDimension();
		int n = a.getColumnDimension();
		LogicalArray ret = new LogicalArray(m, n);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ret.data[i][j] = new Boolean(a.get(i, j) < b);
		return ret;
	}
	public static LogicalArray LT(Jama.Matrix a, long b) {
		return LT(a, (double)b);
	}
	public static LogicalArray LT(Jama.Matrix a, int b) {
		return LT(a, (double)b);
	}
	public static LogicalArray LT(double a, Jama.Matrix b) {
		return GE(b, a);
	}
	public static LogicalArray LT(long a, Jama.Matrix b) {
		return GE(b, a);
	}
	public static LogicalArray LT(int a, Jama.Matrix b) {
		return GE(b, a);
	}
	
	public static LogicalArray LE(Jama.Matrix a, Jama.Matrix b) {
		if(a.getRowDimension() != b.getRowDimension())
			throw new RuntimeException("Row dimension mismatch!");
		if(a.getColumnDimension() != b.getColumnDimension())
			throw new RuntimeException("Column dimension mismatch!");
		int m = a.getRowDimension();
		int n = a.getColumnDimension();
		LogicalArray ret = new LogicalArray(m, n);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ret.data[i][j] = new Boolean(a.get(i, j) <= b.get(i, j));
		return ret;
	}
	public static LogicalArray LE(Jama.Matrix a, double b) {
		int m = a.getRowDimension();
		int n = a.getColumnDimension();
		LogicalArray ret = new LogicalArray(m, n);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ret.data[i][j] = new Boolean(a.get(i, j) <= b);
		return ret;
	}
	public static LogicalArray LE(Jama.Matrix a, long b) {
		return LE(a, (double)b);
	}
	public static LogicalArray LE(Jama.Matrix a, int b) {
		return LE(a, (double)b);
	}
	public static LogicalArray LE(double a, Jama.Matrix b) {
		return GT(b, a);
	}
	public static LogicalArray LE(long a, Jama.Matrix b) {
		return GT(b, a);
	}
	public static LogicalArray LE(int a, Jama.Matrix b) {
		return GT(b, a);
	}
	
	public static LogicalArray EQ(Jama.Matrix a, Jama.Matrix b) {
		if(a.getRowDimension() != b.getRowDimension())
			throw new RuntimeException("Row dimension mismatch!");
		if(a.getColumnDimension() != b.getColumnDimension())
			throw new RuntimeException("Column dimension mismatch!");
		int m = a.getRowDimension();
		int n = a.getColumnDimension();
		LogicalArray ret = new LogicalArray(m, n);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ret.data[i][j] = new Boolean(a.get(i, j) == b.get(i, j));
		return ret;
	}
	public static LogicalArray EQ(Jama.Matrix a, double b) {
		int m = a.getRowDimension();
		int n = a.getColumnDimension();
		LogicalArray ret = new LogicalArray(m, n);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ret.data[i][j] = new Boolean(a.get(i, j) == b);
		return ret;
	}
	public static LogicalArray EQ(Jama.Matrix a, long b) {
		return EQ(a, (double)b);
	}
	public static LogicalArray EQ(Jama.Matrix a, int b) {
		return EQ(a, (double)b);
	}
	public static LogicalArray EQ(double a, Jama.Matrix b) {
		return EQ(b, a);
	}
	public static LogicalArray EQ(long a, Jama.Matrix b) {
		return EQ(b, (double)a);
	}
	public static LogicalArray EQ(int a, Jama.Matrix b) {
		return EQ(b, (double)a);
	}
	
	public static LogicalArray NEQ(Jama.Matrix a, Jama.Matrix b) {
		if(a.getRowDimension() != b.getRowDimension())
			throw new RuntimeException("Row dimension mismatch!");
		if(a.getColumnDimension() != b.getColumnDimension())
			throw new RuntimeException("Column dimension mismatch!");
		int m = a.getRowDimension();
		int n = a.getColumnDimension();
		LogicalArray ret = new LogicalArray(m, n);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ret.data[i][j] = new Boolean(a.get(i, j) != b.get(i, j));
		return ret;
	}
	public static LogicalArray NEQ(Jama.Matrix a, double b) {
		int m = a.getRowDimension();
		int n = a.getColumnDimension();
		LogicalArray ret = new LogicalArray(m, n);
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				ret.data[i][j] = new Boolean(a.get(i, j) != b);
		return ret;
	}
	public static LogicalArray NEQ(Jama.Matrix a, long b) {
		return NEQ(a, (double)b);
	}
	public static LogicalArray NEQ(Jama.Matrix a, int b) {
		return NEQ(a, (double)b);
	}
	public static LogicalArray NEQ(double a, Jama.Matrix b) {
		return NEQ(b, a);
	}
	public static LogicalArray NEQ(long a, Jama.Matrix b) {
		return NEQ(b, (double)a);
	}
	public static LogicalArray NEQ(int a, Jama.Matrix b) {
		return NEQ(b, (double)a);
	}
	//--------------------------
	
	
	public static Jama.Matrix getMatrix(Jama.Matrix A, LogicalArray Idx) {
		ArrayList<Double> ret = new ArrayList<Double>();
		int m = A.getRowDimension();
		int n = A.getColumnDimension();
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++) {
				if(Idx.get(i,j).equals(true))
					ret.add(A.get(i,j));
			}
		double[] data = new double[ret.size()];
		for(int i=0; i<ret.size(); i++)
			data[i] = ret.get(i);
		return new Jama.Matrix(data, data.length);
	}
	
	
	public static Jama.Matrix[] find(Jama.Matrix A) {
		int m = A.getRowDimension();
		int n = A.getColumnDimension();
		List<Integer> rows = new ArrayList<Integer>();
		List<Integer> cols = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(A.get(i, j) != 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		double[] rowAry = new double[rows.size()];
		double[] colAry = new double[cols.size()];
		for(int i=0; i<rows.size(); i++)
			rowAry[i] = rows.get(i)+MatrixAccessNode.INDEX_BASE;
		for(int i=0; i<cols.size(); i++)
			colAry[i] = cols.get(i)+MatrixAccessNode.INDEX_BASE;
		
		Jama.Matrix[] ret = new Jama.Matrix[2];
		ret[0] = new Jama.Matrix(rowAry, rowAry.length);
		ret[1] = new Jama.Matrix(colAry, colAry.length);
		return ret;
	}
	
	public static Jama.Matrix sort(Jama.Matrix A) {
		Jama.Matrix m = A.transpose();
		double[][] data = m.getArray();
		for(int i=0; i<data.length; i++) {
			Arrays.sort(data[i]);
		}
		return m.transpose();
	}
	
	public static boolean strcmp(String s, String t) {
		return s.equals(t);
	}
	
	public static Jama.Matrix diff(Jama.Matrix A) {
		int m = A.getRowDimension();
		int n = A.getColumnDimension();
		if(m == 1) {
			double[] data = new double[n-1];
			for(int i=0; i<n-1; i++) {
				data[i] = A.get(0, i+1) - A.get(0, i);
			}
			return new Jama.Matrix(data, 1);
		} else if(m > 1) {
			double[][] data = A.getArray();
			double[][] ret = new double[m-1][n];
			for(int i=0; i<m-1; i++) {
				for(int j=0; j<n; j++) {
					ret[i][j] = data[i+1][j] - data[i][j];
				}
			}
			return new Jama.Matrix(ret);
		} else {
			return A;
		}
	}
	
	public static String class1(Object o) {
		return o.getClass().getName();
	}
	public static String class1(Jama.Matrix o) {
		return o.getClass().getName();
	}
	public static String class1(double o) {
		return "double";
	}
	public static String class1(int o) {
		return "int";
	}
	public static String class1(long o) {
		return "long";
	}
	
	public static Jama.Matrix cumsum(Jama.Matrix A) {
		int m = A.getRowDimension();
		int n = A.getColumnDimension();
		if(m == 1) {
			double[] data = new double[n];
			data[0] = A.get(0, 0);
			for(int i=1; i<n; i++) {
				data[i] = data[i-1] + A.get(0, i);
			}
			return new Jama.Matrix(data, 1);
		} else if(m > 1) {
			double[][] data = A.getArray();
			double[][] ret = new double[m][n];
			for(int j=0; j<n; j++) {
				ret[0][j] = data[0][j];
			}
			for(int i=1; i<m; i++) {
				for(int j=0; j<n; j++) {
					ret[i][j] = ret[i-1][j] + data[i][j];
				}
			}
			return new Jama.Matrix(ret);
		} else {
			return A;
		}
	}
	
	public static int ndims(Jama.Matrix m) {
		if(m.getRowDimension() == 1 || m.getColumnDimension() == 1)
			return 1;
		else
			return 2;
	}
	
	public static boolean any(int i) {
		return i>0;
	}
	public static boolean any(long i) {
		return i>0;
	}
	public static boolean any(double i) {
		return i>0;
	}
	public static Jama.Matrix any(Jama.Matrix m) {
		Jama.Matrix ret = null;
		if(m.getRowDimension() == 1) {
			ret = new Jama.Matrix(1,1);
			for(int i=0; i<m.getColumnDimension(); i++) {
				if(m.get(0, i) > 0.0) {
					ret.set(0, 0, 1.0);
					return ret;
				}
			}
		} else {
			ret = new Jama.Matrix(1, m.getColumnDimension());
			for(int i=0; i<m.getColumnDimension(); i++) {
				for(int j=0; j<m.getRowDimension(); j++) {
					if(m.get(j, i) > 0.0) {
						ret.set(0, i, 1.0);
						break;
					}
				}
			}
		}
		return ret;
	}
	
	/**
	 * %      C = {1:10, [2; 4; 6], []};
%      Cmeans = cellfun(@mean, C);
%      [Cnrows,Cncols] = cellfun(@size, C);
%      Csize = cellfun(@size, C, 'UniformOutput', false);
%
%      % Find the positive values in several datasets.
%      C = {randn(10,1), randn(20,1), randn(30,1)};
%      Cpositives = cellfun(@(x) x(x>0), C, 'UniformOutput',false);
%
%      % Compute the covariance between several pairs of datasets.
%      C = {randn(10,1), randn(20,1), randn(30,1)};
%      D = {randn(10,1), randn(20,1), randn(30,1)};
%      CDcovs = cellfun(@cov, C, D, 'UniformOutput', false);

	 */
	public static CSList cellfun(String funName, ObjectArray o) {
		return cellfun(funName, new ObjectArray[]{o});
	}
	public static CSList cellfun(String funName, ObjectArray o1, ObjectArray o2) {
		return cellfun(funName, new ObjectArray[]{o1, o2});
	}
	public static CSList cellfun(String funName, ObjectArray[] o) {
		Object[] args = new Object[o.length];
		int N = BytecodeSupport.numel(o[0]);
		CSList rlt = null;
		Method m = null;
		for(int i=0; i<N; i++) {
			for(int j=0; j<args.length; j++) {
				args[j] = o[j].get(i);
			}
			m = findMethod(funName, args);
			try {
				Object ret = m.invoke(null, args);
				if(null == rlt) { //initialize the return value
					if(ret instanceof CSList) {
						CSList retList = (CSList)ret;
						rlt = new CSList(retList.size());
						for(int k=0; k<retList.size(); k++) {
							rlt.data[k] = new ObjectArray(N,1);
						}
					} else {
						rlt = new CSList(1);
						rlt.data[0] = new ObjectArray(N,1);
					}
				}
				
				if(ret instanceof CSList) {
					CSList retList = (CSList)ret;
					for(int k=0; k<retList.size(); k++) {
						((ObjectArray)rlt.data[k]).set(i, retList.get(k));
					}
				} else {
					((ObjectArray)rlt.data[0]).set(i, ret);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return rlt;
	}
	
	public static Method findMethod(String funName, Object[] o) {
		Method m = null;
		try {
			m = BytecodeSupport.class.getMethod(funName, Tools.getParameterArray(o));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public static boolean matrix2boolean(Jama.Matrix m) {
		if(m.getRowDimension() > 0 && m.getColumnDimension() > 0) {
			if(m.get(0, 0) > 0) return true;
		}
		return false;
	}
}
