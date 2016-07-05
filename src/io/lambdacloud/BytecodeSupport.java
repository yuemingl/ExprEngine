package io.lambdacloud;

public class BytecodeSupport {
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
}
