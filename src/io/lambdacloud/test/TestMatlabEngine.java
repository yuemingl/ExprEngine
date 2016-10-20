package io.lambdacloud.test;

import static io.lambdacloud.MatlabEngine.exec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.Type;

import Jama.Matrix;
import io.lambdacloud.BytecodeSupport;
import io.lambdacloud.MatlabEngine;
import io.lambdacloud.node.VariableNode;
import io.lambdacloud.node.matrix.MatrixAccessNode;
import io.lambdacloud.util.Struct;

/**
 * The type of an optional function parameter is set to null. All the null type of function parameters
 * will be ignored when generating bytecode. Two problems are solved:
 * (1) A function call with less parameters than the declared number of parameters of a function;
 * (2) The optional parameter in the expression of the function body can be ignored/skipped if the parameter appears 
 * in a call of a function.
 * Question (TODO):
 * exec("function R=myProd(m, n), if nargin==1, r=m*m; else r=m*n; end end myProd(3);")
 * m*n cannot be compiled if the type of n is null
 * Bugs fixed:
 * <1> exec("function r=fib(n)\n if n<=1\n r=1; else r=fib(n-1)+fib(n-2); end\n end\n fib(42)")
 * two times assignement for 'r=fib(n-1)+fib(n-2);' due to two types of 'r' (e.g. I and D)
 * 
 * 
 * TODO
 * multi-assign:
 * [A B;C] = D;
 * 
 * TODO
 *   object operation +,-,*,/
 *   remove value form VariableNode
 *   **bootstrap function for object arguments
 *   finish test for assignment with comma-separated list on right hand side
 *   multi-variable assignement test
 *   fix confilict for math.sin(x) and math.sin Struct
 *   *fix all tests
 * 
 * 
 * 
 * 
 * @author yueming.liu
 *
 */
public class TestMatlabEngine {
	public static void main(String[] args){
		exec("car.monitor.mpg=35");
		assertEqual(exec("math.sin(1.0);"), Math.sin(1.0));

		exec("C = {'one', 'two', 'three'; 1, 2, 3}; [a b c]=C{1:3}; a\n b\n c\n");
		exec("C = {'one', 'two', 'three'; 1, 2, 3}; C{1:3}");
		exec("C = {'one', 'two', 'three'; 1, 2, 3}; a=C{1:3}; a");
		assertEqual(exec("sum=0.0; for i=[10 20 30], sum+=i; end sum;"), 60.0);

		exec("function [A B]=myfun(), A=1; B=2; end [a b]=myfun(); a\n b");
		exec("function [A B]=myfun(), A=1; B=2; end myfun()");

		exec("C = {'one', 'two', 'three'; 1, 2, 3}; a=C{2,3}; a");
		exec("C = {'one', 'two', 'three'; 1, 2, 3}; a=C{1:3}; a");

		exec("C = [1, 2, 3]; [a b c]=C(1:3)'; a\n b\n c\n");
		exec("C = [1, 2, 3]; [a b c]=C(:)'; a\n b\n c\n");
		exec("C = [1, 2, 3]; [a b c]=C; a\n b\n c\n");

		//exec("C = {'one', 'two', 'three'; 1, 2, 3}; [a b c]=C{1:3}"); //string type?
		exec("C = {'one', 'two', 'three'; 1, 2, 3}; C{1:3}");
		exec("C = {'one', 'two', 'three'; 1, 2, 3}; C{1}+C{1,2}");

		exec("C = {'one', 'two', 'three'; 1, 2, 3}; C");
		exec("C = {'one', 'two', 'three'; 1, 2, 3}; C(1:2,1:2)");
		exec("C = {'one', 'two', 'three'; 1, 2, 3}; C(1,1:3)");
		exec("C = {'one', 'two', 'three'; 1, 2, 3}; C{1:2,1:2}");
		exec("C = {'one', 'two', 'three'; 1, 2, 3}; C{1,1:3}");
		exec("C = {'one', 'two', 'three'; 1, 2, 3}; C(1,1:3) = {'first','second','third'}");
		
		//error: invalid assignment to cs-list outside multiple assignment
//		exec("a={1,3.0,'abc'}; a{1}=100");
//		exec("a={1,3.0,'abc'}; a{2}=100");
//		exec("a={1,3.0,'abc'}; a{3}=100");
//		exec("a={1,3.0,'abc'}; a(1)=100");
//		exec("a={1,3.0,'abc'}; a(2)=100");
//		exec("a={1,3.0,'abc'}; a(3)=100");
//		exec("a={1,3.0,'abc'}; a(1,3)=100");
//		exec("a={1,3.0,'abc'}; a{1,3}=100");
		exec("a={1,3.0,'abc'}; a{1:3}");
		exec("a={1,3.0,'abc'}; a(1:3)");

		exec("a={1,3.0,'abc'}; a(3)");
		exec("a={1,3.0,'abc'}; a{3}");
		exec("a={1,3.0,'abc'}; a{1:3}");
		exec("a={1,3.0,'abc'}; a(1:3)");

		
		System.out.println(exec("a.b=[1 2; 3 4]; a.c=2; a.d=false"));
		exec("a.b=[1 2; 3 4]; a.c=2; a.b+a.c");
		//exec("car.monitor.mpg=35.0; car.monitor.miles=2000; car.monitor.mpg+car.monitor.miles");
		//exec("car.monitor.mpg=35.0; car.monitor.miles=2000; car");
		
		exec("car.monitor.mpg=35.0; car.monitor.mpg+2");
		exec("car.monitor.mpg=35L; car.monitor.mpg+2");
		exec("car.monitor.mpg=false; car.monitor.mpg || 2>1");
		exec("car.monitor.mpg=35; car.monitor.mpg+2");
		exec("car.monitor.mpg=[1 2;3 4]; car.monitor.mpg");
		exec("car.monitor.mpg=[1 2;3 4]; car.monitor.mpg+2");
		exec("car.monitor.mpg=35; car.monitor.mpg");
		exec("car.monitor.mpg=35; car.monitor");
		exec("car.monitor.mpg.a.b.c=35");
		exec("car.monitor.mpg=35");
		
//		Struct s = new Struct();
//		//s.put("mpg", new Jama.Matrix(3,3));
//		s.put("mpg", 35);
//		Struct ss = new Struct();
//		ss.put("monitor", s);
//		exec("car.monitor.mpg", new Object[]{ss});
//		exec("car.mpg", new Object[]{s});
//		exec("car", new Object[]{s});

		testCellArray();
		testVariableNode();
		testBasic();
		testBasic2();
		testBasic3();
		testPrint();
		testComment();
		testEndIndex();
		testNArgin();
		testShaddowVariables();
		testBuildinFunc();
		testFunction();
		testMatrixInit();
		testMatrixAssign();
		testMatrixAccess();
		testOptionalParamters();
		testMisc();
		testString();
	}
	
