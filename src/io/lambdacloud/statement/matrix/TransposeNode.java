package io.lambdacloud.statement.matrix;

import org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.statement.ExprNode;
import io.lambdacloud.statement.UnaryOp;

public class TransposeNode extends UnaryOp {
	public TransposeNode(ExprNode expr) {
		this.expr = expr;
	}

	public String toString() {
		return expr+"'";
	}

	@Override
	public void genCode(MethodGenHelper mg) {
		expr.genCode(mg);
		mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "transpose", "()LJama/Matrix;", false);
	}
}
