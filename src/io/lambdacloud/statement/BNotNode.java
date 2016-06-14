package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.ICONST_M1;
import static org.objectweb.asm.Opcodes.IXOR;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class BNotNode extends ExprNode {
	public ExprNode expr;
	
	public BNotNode(ExprNode expr) {
		this.expr = expr;
		this.type = Type.INT_TYPE;
	}
	
	public String toString() {
		return "~" + expr;
	}
	
	@Override
	public void genCode(MethodVisitor mv) {
		expr.genCode(mv);
		mv.visitInsn(ICONST_M1);
		mv.visitInsn(IXOR);
	}
	
	public int test(int a, int b) {
		int c =  ~b;
		return c;
	}
}