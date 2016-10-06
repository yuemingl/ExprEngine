package io.lambdacloud.node.comparion;

import static org.objectweb.asm.Opcodes.DCMPG;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.IFGE;
import static org.objectweb.asm.Opcodes.IF_ICMPGE;

import java.util.Deque;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;

public class LTNode extends BinaryOp {

	public LTNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
	}

	public String toString() {
		return left + " < " + right;
	}

	@Override
	public void genCode(MethodGenHelper mg) {
		if(null == left.getType() || null == right.getType())
			return;
		Type ty = Tools.typeConversion(left.getType(), right.getType());
		left.genCode(mg);
		Tools.insertConversionInsn(mg, left.getType(), ty);
		right.genCode(mg);
		Tools.insertConversionInsn(mg, right.getType(), ty);
		if (ty.getSort() == Type.DOUBLE) {
			mg.visitInsn(DCMPG);
			Label l1 = new Label();
			mg.visitJumpInsn(IFGE, l1);
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
			mg.visitJumpInsn(IF_ICMPGE, l1);
			mg.visitInsn(ICONST_1);
			Label l2 = new Label();
			mg.visitJumpInsn(GOTO, l2);
			mg.visitLabel(l1);
			mg.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mg.visitInsn(ICONST_0);
			mg.visitLabel(l2);
			// mv.visitInsn(Opcodes.NOP);
		} else
			throw new RuntimeException();
	}

	@Override
	public Type getType() {
		if(null == left.getType() || null == right.getType())
			return null;
		return Type.BOOLEAN_TYPE;
	}

	@Override
	public Type getType(Deque<Object> stack) {
		if(null == left.getType() || null == right.getType())
			return null;
		return Type.BOOLEAN_TYPE;
	}

	public boolean test(double a, double b) {
		boolean c = a < b;
		return c;
	}

	public boolean test(int a, int b) {
		boolean c = a < b;
		return c;
	}
}
