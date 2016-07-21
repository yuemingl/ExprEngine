package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import java.util.Deque;
import java.util.LinkedList;

import org.objectweb.asm.Opcodes;

public class AddNode extends ExprNode {
	public ExprNode left;
	public ExprNode right;
	public AddNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.left.genLoadInsn(true);
		this.right = right;
		this.right.genLoadInsn(true);
	}
	
	public String toString() {
		return left + " + " + right;
	}
	
	public void genCode(MethodGenHelper mg) {
		Type myType = this.getType();
		left.genCode(mg);
		Tools.insertConversionInsn(mg, left.getType(), myType);
		right.genCode(mg);
		Tools.insertConversionInsn(mg, right.getType(), myType);
		if(myType.getDescriptor().equals(Type.getType(String.class).getDescriptor())) {
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
		} else {
			mg.visitInsn(myType.getOpcode(Opcodes.IADD));
		}
	}

	@Override
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) return null;
		stack.push(this);
		Type lType = left.getType(stack);
		Type rType = right.getType(stack);
		stack.pop();
		return Tools.typeConversion(lType, rType);
	}
}
