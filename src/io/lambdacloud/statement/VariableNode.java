package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class VariableNode implements ExprNode {
	public String name;
	public int idxLVT; //index in local variable table
	public ExprNode value;
	
	public VariableNode(String name) {
		this.name = name;
	}
	
	public VariableNode assign(ExprNode node) {
		this.value = node;
		return this;
	}
	
	public String toString() {
		return this.name;
	}
	
	public void genCode(MethodVisitor mv) {
		mv.visitIntInsn(Opcodes.DLOAD, this.idxLVT);
	}

	@Override
	public String getType() {
		return null;
	}	
}