	public static void testCellArray() {
//		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; for i=1:8, a{i} end");

		
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:end}={1,2,3,4,5,6,7,8}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:2,1:3}={1,2,3;4,5,6}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:2,1:3:4}={1,2;3,4}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:2,end:-1:1}={1,2,3,4;5,6,7,8}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{[1 2],[1 3 4]}={1,2,3;4,5,6}");
////		//exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{end:1}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{end:-1:1}={1,2,3,4,5,6,7,8}");
//		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{2,2}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{2:4}={1,2,3}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:2:8}={1,2,3,4}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{2:2:8}={1,2,3,4}");
//		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{3}={100}");
//		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{5}={100}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{:}={1,2,3,4;5,6,7,8}");
		
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:end}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:2,1:3}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:2,1:3:4}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:2,end:-1:1}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{[1 2],[1 3 4]}=100");
//		//exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{end:1}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{end:-1:1}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{2,2}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{2:4}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:2:8}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{2:2:8}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{3}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{5}=100");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{:}=100");

		
		exec("a=[1 2 3 4 5; 10 20 30 40 50]; a([1 2],[1 3 4])");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:end}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:2,1:3}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:2,1:3:4}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{1:2,end:-1:1}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{[1 2],[1 3 4]}");
		//exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{end:1}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{end:-1:1}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{2,2}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{2:4}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{2:2:8}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{3}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{5}");
		exec("a={10,20,30,'ttt';  1L,3.5,true,false}; a{:}");

		
		exec("{ 30,    'ttt'    }");
		exec("{ {10, 20}, {30, 'ttt'} }");
		exec("{ {10, 20, 30, 'ttt'}; {1L, 3.5}, {true, false} }");
		exec("{ {10, 20}, {30, 'ttt'}, {1L, 3.5}, {true, false} }");
		exec("{ {10; 20}, {30; 'ttt'}, {1L; 3.5}, {true; false} }");
		exec("{10; 20; 30; 'ttt'; 1L; 3.5; true; false}");
		exec("{10,20; 30,'ttt'; 1L,3.5; true,false}");
		exec("{10,20,30,'ttt';  1L,3.5,true,false}");
		exec("{10,20,30,'ttt',1L,3.5,true}");
		exec("{10,20,30,'ttt',1L}");
		
		
		//exec("a=[1,2,3]; a{1:2}");
		//assertEqual(exec("a=[1,2,3]; a{1}=10"),  null);
		//assertEqual(exec("a{1:2}(0)"),  null);
		//assertEqual(exec("a[0]{1:2}"),  null);
		//assertEqual(exec("a(0){1}"),  null);
		//assertEqual(exec("a{1:2}{0}"),  null);
		//assertEqual(exec("a.b{1:2}{0}"),  null);
		//assertEqual(exec("a.b(1:2)(0)"),  null);
		//assertEqual(exec("aa.bb(1:2).cc(0)"),  null);
		//assertEqual(exec("dd(1:2,3,4)"),  null);
		//assertEqual(exec("a=[1,2,3,4]; a(3);"),  3.0);
		//assertEqual(exec("math.sin(1.0);"),  Math.sin(1.0));
		//assertEqual(exec("rem(3.0,2.0);"),  1.0);
		//assertEqual(exec("mod(3.0,2.0);"),  1.0);
		//assertEqual(exec("a", getMap("a",1)),  1);		
	}
	
	public static void testMisc() {
		assertEqual(exec("function r=fib(n)\n if n<=1\n r=1; else r=fib(n-1)+fib(n-2); end\n end\n fib(4)"),5);
		assertEqual(exec("function c=fun(a, b), if nargin < 2, return; end c=a+b; end fun(1);"),  null);

		
		//Test logical constant
		assertEqual(exec("if true, 1; else 2; end"), 1);
		
		
		assertEqual(exec("a=1; a-=[1 2;3 4]; a"), getMatrix(new double[][]{{0,-1},{-2,-3}}));
		assertEqual(exec("a=1; a+=[1 2;3 4]; a=1.0; a"),1.0);
		assertEqual(exec("A=[1 2; 3 4]; A*=[1 2; 1 3]; A"), getMatrix(new double[][]{{3,8},{7,18}}));
		
//		//BUgfix: Two calls of 'r=fib(n-1)+fib(n-2)' for shadow variable of r.
		exec("function r=fib(n)\n if n<=1\n r=1; else r=fib(n-1)+fib(n-2); end\n end\n fib(29)");
		exec("function fib(n)\n if n<=1\n 1; else fib(n-1)+fib(n-2); end\n end\n fib(29)");
		
		//test local, paramter, func call and array accesses
		//assertEqual(MatlabEngine.exec("if n<=1; r=5;r;1\n else 5; 6+7\n 100\n 9; 8; end",new int[]{8}), 8);
//		double[][] array3 = {{1,2,3,4,5,6},{11,22,33,44,55,66}};
//		Matrix C = new Matrix(array3);
//		assertEqual(exec("C(   :  , :  )", getMap("C",C)), C);
//		assertEqual(exec("a&&b", new Object[]{true, false}),   false);
		
		//Exception in thread "main" java.lang.VerifyError: get long/double overflows locals
		//assertEqual(exec("r = -((n-j+1)*r*(n+j-1))/(j-1)^2; r", new double[]{1,2,3}),Double.NEGATIVE_INFINITY);
		//assertEqual(exec("isnumeric(c) && isnumeric(r)", getMap("c",1,"r",2)), true);
		//assertEqual(exec("if mod(i,2)==0; a+=1; else b+=1; end i\n a\n b\n", 
		//		new int[]{4,10,0}),10);//a=4,b=10,i=0
//		assertEqual(exec("A=[10 20 30; 40 50 60]; A(end:-2:1)=[1 3 5];"),
//				getMatrix(new double[][]{{10, 20, 30},{5,3,1}}));
//		assertEqual(exec("function fib(r, n); A=[1 1; 1 0]; if n<1; r; else r=A*r; fib(r, n-1); end end fib([1 1]', 5)"), 
//				new Jama.Matrix(new double[]{13,8},2));

		//func_def_return is for 'function HERE=fun(a,b) ... end'
		assertEqual(exec("function fun(a,b), return a+b end fun(1,2)"),3);

	}
	
	public static void testString() {
		assertEqual(exec("'aaa'+a;", new Object[]{"bbb"}),"aaabbb");
//		//assertEqual(exec("'aaa'+a", new Object[]{5}),"aaabbb");
		assertEqual(exec("function fun(a,b), a+b; end fun('aaa','bbb');"),"aaabbb");
		assertEqual(exec("function fun(a,b), a+b; end fun('aaa');"),null);
		assertEqual(exec("function fun(a,b), a+b; end fun(3,5);"),8);
		
	}
	
	public static void testOptionalParamters() {
		
//		//If the caller only pass one argument m, what's the type of n in the call of zeros(m,n)?
		assertEqual(exec("function R=myZeros(m, n), if nargin==1, R=zeros(m, m); else R=zeros(m,n); end end myZeros(3)"),
				getMatrix(new double[3][3]));
		assertEqual(exec("function R=myZeros(m, n), if nargin==1, R=zeros(m, m); else R=zeros(m,n); end end myZeros(3,2)"),
				getMatrix(new double[3][2]));
		assertEqual(exec("function R=myZeros(m, n), if nargin==1, R=zeros(m, m); else R=zeros(m,1+n); end end myZeros(3)"),
				getMatrix(new double[3][3]));
		assertEqual(exec("function R=myZeros(m, n), if nargin==1, R=zeros(m, m); else R=zeros(m,1+n); end end myZeros(3,1)"),
				getMatrix(new double[3][2]));

		assertEqual(exec("function R=myZeros(m, n), if nargin==1, R=zeros(m, m); else R=zeros(m,n); end end myZeros(3);"),
				getMatrix(new double[3][3]));
		
		assertEqual(exec("function fun(a, b), a+b; end fun(1,2)"),  3);
		
		assertEqual(exec("function fun(a, b), a+b; end fun(1)"),  null);
		assertEqual(exec("function fun(a, b), a-b; end fun(1)"),  null);
		assertEqual(exec("function fun(a, b), a*b; end fun(1)"),  null);
		assertEqual(exec("function fun(a, b), a/b; end fun(1)"),  null);
		
		//java.lang.NoSuchMethodException: io.lambdacloud.BytecodeSupport.mod(int)
		//assertEqual(exec("function fun(a, b), mod(a,b); end fun(1)"),  null);
		
		assertEqual(exec("function fun(a, b), a+=b; a;  end fun(1)"), 1);
		assertEqual(exec("function fun(a, b), a+=b; a;  end fun(1,2)"),  3);
		assertEqual(exec("function fun(a, b), a+=b; end fun(1,2)"),  3);
		
		assertEqual(exec("function fun(a, b), a+=b; end fun(1)"),  null);
		assertEqual(exec("function fun(a, b), a-=b; end fun(1)"),  null);
		assertEqual(exec("function fun(a, b), a*=b; end fun(1)"),  null);
		assertEqual(exec("function fun(a, b), a/=b; end fun(1)"),  null);
		
		//assertEqual(exec("function fun(a, b), a++; end fun(1)"),  null);
		//assertEqual(exec("function fun(a, b), a--; end fun(1)"),  null);
		
		assertEqual(exec("function fun(a, b), a=b; end fun(1,2)"),  2);
		assertEqual(exec("function fun(a, b), a=b; end fun(1)"),  null);
		
//		//optional parameter in function call
//		assertEqual(exec("range(5)"),  5);
//		//assertEqual(exec("range(1:5)"),  5);
//		assertEqual(exec("function fun(a, b, c), range(a:c:b); end fun(1,10,2)"),  
//				getVector(1,3,5,7,9).transpose());
		assertEqual(exec("function fun(a, b, c), range(a:c:b); end fun(1,5)"),  
				getVector(1,2,3,4,5).transpose());
		
		assertEqual(exec("function fun(a, b), a==b; end fun(1,2)"),  false);
		assertEqual(exec("function fun(a, b), a==b; end fun(1)"),  null);
		assertEqual(exec("function fun(a, b), a>b; end fun(1)"),   null);
		assertEqual(exec("function fun(a, b), a>=b; end fun(1)"),  null);
		assertEqual(exec("function fun(a, b), a<b; end fun(1)"),   null);
		assertEqual(exec("function fun(a, b), a<=b; end fun(1)"),  null);
		
		assertEqual(exec("function fun(a, b), a and b; end fun(1)"),  null);
		assertEqual(exec("function fun(a, b), a && b; end fun(1)"),   null);
		assertEqual(exec("function fun(a, b), a or b; end fun(1)"),   null);
		assertEqual(exec("function fun(a, b), a || b; end fun(1)"),   null);
		assertEqual(exec("function fun(a, b), a != b; end fun(1)"),   null);
		assertEqual(exec("function fun(a, b), a ~= b; end fun(1)"),   null);
		
		//optional parameter in if/for/while condition
		
		assertEqual(exec("function fun(a,b,c,d,e), [a,b,c,d,e]; end fun(1,2,3,4,5)"), getVector(1,2,3,4,5).transpose());
		assertEqual(exec("function fun(a,b,c,d,e), [a,b,c,d,e]; end fun(1)"), getVector(1).transpose());
		assertEqual(exec("function fun(a,b,c,d,e), [a,b,c,d,e]; end fun(1,2)"), getVector(1,2).transpose());
		assertEqual(exec("function fun(a,b,c,d,e), [a,b,c,d,e]; end fun(1,2,3)"), getVector(1,2,3).transpose());
		assertEqual(exec("function fun(a,b,c,d,e), [a,b,c,d,e]; end fun(1,2,3,4)"), getVector(1,2,3,4).transpose());

//		//how to compile m*n if the type of n is null ?
		assertEqual(exec("function r=myProd(m, n), if nargin==1, r=m*m; else r=m*n; end end myProd(3);"),9);

	}
	
	public static void testVariableNode() {
		VariableNode v = new VariableNode();
		v.setType(Type.DOUBLE_TYPE);
		v.setLVTIndex(Type.DOUBLE_TYPE, 1);
		v.setType(Type.getType("D"));
		v.setLVTIndex("D", 2);
		assertEqual(v.getLVTIndex(),2);
		
		v.setType(Type.DOUBLE_TYPE);
		assertEqual(v.getLVTIndex(),2);
	}
	
	public static void testMatrixInit() {
		assertEqual(exec("[1 2 3];"), getVector(1,2,3).transpose());
		assertEqual(exec("[1,2,3];"), getVector(1,2,3).transpose());
		assertEqual(exec("[1, 2, 3];"), getVector(1,2,3).transpose());
		assertEqual(exec("[1  2   3];"), getVector(1,2,3).transpose());
		assertEqual(exec("[1,  2  ,  3];"), getVector(1,2,3).transpose());

		assertEqual(exec("a=1; b=2; c=3; d=4; [a b; c d];"), getMatrix(new double[][]{{1,2},{3,4}}));
		
		assertEqual(exec("A=[1 2; 3 4]; B=[5 6; 7 8]; [A B];"),
				getMatrix(new double[][] {
				      {1.00,      2.00,      5.00,      6.00},
				      {3.00,      4.00,      7.00,      8.00} }));
		assertEqual(exec("A=[1 2; 3 4]; B=[5 6; 7 8]; [A, B];"),
				getMatrix(new double[][] {
		      {1.00,      2.00,      5.00,      6.00},
		      {3.00,      4.00,      7.00,      8.00} }));
		
		assertEqual(exec("A=[1 2; 3 4]; B=[5 6; 7 8]; [A; B];"),
				getMatrix(new double[][] {
		      {1.00,      2.00},
		      {3.00,      4.00},
		      {5.00,      6.00},
		      {7.00,      8.00},
		      }));

		//exec("A=[1 2; 3 4]; B=[5 6 7 8]; [A B]"); //pad 0???

		assertEqual(exec("A=[1 2; 3 4]; B=[5 6; 7 8]; C=[11 22 33 44; 55 66 77 88]; [[A, B]; C];"),
				getMatrix(new double[][] {
			{ 1.00,      2.00,      5.00,      6.00},
			{ 3.00,      4.00,      7.00,      8.00},
			{11.00,     22.00,     33.00,     44.00},
			{55.00,     66.00,     77.00,     88.00} }));
		
		assertEqual(exec("A=[1 2; 3 4]; B=[5 6; 7 8]; C=[11 22 33 44; 55 66 77 88]; [A, B; C];"),
				getMatrix(new double[][] {
			{ 1.00,      2.00,      5.00,      6.00},
			{ 3.00,      4.00,      7.00,      8.00},
			{11.00,     22.00,     33.00,     44.00},
			{55.00,     66.00,     77.00,     88.00} }));
		
		assertEqual(exec("A=[1 2; 3 4]; B=[5 6; 7 8]; C=[11 22 33 44; 55 66 77 88]; [[A; B],C'];"),
				getMatrix(new double[][] {
			{1.00,      2.00,     11.00,     55.00},
			{3.00,      4.00,     22.00,     66.00},
			{5.00,      6.00,     33.00,     77.00},
			{7.00,      8.00,     44.00,     88.00} }));
	}
	
	/**
	 * [A, B] = [C, D]
	 * [m, n] = size(A)
	 */
	public static void testMultiAssign() {
//		exec("[a b]=[2 3]; a");
//		exec("[a b]=[2 3]; b");
		
//		exec("A=[1 2; 3 4]; B=[5 6 7 8]; [C D]=[A B]; C\n D\n [C D]=[2 3]; C\n D\n");
		exec("A=[1 2; 3 4]; B=[5 6 7 8]; [C D]=[A B]; C\n D\n");

//		exec("function [A B]=myfun(), A=[1 2; 3 4]; B=[5 6; 7 8]; end myfun()");
		exec("function [A B]=myfun(), A=[1 2; 3 4]; B=[5 6; 7 8]; end [A B]=myfun()\n A\n B\n");
//		exec("function [A B]=myfun(), A=[1 2; 3 4]; B=[5 6; 7 8]; end A=myfun() ");
//		exec("function [A B]=myfun(), A=[1 2; 3 4]; B=[5 6; 7 8]; end [A]=myfun() ");
//		exec("A=[1 2; 3 4]; B=[5 6 7 8]; [C D]=[A B]; C\n D\n [C D]=[2 3]; C\n D\n");
		exec("A=[1 2; 3 4]; B=[5 6 7 8]; [C D]=[A B]; C\n D\n");		
}
	
	/**
	 * A(:)=[1 2 3]
	 * A(:,1)=[1 2 3]'
	 */
	public static void testMatrixAssign() { //ExprArrayAssign
//		exec("[a b]=[2 3]; a");
//		exec("[a b]=[2 3]; b");
		

	}
	
	/**
	 * A(1,2)
	 * A(:)
	 * A(1:3,1:2:5)
	 */
	public static  void testMatrixAccess() {
		double[][] array = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
		double[][] array3 = {{1,2,3,4,5,6},{11,22,33,44,55,66}};
		Matrix A = new Matrix(array);
		Matrix C = new Matrix(array3);
		Matrix M = new Matrix(new double[][]{{1,2},{3,4}});

		Matrix D = new Matrix(
				new double[]{1,2,3,4,5,6,7,8,9,10,
						11,12,13,14,15,16,17,18,19,20,
						21,22,23,24,25,26,27,28,29,30},
				10).transpose();
		
		if(MatrixAccessNode.INDEX_BASE == 1) {
			assertEqual(exec("A=[1 2 3 4 5 6 7 8 9 10; 11 12 13 14 15 16 17 18 19 20; 21 22 23 24 25 26 27 28 29 30]; A(1, 1:2)"), 
					D.getMatrix(0, 0, 0, 1));
			assertEqual(exec("C ( 2, 2:3:6 )", getMap("C",C)), C.getMatrix(1,1, new int[]{1,4}));
			assertEqual(exec("C(1, 1:2:6)", getMap("C",C)), C.getMatrix(0,0, new int[]{0,2,4}));
			assertEqual(exec("C(:, 1:2:6)", getMap("C",C)), C.getMatrix(0,1, new int[]{0,2,4}));
		} else {
			assertEqual(exec("A=[1 2 3 4 5 6 7 8 9 10; 11 12 13 14 15 16 17 18 19 20; 21 22 23 24 25 26 27 28 29 30]; A(0, 0:1)"), 
					D.getMatrix(0, 0, 0, 1));
			assertEqual(exec("C ( 1, 1:3:5 )", getMap("C",C)), C.getMatrix(1,1, new int[]{1,4}));
			assertEqual(exec("C(0, 0:2:5)", getMap("C",C)), C.getMatrix(0,0, new int[]{0,2,4}));
			assertEqual(exec("C(:, 0:2:5)", getMap("C",C)), C.getMatrix(0,1, new int[]{0,2,4}));
		}
		if(MatrixAccessNode.INDEX_BASE == 1) {
			assertEqual(exec("A(:,2:3)", getMap("A",A)), A.getMatrix(0,2,1,2));
			assertEqual(exec("A=[1 2;3 4]\n A(:,1)"), getVector(1,3));
			assertEqual(exec("A=[1 2;3 4]\n A(2,:)"), getVector(3,4).transpose());
			assertEqual(exec("A=[1 2;3 4]\n A(:,:)"), M);
		} else {
			assertEqual(exec("A(:,1:2)", getMap("A",A)), A.getMatrix(0,2,1,2));
			assertEqual(exec("A=[1 2;3 4]\n A(:,0)"), getVector(1,3));
			assertEqual(exec("A=[1 2;3 4]\n A(1,:)"), getVector(3,4).transpose());
			assertEqual(exec("A=[1 2;3 4]\n A(:,:)"), M);
		}	
	}
	
	public static void testShaddowVariables() {
		assertEqual(exec("sum=0; sum2=0.0; if true, sum2=sum+0.1; end sum2;"), 0.1);
		//assertEqual(exec("sum=0; if true, sum2=sum+0.1; end sum2;"), 0.1);
		assertEqual(exec("sum=0; if true, sum=sum+1; end sum;"), 1);
		assertEqual(exec("sum=0; if true, sum=sum+0.1; end sum;"), 0.1);
		assertEqual(exec("sum=0; if true, sum+=0.1; end sum;"), 0.1);
		//assertEqual(exec("sum=0.0; if true, sum2=0.1; end print(sum2);"), 0.1);
		//bugfix: double type sum (sumD) may be non-initialized
		assertEqual(exec("sum=0.0; if true, sum+=0.1; end sum;"), 0.1); 
		//assertEqual(exec("a=0.0; if true, sum+=0.1; end sum"), 0.1); 
		
		assertEqual(exec("sum=0; sum=sum+0.1; "), 0.1);
		assertEqual(exec("sum=0; sum+=3; sum;"), 3);
		assertEqual(exec("sum=0; sum+=3; sum+=0.1; sum;"), 3.1);

		assertEqual(exec("sum=0; for i=[1 2 3], sum+=i; end sum+=1;"), 7.0);
		assertEqual(exec("sum=0; for i=[1 2 3], sum+=i; end sum;"), 6.0);
		assertEqual(exec("sum=0.0; for i=[1 2 3], sum=sum+i; end sum;"), 6.0);//only sumD
		assertEqual(exec("sum=0; for i=[1 2 3], sum=6; sum=sum+i; end sum;"), 9.0);
		assertEqual(exec("sum=0; for i=[1 2 3], sum=sum+i; end sum;"), 6.0);
	}
	
	public static void testEndIndex() {
		assertEqual(exec("A=[10 20 30; 40 50 60; 70 80 90]; A(2:end, 2:end)=[500 600; 800 900];"),
				getMatrix(new double[][]{{10, 20, 30},{40,500,600},{70,800,900}}));
		
		assertEqual(exec("A=[10 20 30; 40 50 60]; A(end:-2:1)=[1 3 5];"),
				getMatrix(new double[][]{{10, 20, 30},{5,3,1}}));
		
		assertEqual(exec("A=[10 20 30; 40 50 60]; A(end:-1:1)=[1 2 3 4 5 6];"),
				getMatrix(new double[][]{{6,4,2},{5,3,1}}));
		
		assertEqual(exec("A=[10 20 30; 40 50 60]; A(1:3)=[1 2 3];"),
				getMatrix(new double[][]{{1,3,30},{2,50,60}}));
		
		assertEqual(exec("A=[10 20 30; 40 50 60]; A(1:6)=[1 2 3 4 5 6];"),
				getMatrix(new double[][]{{1, 3, 5},{2,4,6}}));
		
		assertEqual(exec("A=[10 20 30; 40 50 60]; A(4)=500;"),
				getMatrix(new double[][]{{10, 20, 30},{40,500,60}}));

		/**
		 * 1   2  3
		 * 4   5  6
		 * 7   8  9
		 * 10 11 12
		 * 13 14 15
		 */
		assertEqual(exec("A=[1 2 3; 4 5 6; 7 8 9; 10 11 12; 13 14 15]; A(end:-1:1);"),
				getVector(15,12,9,6,3,14,11,8,5,2,13,10,7,4,1));
		assertEqual(exec("A=[1 2 3; 4 5 6; 7 8 9; 10 11 12; 13 14 15]; idx=1:2:10; A(idx);"),
			getVector(1,7,13,5,11));
		
		assertEqual(exec("A=[1 2 3; 4 5 6; 7 8 9; 10 11 12; 13 14 15]; A(:);"),
				getVector(1,4,7,10,13,2,5,8,11,14,3,6,9,12,15));
				
		assertEqual(exec("A=[1 2 3; 4 5 6; 7 8 9; 10 11 12; 13 14 15]; A(4:end,2:end);"),
				getMatrix(new double[][]{{11,12},{14,15}}));

		assertEqual(exec("A=[10 20 30; 40 50 60]; A(4:6);"),
				getVector(50,30,60));
		assertEqual(exec("A=[10 20 30; 40 50 60]; A(4);"), 50.0);
		assertEqual(exec("A=[10 20 30; 40 50 60]; A(4:end);"),
				getVector(50,30,60));
		
		assertEqual(exec("A=[10 20 30; 40 50 60]; A(1:3);"),
				getVector(10,40,20));


	}
	
	public static void testPrint() {
		exec("error('aaa')");
		//exec("'aaa\n bbb'"); //should output error
		exec("disp('test disp');");
		exec("rand(3)");
		exec("rand(3,4)");
		
	}
	
	public static void testComment() {
		//exec("% aaa\n 3%4");
	}
	
	public static void testBasic3() {
		
		assertEqual(exec("A=[10 20 30; 40 50 60]; B=[1 2; 1 3]; A(B)=1;"),
				getMatrix(new double[][]{{1,1,30},{1,50,60}}));
		
		assertEqual(exec("A=[10 20 30; 40 50 60]; B=[1 2; 1 3]; A(B)=[1 2; 3 4];"),
				getMatrix(new double[][]{{3,4,30},{2,50,60}}));
		
		assertEqual(exec("A=[1 2 3; 4 5 6]; A(:)=1;"),
				getMatrix(new double[][]{{1,1,1},{1,1,1}}));
		assertEqual(exec("A=[1 2 3; 4 5 6]; A(:)=[10 20 30; 40 50 60];"),
				getMatrix(new double[][]{{10,20,30},{40,50,60}}));
		
		//Test comment
		assertEqual(exec("if n>1 %\n 1; else 2; end",getMap("n",2)), 1);
		
		assertEqual(exec("if n>1 %comment here\n 1; else 2; end",getMap("n",2)), 1);
		
		assertEqual(exec("cidx = (0:m-1)';\n 1;", getMap("m",5.0)),1);
		
		assertEqual(exec("cidx = (0:m-1)';", getMap("m",5.0)), getVector(0,1,2,3,4));

		assertEqual(exec("A=[1 2 3]; B=[1 5 6]; isequaln(A(1),B(1));"), true);
		assertEqual(exec("A=[1 2 3]; B=[1 5 6]; ~isequaln(A(1),B(1));"), false);
		
		assertEqual(exec("A=[1 2 3; 4 5 6]; A=A(:);"), getVector(1,4,2,5,3,6));
		assertEqual(exec("A=[1 2 3]; A(1)=10; A;"), getVector(10,2,3).transpose());
		assertEqual(exec("A=[1 2 3]; A(1,1)=10; A;"), getVector(10,2,3).transpose());
		
		assertEqual(exec("A=[1 2 3]; A(1);"),   1.0);
		assertEqual(exec("A=[1 2 3]; A(1,1);"), 1.0);
		
		/**
		 * 1 2 3    1 1 1
		 * 1 2 3 +  2 2 2
		 * 1 2 3    3 3 3
		 */
		assertEqual(exec("A=[1 2 3]; B=[1 2 3]'; bsxfun(@plus, A,B);"), 
				getMatrix(new double[][]{{2,3,4},{3,4,5},{4,5,6}}));
		
		
		assertEqual(exec("A=[1 2 3]'; B=[1 2 3]; bsxfun(@plus, A,B);"),
				getMatrix(new double[][]{{2,3,4},{3,4,5},{4,5,6}}));
		
		assertEqual(exec("A=[1 2 3]; B=[1 2 3]; bsxfun(@plus, A,B);"), getVector(2,4,6).transpose());

		assertEqual(exec("A=[1 2 3]; B=[4 5 6]; [A, B];"), getVector(1,2,3,4,5,6).transpose());
		assertEqual(exec("A=[1 2 3]; B=[4 5 6]; [A; B];"), getMatrix(new double[][]{{1,2,3},{4,5,6}}));
		
		
		assertEqual(exec("A=[4 5 6; 1 2 3]; B=[10 20 30 40 50 60 70 80 90]; B(A);"),
				getVector(40,10,50,20,60,30));
		
		assertEqual(exec("A=[1 2 3 4]; B=[10 20 30 40 50 60 70 80 90]; B(A);"),
				getVector(10,20,30,40));
		
		
		assertEqual(exec("3:1"), getVector(3,2,1).transpose());
		assertEqual(exec("A=[1 2 3 4 5]; B=A(1,3:1);"), getVector(3,2,1).transpose());
		assertEqual(exec("cidx = (10:-1:1)';"), getVector(10,9,8,7,6,5,4,3,2,1));
		assertEqual(exec("A=[1 2 3]; A(:);"), getVector(1,2,3));

		assertEqual(exec("sum=0.0; for i=[1 2 3], sum+=i; end sum"), 6.0);
		assertEqual(exec("cidx = ([0 1 2])'; cidx;"), getVector(0,1,2));
		assertEqual(exec("cidx = (0.0:1.0:m-1)'; cidx;", getMap("m",5.0)), getVector(0,1,2,3,4));
		assertEqual(exec("cidx = (0:m-1)'; cidx", getMap("m",5)), getVector(0,1,2,3,4));

		assertEqual(exec("c>r && c>r", getMap("c",1,"r",2)), false);
		assertEqual(exec("isnumeric(c) && isnumeric(r)", getMap("c",1,"r",2)), true);
		
		assertEqual(exec("10:-1:1"), getVector(10,9,8,7,6,5,4,3,2,1).transpose());
		assertEqual(exec("A=[1 2 3]; B=[10 20 30]; bsxfun(@plus, A, B)"), getVector(11,22,33).transpose());
		
	}
	
	public static void testNArgin() {
		assertEqual(exec("function fun(a, b), nargin; end fun()"),   0);
		assertEqual(exec("function fun(a, b), nargin; end fun(2)"),  1);
		assertEqual(exec("function fun(a, b), nargin; end fun(2,4)"),2);

		assertEqual(exec("function R=myZeros(m, n), if nargin==1, R=zeros(m, m); else R=zeros(m,n); end end myZeros(3);"),
				getMatrix(new double[3][3]));
		assertEqual(exec("function R=myZeros(m, n), if nargin==1, R=zeros(m, m); else R=zeros(m,n); end end myZeros(2,3);"),
				getMatrix(new double[2][3]));
		
		//early return test
		//TODO: return value need to be specified in the following case
		//exec("function fun(a), if a<0, return end a+1; end fun(-1)");
		exec("function fun(a), if a<0, return 0 end a+1; end fun(-1)");
		
		//TODO:type of return value ('r')? 
		// assertEqual(exec("function r=fun(a), if a<0, return 0 end a+1; end fun(-1)"), 0);
		assertEqual(exec("function r=fun(a), if a<0, return 0 end a+1; end fun(-1)"), 0);

		//Two possible ways to 
		//1. Set the default value of optional parameter to 0/null
		//   Problem: it is not good for function calls inside the body, e.g. zeros(a,b) (what if no overloaded function zeros(double, double) provided?)
		//2. Set type of an optional parameter to null, so the parameter can be ignored
		//   Problem: how to  compile a+b ?
		//3. Combine the two ways? (sounds good)
		assertEqual(exec("function c=fun(a, b), if nargin < 2, return; end c=a+b; end fun();"),   null);
		assertEqual(exec("function c=fun(a, b), if nargin < 2, return; end c=a+b; end fun(1);"),  null);
		assertEqual(exec("function c=fun(a, b), if nargin < 2, return; end c=a+b; end fun(1,2);"),3);
//
//		
//		//exec("function fun(a, b), a+b; end fun(2,4,6)"); //Too many parameters for function fun!
		assertEqual(exec("function fun(a, b), a+b; end fun(2,4)"), 6);
		assertEqual(exec("function fun(a, b), a+b; end fun(2)"), null);
		
	}
	
	public static void testBuildinFunc(){
		assertEqual(exec("A = [1 2; 3 4; 5 6]; size(A);"), getVector(3,2).transpose());

		assertEqual(exec("mod(3.0, 0.0);"), 3.0);
		assertEqual(exec("rem(3.0, 0.0);"), Double.NaN);
		assertEqual(exec("floor(1.1);"), 1.0);
		assertEqual(exec("ceil(1.1);"), 2.0);
		
		assertEqual(exec("fix(1.1);"), 1.0);
		assertEqual(exec("fix(-1.1);"), -1.0);
		
		assertEqual(exec("floor(-1.1);"), -2.0);
		assertEqual(exec("ceil(-1.1);"), -1.0);
		
		assertEqual(exec("round(1.4);"), 1L);
		assertEqual(exec("round(1.5);"), 2L);
		assertEqual(exec("round(1.6);"), 2L);
		assertEqual(exec("round(-1.4);"), -1L);
		assertEqual(exec("round(-1.5);"), -1L);
		assertEqual(exec("round(-1.6);"), -2L);
		
		assertEqual(exec("zeros(3);"), getMatrix(new double[3][3]));
		assertEqual(exec("zeros(3,5);"), getMatrix(new double[3][5]));
		assertEqual(exec("ones(3);"), getMatrix(new double[][]{{1,1,1},{1,1,1},{1,1,1}}));
		assertEqual(exec("ones(3,5);"), getMatrix(new double[][]{{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}}));
		assertEqual(exec("eye(3);"), getMatrix(new double[][]{{1,0,0},{0,1,0},{0,0,1}}));
		assertEqual(exec("eye(3,5);"), getMatrix(new double[][]{{1,0,0,0,0},{0,1,0,0,0},{0,0,1,0,0}}));
		
		assertEqual(exec("size(rand(3));"), getVector(3,3).transpose());
		assertEqual(exec("size(rand(3,4));"), getVector(3,4).transpose());
		
		assertEqual(exec("linspace(0,1,5);"), getVector(0,0.2,0.4,0.6,0.8,1.0).transpose());
		
		assertEqual(exec("math.sin(1.0);"), Math.sin(1.0));

		assertEqual(exec("A=[1 2 3; 4 5 6]; B=[7 8 9; 10 11 12]; vertcat(A,B);"),
				getMatrix(new double[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}})
				);
		assertEqual(exec("A=[1 2 3; 4 5 6]; B=[7 8 9; 10 11 12]; horzcat(A,B);"),
				getMatrix(new double[][]{{1,2,3,7,8,9},{4,5,6,10,11,12}})
				);
	}
	
	public static void testFunction(){

		exec(" A=[1 2; 3 4]; B=[5 6; 7 8]; [A B] ");
		
		exec("function A=myfun(), A=[1 2; 3 4]; B=[5 6; 7 8]; end myfun()");
		exec("function B=myfun(), A=[1 2; 3 4]; B=[5 6; 7 8]; end myfun()");
		exec("function myfun(), A=[1 2; 3 4]; B=[5 6; 7 8]; [A B]; end myfun()");
		
		//function call and assignment
		exec("function [A B]=myfun(), A=[1 2; 3 4]; B=[5 6; 7 8]; end myfun()");
		exec("function [A B]=myfun(), A=[1 2; 3 4]; B=[5 6; 7 8]; end [A B]=myfun()\n A\n B\n");
		exec("function [A B]=myfun(), A=[1 2; 3 4]; B=[5 6; 7 8]; end A=myfun() ");
		exec("function [A B]=myfun(), A=[1 2; 3 4]; B=[5 6; 7 8]; end [A]=myfun() ");

		
		exec("function [A B]=myfun(), A=1; B=2; end myfun()");

		
//		Jama.Matrix[] o = (Jama.Matrix[])exec("A=[1 2; 3 4]; B=[5 6 7 8]; [A B];");
//		for(Jama.Matrix m : o) m.print(8, 2);
//		Jama.Matrix o = (Jama.Matrix)exec("A=[1 2; 3 4]; B=[5 6 7 8]; [A B];");
//		o.print(8, 2);
		
	
		assertEqual(exec("function a=fun(x), if x<0, return end a=x*x; end fun(1)"), 1);
		assertEqual(exec("function a=fun(x), if x<0, return end a=x*x; end fun(-1)"),0);

		assertEqual(exec("function a=fun(x), if x<0, return end a=x*[1 2; 3 4]; end fun(1)"),
				getMatrix(new double[][]{{1,2},{3,4}}));
		assertEqual(exec("function a=fun(x), if x<0, return end a=x*[1 2; 3 4]; end fun(-1)"),
				null);
		//a = ???
		assertEqual(exec("function a=fun(x), if x<0, return a end a=x*[1 2; 3 4]; end fun(-1)"),
				null);

		assertEqual(exec("function fun(a), b=a+2; if b>3, return 0 end return b; end fun(1)"), 3);
		assertEqual(exec("function fun(a), b=a+2; if b>3, return 0 end return b; end fun(6)"), 0);
		assertEqual(exec("function fun(a), b=a+2; return 1; end fun(1);"),1);

		assertEqual(exec("function H = invhilb(n)\n H = zeros(n)\n end invhilb(3)"), 
				getMatrix(new double[3][3]));

		
		//Test order of parameters in function arguments
		assertEqual(exec("function fib(r, n); A=[1 1; 1 0]; if n<1; r; else r=A*r; fib(r, n-1); end end fib([1 1]', 5)"), 
				new Jama.Matrix(new double[]{13,8},2));
		assertEqual(exec("function fib(a, n); A=[1 1; 1 0]; if n<1; a; else a=A*a; fib(a, n-1); end end fib([1 1]', 5)"),
				new Jama.Matrix(new double[]{13,8},2));
		assertEqual(exec("function myfun(b, a); a-b; end myfun(3,1)"),-2);
		assertEqual(exec("function myfun(a, b); b-a; end myfun(3,1)"),-2);
		assertEqual(exec("function s=fun(n), s=n+1\n end fun(5);"),6);


		assertEqual(exec("function s=fun(n), s=n+1\n end fun(5);"),6);
		
		assertEqual(exec("function fib(n), if n<=1; 1; else fib(n-1)+fib(n-2); end; end; fib(42)"),433494437);
//		assertEqual(exec("function fib(n) if n<=1; 1; else fib(n-1)+fib(n-2); end end fib(42)"),433494437);
//java.lang.RuntimeException: Cannot infer type for if statement: if(var(n:I:param:0) <= 1) {[var(r:D:local:1)=1]} else {[var(r:D:local:1)=call FCfib9.fib(var(n:I:param:0) - 1, ) + call FCfib9.fib(var(n:I:param:0) - 2, )]}
//		at io.lambdacloud.node.IfNode.getType(IfNode.java:194)

		assertEqual(exec("function r=fib(n)\n if n<=1\n r=1; else r=fib(n-1)+fib(n-2); end\n end\n fib(42)"),433494437);
		//This case is hard to fix
		//the stack frame is not balanced
		//assertEqual(exec("function r=fib(n)\n if n<=1\n r=1; else r=fib(n-1)+fib(n-2)\n end end\n fib(42)"),433494437);

		assertEqual(exec("function myfun(a, b)\n c=a+b\n d=a-b\n [c d]\n end\n myfun(10,100)"), 
				getVector(110,-90).transpose());
		assertEqual(exec("function [c d]=myfun(a, b)\n c=a+b\n d=a-b\n end\n myfun(10,100)"), 
				getVector(110,-90).transpose());
		assertEqual(exec("function [c d]=myfun(a, b)\n c=a+b\n d=a-b\n end\n myfun(10.,100.)"), 
				getVector(110,-90).transpose());
		assertEqual(exec("function myfun(a, b)\n c=a+b\n d=a-b\n [c d]\n end\n myfun(10.,100.)"), 
				getVector(110,-90).transpose());
		
		assertEqual(exec("function myfun(a)\n a+1\n a+2; end\n myfun(1)"), 3);
		assertEqual(exec("function myfun(a)\n a+1\n a+2\n end\n myfun(1)"), 3);
		assertEqual(exec("function a=myfun(a)\n a+1\n a+2\n end\n myfun(1);"), 1);
		assertEqual(exec("function a=myfun(a)\n a+1\n a+2\n end\n myfun(1)"), 1);
		
		assertEqual(exec("function [c d] = myfun(a, b)\nc=a+b; d=a-b;a;b;a+1\nend\nmyfun(10,100)"), 
				getVector(110,-90).transpose());
		assertEqual(exec("function [c d] = myfun(a, b)\nc=a+b; d=a-b;\nend\nmyfun(10,100)"), 
				getVector(110,-90).transpose());
		assertEqual(exec("function c = myfun(a, b)\nc=a+b\nend\nmyfun(10,100)"),110);
		

		assertEqual(exec("function myfun(n); a=n; a+=1.5; a=3; a end myfun(3)"),3);
		assertEqual(exec("function myfun(n); R=zeros(n); R end myfun(3)"),
				getMatrix(new double[3][3]));
		assertEqual(exec("function myfun(n); R=zeros(n); R end myfun(3.5)"),
				getMatrix(new double[3][3]));
		assertEqual(exec("function GE(A); sz=size(A); m=sz(1,1); n=sz(1,2) end A=[1 2 3; 4 5 6]; GE(A)"), 3.0);
		assertEqual(exec("function GE(A); sz=size(A); m=sz(1,1); n=sz(1,2); U=triu(A)\n m\n n\n end A=[1 2 3; 4 5 6; 7 8 9]; GE(A)"),
				3.0);
		assertEqual(exec("function GE(A); U=A; U end A=[1 2 3; 4 5 6; 7 8 9]; GE(A)"),
				getMatrix(new double[][]{{1,2,3},{4,5,6},{7,8,9}}));
		assertEqual(exec("function U = GE(A); U=triu(A); end A=[1 2 3; 4 5 6; 7 8 9]; GE(A)"),
				getMatrix(new double[][]{{1,2,3},{0,5,6},{0,0,9}}));
//		assertEqual(exec("function r=fib(n)\n  r=fib(n-1); end\n fib(42)"),433494437);
		assertEqual(exec("function r=fib(n)\n if n<=1\n r=1; else r=fib(n-1)+fib(n-2); end\n end\n fib(4)"),5);
		
		System.out.println("testing fib(42):");
		assertEqual(exec("function r=fib(n)\n if n<=1\n r=1; else r=fib(n-1)+fib(n-2); end\n end\n fib(42)"),433494437);
		System.out.println("done!");
	}
	
	public static void testBasic2(){
		
		assertEqual(exec("'aaa'"), "aaa");
		assertEqual(exec("'aaa'+'bbbb'"), "aaabbbb");
		assertEqual(exec("'aaa'+\"bbbb\""), "aaabbbb");
		
		assertEqual(exec(" 1~=2 "), true);
		assertEqual(exec("if 1~=2, 3 end"), null);
		assertEqual(exec("for i in 1:3, i; end"), null);
		assertEqual(exec("for i in 1:3, i end"),  null);
		assertEqual(exec("for i in 1:3, i end i"), 4);

		assertEqual(exec("a=[1 2;3 4]; a+=1; a"), getMatrix(new double[][]{{2,3},{4,5}}));
				
		//VariableNode.mapLVTIndex is set at constructor
		assertEqual(exec("a=1; a=2L; a=1.1; a"), 1.1);

		assertEqual(exec("if 1>2; 1+2; 2+2; elseif 2>3; 0+1; elseif 3>4; 1+2; else 2+3; 3/4; 5*7; end"),35);
		assertEqual(exec("if 1>2; 1; elseif 1<2; 4; end"), null);
		//???else if???assertEqual(exec("a=0; if 1>2; a=1; elseif 1<2; a=4; end a"), 4);

		assertEqual(exec("if n>1; 10 else -10 end", new int[]{2}),10);
		assertEqual(exec("r=0; for i=1:3; for j=10:10:30; r=i+j end end r"),33);
		assertEqual(exec("sum=0.0; for i=[10 20 30], sum+=i; end sum;"), 60.0);
		assertEqual(exec("sum=0.0; for i=[10 20 30; 40 50 60], sum+=i; end sum;"), 210.0);
		
		assertEqual(exec("A=[1 2; 3 4]; A(1,:)=[100 200]; A"), getMatrix(new double[][]{{100,200},{3,4}}));
		assertEqual(exec("A=[1 2; 3 4]; A(1,1)=[100]; A"), getMatrix(new double[][]{{100,2},{3,4}}));//???
		assertEqual(exec("A=[1 2 3 4 5 6; 11 22 33 44 55 66]; A(:,1:2:5)=[100 300 500; 111 333 555]; A"), 
				getMatrix(new double[][]{{100,2,300,4,500,6},{111,22,333,44,555,66}}));
		
		assertEqual(exec("A=[1 2 3 4 5 6; 11 22 33 44 55 66]; A(:,:)=9; A"),
				getMatrix(new double[][]{{9,9,9,9,9,9},{9,9,9,9,9,9}}));
		
		assertEqual(exec("A=[1 2 3 4 5 6; 11 22 33 44 55 66]; A(1,1)=9; A"),
				getMatrix(new double[][]{{9,2,3,4,5,6},{11,22,33,44,55,66}}));
		
		assertEqual(exec("A=[1 2 3 4 5 6; 11 22 33 44 55 66]; A(:,1:2:5)=9; A"),
				getMatrix(new double[][]{{9,2,9,4,9,6},{9,22,9,44,9,66}}));
		
		assertEqual(exec("r=0; while i<10; i+=1; r=i end r", new int[]{5}),10);
		
		//////mode//////
		assertEqual(exec("5 % 3"),5); //% is for comment
		assertEqual(exec("mod(5,3)"),2.0);
		
		assertEqual(exec("if mod(i,2)==0; a+=1; else b+=1; end i\n a\n b\n", 
				new int[]{4,10,0}),10);//a=4,b=10,i=0
		
		assertEqual(exec("a=10; b=0; tic; while i<10; i+=1;  end toc; a\n b\n", new int[]{5}),0);
	
		assertEqual(exec("a=10; b=0; tic; while i<10; i+=1; if mod(i,2)==0; a+=1; else b+=1; end end toc; a\n b\n", 
				new int[]{5}),2);
		//////////////

		assertEqual(exec("A=[1 2; 3 4]; A+=[10 20; 30 40]; A"), getMatrix(new double[][]{{11,22},{33,44}}));
		assertEqual(exec("a=1; a+=1; a"),2);
		assertEqual(exec("A=[1 2; 3 4]; A-=[10 20; 30 40]; A"), getMatrix(new double[][]{{-9,-18},{-27,-36}}));
		
		assertEqual(exec("A=[1 2; 3 4]; A*= 10; A"), getMatrix(new double[][]{{10,20},{30,40}}));
		
		assertEqual(exec("A=[1 2; 3 4]; A*=[1 2; 1 3]; A"), getMatrix(new double[][]{{3,8},{7,18}}));
		
		assertEqual(exec("A    =    [1 2; 3 4]; A    *=     10; A"), getMatrix(new double[][]{{10,20},{30,40}}));
		assertEqual(exec("A = [1 2; 3 4]; A *= [1 2; 1 3]; A"), getMatrix(new double[][]{{3,8},{7,18}}));
		
		
		assertEqual(exec("A = [1 2; 3 4]; A(1,1)"),1.0);
	
		assertEqual(exec(" A = [1 2; 1 -1]\n b=[5 -1]'\n A/=b; A"), getMatrix(new double[][]{{1,2},{1,-1}}).solve(getVector(5,-1)));
		Jama.Matrix A = getMatrix(new double[][]{{1,2},{1,-1}});
		Jama.Matrix b = getVector(5,-1);
		A.print(8, 2);
		b.print(8, 2);
		A.solve(b).print(8, 2);
		
		assertEqual(exec("A = [1 2; 3 4]; A(:)"), getVector(1,3,2,4));
		assertEqual(exec("A = [1 2; 3 4; 5 6]; size(A)"), getVector(3,2).transpose());
		assertEqual(exec("A = [1 2; 3 4]; length(A)"), 2); //max(rowDim,colDim)

		assertEqual(exec("A = [1 2; 3 4]; A(1.0, 1)"),1.0);

		//1 2
		//3 4
		//5 6
		assertEqual(exec("A = [1 2; 3 4; 5 6]\n reshape(A,2,3)"), getMatrix(new double[][]{{1,5,4},{3,2,6}}));
		assertEqual(exec("A = [1 3; 4 2]\n repmat(A,2,3)"), 
		//BytecodeSupport.repmat(getMatrix(new double[][]{{1 3},{4 2}}),2,3));
				getMatrix(new double[][]{
					{1.00,      3.00,      1.00,      3.00,      1.00,      3.00},
					{4.00,      2.00,      4.00,      2.00,      4.00,      2.00},
					{1.00,      3.00,      1.00,      3.00,      1.00,      3.00},
					{4.00,      2.00,      4.00,      2.00,      4.00,      2.00}}));
		
		assertEqual(exec("A = [1 3; 4 2]; ones(A)"), getMatrix(new double[][]{{1,1},{1,1}}));
		assertEqual(exec("A = [1 3; 4 2]; zeros(A)"), getMatrix(new double[][]{{0,0},{0,0}}));
		
		assertEqual(exec("A = []; A\n length(A)\n numel(A)"),0);

		assertEqual(exec("4^2"),16);
		
		//assertEqual(exec("r = -((n-j+1)*r*(n+j-1))/(j-1)^2; r", new double[]{1,2,3}),Double.NEGATIVE_INFINITY);
		
		assertEqual(exec("r=0; for i = 1:n; r+=i end r", new int[]{3}),6);
		
		//?????assertEqual(exec("p=n; for i = 1:n; r = p*p; for j = i+1:n; r = -((n-j+1)*r*(n+j-1))/(j-1)^2; end p = ((n-i)*p*(n+i))/(i^2); end", new int[]{3}),
		//?????		Double.NEGATIVE_INFINITY);
		//?????assertEqual(exec("p=n; for i = 1:n; r = p*p; for j = i+1:n; r = -((n-j+1)*r*(n+j-1))/(j-1); end p = ((n-i)*p*(n+i))/(i^2); end", new int[]{3}),
		//?????		Double.NEGATIVE_INFINITY);
		//?????assertEqual(exec("p=n; for i = 1:n; r = p*p; for j = i+1:n; r = -((n-j+1)*r*(n+j-1)); end p = ((n-i)*p*(n+i))/i end", new int[]{3}),
		//?????		Double.NEGATIVE_INFINITY);
		//assertEqual(exec("p=n; for i = 1:n; i^2  end", new int[]{3});
		//assertEqual(exec("p=n; for i = 1:n; p^2; end", new int[]{3});
		assertEqual(exec("r=0; if n>1; r=p^2 else r=p end r", new int[]{2,3}),9);

		//?????assertEqual(exec("function H = invhilb(n); H=zeros(n); p = n; for i = 1:n; r = p*p;  p end r=0.0; p=0.0; end invhilb(3)"),
		//?????		100);
//java.lang.IllegalArgumentException: wrong number of arguments
//		assertEqual(exec("-((n-j+1)*r*(n+j-1))/((j-1)*(j-1))",getMap("i",1,"j",2,"n",3,"r",9));
		assertEqual(exec("-((n-j+1)*r*(n+j-1))",getMap("j",2,"n",3,"r",9)),-72);
		assertEqual(exec("(n-j+1)*r*(n+j-1)",getMap("j",2,"n",3,"r",9)),72);
		assertEqual(exec("r*(n+j-1)",getMap("j",2,"n",3,"r",9)),36);
		assertEqual(exec("(n-j+1)*r",getMap("j",2,"n",3,"r",9)),18);
		
		assertEqual(exec("n-j+1",getMap("j",2,"n",3)),2); //n-(j+1)???
		assertEqual(exec("n+j-1",getMap("j",2,"n",3)),4);
		assertEqual(exec("n/j*2",getMap("j",2,"n",3)),3.0);
		assertEqual(exec("(n/j)*2",getMap("j",2,"n",3)),3.0);
		
		
		assertEqual(exec("((j-1)*(j-1))",getMap("j",2)),1);
		assertEqual(exec("-((n-j+1)*r*(n+j-1))/((j-1)*(j-1))",getMap("j",2,"n",3,"r",9)),-72.0);
		
		
		assertEqual(exec("3*[1 2;3 4]"), getMatrix(new double[][]{{3,6},{9,12}}));
		assertEqual(exec("[1 2;3 4]*3"), getMatrix(new double[][]{{3,6},{9,12}}));
		assertEqual(exec("[1 2;3 4]*[1 2;3 4]"), getMatrix(new double[][]{{7,10},{15,22}}));
		
		assertEqual(exec("3+[1 2;3 4]"), getMatrix(new double[][]{{4,5},{6,7}}));
		assertEqual(exec("[1 2;3 4]+3"), getMatrix(new double[][]{{4,5},{6,7}}));
		assertEqual(exec("[1 2;3 4]+[1 2;3 4]"), getMatrix(new double[][]{{2,4},{6,8}}));
		
		assertEqual(exec("3-[1 2;3 4]"), getMatrix(new double[][]{{2,1},{0,-1}}));
		assertEqual(exec("[1 2;3 4]-3"), getMatrix(new double[][]{{-2,-1},{0,1}}));
		assertEqual(exec("[1 2;3 4]-[1 2;3 4]"), getMatrix(new double[][]{{0,0},{0,0}}));
		
		//Test shadow variables
		assertEqual(exec("a=1; a=1.1; a"),1.1);
		assertEqual(exec("a=1; a=a+1.1; a"),2.1);
		assertEqual(exec("a=1; a=a+1.1; a=2; a"),2);
		assertEqual(exec("a=[1 2;3 4]; a=1.0; a"), 1.0);
		
		assertEqual(exec("a=[1 2;3 4]; a+=1; a"), getMatrix(new double[][]{{2,3},{4,5}}));
		assertEqual(exec("a=1; a+=[1 2;3 4]; a"), getMatrix(new double[][]{{2,3},{4,5}}));
		assertEqual(exec("a=1; a+=[1 2;3 4]; a=1.0; a"),1.0);
		
		
		assertEqual(exec("a=[1 2;3 4]; a*=2; a"), getMatrix(new double[][]{{2,4},{6,8}}));
		assertEqual(exec("a=2; a*=[1 2;3 4]; a"), getMatrix(new double[][]{{2,4},{6,8}}));
		assertEqual(exec("a=2; a*=[1 2;3 4]; a=1.0; a"),1.0);

		assertEqual(exec("a=[1 2;3 4]; a-=1; a"), getMatrix(new double[][]{{0,1},{2,3}}));
		assertEqual(exec("a=1; a-=[1 2;3 4]; a"), getMatrix(new double[][]{{0,-1},{-2,-3}}));
		assertEqual(exec("a=1; a-=[1 2;3 4]; a=1.0; a"),1.0);
		
		//?????assertEqual(exec("a=[1 2;3 4]; a%=2; a"), getMatrix(new double[][]{{1,0},{1,0}}));
		//?????assertEqual(exec("a=2; a%=[1 2;3 4]; a"), getMatrix(new double[][]{{0,0},{2,2}}));
		//?????assertEqual(exec("a=2; a%=[1 2;3 4]; a=1.0; a"),1.0);
		
		assertEqual(exec("a=1; a+=1.5; a"),2.5);
		assertEqual(exec("a=1; a-=1.5; a"),-0.5);
		assertEqual(exec("a=1; a*=1.5; a"),1.5);
		assertEqual(exec("a=1; a/=1.5; a"),1.0/1.5);
		
		//?????assertEqual(exec("[1 2;3 4] % 3"), getMatrix(new double[][]{{1,2},{0,1}}));
		//?????assertEqual(exec("[1 2;3 4]%[5 6 ;7 8]"), getMatrix(new double[][]{{1,2},{3,4}}));
		//?????assertEqual(exec("2%[1 2;3 4]"), getMatrix(new double[][]{{0,0},{2,2}}));
		
		assertEqual(exec("A=[1 2 3; 4 5 6]; sz=size(A); m=sz(1,1); n=sz(1,2); m"), 2.0);
		assertEqual(exec("A=[1 2 3; 4 5 6;  7 8 9]; triu(A)"), getMatrix(new double[][]{{1,2,3},{0,5,6},{0,0,9}}));
		
		assertEqual(exec("A=[1 2 3; 4 5 6; 7 8 9]; r=[]; for i=1:3; r=A(1:3,i) end r"),
				getVector(3,6,9));
		assertEqual(exec("A=[1 2 3; 4 5 6; 7 8 9]; A(1:3,1)"),
				getVector(1,4,7));
		assertEqual(exec("A=[1 2 3; 4 5 6; 7 8 9]; A(1:3,1)=2*A(1:3,1)"),
				getMatrix(new double[][]{{2,2,3},{8,5,6},{14,8,9}}));
		
		assertEqual(exec("A=[1 2; 3 4]; S=[1 2]; S\n S=size(A)"),
				getVector(2,2).transpose());
		assertEqual(exec("A=[1 2; 3 4]; S=[1 2]; S\n S(1,:)=size(A)"),
				getVector(2,2).transpose());

		assertEqual(exec("A=[1 2  3; 4 5 6]; [m n]=size(A); m\n n\n"),3.0);
		assertEqual(exec("A=[1 2  3; 4 5 6]; [m, n]=size(A); m\n n\n"),3.0);
		assertEqual(exec("[m n]=[1 2]; m\n n\n"),2.0);


	}
	
