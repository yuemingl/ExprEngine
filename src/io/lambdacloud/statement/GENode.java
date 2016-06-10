package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.DCMPL;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.IFLT;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class GENode extends ExprNode {
	public ExprNode left;
	public ExprNode right;
	
	public GENode(ExprNode left, ExprNode right) {
		this.left = left;
		this.right = right;
		this.type = Type.BOOLEAN_TYPE;
	}
	
	@Override
	public void genCode(MethodVisitor mv) {
		left.genCode(mv);
		right.genCode(mv);
		mv.visitInsn(DCMPL);
		Label l1 = new Label();
		mv.visitJumpInsn(IFLT, l1);
		mv.visitInsn(ICONST_1);
		Label l2 = new Label();
		mv.visitJumpInsn(GOTO, l2);
		mv.visitLabel(l1);
		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
		mv.visitInsn(ICONST_0);
		mv.visitLabel(l2);
		//mv.visitInsn(Opcodes.NOP);
	}
	
	public boolean test(double a, double b) {
		boolean c =  a >= b;
		return c;
	}
}
