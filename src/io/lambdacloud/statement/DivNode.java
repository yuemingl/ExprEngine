package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import org.objectweb.asm.Opcodes;

public class DivNode extends ExprNode {
	ExprNode left;
	ExprNode right;
	public DivNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
		this.type = getType();
	}
	
	public String toString() {
		return left + "/" + right;
	}
	
	public void genCode(MethodGenHelper mg) {
		left.genCode(mg);
		Tools.insertConversionInsn(mg, left.getType(), getType());
		right.genCode(mg);
		Tools.insertConversionInsn(mg, right.getType(), getType());
		mg.visitInsn(getType().getOpcode(Opcodes.IDIV));
	}
	
	@Override
	public Type getType() {
		return Tools.typeConversion(left.getType(), right.getType());
	}	
}
