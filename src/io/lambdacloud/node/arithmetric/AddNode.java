package io.lambdacloud.node.arithmetric;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.BytecodeSupport;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;

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
	
	/**
	 * No need to override _genCode(). Override genCode() can have better performance.
	 * 
	 * *** We need to override _genCode() to function properly
	 */
	public void _genCode(MethodGenHelper mg) {
		Type myType = this.getType();
		Type lt = left.getType();
		Type rt = right.getType();
		if(null == lt || null == rt)
			return;
		if(myType.equals(Type.getType(String.class))) {
			left.genCode(mg);
			Tools.insertConversionInsn(mg, left.getType(), myType);
			right.genCode(mg);
			Tools.insertConversionInsn(mg, right.getType(), myType);
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
		} else if((myType.equals(Type.getType(Jama.Matrix.class)))) {
			//myType is Jama.Matrix
			if(lt.getSort() == Type.OBJECT && rt.getSort() == Type.OBJECT) {
				left.genCode(mg);
				right.genCode(mg);
				mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "plus", "(LJama/Matrix;)LJama/Matrix;", false);
			} else if(lt.getSort() == Type.OBJECT) {
				left.genCode(mg);
				right.genCode(mg);
				Tools.insertConversionInsn(mg, rt, Type.DOUBLE_TYPE);
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "plus", "(LJama/Matrix;D)LJama/Matrix;", false);
			} else if(rt.getSort() == Type.OBJECT) {
				right.genCode(mg);
				left.genCode(mg);
				Tools.insertConversionInsn(mg, lt, Type.DOUBLE_TYPE);
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "plus", "(LJama/Matrix;D)LJama/Matrix;", false);
			} else {
				throw new RuntimeException();
			}
		} else if(myType.getSort() == Type.DOUBLE ||
				  myType.getSort() == Type.LONG   ||
				  myType.getSort() == Type.INT
				){
			left.genCode(mg);
			Tools.insertConversionInsn(mg, left.getType(), myType);
			right.genCode(mg);
			Tools.insertConversionInsn(mg, right.getType(), myType);
			mg.visitInsn(myType.getOpcode(Opcodes.IADD));
		} else {
			left.genCode(mg);
			right.genCode(mg);
			mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), 
					"plus", "("+Type.getType(Object.class)+Type.getType(Object.class)+")"+Type.getType(Object.class), false);
		}
	}
}
