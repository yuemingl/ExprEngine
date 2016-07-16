package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import org.objectweb.asm.Opcodes;

public class AddNode extends ExprNode {
	public ExprNode left;
	public ExprNode right;
	public AddNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
		//this.type = getType();
	}
	
	public String toString() {
		return left + " + " + right;
	}
	
	public void genCode(MethodGenHelper mg) {
		left.genCode(mg);
		Tools.insertConversionInsn(mg, left.getType(), getType());
		right.genCode(mg);
		Tools.insertConversionInsn(mg, right.getType(), getType());
		if(this.getType().getDescriptor().equals(Type.getType(String.class).getDescriptor())) {
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
		} else {
			mg.visitInsn(getType().getOpcode(Opcodes.IADD));
		}
	}
	
	@Override
	public Type getType() {
		return Tools.typeConversion(left.getType(), right.getType());
	}
}
