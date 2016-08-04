package io.lambdacloud.node.string;

import java.util.Deque;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;

public class StringCompareNode extends ExprNode {
	ExprNode left;
	ExprNode right;
	String opcode;

	public StringCompareNode(ExprNode left, ExprNode right, String opcode) {
		this.left = left;
		this.right = right;
		this.opcode = opcode;
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		if("==".equals(opcode)) {
			left.genCode(mg);
			right.genCode(mg);
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
		} else if("!=".equals(opcode)){
			left.genCode(mg);
			right.genCode(mg);
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
			Label l1 = new Label();
			mg.visitJumpInsn(Opcodes.IFEQ, l1);
			mg.visitInsn(Opcodes.ICONST_0);
			Label l2 = new Label();
			mg.visitJumpInsn(Opcodes.GOTO, l2);
			mg.visitLabel(l1);
			mg.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mg.visitInsn(Opcodes.ICONST_1);
			mg.visitLabel(l2);
		} else {
			throw new RuntimeException("");
		}
		
	}
	
	public boolean test(String a, String b) {
		return a.equals(b);
	}

	@Override
	public Type getType() {
		return Type.BOOLEAN_TYPE;
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.BOOLEAN_TYPE;
	}

}
