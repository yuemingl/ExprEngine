package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.DCMPL;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.IFEQ;
import static org.objectweb.asm.Opcodes.IF_ICMPEQ;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class NEQNode extends ExprNode {
	public ExprNode left;
	public ExprNode right;
	
	public NEQNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.right = right;
		this.type = Type.BOOLEAN_TYPE;
	}
	
	public String toString() {
		return left + " != " + right;
	}	
	@Override
	public void genCode(MethodVisitor mv) {
		Type ty = Utils.typeConversion(left.getType(), right.getType());
		left.genCode(mv);
		Utils.insertConversionCode(mv, left.getType(), ty);
		right.genCode(mv);
		Utils.insertConversionCode(mv, right.getType(), ty);
		if(ty.getSort() == Type.DOUBLE) {
			mv.visitInsn(DCMPL);
			Label l1 = new Label();
			mv.visitJumpInsn(IFEQ, l1);
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
			mv.visitJumpInsn(IF_ICMPEQ, l1);
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
		boolean c =  a != b;
		return c;
	}
	
	public boolean test(int a, int b) {
		boolean c =  a != b;
		return c;
	}
}
