package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.DCMPG;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.IFGE;
import static org.objectweb.asm.Opcodes.IF_ICMPGE;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class LTNode extends ExprNode {
	public ExprNode left;
	public ExprNode right;
	
	public LTNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
		this.type = Type.BOOLEAN_TYPE;
	}
	
	public String toString() {
		return left + " < " + right;
	}
	
	@Override
	public void genCode(MethodVisitor mv) {
		Type ty = Tools.typeConversion(left.getType(), right.getType());
		left.genCode(mv);
		Tools.insertConversionInsn(mv, left.getType(), ty);
		right.genCode(mv);
		Tools.insertConversionInsn(mv, right.getType(), ty);
		if(ty.getSort() == Type.DOUBLE) {
			mv.visitInsn(DCMPG);
			Label l1 = new Label();
			mv.visitJumpInsn(IFGE, l1);
			mv.visitInsn(ICONST_1);
			Label l2 = new Label();
			mv.visitJumpInsn(GOTO, l2);
			mv.visitLabel(l1);
			mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mv.visitInsn(ICONST_0);
			mv.visitLabel(l2);
			//mv.visitInsn(Opcodes.NOP);
			
		}
		else if(ty.getSort() == Type.INT) {
			Label l1 = new Label();
			mv.visitJumpInsn(IF_ICMPGE, l1);
			mv.visitInsn(ICONST_1);
			Label l2 = new Label();
			mv.visitJumpInsn(GOTO, l2);
			mv.visitLabel(l1);
			mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mv.visitInsn(ICONST_0);
			mv.visitLabel(l2);
			//mv.visitInsn(Opcodes.NOP);
		}
		else
			throw new RuntimeException();
	}
	
	public boolean test(double a, double b) {
		boolean c =  a < b;
		return c;
	}
	
	public boolean test(int a, int b) {
		boolean c =  a < b;
		return c;
	}
}
