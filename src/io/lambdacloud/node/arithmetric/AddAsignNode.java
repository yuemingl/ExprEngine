package io.lambdacloud.node.arithmetric;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.VariableNode;

public class AddAsignNode extends BinaryOp {
	public AddAsignNode(VariableNode left, ExprNode right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return left + " += " + right;
	}

	public void genCode(MethodGenHelper mg) {
		VariableNode var = (VariableNode) left;

		Type myType = this.getType();
		left.genCode(mg); // load
		right.genCode(mg);
		
		if(myType.getDescriptor().equals(Type.getType(String.class).getDescriptor())) {
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
			mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.idxLVT);
		} else if((myType.getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor()))) {
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "plusEquals", "(LJama/Matrix;)LJama/Matrix;", false);
		} else {
			mg.visitInsn(myType.getOpcode(Opcodes.IADD));
			mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.idxLVT);
		}
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.idxLVT);
		}
	}

	public int test(int x, int y) {
		x += y * y;
		return x;
	}
}
