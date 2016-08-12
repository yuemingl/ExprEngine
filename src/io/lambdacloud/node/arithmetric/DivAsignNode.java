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

		left.addValue(this); // Add value to the variable list to generate the record in LVT for this type
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
			mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(myType.getDescriptor()));
		} else {
			left.genCode(mg);
			Tools.insertConversionInsn(mg, left.getType(), myType);
			right.genCode(mg);
			Tools.insertConversionInsn(mg, right.getType(), myType);
			mg.visitInsn(myType.getOpcode(Opcodes.IDIV));
			mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(myType.getDescriptor()));
			
			var.setType(myType); // Change the variable type here for later reference of the variable
		}
		
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
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
