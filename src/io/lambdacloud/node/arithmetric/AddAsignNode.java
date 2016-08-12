package io.lambdacloud.node.arithmetric;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.BytecodeSupport;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.node.VariableNode;

public class AddAsignNode extends BinaryOp {
	public AddAsignNode(VariableNode left, ExprNode right) {
		this.left = left;
		this.right = right;
		
		left.addValue(this); // Add value to the variable list to generate the record in LVT for this type
	}

	public String toString() {
		return left + " += " + right;
	}

	public void genCode(MethodGenHelper mg) {
		VariableNode var = (VariableNode) left;
		Type myType = this.getType();
		Type lt = left.getType();
		Type rt = right.getType();
		
		if(myType.getDescriptor().equals(Type.getType(String.class).getDescriptor())) {
			left.genCode(mg);
			right.genCode(mg);
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
			mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(right.getType().getDescriptor()));
		} else if((myType.getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor()))) {
			if(lt.getSort() == Type.OBJECT && rt.getSort() == Type.OBJECT) {
				left.genCode(mg);
				right.genCode(mg);
				mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "plusEquals", "(LJama/Matrix;)LJama/Matrix;", false);
			} else if(lt.getSort() == Type.OBJECT) {
				left.genCode(mg);
				right.genCode(mg);
				Tools.insertConversionInsn(mg, rt, Type.DOUBLE_TYPE);
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "plus", "(LJama/Matrix;D)LJama/Matrix;", false);
				mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(lt.getDescriptor()));
			} else if(rt.getSort() == Type.OBJECT) {
				right.genCode(mg);
				left.genCode(mg);
				Tools.insertConversionInsn(mg, lt, Type.DOUBLE_TYPE);
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "plus", "(LJama/Matrix;D)LJama/Matrix;", false);
				mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(rt.getDescriptor()));
				
				var.setType(myType); // Change the variable type here for later reference of the variable
				
			} else {
				throw new RuntimeException();
			}
		} else {
			left.genCode(mg);
			Tools.insertConversionInsn(mg, left.getType(), myType);
			right.genCode(mg);
			Tools.insertConversionInsn(mg, right.getType(), myType);
			mg.visitInsn(myType.getOpcode(Opcodes.IADD));
			mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(myType.getDescriptor()));
			
			var.setType(myType); // Change the variable type here for later reference of the variable
		}
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
		}
	}

	public int test(int x, int y) {
		x += y * y;
		return x;
	}
}
