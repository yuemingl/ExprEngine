package io.lambdacloud.node.arithmetric;

import java.util.Deque;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.node.VariableNode;

public class DivAsignNode extends BinaryOp {
	public DivAsignNode(VariableNode left, ExprNode right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return left + " /= " + right;
	}

	public void genCode(MethodGenHelper mg) {
		VariableNode var = (VariableNode) left;

		Type myType = this.getType();
		left.genCode(mg);
		Tools.insertConversionInsn(mg, left.getType(), myType);
		right.genCode(mg);
		Tools.insertConversionInsn(mg, right.getType(), myType);
		
		if((myType.getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor()))) {
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "solve", "(LJama/Matrix;)LJama/Matrix;", false);
			mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.idxLVT);
		} else {
			mg.visitInsn(myType.getOpcode(Opcodes.IDIV));
			mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.idxLVT);
		}
		
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.idxLVT);
		}
	}
	
	
	@Override
	public Type getType(Deque<Object> stack) {
		if(left.getType().getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor()) ||
			right.getType().getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor()) ) {
			return Type.getType(Jama.Matrix.class);
		}
		return Type.DOUBLE_TYPE;
	}
	
	
	public int test(int x, int y) {
		x /= y * y;
		return x;
	}
}
