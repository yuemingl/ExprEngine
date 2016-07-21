package io.lambdacloud.statement;

import java.util.Deque;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class UnaryOp extends ExprNode {
	public ExprNode expr;
	
	@Override
	public void genCode(MethodGenHelper mg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Type getType(Deque<Object> stack) {
		// TODO Auto-generated method stub
		return null;
	}

}
