package io.lambdacloud.node;

import java.util.Deque;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class AssignNode extends BinaryOp {

	public AssignNode(VariableNode left, ExprNode right) {
		//left.genLoadInsn(true);???
		VariableNode var = left;
		var.addValue(right);
		
		this.left = var;
		this.right = right;
		//this.right.genLoadInsn(true);???
	}

	public String toString() {
		return left + "=" + right;
	}

	public void genCode(MethodGenHelper mg) {
		VariableNode var = (VariableNode)left;
		
		Type myType = this.getType();
		right.genCode(mg);
		/**
		 *  No need to insert type conversion since the type of var should be the same as the type of right
		 *  We are 'over writing' the type of left. We need call setType of left to indicate we are on the state
		 *  that left has the type from right
		 *  for example: "a=1; a=a+1.1;"
		 *   
		 */
		//Tools.insertConversionInsn(mg, right.getType(), left.getType());
		////var.setType(myType); //don't change the type of var, use var.getLVTIndex(myType.getDescriptor()) instead
		var.setType(myType); //we still need to change this
		mg.updateLVTIndex();
		
		//Load right node in case of a=b=c;
		if (right instanceof AssignNode) {
			AssignNode r = (AssignNode) right;
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), ((VariableNode)(r.left)).getLVTIndex(myType.getDescriptor()));
		}
		mg.visitIntInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(myType.getDescriptor()));
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
		}
	}
	
	@Override
	public Type getType(Deque<Object> stack) {
		// circle check
		if (stack.contains(this))
			return null;

		stack.push(this);
		//Here we use right.getType() since the type form right will override the type of left
		Type retType = right.getType(stack);
		stack.pop();

		return retType;
	}

	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		right.updateType(stack);
		stack.pop();
		
		left.setType(right.getType());
	}
}
