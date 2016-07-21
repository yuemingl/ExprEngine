package io.lambdacloud.statement;

import java.util.Deque;
import java.util.LinkedList;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class DescNode extends ExprNode {
	public VariableNode var;
	
	public DescNode(VariableNode var) {
		this.var = var;
	}
	
	public String toString() {
		return var + "--";
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		Type myType = this.getType();
		if(myType.getSort() == Type.LONG) {
			var.genCode(mg);
			mg.visitInsn(Opcodes.DUP2);
			mg.visitInsn(Opcodes.LCONST_1);
			mg.visitInsn(Opcodes.LSUB);
			mg.visitVarInsn(Opcodes.LSTORE, var.idxLVT);
		} else
			mg.visitIincInsn(var.idxLVT, -1);
		if(genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.idxLVT);
		}
	}

	@Override
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) return null;
		stack.push(this);
		
		return this.var.getType(stack);
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