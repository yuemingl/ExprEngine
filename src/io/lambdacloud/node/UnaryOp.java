package io.lambdacloud.node;

import java.util.Deque;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class UnaryOp extends ExprNode {
	public ExprNode expr;
	
	public UnaryOp(ExprNode node) {
		if(null != node)
			this.expr = node.setParent(this);
	}
	
	@Override
	public void _genCode(MethodGenHelper mg) {
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
	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		expr.updateType(stack);
		stack.pop();
	}

	@Override
	public boolean contains(ExprNode target) {
		if(this == target)
			return true;
		else
			return this.expr.contains(target);
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		if(this.expr == oldNode) {
			this.expr = newNode;
		}
		this.expr.replaceChild(oldNode, newNode);
	}

	@Override
	public void updateTree(MethodGenHelper mg) {
		if(!(this.expr instanceof VariableNode) && this != this.expr.getParent()) {
			throw new RuntimeException("Parent link of chind is not set correctly!");
		}
		this.expr.updateTree(mg);
	}

	@Override
	public void updateParam(String name, Object value) {
		this.expr.updateParam(name, value);
	}
}
