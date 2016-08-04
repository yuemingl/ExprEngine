package io.lambdacloud.node;

import java.util.Deque;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class AssignNode extends BinaryOp {

	public AssignNode(VariableNode left, ExprNode right) {
		left.genLoadInsn(true);
		left.lastValue = right;
		this.left = left;

		this.right = right;
		this.right.genLoadInsn(true);
	}

	public String toString() {
		return left + "=" + right;
	}

	public void genCode(MethodGenHelper mg) {
		VariableNode var = (VariableNode)left;
		
		Type myType = this.getType();
		right.genCode(mg);
		if (right instanceof AssignNode) {
			AssignNode r = (AssignNode) right;
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), r.getIdxLVT());
		}
		mg.visitIntInsn(myType.getOpcode(Opcodes.ISTORE), var.idxLVT);
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.idxLVT);
		}
	}
	
	public int getIdxLVT() {
		return ((VariableNode)left).idxLVT;
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

	public void fixType() {
		left.setType(right.getType());
	}
}
