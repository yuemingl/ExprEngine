package io.lambdacloud.statement;

import org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;

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