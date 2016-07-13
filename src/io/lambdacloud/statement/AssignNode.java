package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import org.objectweb.asm.Opcodes;

public class AssignNode extends ExprNode {
	VariableNode left;
	ExprNode right;
	public AssignNode(VariableNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.left.lastValue = right;
		
		this.right = right;
		this.right.genLoadInsn(true);
		this.type = right.getType();
	}
	
	public String toString() {
		return left + "=" + right;
	}
	
	@Override
	public Type getType() {
		return right.getType();
	}
	
	public void genCode(MethodGenHelper mg) {
		right.genCode(mg);
		if(right instanceof AssignNode) {
			AssignNode r = (AssignNode)right;
			mg.visitIntInsn(getType().getOpcode(Opcodes.ILOAD), r.left.idxLVT);
		}
		mg.visitIntInsn(getType().getOpcode(Opcodes.ISTORE), left.idxLVT);
		if(genLoadInsn) {
			mg.visitIntInsn(getType().getOpcode(Opcodes.ILOAD), left.idxLVT);
		}
	}
	
}
