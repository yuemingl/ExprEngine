package io.lambdacloud.node;

import java.util.Deque;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;

public class ReturnNode extends UnaryOp {
	public FuncDefNode refFunc;
	
	public ReturnNode() {
	}

	public ReturnNode(ExprNode retExpr, FuncDefNode refFunc) {
		this.expr = retExpr;
		this.refFunc = refFunc;
	}

	@Override
	public void genCode(MethodGenHelper mg) {
		if (null != expr && null != expr.getType()) {
			expr.genCode(mg);
			mg.visitInsn(this.getType().getOpcode(Opcodes.IRETURN));
			return;
		} else if(null != refFunc.retExpr && null != refFunc.retExpr.getType()){
			refFunc.retExpr.genCode(mg);
			mg.visitInsn(refFunc.retExpr.getType().getOpcode(Opcodes.IRETURN));
			return;
		} else {
			mg.visitInsn(Opcodes.RETURN);
		}
	}
	
	@Override
	public Type getType(Deque<Object> stack) {
		if(null == this.expr)
			return Type.VOID_TYPE;
		else 
			return expr.getType(stack);
	}

	@Override
	public void updateType(Deque<Object> stack) {
	}
}
