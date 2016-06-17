package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class DescNode extends ExprNode {
	public VariableNode var;
	
	public DescNode(VariableNode var) {
		this.var = var;
		this.type = var.getType();
	}
	
	public String toString() {
		return var + "--";
	}
	
	@Override
	public void genCode(MethodVisitor mv) {
		if(getType().getSort() == Type.LONG) {
			var.genCode(mv);
			mv.visitInsn(Opcodes.DUP2);
			mv.visitInsn(Opcodes.LCONST_1);
			mv.visitInsn(Opcodes.LSUB);
			mv.visitVarInsn(Opcodes.LSTORE, var.idxLVT);
		} else
			mv.visitIincInsn(var.idxLVT, -1);
		if(genLoadInsn) {
			mv.visitIntInsn(getType().getOpcode(Opcodes.ILOAD), var.idxLVT);
		}
	}
	
	@Override
	public Type getType() {
		return this.var.getType();
	}
	
	public int test(int a) {
		int c =  a--;
		return c;
	}
	public long test(long a) {
		long c =  a--;
		return c;
	}
}