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
	public void genCode(MethodGenHelper mg) {
		Type[] ty = refFunc.getParameterTypes(false);
		mg.visitLdcInsn(ty.length);
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.INT_TYPE;
	}

	@Override
	public void updateType(Deque<Object> stack) {
	}

}
