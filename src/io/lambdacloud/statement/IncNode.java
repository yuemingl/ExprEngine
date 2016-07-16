package io.lambdacloud.statement;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class IncNode extends ExprNode {
	public VariableNode var;
	
	public IncNode(VariableNode var) {
		this.var = var;
	}
	
	public String toString() {
		return var + "++";
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		if(getType().getSort() == Type.LONG) {
			var.genCode(mg);
			mg.visitInsn(Opcodes.DUP2);
			mg.visitInsn(Opcodes.LCONST_1);
			mg.visitInsn(Opcodes.LADD);
			mg.visitVarInsn(Opcodes.LSTORE, var.idxLVT);
		} else {
			mg.visitIincInsn(var.idxLVT, 1);
		}
		if(genLoadInsn) {
			mg.visitIntInsn(getType().getOpcode(Opcodes.ILOAD), var.idxLVT);
		}
	}
	
	@Override
	public Type getType() {
		return this.var.getType();
	}
	
	public int test(int a) {
		int c =  a++;
		return c;
	}
	public long test(long a) {
		long c =  a++;
		return c;
	}
}