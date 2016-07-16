package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.ICONST_M1;
import static org.objectweb.asm.Opcodes.IXOR;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class BNotNode extends ExprNode {
	public ExprNode expr;
	
	public BNotNode(ExprNode expr) {
		this.expr = expr;
		this.expr.genLoadInsn(true);
	}
	
	public String toString() {
		return "~" + expr;
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		expr.genCode(mg);
		if(getType().getSort() == Type.LONG)
			mg.visitLdcInsn(new Long(-1L));
		else
			mg.visitInsn(ICONST_M1);
		mg.visitInsn(getType().getOpcode(IXOR));
	}
	
	@Override
	public Type getType() {
		return this.expr.getType();
	}
	
	public int test(int a) {
		int c =  ~a;
		return c;
	}
	public long test(long a) {
		long c =  ~a;
		return c;
	}
	public short test(short a) {
		short c =  (short) ~a; //I2S
		return c;
	}
	
}