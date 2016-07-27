package io.lambdacloud.node.arithmetric;

import org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.UnaryOp;

public class NegateNode extends UnaryOp {

	public NegateNode(ExprNode expr) {
		this.expr = expr;
		expr.genLoadInsn(true);
	}

	public String toString() {
		return "-" + expr;
	}

	public void genCode(MethodGenHelper mg) {
		expr.genCode(mg);
		mg.visitInsn(getType().getOpcode(Opcodes.INEG));

	}
}