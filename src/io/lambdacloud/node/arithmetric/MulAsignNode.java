package io.lambdacloud.node.arithmetric;

import java.util.Deque;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.BytecodeSupport;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.node.VariableNode;

public class MulAsignNode extends BinaryOp {
	public MulAsignNode(VariableNode left, ExprNode right) {
		this.left = left;
		this.right = right;
		
////		left.addValue(this); // Add value to the variable list to generate the record in LVT for this type
	}

	public String toString() {
		return left + " *= " + right;
	}

	public void genCode(MethodGenHelper mg) {
		Type lt = left.getType();
		Type rt = right.getType();
		if(null == lt || null == rt)
			return;

		VariableNode var = (VariableNode) left;
		Type myType = this.getType();

		if((myType.getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor()))) {
			if(lt.getSort() == Type.OBJECT && rt.getSort() == Type.OBJECT) {
				left.genCode(mg);
				right.genCode(mg);
				mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "times", "(LJama/Matrix;)LJama/Matrix;", false);
				mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(rt.getDescriptor()));
			} else if(lt.getSort() == Type.OBJECT) {
				left.genCode(mg); // load
				right.genCode(mg);
				Tools.insertConversionInsn(mg, right.getType(), Type.DOUBLE_TYPE);
				mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "timesEquals", "(D)LJama/Matrix;", false);
				mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(lt.getDescriptor()));
			} else if(rt.getSort() == Type.OBJECT) {
				right.genCode(mg);
				left.genCode(mg);
				Tools.insertConversionInsn(mg, lt, Type.DOUBLE_TYPE);
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "times", "(LJama/Matrix;D)LJama/Matrix;", false);

				var.setType(myType); // Change the variable type here for later reference of the variable
				mg.updateLVTIndex();
				mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(rt.getDescriptor()));
			} else {
				throw new RuntimeException();
			}
			//TODO update shadow variables
		} else {
			left.genCode(mg);
			Tools.insertConversionInsn(mg, left.getType(), myType);
			right.genCode(mg);
			Tools.insertConversionInsn(mg, right.getType(), myType);
			mg.visitInsn(myType.getOpcode(Opcodes.IMUL));

			var.setType(myType); // Change the variable type here for later reference of the variable
			mg.updateLVTIndex();
			mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(myType.getDescriptor()));
		}
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
		}
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
		x *= y * y;
		return x;
	}
}
