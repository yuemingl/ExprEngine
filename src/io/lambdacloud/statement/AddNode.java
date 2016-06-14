package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class AddNode extends ExprNode {
	ExprNode left;
	ExprNode right;
	public AddNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.right = right;
		this.type = getType();
	}
	
	public String toString() {
		return left + " + " + right;
	}
	
	public void genCode(MethodVisitor mv) {
		left.genCode(mv);
		Utils.insertConversionCode(mv, left.getType(), getType());
		right.genCode(mv);
		Utils.insertConversionCode(mv, right.getType(), getType());
		mv.visitInsn(getType().getOpcode(Opcodes.IADD));
	}
	
	@Override
	public Type getType() {
		return Utils.typeConversion(left.getType(), right.getType());
	}
}
