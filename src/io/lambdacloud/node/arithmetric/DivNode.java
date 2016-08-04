package io.lambdacloud.node.arithmetric;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;

public class DivNode extends BinaryOp {
	public DivNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
	}

	public String toString() {
		return left + "/" + right;
	}

	public void genCode(MethodGenHelper mg) {
		Type myType = this.getType();
		if((myType.getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor()))) {
			right.genCode(mg);
			Tools.insertConversionInsn(mg, right.getType(), myType);
			left.genCode(mg);
			Tools.insertConversionInsn(mg, left.getType(), myType);
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "solve", "(LJama/Matrix;)LJama/Matrix;", false);
		} else {
			left.genCode(mg);
			Tools.insertConversionInsn(mg, left.getType(), myType);
			right.genCode(mg);
			Tools.insertConversionInsn(mg, right.getType(), myType);
			mg.visitInsn(myType.getOpcode(Opcodes.IDIV));
		}
	}
}
