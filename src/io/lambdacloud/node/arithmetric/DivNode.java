package io.lambdacloud.node.arithmetric;

import java.util.Deque;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;

public class DivNode extends BinaryOp {
	public DivNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
	}

	public String toString() {
		return left + "/" + right;
	}

	public void genCode(MethodGenHelper mg) {
		Type lt = left.getType();
		Type rt = right.getType();
		if(null == lt || null == rt)
			return;
		Type myType = this.getType();
		left.genCode(mg);
		Tools.insertConversionInsn(mg, left.getType(), myType);
		right.genCode(mg);
		Tools.insertConversionInsn(mg, right.getType(), myType);
		if((myType.getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor()))) {
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "solve", "(LJama/Matrix;)LJama/Matrix;", false);
		} else {
			mg.visitInsn(myType.getOpcode(Opcodes.IDIV));
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

}
