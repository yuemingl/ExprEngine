package io.lambdacloud.node;

import java.util.Deque;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class BinaryOp extends ExprNode {
	public ExprNode left;
	public ExprNode right;
	
	@Override
	public void genCode(MethodGenHelper mg) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return null;
		
		stack.push(this);
		Type lType = left.getType(stack);
		Type rType = right.getType(stack);
		stack.pop();
		
		return Tools.typeConversion(lType, rType);
	}
	
	@Override
	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		left.updateType(stack);
		right.updateType(stack);
		stack.pop();
	}

	@Override
	public boolean contains(ExprNode target) {
		if(this == target) 
			return true;
		else 
			return this.left.contains(target) || this.right.contains(target);
	}
}
