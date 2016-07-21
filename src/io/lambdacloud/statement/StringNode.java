package io.lambdacloud.statement;

import java.util.Deque;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class StringNode extends ExprNode {
	public String strVal;
	public StringNode(String s) {
		this.strVal = s;
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		mg.visitLdcInsn(strVal);
	}
	
	public static String test() {
		return "abc";
	}
	
	@Override
	public Type getType() {
		return Type.getType(String.class);
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.getType(String.class);
	}	
	
	@Override
	public String toString() {
		return this.strVal;
	}
}
