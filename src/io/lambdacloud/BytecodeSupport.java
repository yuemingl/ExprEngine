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
	public static int[] range(int s) {
		int[] ret = new int[s];
		for(int i=0; i<s; i++) {
			ret[i] = i;
		}
		return ret;
	}
	
	//[s,e)
	public static int[] range(int s, int e) {
		int[] ret = new int[e-s];
		for(int i=s; i<e; i++) {
			ret[i-s] = i;
		}
		return ret;
	}

	//[s : step : e)
	public static int[] range(int s, int step, int e) {
		int n = (e-s)/step;
		int rem = (e-s)%step;
		n = (rem==0) ? n : n+1;

		int[] ret = new int[n];
		for(int i=0; i<n; i++, s+=step) {
			ret[i] = s;
		}
		return ret;
	}
	
	//[s,e]
	public static int[] range2(int s, int e) {
		int[] ret = new int[e-s+1];
		for(int i=s; i<=e; i++) {
			ret[i-s] = i;
		}
		return ret;
	}

	//[s : step : e]
	public static int[] range2(int s, int step, int e) {
		int n = 1 + (e-s)/step;
		int[] ret = new int[n];
		for(int i=0; i<n; i++, s+=step) {
			ret[i] = s;
		}
		return ret;
	}
	
	public static double[] range(double s, double step, double e) {
		List<Double> ret = new ArrayList<Double>();
		for(double i=s; i<=e; i+=step) {
			ret.add(i);
		}
		double[] dret = new double[ret.size()];
		for(int i=0; i<ret.size(); i++)
			dret[i] = ret.get(i);
		return dret;
	}
	
	public static double[] range2(double s, double step, double e) {
		return range(s, step, e);
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
}
