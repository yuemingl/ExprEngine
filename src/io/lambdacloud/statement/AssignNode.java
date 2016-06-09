package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class AssignNode implements ExprNode {
	VariableNode left;
	ExprNode right;
	public AssignNode(ExprNode left, ExprNode right) {
		this.left = (VariableNode)left;
		this.right = right;
	}
	
	public String toString() {
		return left + "=" + right;
	}
	
	public void genCode(MethodVisitor mv) {
		right.genCode(mv);
		mv.visitIntInsn(Opcodes.DSTORE, left.idxLVT);
	}

	@Override
	public String getType() {
		return null;
	}
}
