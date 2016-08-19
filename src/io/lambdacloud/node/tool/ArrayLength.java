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
	public void genCode(MethodGenHelper mg) {
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

	public void test() {
		int[] a = null;
		int b= a.length;
	}
}
