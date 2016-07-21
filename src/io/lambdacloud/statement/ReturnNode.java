package io.lambdacloud.statement;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;

public class ReturnNode extends UnaryOp {

	public ReturnNode() {
	}

	public ReturnNode(ExprNode retExpr) {
		this.expr = retExpr;
	}

	@Override
	public void genCode(MethodGenHelper mg) {
		if (null != expr) {
			expr.genCode(mg);
			mg.visitInsn(this.getType().getOpcode(Opcodes.IRETURN));
		} else {
			mg.visitInsn(Opcodes.RETURN);
		}
	}
}
