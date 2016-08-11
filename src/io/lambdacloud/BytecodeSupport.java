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
	
	
	//------------------
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
		o.print(8, 2);
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
		for(double i=s; i<=e; i+=step) {
			ret.add(i-shift);
		}
		double[] dret = new double[ret.size()];
		for(int i=0; i<ret.size(); i++)
			dret[i] = ret.get(i);
		return dret;
	}
	
	public static double[] range2(double s, double step, double e, int shift) {
		return range(s, step, e, shift);
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
	
}
