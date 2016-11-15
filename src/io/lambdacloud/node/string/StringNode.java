package io.lambdacloud.node.string;

import java.util.Deque;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;

public class StringNode extends ExprNode {
	public String strVal;
	
	public StringNode(String s) {
		this.strVal = s;
	}
	
	@Override
	public void _genCode(MethodGenHelper mg) {
		mg.visitLdcInsn(strVal);
	}
	
	public static String test() {
		return "abc";
	}
	
	@Override
	public Type getType() {
		return Type.getType(String.class);
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.getType(String.class);
	}	
	
	@Override
	public String toString() {
		return this.strVal;
	}

	@Override
	public void updateType(Deque<Object> stack) {
	}

	@Override
	public boolean contains(ExprNode target) {
		return this == target;
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
	}

	@Override
	public void updateTree(MethodGenHelper mg) {
	}

	@Override
	public void updateParam(String name, Object value) {
	}
}
