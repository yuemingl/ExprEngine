package io.lambdacloud.statement;

import org.objectweb.asm.Type;

public class Utils {
	public static Type typeConversion(Type type1, Type type2) {
		int t1 = type1.getSort();
		int t2 = type2.getSort();
		if(t1 == Type.DOUBLE || t2 == Type.DOUBLE) {
			return Type.getType(double.class);
		}
		if(t1 == Type.INT || t2 == Type.INT) {
			return Type.getType(int.class);
		}
		return Type.getType(boolean.class);
	}
	
	public static void main(String[] args) {
		System.out.println(Type.getType(Object.class).getDescriptor());
	}
}
