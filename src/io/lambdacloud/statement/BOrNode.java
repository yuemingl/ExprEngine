package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import java.util.Deque;
import java.util.LinkedList;

import org.objectweb.asm.Opcodes;

public class BOrNode extends ExprNode {
	ExprNode left;
	ExprNode right;
	public BOrNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
	}
	
	public String toString() {
		return left + "|" + right;
	}
	
	public void genCode(MethodGenHelper mg) {
		left.genCode(mg);
		right.genCode(mg);
		mg.visitInsn(getType().getOpcode(Opcodes.IOR));
	}

	@Override
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) return null;
		stack.push(this);
		
		return Tools.typeConversion(left.getType(stack), right.getType(stack));
	}
	public int test(int a, int b) {
		int c = a | b;
		return c;
	}
}