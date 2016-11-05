package io.lambdacloud.node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public abstract class ExprNode {
	boolean freezeType = false; //no use?
	// protected Type type;
	protected Object tag; //no use?
	protected boolean genLoadInsn = false;

	protected ArrayList<ExprNode> beforeExprs = new ArrayList<ExprNode>();
	protected ArrayList<ExprNode> afterExprs = new ArrayList<ExprNode>();

	/**
	 * Subclass needs to implement this method to generate bytecode
	 * @param mg
	 */
	public abstract void _genCode(MethodGenHelper mg);

	/**
	 * Expressions can inserted before or after any expression 
	 * @param mg
	 */
	public void genCode(MethodGenHelper mg) {
		for(int i=0; i<beforeExprs.size(); i++) {
			beforeExprs.get(i)._genCode(mg);
		}
		_genCode(mg);
		for(int i=0; i<afterExprs.size(); i++) {
			afterExprs.get(i)._genCode(mg);
		}
	}
	
	public Type getType() {
		Deque<Object> stack = new LinkedList<Object>();
		return getType(stack);
	}
	
	public abstract Type getType(Deque<Object> stack);

	public void setType(Type type) {
		throw new UnsupportedOperationException("Call getRetType() instead!");
	}

	public void freezeType(boolean isFreeze) {
		this.freezeType = isFreeze;
	}

	// Pass all the way down to the leave of the expresson tree
	// public void fixType(Map<String, VariableNode> varMap) {
	// }

	public ExprNode setTag(Object tag) {
		this.tag = tag;
		return this;
	}

	public Object getTag() {
		return this.tag;
	}

//	public String toString() {
//		return getType(1) + ":" + tag;
//	}

	/**
	 * Generate LOAD instruction for assign like operators =, +=, -=, *=, /=,
	 * %=, ++, --
	 * 
	 * @param flag
	 */
	public void genLoadInsn(boolean flag) {
		this.genLoadInsn = flag;
	}

//	public void updateType() {
//		Deque<Object> stack = new LinkedList<Object>();
//		updateType(stack);
//	}

	public abstract void updateType(Deque<Object> stack);
	
	
	//////////////////Tree transformation functions////////////////
	
	/**
	 * Check if target exists in the current expression
	 * by comparing java object reference
	 * 
	 * @param target
	 * @return
	 */
	public abstract boolean contains(ExprNode target);
	
	
	public abstract void replaceChild(ExprNode oldNode, ExprNode newNode);
	
	/**
	 * Insert an expression before this node
	 * @param node
	 */
	public void insertBefore(ExprNode node) {
		this.beforeExprs.add(0, node);
	}
	
	/**
	 * Insert an expression after this node
	 * @param node
	 */
	public void insertAfter(ExprNode node) {
		this.afterExprs.add(node);
	}

}
