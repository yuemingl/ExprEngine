package io.lambdacloud.node.arithmetric;

import java.util.Deque;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.BytecodeSupport;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;

public class DivNode extends BinaryOp {
	public DivNode(ExprNode left, ExprNode right) {
		super(left, right);
		this.left.genLoadInsn(true);
		this.right.genLoadInsn(true);
	}

	public String toString() {
		return left + "/" + right;
	}

	public void _genCode(MethodGenHelper mg) {
		Type lt = left.getType();
		Type rt = right.getType();
		if(null == lt || null == rt)
			return;
		Type myType = this.getType();
		if((myType.equals(Type.getType(Jama.Matrix.class)))) {
			if(lt.getSort() == Type.OBJECT && rt.getSort() == Type.OBJECT) {
				left.genCode(mg);
				right.genCode(mg);
				mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", 
						"solve", "(LJama/Matrix;)LJama/Matrix;", false);
			} else if(lt.getSort() == Type.OBJECT) {
				left.genCode(mg);
				right.genCode(mg);
				Tools.insertConversionInsn(mg, rt, Type.DOUBLE_TYPE);
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), 
						"div", "(LJama/Matrix;D)LJama/Matrix;", false);
			} else if(rt.getSort() == Type.OBJECT) {
				left.genCode(mg);
				Tools.insertConversionInsn(mg, lt, Type.DOUBLE_TYPE);
				right.genCode(mg);
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), 
						"div", "(DLJama/Matrix;)LJama/Matrix;", false);
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
			mg.visitInsn(myType.getOpcode(Opcodes.IDIV));
		} else {
			left.genCode(mg);
			right.genCode(mg);
			mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), 
					"div", "("+Type.getType(Object.class)+Type.getType(Object.class)+")"+Type.getType(Object.class), false);
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
		if(Type.getType(Object.class).equals(lType) ||
				Type.getType(Object.class).equals(rType) ) {
			stack.pop();
			return Type.getType(Object.class);
		}
		stack.pop();
		return Type.DOUBLE_TYPE;
	}

}
