package io.lambdacloud;

import java.util.List;

public class BytecodeSupport {
	public static void print(Object str) {
		System.out.print(str);
	}
	public static void print(String str) {
		System.out.print(str);
	}
	public static void print(int str) {
		System.out.print(str);
	}
	public static void print(double str) {
		System.out.print(str);
	}
	public static void print(long str) {
		System.out.print(str);
	}
	public static void print(boolean str) {
		System.out.print(str);
	}
	
	public static void println(Object o) {
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
	}

	public static void println(Jama.Matrix o) {
		o.print(8, 2);
	}
	
	public static void println(String str) {
		System.out.println(str);
	}
	public static void println(int str) {
		System.out.println(str);
	}
	public static void println(long str) {
		System.out.println(str);
	}
	public static void println(double str) {
		System.out.println(str);
	}
	public static void println(boolean str) {
		System.out.println(str);
	}
	
	public static void print(String format, Object ...params) {
		
	}
	
	public static int[] range(int s) {
		int[] ret = new int[s];
		for(int i=0; i<s; i++) {
			ret[i] = i;
		}
		return ret;
	}
	
	public static int[] range(int s, int e) {
		int[] ret = new int[e-s];
		for(int i=s; i<e; i++) {
			ret[i-s] = i;
		}
		return ret;
	}
	
	public static int[] range2(int s, int e) {
		int[] ret = new int[e-s+1];
		for(int i=s; i<=e; i++) {
			ret[i-s] = i;
		}
		return ret;
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

}
