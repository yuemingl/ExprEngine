package io.lambdacloud.node.tool;

import java.util.Deque;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.AssignNode;
import io.lambdacloud.node.BinaryOp;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.VariableNode;

public class SimpleAssign extends BinaryOp  {
	Type activeVarType = null;
	
	public SimpleAssign(VariableNode left, ExprNode right) {
		this.left = left;
		this.right = right;
	}
	public SimpleAssign(VariableNode left, ExprNode right, Type activeVarType) {
		this.left = left;
		this.right = right;
		this.activeVarType = activeVarType;
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		VariableNode var = (VariableNode)left;
		Type myType = this.getType();
		if(null == myType) return;
	
		right.genCode(mg);

		if(null != this.activeVarType) {
			myType = this.activeVarType;
			var.setType(this.activeVarType);
		} else {
			var.setType(myType);
		}
		mg.updateLVTIndex();
		
		if (right instanceof AssignNode) {
			AssignNode r = (AssignNode) right;
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), ((VariableNode)(r.left)).getLVTIndex(myType.getDescriptor()));
		}
		mg.visitIntInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(myType.getDescriptor()));
	}

	@Override
	public Type getType(Deque<Object> stack) {
		// circle check
		if (stack.contains(this))
			return null;
		stack.push(this);
		Type retType = right.getType(stack);
		stack.pop();
		return retType;
	}

	@Override
	public void updateType(Deque<Object> stack) {
	}

	public String toString() {
		return this.left + "=" + this.right;
	}
}
