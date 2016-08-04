package io.lambdacloud;

import static io.lambdacloud.ExprEngine.genStaticMethod;
import static io.lambdacloud.ExprEngine.genMethodHandle;
import static io.lambdacloud.ExprEngine.parse;
import static io.lambdacloud.ExprEngine.exec;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import io.lambdacloud.test.TestExprEngine;

public class Examples {

	/**
	 * A quick example: parse and evaluate. 
	 * Warning: the bytecode will be generated each time of the call of parseAndEval().
	 */
	@SuppressWarnings("unchecked")
	public static void ex1() {

		//Basic expressions
		System.out.println(exec("-x", new int[]{3}));
		System.out.println(exec("x + y", new int[]{3,4}));
		System.out.println(exec("x > y", new int[]{3,4}));
		System.out.println(exec("x <= y and x > 0", new int[]{3,4}));
		System.out.println(exec("a=x+y; a+2", new double[]{3.0,4.0}));
		System.out.println(exec("(7^3) == (1<<2)"));
		System.out.println(exec(" 'abc'+'def' "));
		System.out.println(exec(" \"abc\"+'def' "));
		System.out.println(exec("7**2"));
		
		//If else
		System.out.println(exec("if(x>y) {a=x+y;a } else {a=x*2;b=y*3; if(x<0) {x-1} else {a+b} }", new double[]{3,4}));
		System.out.println("max(3,4)="+exec("a=if(x>y) {x} else {y}; a", new int[]{3,4}));
		
		//While for loops
		System.out.println(exec("while(x<y) {x=x+1} x", new int[]{1,4}));
		System.out.println(exec("for(i=0;i<=n;i++) {x+=i} x", new int[]{100,0}));
		
		//Array
		System.out.println(exec("a=[10,20,30,40]; sum1=0; for(i=0;i<4;i++) { sum1+=a[i] } sum1"));
		System.out.println(Arrays.toString(
				(int[])exec("[x, y, 3, 4]", new Object[]{ 1,2 })));
		System.out.println(Arrays.toString(
				(String[])exec("['abc', 'def', x]", new Object[]{"ghi"})));
		System.out.println(Arrays.deepToString(
				(int[][])exec("[ [x], [y] ]", new Object[]{ 1,2 })));
		System.out.println(Arrays.deepToString(
				(int[][][])exec("[ [[x],[y]], [[x+y]] ]", new Object[]{ 1,2 })));
		System.out.println(Arrays.toString(
				(double[])exec("x[i+1:j-1]", new Object[]{1,4,new double[]{1,2,3,4,5}})));
		System.out.println(Arrays.deepToString((int[][])exec("[1:3, 5:10, 100:101]")));
		
		//List comprehension
		System.out.println(exec("[x for x in A for y in B]",
				new Object[]{ new int[]{0,1,2}, new int[]{100,101,102} }));
		
		System.out.println(exec("[x+y for x in A for y in B if x+y>=1000]",
				new Object[]{ new int[]{1,2,3}, new int[]{10,100,1000} }));
		
		System.out.println(exec("[ x>3 for x in A ]", new Object[] {new int[]{1,2,3,4,5,6}}));
		
		System.out.println(exec("[ x for x in A if x>3 ]", new Object[] {new int[]{1,2,3,4,5,6}}));
		
		System.out.println(Arrays.deepToString(
				((List<int[][][]>)exec("[ [ [[x],[y]], [[x+y]] ] for x in A for y in B]",
				new Object[]{ new int[]{1,2}, new int[]{3,4} })).toArray()));
		
		//Memory efficient range() function (no temp list generated)
		System.out.println(exec("[x+10.0 for x in range(3)]")); //0,1,2
		System.out.println(exec("[x+10.0 for x in 1:3]"));      //1,2,3
		System.out.println(exec("[[1 for col in range(3)] for row in range(2)]"));
		
		//Array access
		System.out.println(exec("a=[[1,2],[3,4,5]]; a[1][2]"));
		System.out.println(exec("a=[[1,2],[3,4,5],[6,7,8]]; a[1:2]"));
		System.out.println(Arrays.toString((int[])exec("a=[[1,2],[3,4,5],[6,7,8]]; a[1:2][1]")));
		System.out.println(exec("a=[[1,2],[3,4,5],[6,7,8]]; a[1:2][1][1]"));
		System.out.println(Arrays.deepToString(
				((List<int[][][]>)exec("a=[ [10*x+y for x in 1:5] for y in 6:10]; a[1:3][1:2][1][2:4]")).toArray()));

	}
	
