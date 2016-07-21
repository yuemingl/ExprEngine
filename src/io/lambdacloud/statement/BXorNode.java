package io.lambdacloud.statement;

import org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;

public class BXorNode extends BinaryOp {
	public BXorNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return left + "^" + right;
	}

	public void genCode(MethodGenHelper mg) {
		left.genCode(mg);
		right.genCode(mg);
		mg.visitInsn(getType().getOpcode(Opcodes.IXOR));
	}

	public int test(int a, int b) {
		int c = a ^ b;
		return c;
	}
}