package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class StringNode extends ExprNode {
	String str;
	public StringNode(String s) {
		this.str = s;
	}
	@Override
	public void genCode(MethodVisitor mv) {
		mv.visitLdcInsn(str);
	}
	
	public static String test() {
		return "abc";
	}
	
	@Override
	public Type getType() {
		return Type.getType(String.class);
	}	
}
