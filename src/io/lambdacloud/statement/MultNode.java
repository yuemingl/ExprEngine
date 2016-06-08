package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class MultNode implements ExprNode {
	ExprNode left;
	ExprNode right;
	public MultNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return left + "*" + right;
	}
	
	public void genCode(MethodVisitor mv) {
		left.genCode(mv);
		right.genCode(mv);
		mv.visitInsn(Opcodes.DMUL);
	}

	@Override
	public String getType() {
		return null;
	}	
}
