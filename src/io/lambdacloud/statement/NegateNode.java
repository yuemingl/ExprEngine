package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import java.util.Deque;
import java.util.LinkedList;

import org.objectweb.asm.Opcodes;

public class NegateNode extends ExprNode {
	ExprNode expr;
	public NegateNode(ExprNode expr) {
		this.expr = expr;
		expr.genLoadInsn(true);
	}
	
	public String toString() {
		return "-" + expr;
	}
	
	public void genCode(MethodGenHelper mg) {
		expr.genCode(mg);
		mg.visitInsn(getType().getOpcode(Opcodes.INEG));
		
	}

	@Override
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) return null;
		stack.push(this);
		
		return this.expr.getType(stack);
	}	
}