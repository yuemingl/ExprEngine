package io.lambdacloud.node;

import java.util.Deque;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class BinaryOp extends ExprNode {
	public ExprNode left;
	public ExprNode right;
	
	public BinaryOp(ExprNode left, ExprNode right) {
		this.left = left.setParent(this);
		this.right = right.setParent(this);
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

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		if(this.left == oldNode) {
			this.left = newNode;
		}
		if(this.right == oldNode) {
			this.right = newNode;
		}
		this.left.replaceChild(oldNode, newNode);
		this.right.replaceChild(oldNode, newNode);
	}

	@Override
	public void updateTree(MethodGenHelper mg) {
		this.left.updateTree(mg);
		this.right.updateTree(mg);
	}

	@Override
	public void updateParam(String name, Object value) {
		left.updateParam(name, value);
		right.updateParam(name, value);
	}
}
