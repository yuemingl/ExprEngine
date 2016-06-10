package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class AssignNode extends ExprNode {
	VariableNode left;
	ExprNode right;
	public AssignNode(VariableNode left, ExprNode right) {
		this.left = left;
		this.right = right;
		this.type = right.getType();
	}
	
	public String toString() {
		return left + "=" + right;
	}
	
	public void genCode(MethodVisitor mv) {
		right.genCode(mv);
		mv.visitIntInsn(this.type.getOpcode(Opcodes.ISTORE), left.idxLVT);
	}
	
}
