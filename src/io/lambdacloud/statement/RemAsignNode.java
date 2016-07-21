package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import java.util.Deque;
import java.util.LinkedList;

import org.objectweb.asm.Opcodes;

public class RemAsignNode extends ExprNode {
	VariableNode left;
	ExprNode right;
	public RemAsignNode(VariableNode left, ExprNode right) {
		this.left = left;
		this.right = right;
	}
	
	public String toString() {
		return left + " %= " + right;
	}
	
	public void genCode(MethodGenHelper mg) {
		Type myType = this.getType();
		left.genCode(mg); //load
		right.genCode(mg);
		mg.visitInsn(myType.getOpcode(Opcodes.IREM));
		mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), left.idxLVT);
		if(genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), left.idxLVT);
		}
	}

	@Override
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) return null;
		stack.push(this);
		
		return Tools.typeConversion(left.getType(stack), right.getType(stack));
	}
	
	public int test(int x, int y) {
		x %= y*y;
		return x;
	}
}
