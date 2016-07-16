package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.IFEQ;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class NotNode extends ExprNode {
	public ExprNode expr;
	
	public NotNode(ExprNode expr) {
		this.expr = expr;
	}
	
	public String toString() {
		return " ! " + expr;
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		expr.genCode(mg);
		Label l1 = new Label();
		mg.visitJumpInsn(IFEQ, l1);
		mg.visitInsn(ICONST_0);
		Label l2 = new Label();
		mg.visitJumpInsn(GOTO, l2);
		mg.visitLabel(l1);
		mg.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
		mg.visitInsn(ICONST_1);
		mg.visitLabel(l2);
	}
	
	@Override
	public Type getType() {
		return Type.BOOLEAN_TYPE;
	}
	
	public boolean test(boolean a, boolean b) {
		boolean c =  ! b;
		return c;
	}
}