//	assertEqual(exec("function r=fib(r, n); A=[1 1; 1 0]; if n<1; r=1; else r=A*r; r=fib(r, n-1); end end fib([1 1]', 5)"), 
//	new Jama.Matrix(new double[]{13,8},2));
	
	
	
	public static void testBasic() {
		double[][] array = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
		double[][] array2 = {{1.,2.,3},{1.,1.,1.},{2.,2.,2.}};
		double[][] array3 = {{1,2,3,4,5,6},{11,22,33,44,55,66}};
		Matrix A = new Matrix(array);
		Matrix B = new Matrix(array2);
		Matrix C = new Matrix(array3);
		Matrix b = Matrix.random(3,1); //column vector
		Matrix A1 = A.getMatrix(0,2,1,2);
		Matrix A2 = A.getMatrix(1,2,1,2);
		Matrix B1 = B.getMatrix(0,2,1,2);
		Matrix B2 = B.getMatrix(1,2,1,2);

		Matrix M = new Matrix(new double[][]{{1,2},{3,4}});
		Matrix N = new Matrix(new double[][]{{10,20},{30,40}});
		Matrix d = getVector(3,4); //column vector
		
		assertEqual(exec("-A",    getMap("A",A)),       A.uminus());
		assertEqual(exec("A+B",   getMap("A",A,"B",B)), A.plus(B));
		assertEqual(exec("A-B",   getMap("A",A,"B",B)), A.minus(B));
		assertEqual(exec("A*B",   getMap("A",A,"B",B)), A.times(B));
//		assertEqual(exec("B/A",   getMap("A",A,"B",B)), A.solve(B));
		assertEqual(exec("A\\B",  getMap("A",A,"B",B)), A.solve(B));
		assertEqual(exec("A.*B",  getMap("A",A,"B",B)), A.arrayTimes(B));
		assertEqual(exec("A.\\B", getMap("A",A,"B",B)), A.arrayLeftDivide(B));
		assertEqual(exec("A./B",  getMap("A",A,"B",B)), A.arrayRightDivide(B));

		assertEqual(exec("tic; toc; 1;"),1);
		assertEqual(exec("tic; 9+10\n toc; 1;"),1);

		assertEqual(exec("[1 2; 3 4] + [11 22; 33 44]"), getMatrix(new double[][]{{12,24},{36,48}}));
		assertEqual(exec("for i=1:2:10; i\n end"), null);
		assertEqual(exec("for i=1:10; i\n end"), null);
		assertEqual(exec("for i=1:10; i; end"), null);

		//Test order of parameters in the generated function
		assertEqual(exec("b-a",   getMap("a",1,"b",3)), 2);
		assertEqual(exec("a-b",   getMap("a",1,"b",3)), -2);
		assertEqual(exec("B/A",   getMap("A",B,"B",A)), A.solve(B));

		
		assertEqual(MatlabEngine.exec("if n<=1; r=5;r;1\n else 5; 6+7\n 100\n 9; 8; end",new int[]{8}), 8);
		assertEqual(MatlabEngine.exec("if n<=1; r=5\n else s=8\n end",new int[]{8}), 8);
		assertEqual(MatlabEngine.exec("if n<=1; r=5;r;1\n else 7; 9; 8\n end",new int[]{8}), 8);
		assertEqual(MatlabEngine.exec("if n<=1; r=5;r;1\n else 7; 9; 8; end",new int[]{8}), 8);
		assertEqual(MatlabEngine.exec("r=0; if n<=1; r=5\n end r",new int[]{0}), 5);
		assertEqual(MatlabEngine.exec("r=0; if n<=1; r=5; end r",new int[]{0}), 5);
		assertEqual(MatlabEngine.exec("1+1; 2\n r=9"),9);
		
		assertEqual(exec("if 1>2; 3;   \nelse\n 4\n end"),4);
		assertEqual(exec("if 1>2; 3\n else\n 4\n end"),4);
		
		assertEqual(exec("if 1>2; 3\n else 4\n end"),4);
		assertEqual(exec(" if 1>2; 3\n else 4\n end"),4);
		assertEqual(exec(" if 1>2; 3\n else 4\n end "),4);
		assertEqual(exec("if 1>2; 3\n else 4\n end"),4);
		assertEqual(exec("if 1<2; 3\n else 4\n end"),3);
		
		assertEqual(exec("1 > 2"), false);
		assertEqual(exec("1 >= 2"), false);
		assertEqual(exec("1 < 2"), true);
		assertEqual(exec("1 <= 2"), true);
		assertEqual(exec("1 == 2"), false);
		assertEqual(exec("1 != 2"), true);
		
		assertEqual(exec("[10.0 20.0 30.0]'"), getVector(10,20,30));

		assertEqual(exec("C(   :  , :  )", getMap("C",C)), C);
		assertEqual(exec("C(:  , :)", getMap("C",C)), C);
		assertEqual(exec("C(:, :)", getMap("C",C)), C);
		assertEqual(exec("C(:,:)", getMap("C",C)), C);

		assertEqual(exec("0.0 : 0.5 : 1.6"), getVector(0,0.5,1,1.5).transpose());
		assertEqual(exec("0.0 : 0.5 : 1.4"), getVector(0,0.5,1).transpose());
		assertEqual(exec("0.0 : 0.5 : 1.5"), getVector(0,0.5,1,1.5).transpose());
		assertEqual(exec("1:2:6"), getVector(1,3,5).transpose());
		assertEqual(exec("1:2:5"), getVector(1,3,5).transpose());
		assertEqual(exec("1:5"), getVector(1,2,3,4,5).transpose());



		assertEqual(exec("M=[1 2; 3 4]\n d=[3 4]'\n M\\d"), M.solve(d));
		assertEqual(exec("M=[1 2; 3 4]; d=[3 4]'; M\\d"), M.solve(d));
		
		assertEqual(exec("a=2\n a"), 2);
		assertEqual(exec("a=2; a"), 2);
		assertEqual(exec("100+1; 200+1;"), 201);
		assertEqual(exec("10+1\n 20+1"), 21);

	
		if(MatrixAccessNode.INDEX_BASE == 1) {
			assertEqual(exec("a=[1, 2; 3, 4];  a(2, 2)"), 4.0);
			assertEqual(exec("a=[1 2; 3 4];  a(2, 2)"), 4.0);
			assertEqual(exec("a=[1 2; 3 4];  a(2,2)"), 4.0);
		} else {
//			myPrint(exec("fun(1, 1)"));
			assertEqual(exec("a=[1, 2; 3, 4];  a(1, 1)"), 4.0);
			assertEqual(exec("a=[1 2; 3 4];  a(1, 1)"), 4.0);
			assertEqual(exec("a=[1 2; 3 4];  a(1,1)"), 4.0);
		}
		
		
		//white space test
		assertEqual(exec("A=[1 2; 3 4];B=[10 20; 30 40]; A+B"), M.plus(N));
		assertEqual(exec("A=[1 2; 3 4];  B=[10 20; 30 40]; A+B"), M.plus(N));
		assertEqual(exec("A=  [1 2; 3 4]; A +  [10 20; 30 40]  ;  "), M.plus(N));

		if(MatrixAccessNode.INDEX_BASE == 1) {
			assertEqual(exec("A(1:3,2:3)+B(1:3,2:3)",  getMap("A",A,"B",B)), A1.plus(B1));
			assertEqual(exec("A(2:3,2:3)-B(2:3,2:3)",  getMap("A",A,"B",B)), A2.minus(B2));
			assertEqual(exec("A(2:3,2:3)*B(2:3,2:3)",  getMap("A",A,"B",B)), A2.times(B2));
			assertEqual(exec("A(2:3,2:3).*B(2:3,2:3)", getMap("A",A,"B",B)), A2.arrayTimes(B2));
			assertEqual(exec("A(2:3,2:3)./B(2:3,2:3)", getMap("A",A,"B",B)), A2.arrayRightDivide(B2));
		} else {
			assertEqual(exec("A(0:2,1:2)+B(0:2,1:2)",  getMap("A",A,"B",B)), A1.plus(B1));
			assertEqual(exec("A(1:2,1:2)-B(1:2,1:2)",  getMap("A",A,"B",B)), A2.minus(B2));
			assertEqual(exec("A(1:2,1:2)*B(1:2,1:2)",  getMap("A",A,"B",B)), A2.times(B2));
			assertEqual(exec("A(1:2,1:2).*B(1:2,1:2)", getMap("A",A,"B",B)), A2.arrayTimes(B2));
			assertEqual(exec("A(1:2,1:2)./B(1:2,1:2)", getMap("A",A,"B",B)), A2.arrayRightDivide(B2));
		}
		
		assertEqual(exec("-A",    getMap("A",A)),       A.uminus());
		assertEqual(exec("A+B",   getMap("A",A,"B",B)), A.plus(B));
		assertEqual(exec("A-B",   getMap("A",A,"B",B)), A.minus(B));
		assertEqual(exec("A*B",   getMap("A",A,"B",B)), A.times(B));
//		assertEqual(exec("B/A",   getMap("A",A,"B",B)), A.solve(B));
		assertEqual(exec("A\\B",  getMap("A",A,"B",B)), A.solve(B));
		assertEqual(exec("A.*B",  getMap("A",A,"B",B)), A.arrayTimes(B));
		assertEqual(exec("A.\\B", getMap("A",A,"B",B)), A.arrayLeftDivide(B));
		assertEqual(exec("A./B",  getMap("A",A,"B",B)), A.arrayRightDivide(B));
		
		//no longer supported for array
		//myPrint(exec("A(1,1:2)", getMap("A",array)));
		//myPrint(exec("A(1,1:2)", getMap("A",array)));
		
		if(MatrixAccessNode.INDEX_BASE == 1) {
			assertEqual(exec("A(3,2:3)", getMap("A",A)), A.getMatrix(2,2,1,2));
			assertEqual(exec("A(2:3,3)", getMap("A",A)), A.getMatrix(1,2,2,2));
		} else {
			assertEqual(exec("A(2,1:2)", getMap("A",A)), A.getMatrix(2,2,1,2));
			assertEqual(exec("A(1:2,2)", getMap("A",A)), A.getMatrix(1,2,2,2));
		}
		
		assertEqual(exec("[1. .2 3.]"), getVector(1,0.2,3).transpose());
		
		assertEqual(exec("A\\b", getMap("A",A,"b",b)), A.solve(b));
		
		assertEqual(exec("[1 2 3; 4 5 6; 7 8 10]"), A);
		assertEqual(exec("[1 2 3; 4 5 6; 7 8 10]'"), A.transpose());
		assertEqual(exec("A'", getMap("A",M)), M.transpose());

		assertEqual(exec("a + b  ", getMap("a",M,"b",N)), M.plus(N));
		assertEqual(exec("a+b", getMap("a",2,"b",3)), 5);
		
		
		assertEqual(exec("[10.0 20.0 30.0]"), getVector(10,20,30).transpose());
		
		assertEqual(exec("a&&b", new Object[]{true, false}),   false);
		assertEqual(exec("a && b", new Object[]{true, true}),  true);
		assertEqual(exec("a and b", new Object[]{true, true}), true);
		assertEqual(exec("a || b", new Object[]{true, true}),  true);
		assertEqual(exec("a or b", new Object[]{true, true}),  true);
		assertEqual(exec("a != b", new Object[]{1, 2}),        true);
		assertEqual(exec("a != b", new Object[]{true, false}), true);
		assertEqual(exec("a ~= b", new Object[]{true, true}),  false);

		
	}
	
	public static Jama.Matrix getVector(double ...args) {
		return new Jama.Matrix(args, args.length);
	}
	
	public static Jama.Matrix getMatrix(double[][] args) {
		return new Jama.Matrix(args);
	}
	
	public static void assertEqual(Object o1, Object o2) {
		if(null == o1 && null == o2) return;
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
			else {
				m1.print(8, 2);
				System.out.println(" != ");
				m2.print(8, 2);
				throw new RuntimeException("Assert fail!");
			}
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
