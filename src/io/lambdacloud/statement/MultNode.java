package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import org.objectweb.asm.Opcodes;

public class MultNode extends ExprNode {
	public ExprNode left;
	public ExprNode right;
	public MultNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
	}

	public String toString() {
		return left + "*" + right;
	}
	
	public void genCode(MethodGenHelper mg) {
		left.genCode(mg);
		Tools.insertConversionInsn(mg, left.getType(), getType());
		right.genCode(mg);
		Tools.insertConversionInsn(mg, right.getType(), getType());
		mg.visitInsn(getType().getOpcode(Opcodes.IMUL));
	}
	
	@Override
	public Type getType() {
		return Tools.typeConversion(left.getType(), right.getType());
	}
}
