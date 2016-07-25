package io.lambdacloud.statement;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import Jama.Matrix;
import io.lambdacloud.MethodGenHelper;

public class AddNode extends BinaryOp {
	
	public AddNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
	}
	
	public String toString() {
		return left + " + " + right;
	}
	
	public void genCode(MethodGenHelper mg) {
		Type myType = this.getType();
		left.genCode(mg);
		Tools.insertConversionInsn(mg, left.getType(), myType);
		right.genCode(mg);
		Tools.insertConversionInsn(mg, right.getType(), myType);
		if(myType.getDescriptor().equals(Type.getType(String.class).getDescriptor())) {
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
		} else if((myType.getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor()))) {
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "plus", "(LJama/Matrix;)LJama/Matrix;", false);
		} else {
			mg.visitInsn(myType.getOpcode(Opcodes.IADD));
		}
	}
}
