package io.lambdacloud.node.tool;

import java.util.Deque;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;

public class ArrayAccess extends ExprNode {
	ExprNode array;
	ExprNode index;

	public ArrayAccess(ExprNode array, ExprNode index) {
		this.array = array;
		this.index = index;
		
	}
	@Override
	public void genCode(MethodGenHelper mg) {
		array.genCode(mg);
		index.genCode(mg);
		mg.visitInsn(getType().getOpcode(Opcodes.IALOAD));
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return array.getType().getElementType();
	}

	@Override
	public void updateType(Deque<Object> stack) {
	}
	
	public int test() {
		int[] a = new int[10];
		return a[5];
	}

}
