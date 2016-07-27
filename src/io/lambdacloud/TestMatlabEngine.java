package io.lambdacloud;

import static io.lambdacloud.MatlabEngine.exec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Jama.Matrix;

public class TestMatlabEngine {
	public static void main(String[] args){
		Matrix m = new Matrix(new double[][]{{1,2},{3,4}});
		Matrix n = new Matrix(new double[][]{{10,20},{30,40}});

		double[][] array = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
		Matrix A = new Matrix(array);
		Matrix b = Matrix.random(3,1);
		
		myPrint(exec("A(1,1:2)", getMap("A",array)));
		//myPrint(exec("A(1,1)", getMap("A",A)));
		
//		myPrint(exec("[1. .2 3.]"));
//		
//		((Matrix)exec("A\\b", getMap("A",A,"b",b))).print(8,2);
//		
//		myPrint(exec("[1 2 3; 4 5 6; 7 8 9]"));
//		myPrint(exec("[1 2 3; 4 5 6; 7 8 9]'"));
//		myPrint(exec("A'", getMap("A",m)));

//		((Matrix)exec("a + b  ", getMap("a",m,"b",n))).print(8,2);
//		//System.out.println(exec("a+b", getMap("a",2,"b",3)));
//		
//		
//		myPrint(exec("[10.0 20.0 30.0]"));
//		
//		myPrint(exec("[1 2 3]"));
//		myPrint(exec("[1,2,3]"));
//		myPrint(exec("[1, 2, 3]"));
//		myPrint(exec("[1  2   3]"));
//		myPrint(exec("[1,  2  ,  3]"));
	}
	
	public static void assertEqual(Object o1, Object o2) {
		if(o1 instanceof int[][] && o2 instanceof int[][]) {
			int[][] o11 = (int[][])o1;
			int[][] o22 = (int[][])o2;
			for(int i=0; i<o11.length; i++)
				assertEqual(o11[i],o22[i]);
			return;
		}
		else if(o1 instanceof int[] && o2 instanceof int[]) {
			int[] a = (int[])o1;
			int[] b = (int[])o2;
			if(a.length != b.length)
				throw new RuntimeException("Assert fail! Length: "+a.length+" != "+b.length);
			for(int i=0; i<a.length; i++) {
				if(a[i] != b[i])
					throw new RuntimeException("Assert fail!  "+a[i]+" != "+b[i]);
			}
			return;
		} else if(o1 instanceof double[] && o2 instanceof double[]) {
			double[] a = (double[])o1;
			double[] b = (double[])o2;
			if(a.length != b.length)
				throw new RuntimeException("Assert fail! Length: "+a.length+" != "+b.length);
			for(int i=0; i<a.length; i++) {
				if(a[i] != b[i])
					throw new RuntimeException("Assert fail!  "+a[i]+" != "+b[i]);
			}
			return;
		} else if(o1 instanceof List && o2 instanceof List) {
			List<?> l1 = (List<?>)o1;
			List<?> l2 = (List<?>)o2;
			if(l1.size() != l2.size())
				throw new RuntimeException("Assert fail!  Length: "+l1.size()+" != "+l2.size());
			for(int i=0; i<l1.size(); i++) {
				assertEqual(l1.get(i), l2.get(i));
			}
			return;
		}
		if(!o1.equals(o2)) {
			System.err.println(o1 + " != "+o2);
			throw new RuntimeException("Assert fail!");
		}
	}
	
	public static void myPrint(Object o) {
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
			((Jama.Matrix)o).print(8, 2);;
		}
		else {
			System.out.println(o);
		}
	}
	
	public static int arrayArgFunc(int[] arg) {
		return arg[0];
	}
	
	public static Map<String, Object> getMap(Object ...args) {
		Map<String, Object> ret = new HashMap<String, Object>();
		for(int i=0; i<args.length; i+=2) {
			ret.put(args[i].toString(), args[i+1]);
		}
		return ret;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getList(Object ...e) {
		List ret = new ArrayList();
		for(Object o : e) 
			ret.add(o);
		return ret;
	}
}
