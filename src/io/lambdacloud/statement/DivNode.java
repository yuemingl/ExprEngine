package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class DivNode extends ExprNode {
	ExprNode left;
	ExprNode right;
	public DivNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.right = right;
		this.type = Utils.typeConversion(left.getType(), right.getType());
	}
	
	public String toString() {
		return left + "/" + right;
	}
	
	public void genCode(MethodVisitor mv) {
		left.genCode(mv);
		right.genCode(mv);
		mv.visitInsn(this.type.getOpcode(Opcodes.IDIV));
	}
}