	/**
	 * Parse and generate bytecode once, call many times.
	 * Use reflection to invoke the generated statis method
	 */
	public static void ex2() {
		ExprTreeBuildWalker ew = parse("x+y", double.class);
		Method m = genStaticMethod(ew, "myclass", false, "myfun");
		try {
			for(int i=0; i<3; i++)
				System.out.println(m.invoke(null, i, 10.0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Parse and generate bytecode once, call many times.
	 * Use method handle to invoke the generated static method
	 */
	public static void ex3() {
		ExprTreeBuildWalker ew = parse("x+y");
		MethodHandle mh = genMethodHandle(ew, "myclass", false, "myfun", 
				double.class,  double.class, double.class);
		try {
			for(int i=0; i<3; i++)
					System.out.println(mh.invoke(i, 10.0));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Declare an interface for your function
	 * A class which implements the interface is generated and ready to use
	 */
	public static interface Fun2 {
		double apply(double x, double y);
	}
	public static void ex4() {
		ExprTreeBuildWalker ew = parse("x+y", Fun2.class);
		Fun2 f = (Fun2)ExprEngine.newInstance(ew, "myclass", true);
		System.out.println(f.apply(3,4));
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(exec("def fib(n) { if(n<=1) {1L} else {fib(n-1)+fib(n-2)} } fib(46)"));
		System.out.println("Fibonacci(46) time(ms):"+(System.currentTimeMillis()-startTime));

		startTime = System.currentTimeMillis();
		System.out.println(exec("def fib(n) { if(n<=1) {1} else {fib(n-1)+fib(n-2)} } fib(46)"));
		System.out.println("Fibonacci(46) time(ms):"+(System.currentTimeMillis()-startTime));

		//runAll();
	}
	
	public static void runAll() {
		// Put them together to test for function definition across call of exec()
		//System.out.println(exec("def test(x,y) { x+y }"));
		//System.out.println(exec("test(1,2)"));
		//-----------------------------------------------------------------------

		
		System.out.println(exec("def plus(x, y) { if(x+y>10) { return x+y+100.0; } plus(x+y,2.0) } plus(1,2)"));
		/*
Call plus in scope global
genCode: (II)D

bootstrap: FCplus1.plus:(II)D
genCode: (ID)D
bootstrap: FCplus1.plus:(ID)D
genCode: (DD)D
bootstrap: FCplus1.plus:(DD)D
genCode: (DD)D
111.0
		 */
		System.out.println(exec("def plus(x, y) { if(x+y>10) { return x+y+100.0; } plus(x+y+0.1,2.0) } plus(1,2)"));
/*
Call plus in scope global
genCode: (II)D

bootstrap: FCplus2.plus:(II)D
genCode: (DD)D
bootstrap: FCplus2.plus:(DD)D
genCode: (DD)D
111.4
 */
		System.out.println(exec("def fib(n) { if(n>1) {fib(n-1)+fib(n-2)} else {1}} fib(5)"));
		System.out.println(exec("def fib(n) { if(n<=1) {1} else {fib(n-1)+fib(n-2)} } fib(5)"));
		//stack overflow: System.out.println(exec("def plus(x, y) { if(x+y>10) { return x+y+0.01 } plus(1.1,2.2) } plus(1,2)"));
		//System.out.println(exec("def plus(x, y) { if(x+y>10) { return x+y } plus(1.1,2.2) } plus(1,2)"));
			
//		System.out.println(exec(
//				"[ i+j for i in range(20) for j in range(i+1,20) if i+j == 32 ]"));
				
		//Put the algorithm logic in the expression without considering types
		//Pass typed parameters in and compile the algorithm with most efficient
		//Bytecode
		System.out.println(exec("for(i=0;i<N;i++) { r += a[i]*b[i] } r", 
				TestExprEngine.getMap(
						"a", new double[]{1,2,3},
						"b", new double[]{1,1,1},
						"r", 0.0,
						"N", 3
						)));
		System.out.println(exec("for(i=0;i<N;i++) { r += a[i]*b[i] } r", 
				TestExprEngine.getMap(
						"a", new int[]{1,2,3},
						"b", new int[]{1,1,1},
						"r", 0,
						"N", 3
						)));

//		System.out.println(exec("def fun1(x, y) { x+y }"));
//		System.out.println(exec("fun1(1,1)+fun1(3,4)"));
		
		
		
		System.out.println(exec("if (x>0) { return 1 } x ", new int[]{2}));
		System.out.println(exec("def test(n) {if(n<5) { return n; } else  {a=n+1} a+100 } test(7)"));
		System.out.println(exec("def test(n) {a=0; if(n<5) { return n; } else  {a=n+1} a+100 } test(7)"));

		System.out.println(exec("def fun1(x, y) { x+y } def fun2(x,y) {x-y} fun2(1,1)"));

		System.out.println(exec("def fib(n) { if(n<=1) {1} else {fib(n-1)+fib(n-2)} } fib(5)"));
		System.out.println(exec("def fun1(x, y) { a=x+y; b=x-y; if(a<10) {fun1(a,b)} else{a} } fun1(1,1)"));
		
		System.out.println(exec("def fun1(x, y) { x+y } fun1(1,1)+fun1(3,4)"));
		System.out.println(exec("a=x+y; a-1",new int[]{1,2}));
		System.out.println(exec("def fun1(x, y) { a=x+y; a-1 } a=fun1(1,2); a+1"));
		System.out.println(exec("def fun1(x, y) { a=x+y; a-1 } b=fun1(1,2); b+1"));
		System.out.println(exec("def fun1(x, y) { x+y } fun1(2.5,1)"));
		System.out.println(exec("def fun1(x, y) { x+y } r=0; for(i=0;i<10;i++) { r+=fun1(1,i)+fun1(2,i) } r"));
		System.out.println(exec("def fun1(x, y) { x+y } r=0; for(i=0;i<10;i++) { r+=fun1(1,i) } r"));
		//bootstrap 3 times? System.out.println(exec("def fun1(x, y) { x+y } fun1(1.5,2.5)+fun1(1,1)+fun1(3,4)"));
		System.out.println(exec("def fun1(x, y) { a=x+y; a-1 } a=fun1(1,2); b=fun1(1.5,2.5); a+b"));
		System.out.println(exec("def fun1(x, y) { x+y } a=fun1(1,2); b=fun1(1.5,2.5); a+b"));
		System.out.println(exec("def fun1(x, y) { x+y } fun1(1.5,2.5)+fun1(1,1)"));

		//bug		System.out.println(exec("x**2", new int[]{5}));
		
//bug		System.out.println(exec("sum x**2 for x in 1:3"));
//		System.out.println(exec("sum x+1 for x in 1:3"));
		
////		System.out.println(exec("10+2**3"));
//		System.out.println(exec("5**2"));
//
//bug		System.out.println(exec("[x**2 for x in 1:3]"));
//		System.out.println(exec("[(x+0.0)**2 for x in 1:3]"));
//bug sum is used as key word		System.out.println(exec("sum( [(x+0.0)**2 for x in 1:3] )"));
//
//		System.out.println(exec("[sum(x=1:y) for y in 1:10]"));
//		
//		System.out.println(exec("sum(x=1:3)"));
//		System.out.println(exec("sum(1:3)"));
		
//		System.out.println(exec("sum([x for x in 1:3])"));
		
		//System.out.println(exec("a=[1,2,3]; sum(a)"));
		//System.out.println(exec("sum([1,2,3])"));
		//System.out.println(exec("'abc'+10"));

		//System.out.println(exec("a=10:20; for(i=0;i<10;i++) { b+=a[i] } b"));
		System.out.println(exec("a=10:20; for(i=0;i<10;i++) { b+=a[i] } b",new int[]{0}));
		System.out.println(exec("b=0; a=10:20; for(i=0;i<10;i++) { b+=a[i] } b"));
		
		System.out.println(exec("a=[[x,x+1] for x in 1:3]; a[1:2][0][1]")); //mixed type: array in list

		System.out.println(exec("a=[ [10*x+y for x in 1:3] for y in 4:6]; a[2][1]"));

		System.out.println(exec("a=[[1 for col in range(3)] for row in range(2)]; a[0]"));

		System.out.println(exec("a=[[x,x+1] for x in 1:3]; a[1][0]")); //mixed type: array in list

		System.out.println(exec("a=[[1,2,3],[4,5,6],[7,8,9]]; a[0][1]"));
		System.out.println(exec("a=[[1,2,3],[4,5,6],[7,8,9]]; a[1:2][1][0]"));
		System.out.println(exec("a=[[1,2],[3,4,5]]; b=a[0]; b[0]"));
		System.out.println(exec("a=[[1 for col in range(3)] for row in range(2)]; a[0]"));
		System.out.println(Arrays.deepToString((int[][])exec("a=[[1,2,3],[4,5,6],[7,8,9]]; a[0][1]=20; a")));
		System.out.println(Arrays.deepToString((int[][])exec("a=[[1,2,3],[4,5,6],[7,8,9]]; a[1:2][1][0]=20; a")));

		ex1();
		ex2();
		ex3();
		ex4();
//		int x=5,y=3;
//		System.out.println(x*y%2);
	}

}
