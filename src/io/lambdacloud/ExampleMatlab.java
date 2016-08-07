package io.lambdacloud;

public class ExampleMatlab {

	public static void main(String[] args) {
		MatlabEngine.exec("A=[1 2; 3 4]; b=[3 4]'; A\\b");
		
		System.out.println("Computing Fibonacci(46): ");
		MatlabEngine.exec("function fib(n) if n<=1; 1L; else fib(n-1)+fib(n-2); end end"
				+ " tic; fib(46)\n toc");
		
		MatlabEngine.exec("tic; toc; 1 ");
		MatlabEngine.exec("tic; 9+10\n toc; 1 ");

	}

}
