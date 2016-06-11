package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class NegateNode extends ExprNode {
	ExprNode expr;
	public NegateNode(ExprNode expr) {
		this.expr = expr;
		this.type = expr.getType();
	}
	
	public String toString() {
		return "-" + expr;
	}
	
	public void genCode(MethodVisitor mv) {
		expr.genCode(mv);
		mv.visitInsn(this.type.getOpcode(Opcodes.INEG));
	}
}