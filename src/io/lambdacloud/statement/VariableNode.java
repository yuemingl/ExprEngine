package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;

public class VariableNode extends ExprNode {
	public String name;
	public int idxLVT; //index in local variable table
	private int varLoc; //1 parameter; 2 local variable; 3 global?
	
	//This is mainly used to carry type info for arrays generated from list comprehension
	public ExprNode lastValue;
	
	public boolean isParameter() {
		return varLoc == 1;
	}
	
	public boolean isLocalVar() {
		return varLoc == 2;
	}
	
	public void setAsParameter() {
		this.varLoc = 1;
	}
	
	public void setAsLocalVar() {
		this.varLoc = 2;
	}
	
	public static VariableNode newParameter(String name, Type type) {
		VariableNode node = new VariableNode();
		node.name = name;
		node.type = type;
		node.varLoc = 1;
		return node;
	}
	
	public static VariableNode newLocalVar(String name, Type type) {
		VariableNode node = new VariableNode();
		node.name = name;
		node.type = type;
		node.varLoc = 2;
		return node;
	}
	
	private VariableNode() {
	}
	
//	@Override 
//	public Type getType() {
//		if(null != this.lastValue && this != this.lastValue) {
//			return this.lastValue.getType();
//		} else {
//			return type;
//		}
//	}
	
	public String toString() {
		String loc = "local";
		if(this.varLoc == 1) loc = "param";
		return "var(" + this.name + ":" + type + ":" + loc + ":" + idxLVT + ")";
	}
	
	public void genCode(MethodGenHelper mg) {
		mg.visitIntInsn(getType().getOpcode(Opcodes.ILOAD), this.idxLVT);
	}

}
