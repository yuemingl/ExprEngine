package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class StringNode extends ExprNode {
	public String strVal;
	public StringNode(String s) {
		this.strVal = s;
	}
	
	@Override
	public void genCode(MethodVisitor mv) {
		mv.visitLdcInsn(strVal);
	}
	
	public static String test() {
		return "abc";
	}
	
	@Override
	public Type getType() {
		return Type.getType(String.class);
	}
	
	@Override
	public String toString() {
		return this.strVal;
	}
}
