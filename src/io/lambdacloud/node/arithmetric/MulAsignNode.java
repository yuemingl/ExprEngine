package io.lambdacloud.node.arithmetric;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.node.VariableNode;

public class MulAsignNode extends BinaryOp {
	public MulAsignNode(VariableNode left, ExprNode right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return left + " *= " + right;
	}

	public void genCode(MethodGenHelper mg) {
		VariableNode var = (VariableNode) left;
		Type myType = this.getType();
		if((myType.getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor()))) {
			if(right.getType().getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor())) {
				left.genCode(mg); // load
				right.genCode(mg);
				mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "times", "(LJama/Matrix;)LJama/Matrix;", false);
				mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.idxLVT);
			} else {
				left.genCode(mg); // load
				right.genCode(mg);
				Tools.insertConversionInsn(mg, right.getType(), Type.DOUBLE_TYPE);
				mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "timesEquals", "(D)LJama/Matrix;", false);
			}
		} else {
			left.genCode(mg); // load
			right.genCode(mg);
			mg.visitInsn(myType.getOpcode(Opcodes.IMUL));
			mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.idxLVT);
		}
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.idxLVT);
		}
	}

	public int test(int x, int y) {
		x *= y * y;
		return x;
	}
}
