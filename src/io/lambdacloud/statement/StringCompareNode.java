package io.lambdacloud.statement;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class StringCompareNode extends ExprNode {
	ExprNode left;
	ExprNode right;
	String opcode;

	public StringCompareNode(ExprNode left, ExprNode right, String opcode) {
		this.left = left;
		this.right = right;
		this.opcode = opcode;
		this.type = Type.BOOLEAN_TYPE;
	}
	
	@Override
	public void genCode(MethodVisitor mv) {
		if("==".equals(opcode)) {
			left.genCode(mv);
			right.genCode(mv);
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
		} else if("!=".equals(opcode)){
			left.genCode(mv);
			right.genCode(mv);
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
			Label l1 = new Label();
			mv.visitJumpInsn(Opcodes.IFEQ, l1);
			mv.visitInsn(Opcodes.ICONST_0);
			Label l2 = new Label();
			mv.visitJumpInsn(Opcodes.GOTO, l2);
			mv.visitLabel(l1);
			mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mv.visitInsn(Opcodes.ICONST_1);
			mv.visitLabel(l2);
		} else {
			throw new RuntimeException("");
		}
		
	}

	public boolean test(String a, String b) {
		return a.equals(b);
	}

}
