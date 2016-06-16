package io.lambdacloud;

import static io.lambdacloud.ExprEngine.genStaticMethod;
import static io.lambdacloud.ExprEngine.genMethodHandle;
import static io.lambdacloud.ExprEngine.parse;
import static io.lambdacloud.ExprEngine.parseAndEval;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;

public class Examples {

	/**
	 * A quick example: parse and evaluate. 
	 * Warning: the bytecode will be generated each time of the call of parseAndEval().
	 */
	public static void ex1() {
		System.out.println(parseAndEval("-x", new int[]{3}));
		System.out.println(parseAndEval("x + y", new int[]{3,4}));
		System.out.println(parseAndEval("x > y", new int[]{3,4}));
		System.out.println(parseAndEval("x <= y and x > 0", new int[]{3,4}));
		System.out.println(parseAndEval("a=x+y; a+2", new double[]{3.0,4.0}));
		System.out.println(parseAndEval("(7^3) == (1<<2)"));
		System.out.println(parseAndEval("if(x>y) {a=x+y;a } else {a=x*2;b=y*3; if(x<0) {x-1} else {a+b} }", new double[]{3,4}));
		System.out.println("max(3,4)="+parseAndEval("a=if(x>y) {x} else {y}; a", new int[]{3,4}));
	}
	
	/**
	 * Parse and generate bytecode once, call many times.
	 * Use reflection to invoke the generated statis method
	 */
	public static void ex2() {
		ExprTreeBuildWalker ew = parse("x+y");
		Method m = genStaticMethod(ew, "myclass", false, "myfun", 
				double.class, double.class);
		try {
			for(int i=0; i<5; i++)
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
		ExprTreeBuildWalker ew = parse("x*y");
		MethodHandle mh = genMethodHandle(ew, "myclass", false, "myfun", 
				double.class,  double.class, double.class);
		try {
			for(int i=0; i<5; i++)
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
		ExprTreeBuildWalker ew = parse("x*y");
		Fun2 f = (Fun2)ExprEngine.newInstance(ew, "myclass", Fun2.class, true);
		System.out.println(f.apply(3,4));
	}
	
	public static void main(String[] args) {
		ex1();
		ex2();
		ex3();
		ex4();
	}

}
