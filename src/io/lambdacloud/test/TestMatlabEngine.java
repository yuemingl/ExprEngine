package io.lambdacloud.test;

import static io.lambdacloud.MatlabEngine.exec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Jama.Matrix;

public class TestMatlabEngine {
	public static void main(String[] args){
		exec("function myfun(a, b)\n c=a+b\n d=a-b\n [c d]\n end\n myfun(10,100)");
		
		test();
	}
	
	public static void test() {
		Matrix m = new Matrix(new double[][]{{1,2},{3,4}});
		Matrix n = new Matrix(new double[][]{{10,20},{30,40}});

		double[][] array = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
		double[][] array2 = {{1.,2.,3},{1.,1.,1.},{2.,2.,2.}};
		Matrix A = new Matrix(array);
		Matrix B = new Matrix(array2);
		Matrix b = Matrix.random(3,1);
		
		exec("function myfun(a, b)\n c=a+b\n d=a-b\n [c d]\n end\n myfun(10,100)");
		//exec("function [c d]=myfun(a, b)\n c=a+b\n d=a-b\n end\n myfun(10,100)");
		//exec("function [c d]=myfun(a, b)\n c=a+b\n d=a-b\n end\n myfun(10.,100.)");
		//exec("function myfun(a, b)\n c=a+b\n d=a-b\n [c d]\n end\n myfun(10.,100.)");
		
		//exec("function myfun(a)\n a+1\n a+2; end\n myfun(1)");
		//exec("function myfun(a)\n a+1\n a+2\n end\n myfun(1)");
		//exec("function a=myfun(a)\n a+1\n a+2\n end\n myfun(1);");
		//exec("function a=myfun(a)\n a+1\n a+2\n end\n myfun(1)");
		
//		exec("A=[1 2; 3 4]; b=[3 5]; A\\b");
//		exec("A=[1 2; 3 4]\n b=[3 5]\n A\\b");
		
//		exec("a=2\n a");
//		exec("a=2; a");
//		exec("100+1; 200+1;");
//		exec("10+1\n 20+1");

//		myPrint(exec("function [c d] = myfun(a, b)\nc=a+b; d=a-b;a;b;a+1\nend\nmyfun(10,100)"));
//		myPrint(exec("function [c d] = myfun(a, b)\nc=a+b; d=a-b;\nend\nmyfun(10,100)"));
//		myPrint(exec("function c = myfun(a, b)\na+b\nend\nmyfun(10,100)"));
//		myPrint(exec("fun(1, 1)"));
//		myPrint(exec("a=[1, 2; 3, 4];  a(1, 1)"));
//		
//		myPrint(exec("a=[1 2; 3 4];  a(1, 1)"));
//		myPrint(exec("a=[1 2; 3 4];  a(1,1)"));
//		
////		//white space test
////		//myPrint(exec("a=[1 2; 3 4];b=[2 3; 4 5]; a+b"));
////		myPrint(exec("a=[1 2; 3 4];  b=[2 3; 4 5]; a+b"));
//		myPrint(exec("a=  [1 2; 3 4]; a +  [2 3; 4 5]  ;  "));
//
		
//		myPrint(exec("A(0:2,1:2)+B(0:2,1:2)", getMap("A",A,"B",B)));
//		myPrint(exec("A(1:2,1:2)-B(1:2,1:2)", getMap("A",A,"B",B)));
//		myPrint(exec("A(1:2,1:2)*B(1:2,1:2)", getMap("A",A,"B",B)));
//		myPrint(exec("A(1:2,1:2).*B(1:2,1:2)", getMap("A",A,"B",B)));
//		myPrint(exec("A(1:2,1:2)./B(1:2,1:2)", getMap("A",A,"B",B)));
		
		assertEqual(exec("-A",    getMap("A",A)),       A.uminus());
		assertEqual(exec("A+B",   getMap("A",A,"B",B)), A.plus(B));
		assertEqual(exec("A-B",   getMap("A",A,"B",B)), A.minus(B));
		assertEqual(exec("A*B",   getMap("A",A,"B",B)), A.times(B));
		assertEqual(exec("B/A",   getMap("A",A,"B",B)), A.solve(B));
		assertEqual(exec("A\\B",  getMap("A",A,"B",B)), A.solve(B));
		assertEqual(exec("A.*B",  getMap("A",A,"B",B)), A.arrayTimes(B));
		assertEqual(exec("A.\\B", getMap("A",A,"B",B)), A.arrayLeftDivide(B));
		assertEqual(exec("A./B",  getMap("A",A,"B",B)), A.arrayRightDivide(B));
		
		
		//myPrint(exec("A(1,1:2)", getMap("A",array)));
		
		//myPrint(exec("A(1,1:2)", getMap("A",array)));
		//myPrint(exec("A(1:2,1:2)", getMap("A",A)));
		//myPrint(exec("A(1:2,2)", getMap("A",A)));
		
		assertEqual(exec("[1. .2 3.]"), getMatrix(1,0.2,3));
		
		assertEqual(exec("A\\b", getMap("A",A,"b",b)), A.solve(b));
		
		assertEqual(exec("[1 2 3; 4 5 6; 7 8 10]"), A);
		assertEqual(exec("[1 2 3; 4 5 6; 7 8 10]'"), A.transpose());
		assertEqual(exec("A'", getMap("A",m)), m.transpose());

		assertEqual(exec("a + b  ", getMap("a",m,"b",n)), m.plus(n));
		assertEqual(exec("a+b", getMap("a",2,"b",3)), 5);
		
		
		assertEqual(exec("[10.0 20.0 30.0]"), getMatrix(10,20,30));
		
		assertEqual(exec("[1 2 3]"), getMatrix(1,2,3));
		assertEqual(exec("[1,2,3]"), getMatrix(1,2,3));
		assertEqual(exec("[1, 2, 3]"), getMatrix(1,2,3));
		assertEqual(exec("[1  2   3]"), getMatrix(1,2,3));
		assertEqual(exec("[1,  2  ,  3]"), getMatrix(1,2,3));
	}
	
	public static Jama.Matrix getMatrix(double ...args) {
		return new Jama.Matrix(args, args.length);
	}
	
	public static Jama.Matrix getRow(double[][] args) {
		return new Jama.Matrix(args);
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
		} else if(o1 instanceof Jama.Matrix && o2 instanceof Jama.Matrix) {
			Jama.Matrix m1 = (Jama.Matrix)o1;
			Jama.Matrix m2 = (Jama.Matrix)o2;
			double norm = m1.minus(m2).norm2();
			if(norm <1e-8)
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