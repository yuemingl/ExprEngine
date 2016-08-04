package io.lambdacloud.node;

import java.util.Deque;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class UnaryOp extends ExprNode {
	public ExprNode expr;
	
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
		Type retType = this.expr.getType(stack);
		stack.pop();
		
		return retType;
	}

	@Override
	public void fixType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		expr.fixType(stack);
		stack.pop();
	}
}
