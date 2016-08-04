package io.lambdacloud;

public class ExampleMatlab {

	public static void main(String[] args) {
		MatlabEngine.exec("A=[1 2; 3 4]; b=[3 4]'; A\\b");
	}

}
