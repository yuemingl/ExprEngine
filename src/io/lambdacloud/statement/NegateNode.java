package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class NegateNode extends ExprNode {
	ExprNode expr;
	public NegateNode(ExprNode expr) {
		this.expr = expr;
		this.type = getType();
	}
	
	public String toString() {
		return "-" + expr;
	}
	
	public void genCode(MethodVisitor mv) {
		expr.genCode(mv);
		mv.visitInsn(getType().getOpcode(Opcodes.INEG));
	}
	
	@Override
	public Type getType() {
		return this.expr.getType();
	}
}