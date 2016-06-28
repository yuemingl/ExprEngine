package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.Opcodes;

public class MulAsignNode extends ExprNode {
	VariableNode left;
	ExprNode right;
	public MulAsignNode(VariableNode left, ExprNode right) {
		this.left = left;
		this.right = right;
		this.type = getType();
	}
	
	public String toString() {
		return left + " *= " + right;
	}
	
	public void genCode(MethodVisitor mv) {
		left.genCode(mv); //load
		right.genCode(mv);
		mv.visitInsn(getType().getOpcode(Opcodes.IMUL));
		mv.visitVarInsn(getType().getOpcode(Opcodes.ISTORE), left.idxLVT);
		if(genLoadInsn) {
			mv.visitIntInsn(getType().getOpcode(Opcodes.ILOAD), left.idxLVT);
		}
	}
	
	@Override
	public Type getType() {
		return Tools.typeConversion(left.getType(), right.getType());
	}
	
	public int test(int x, int y) {
		x *= y*y;
		return x;
	}
}
