package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import org.objectweb.asm.Opcodes;

public class NegateNode extends ExprNode {
	ExprNode expr;
	public NegateNode(ExprNode expr) {
		this.expr = expr;
		expr.genLoadInsn(true);
		this.type = getType();
	}
	
	public String toString() {
		return "-" + expr;
	}
	
	public void genCode(MethodGenHelper mg) {
		expr.genCode(mg);
		mg.visitInsn(getType().getOpcode(Opcodes.INEG));
		
	}
	
	@Override
	public Type getType() {
		return this.expr.getType();
	}
}