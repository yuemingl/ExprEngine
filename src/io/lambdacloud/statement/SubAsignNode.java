package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import org.objectweb.asm.Opcodes;

public class SubAsignNode extends ExprNode {
	VariableNode left;
	ExprNode right;
	public SubAsignNode(VariableNode left, ExprNode right) {
		this.left = left;
		this.right = right;
	}
	
	public String toString() {
		return left + " -= " + right;
	}
	
	public void genCode(MethodGenHelper mg) {
		left.genCode(mg); //load
		right.genCode(mg);
		mg.visitInsn(getType().getOpcode(Opcodes.ISUB));
		mg.visitVarInsn(getType().getOpcode(Opcodes.ISTORE), left.idxLVT);
		if(genLoadInsn) {
			mg.visitIntInsn(getType().getOpcode(Opcodes.ILOAD), left.idxLVT);
		}
	}
	
	@Override
	public Type getType() {
		return Tools.typeConversion(left.getType(), right.getType());
	}
	
	public int test(int x, int y) {
		x -= y*y;
		return x;
	}
}
