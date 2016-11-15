package io.lambdacloud.node.binary;

import org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;

public class BAndNode extends BinaryOp {
	public BAndNode(ExprNode left, ExprNode right) {
		super(left, right);
		this.left.genLoadInsn(true);
		this.right.genLoadInsn(true);
	}

	public String toString() {
		return left + "&" + right;
	}

	public void genCode(MethodGenHelper mg) {
		left.genCode(mg);
		right.genCode(mg);
		mg.visitInsn(getType().getOpcode(Opcodes.IAND));
	}

	public int test(int a, int b) {
		int c = a & b;
		return c;
	}
}
