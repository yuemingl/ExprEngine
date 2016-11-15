package io.lambdacloud.node.binary;

import static org.objectweb.asm.Opcodes.ICONST_M1;
import static org.objectweb.asm.Opcodes.IXOR;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.UnaryOp;

public class BNotNode extends UnaryOp {

	public BNotNode(ExprNode expr) {
		super(expr);
		this.expr.genLoadInsn(true);
	}

	public String toString() {
		return "~" + expr;
	}

	@Override
	public void genCode(MethodGenHelper mg) {
		Type myType = this.getType();
		expr.genCode(mg);
		if (myType.getSort() == Type.LONG)
			mg.visitLdcInsn(new Long(-1L));
		else
			mg.visitInsn(ICONST_M1);
		mg.visitInsn(myType.getOpcode(IXOR));
	}

	public int test(int a) {
		int c = ~a;
		return c;
	}

	public long test(long a) {
		long c = ~a;
		return c;
	}

	public short test(short a) {
		short c = (short) ~a; // I2S
		return c;
	}

}