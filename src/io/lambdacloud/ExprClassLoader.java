package io.lambdacloud;
public class ExprClassLoader extends ClassLoader {

	public ExprClassLoader(ClassLoader classLoader) {
		super(classLoader);
	}

	public Class<?> defineClassForName(String name, byte[] data) {
		return this.defineClass(name, data, 0, data.length);
	}

}