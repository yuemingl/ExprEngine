package io.lambdacloud.statement;

import java.util.Deque;
import java.util.LinkedList;

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
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) return null;
		stack.push(this);
		
		return retExpr.getType(stack);
	}
}
