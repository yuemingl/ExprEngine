package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import java.util.Deque;
import java.util.LinkedList;

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
	}
	
	public String toString() {
		return left + "=" + right;
	}
	
	public void genCode(MethodGenHelper mg) {
		Type myType = this.getType();
		right.genCode(mg);
		if(right instanceof AssignNode) {
			AssignNode r = (AssignNode)right;
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), r.left.idxLVT);
		}
		mg.visitIntInsn(myType.getOpcode(Opcodes.ISTORE), left.idxLVT);
		if(genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), left.idxLVT);
		}
	}

	@Override
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) return null;
		stack.push(this);
		
		return right.getType(stack);
	}
	
	public void fixType() {
		left.setType(right.getType());
	}
}
