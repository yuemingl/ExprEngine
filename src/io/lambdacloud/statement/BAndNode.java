package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class BAndNode extends ExprNode {
	ExprNode left;
	ExprNode right;
	public BAndNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.right = right;
		this.type = Type.INT_TYPE;
	}
	
	public String toString() {
		return left + "&" + right;
	}
	
	public void genCode(MethodVisitor mv) {
		left.genCode(mv);
		right.genCode(mv);
		mv.visitInsn(this.type.getOpcode(Opcodes.IAND));
	}
	
	public int test(int a, int b) {
		int c = a & b;
		return c;
	}
}
