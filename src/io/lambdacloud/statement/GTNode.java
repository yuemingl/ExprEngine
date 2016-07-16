package io.lambdacloud.statement;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import static org.objectweb.asm.Opcodes.*;

import org.objectweb.asm.Label;

/**
 * Greater than expression
 * left > right
 */
public class GTNode extends ExprNode {
	public ExprNode left;
	public ExprNode right;
	
	public GTNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
	}
	
	public String toString() {
		return left + " > " + right;
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		Type ty = Tools.typeConversion(left.getType(), right.getType());
		left.genCode(mg);
		Tools.insertConversionInsn(mg, left.getType(), ty);
		right.genCode(mg);
		Tools.insertConversionInsn(mg, right.getType(), ty);
		if(ty.getSort() == Type.DOUBLE) {
			mg.visitInsn(DCMPL);
			Label l1 = new Label();
			mg.visitJumpInsn(IFLE, l1);
			mg.visitInsn(ICONST_1);
			Label l2 = new Label();
			mg.visitJumpInsn(GOTO, l2);
			mg.visitLabel(l1);
			mg.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mg.visitInsn(ICONST_0);
			mg.visitLabel(l2);
			//mv.visitInsn(Opcodes.NOP);
			
		}
		else if(ty.getSort() == Type.INT) {
			Label l1 = new Label();
			mg.visitJumpInsn(IF_ICMPLE, l1);
			mg.visitInsn(ICONST_1);
			Label l2 = new Label();
			mg.visitJumpInsn(GOTO, l2);
			mg.visitLabel(l1);
			mg.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mg.visitInsn(ICONST_0);
			mg.visitLabel(l2);
			//mv.visitInsn(Opcodes.NOP);
		}
		else
			throw new RuntimeException();
	}
	
	@Override
	public Type getType() {
		return Type.BOOLEAN_TYPE;
	}
	
	public boolean test(double a, double b) {
		boolean c =  a > b;
		return c;
	}
	public boolean test(int a, int b) {
		boolean c =  a > b;
		return c;
	}
}
