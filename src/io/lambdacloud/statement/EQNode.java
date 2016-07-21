package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.DCMPL;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.IF_ICMPNE;

import java.util.Deque;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class EQNode extends BinaryOp {

	public EQNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
	}

	public String toString() {
		return left + " == " + right;
	}

	@Override
	public void genCode(MethodGenHelper mg) {
		Type ty = Tools.typeConversion(left.getType(), right.getType());
		left.genCode(mg);
		Tools.insertConversionInsn(mg, left.getType(), ty);
		right.genCode(mg);
		Tools.insertConversionInsn(mg, right.getType(), ty);
		if (ty.getSort() == Type.DOUBLE) {
			mg.visitInsn(DCMPL);
			Label l1 = new Label();
			mg.visitJumpInsn(IFNE, l1);
			mg.visitInsn(ICONST_1);
			Label l2 = new Label();
			mg.visitJumpInsn(GOTO, l2);
			mg.visitLabel(l1);
			mg.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mg.visitInsn(ICONST_0);
			mg.visitLabel(l2);
			// mv.visitInsn(Opcodes.NOP);
		} else if (ty.getSort() == Type.INT) {
			Label l1 = new Label();
			mg.visitJumpInsn(IF_ICMPNE, l1);
			mg.visitInsn(ICONST_1);
			Label l2 = new Label();
			mg.visitJumpInsn(GOTO, l2);
			mg.visitLabel(l1);
			mg.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mg.visitInsn(ICONST_0);
			mg.visitLabel(l2);
			// mv.visitInsn(Opcodes.NOP);
		} else if (ty.getDescriptor().equals(Type.getType(String.class).getDescriptor())) {
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
		} else
			throw new RuntimeException();
	}

	@Override
	public Type getType() {
		return Type.BOOLEAN_TYPE;
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.BOOLEAN_TYPE;
	}

	public boolean test(double a, double b) {
		boolean c = a == b;
		return c;
	}

	public boolean test(int a, int b) {
		boolean c = a == b;
		return c;
	}
}
