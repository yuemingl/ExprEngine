package io.lambdacloud.statement;

import java.util.Deque;
import java.util.LinkedList;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class USHRNode extends ExprNode {
	public ExprNode left;
	public ExprNode right;

	public USHRNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
	}
	
	public String toString() {
		return left + ">>>" + right;
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		left.genCode(mg);
		right.genCode(mg);
		mg.visitInsn(getType().getOpcode(Opcodes.IUSHR));
	}

	@Override
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) return null;
		stack.push(this);
		
		return Tools.typeConversion(left.getType(stack), right.getType(stack));
	}
	
	public int test(int a, int b) {
		int c = a >>> b;
		return c;
	}

}
