package io.lambdacloud.node;

import java.util.Deque;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class NArgInNode extends ExprNode {
	public FuncDefNode refFunc;
	
	public NArgInNode(FuncDefNode refFunc) {
		this.refFunc = refFunc;
	}
	
	@Override
	public void _genCode(MethodGenHelper mg) {
		Type[] ty = refFunc.getParameterTypes(false);
		mg.visitLdcInsn(ty.length);
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.INT_TYPE;
	}

	@Override
	public void updateType(Deque<Object> stack) {
		refFunc.updateType(stack);
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
