package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;

public class VariableNode extends ExprNode {
	public String name;
	public int idxLVT; //index in local variable table
	
	public VariableNode(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	public String toString() {
		return "var "+this.name;
	}
	
	public void genCode(MethodGenHelper mg) {
		mg.visitIntInsn(getType().getOpcode(Opcodes.ILOAD), this.idxLVT);
	}
	
	@Override
	public Type getType() {
		return this.type;
	}
}
