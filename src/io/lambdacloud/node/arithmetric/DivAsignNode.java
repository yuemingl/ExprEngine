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

////		left.addValue(this); // Add value to the variable list to generate the record in LVT for this type
	}

	public String toString() {
		return left + " /= " + right;
	}

	public void genCode(MethodGenHelper mg) {
		Type lt = left.getType();
		Type rt = right.getType();
		if(null == lt || null == rt)
			return;

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

			var.setType(myType); // Change the variable type here for later reference of the variable
			mg.updateLVTIndex();
			mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(myType.getDescriptor()));			
			//TODO update shadow variables
		}
		
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
		}
	}
	
	
	@Override
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return null;
		
		stack.push(this);
		Type lType = left.getType(stack);
		Type rType = right.getType(stack);
		if(null == lType || null == rType) {
			stack.pop();
			return null;
		}
		if(Type.getType(Jama.Matrix.class).equals(lType) ||
				Type.getType(Jama.Matrix.class).equals(rType) ) {
			stack.pop();
			return Type.getType(Jama.Matrix.class);
		}
		stack.pop();
		return Type.DOUBLE_TYPE;
	}
	
	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		left.updateType(stack);
		right.updateType(stack);
		stack.pop();
		
		if(null == this.getType(stack)) {
			//throw new RuntimeException("Cannot get type for "+right);
			//left.setType(null);
		} else {
			left.setType(this.getType(stack));
		}
	}
	
	public int test(int x, int y) {
		x /= y * y;
		return x;
	}
}
