package io.lambdacloud;


public class ExampleMatlab {

	public static void main(String[] args) {
		//MatlabEngine.exec("A=[1 2; 3 4]; b=[3 4]'; A\\b");
		
		long startTime = System.currentTimeMillis();
		System.out.println("Fibonacci(42)="+
				//MatlabEngine.exec("function fib(n)\n if n<=1\n 1; else fib(n-1)+fib(n-2); end\n end\n fib(42)"));
				MatlabEngine.exec("function r=fib(n)\n if n<=1\n r=1; else r=fib(n-1)+fib(n-2); end\n end\n fib(42)"));
		System.out.println("Time: "+(System.currentTimeMillis()-startTime)+"ms");
	}

}
