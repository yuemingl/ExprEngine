package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import org.objectweb.asm.Opcodes;

public class SubNode extends ExprNode {
	public ExprNode left;
	public ExprNode right;
	public SubNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
		this.type = getType();
	}
	
	public String toString() {
		return left + " - " + right;
	}
	
	public void genCode(MethodGenHelper mg) {
		left.genCode(mg);
		Tools.insertConversionInsn(mg, left.getType(), getType());
		right.genCode(mg);
		Tools.insertConversionInsn(mg, right.getType(), getType());
		mg.visitInsn(getType().getOpcode(Opcodes.ISUB));
	}
	
	@Override
	public Type getType() {
		return Tools.typeConversion(left.getType(), right.getType());
	}	
}
