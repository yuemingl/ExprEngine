package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.Opcodes;

public class MultNode extends ExprNode {
	ExprNode left;
	ExprNode right;
	public MultNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
		this.type = getType();
	}

	public String toString() {
		return left + "*" + right;
	}
	
	public void genCode(MethodVisitor mv) {
		left.genCode(mv);
		Tools.insertConversionInsn(mv, left.getType(), getType());
		right.genCode(mv);
		Tools.insertConversionInsn(mv, right.getType(), getType());
		mv.visitInsn(getType().getOpcode(Opcodes.IMUL));
	}
	
	@Override
	public Type getType() {
		return Tools.typeConversion(left.getType(), right.getType());
	}
}
