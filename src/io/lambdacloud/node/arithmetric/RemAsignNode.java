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

public class RemAsignNode extends BinaryOp {
	public RemAsignNode(VariableNode left, ExprNode right) {
		super(left, right);
	}

	public String toString() {
		return left + " %= " + right;
	}

	public void _genCode(MethodGenHelper mg) {
		VariableNode var = (VariableNode) left;
		Type myType = this.getType();
		Type lt = left.getType();
		Type rt = right.getType();
		if(null == lt || null == rt)
			return;
		
		if(myType.getDescriptor().equals(Type.getType(String.class).getDescriptor())) {
			left.genCode(mg);
			right.genCode(mg);
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
			mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(right.getType().getDescriptor()));
		} else if((myType.getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor()))) {
			if(lt.getSort() == Type.OBJECT && rt.getSort() == Type.OBJECT) {
				left.genCode(mg);
				right.genCode(mg);
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "rem","(LJama/Matrix;LJama/Matrix;)LJama/Matrix;", false);
			} else if(lt.getSort() == Type.OBJECT) {
				left.genCode(mg);
				right.genCode(mg);
				Tools.insertConversionInsn(mg, rt, Type.DOUBLE_TYPE);
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "rem", "(LJama/Matrix;D)LJama/Matrix;", false);
				mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(lt.getDescriptor()));
			} else if(rt.getSort() == Type.OBJECT) {
				left.genCode(mg);
				Tools.insertConversionInsn(mg, lt, Type.DOUBLE_TYPE);
				right.genCode(mg);
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "rem", "(DLJama/Matrix;)LJama/Matrix;", false);

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
			mg.visitInsn(myType.getOpcode(Opcodes.IREM));

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
			left.setType(null);
		} else {
			left.setType(this.getType(stack));
		}
	}

	public int test(int x, int y) {
		x %= y * y;
		return x;
	}
}
