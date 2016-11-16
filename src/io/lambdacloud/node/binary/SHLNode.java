package io.lambdacloud.node.binary;

import org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;

public class SHLNode extends BinaryOp {

	public SHLNode(ExprNode left, ExprNode right) {
		super(left, right);
		this.left.genLoadInsn(true);
		this.right.genLoadInsn(true);
	}

	public String toString() {
		return left + "<<" + right;
	}

	@Override
	public void _genCode(MethodGenHelper mg) {
		left.genCode(mg);
		right.genCode(mg);
		mg.visitInsn(getType().getOpcode(Opcodes.ISHL));
	}

	public int test(int a, int b) {
		int c = a << b;
		return c;
	}

}
