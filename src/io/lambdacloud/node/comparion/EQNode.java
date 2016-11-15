package io.lambdacloud.node.comparion;

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

import io.lambdacloud.BytecodeSupport;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.util.LogicalArray;

public class EQNode extends BinaryOp {

	public EQNode(ExprNode left, ExprNode right) {
		super(left, right);
		this.left.genLoadInsn(true);
		this.right.genLoadInsn(true);
	}

	public String toString() {
		return left + " == " + right;
	}

	@Override
	public void genCode(MethodGenHelper mg) {
		Type lType = left.getType();
		Type rType = right.getType();
		if(null == lType || null == rType)
			return;
		
		if(lType.equals(Type.getType(Jama.Matrix.class)) || rType.equals(Type.getType(Jama.Matrix.class))) {
			left.genCode(mg);
			right.genCode(mg);
			mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), 
					"EQ", "("+lType.getDescriptor()+rType.getDescriptor()+")"+Type.getType(LogicalArray.class), false);
		} else {
			Type ty = Tools.typeConversion(lType, rType);
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
			} else if (ty.equals(Type.getType(String.class))) {
				mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
			} else
				throw new RuntimeException("Unsupported type: "+ty.toString());
		}
	}

	@Override
	public Type getType() {
		return getType(null);
	}

	@Override
	public Type getType(Deque<Object> stack) {
		Type lType = left.getType();
		Type rType = right.getType();
		if(null == lType || null == rType)
			return null;
		
		if(lType.equals(Type.getType(Jama.Matrix.class)) || rType.equals(Type.getType(Jama.Matrix.class))) {
			return Type.getType(LogicalArray.class);
		}
		
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
