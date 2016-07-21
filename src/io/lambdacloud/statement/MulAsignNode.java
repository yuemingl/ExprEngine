package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import java.util.Deque;
import java.util.LinkedList;

import org.objectweb.asm.Opcodes;

public class MulAsignNode extends BinaryOp {
	public MulAsignNode(VariableNode left, ExprNode right) {
		this.left = left;
		this.right = right;
	}
	
	public String toString() {
		return left + " *= " + right;
	}
	
	public void genCode(MethodGenHelper mg) {
		VariableNode var = (VariableNode) left;
		Type myType = this.getType();
		left.genCode(mg); //load
		right.genCode(mg);
		mg.visitInsn(myType.getOpcode(Opcodes.IMUL));
		mg.visitVarInsn(myType.getOpcode(Opcodes.ISTORE), var.idxLVT);
		if(genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.idxLVT);
		}
	}

	public int test(int x, int y) {
		x *= y*y;
		return x;
	}
}
