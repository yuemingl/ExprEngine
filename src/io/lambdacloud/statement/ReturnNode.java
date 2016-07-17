package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;

public class ReturnNode extends ExprNode {
	ExprNode retExpr;
	
	public ReturnNode() {
	}
	
	public ReturnNode(ExprNode retExpr) {
		this.retExpr = retExpr;
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		if(null != retExpr) {
			retExpr.genCode(mg);
			mg.visitInsn(this.getType().getOpcode(Opcodes.IRETURN));
		} else {
			mg.visitInsn(Opcodes.RETURN);
		}
	}

	@Override
	public Type getType() {
		return retExpr.getType();
	}

}
