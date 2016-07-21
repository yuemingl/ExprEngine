package io.lambdacloud.statement;

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
}
