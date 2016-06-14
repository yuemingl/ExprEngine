package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.IFEQ;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class AndNode extends ExprNode {
	public ExprNode left;
	public ExprNode right;

	public AndNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.right = right;
		this.type = Type.BOOLEAN_TYPE;
	}
	
	public String toString() {
		return left + " && " + right;
	}
	
	@Override
	public void genCode(MethodVisitor mv) {
		left.genCode(mv);
		Label l1 = new Label();
		mv.visitJumpInsn(IFEQ, l1);
		right.genCode(mv);
		mv.visitJumpInsn(IFEQ, l1);
		mv.visitInsn(ICONST_1);
		Label l2 = new Label();
		mv.visitJumpInsn(GOTO, l2);
		mv.visitLabel(l1);
		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
		mv.visitInsn(ICONST_0);
		mv.visitLabel(l2);
	}
	
	public boolean test(boolean a, boolean b) {
		boolean c = a && b;
		return c;
	}
}