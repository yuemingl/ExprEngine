package io.lambdacloud.node.tool;

import java.util.Deque;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;

public class ArrayLength extends ExprNode {
	ExprNode array;
	
	public ArrayLength(ExprNode array) {
		this.array = array;
	}
	
	@Override
	public void _genCode(MethodGenHelper mg) {
		array.genCode(mg);
		mg.visitInsn(Opcodes.ARRAYLENGTH);
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.INT_TYPE;
	}

	@Override
	public void updateType(Deque<Object> stack) {
	}

	@Override
	public boolean contains(ExprNode target) {
		if(this == target)
			return true;
		if(this.array.contains(target))
			return true;
		return false;
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		if(this.array == oldNode)
			this.array = newNode;
	}

	@Override
	public void updateTree(MethodGenHelper mg) {
		this.array.updateTree(mg);
	}

	@Override
	public void updateParam(String name, Object value) {
		this.array.updateParam(name, value);
	}
}
