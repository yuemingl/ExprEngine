package io.lambdacloud.node.logical;

import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.IFEQ;

import java.util.Deque;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.UnaryOp;

public class NotNode extends UnaryOp {
	
	public NotNode(ExprNode expr) {
		this.expr = expr;
	}
	
	public String toString() {
		return " ! " + expr;
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		if(null == expr.getType())
			return;
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
		if(null == expr.getType())
			return null;
		return Type.BOOLEAN_TYPE;
	}

	@Override
	public Type getType(Deque<Object> stack) {
		if(null == expr.getType())
			return null;
		return Type.BOOLEAN_TYPE;
	}
	
	public boolean test(boolean a, boolean b) {
		boolean c =  ! b;
		return c;
	}
}