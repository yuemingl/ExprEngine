package io.lambdacloud.statement;

import org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;

public class USHRNode extends BinaryOp {

	public USHRNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
	}

	public String toString() {
		return left + ">>>" + right;
	}

	@Override
	public void genCode(MethodGenHelper mg) {
		left.genCode(mg);
		right.genCode(mg);
		mg.visitInsn(getType().getOpcode(Opcodes.IUSHR));
	}

	public int test(int a, int b) {
		int c = a >>> b;
		return c;
	}

}
