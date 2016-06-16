package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class VariableNode extends ExprNode {
	public String name;
	public int idxLVT; //index in local variable table
	protected ExprNode lastValue;
	
	public VariableNode(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	public VariableNode(String name, ExprNode val) {
		this.name = name;
		this.lastValue = val;
		this.type = val.type;
	}
	
	public VariableNode assign(ExprNode val) {
		this.lastValue = val;
		this.type = val.getType();
		return this;
	}
	
	public String toString() {
		if(null == this.lastValue)
			return this.name;
		else
			return "var "+this.name+"="+this.lastValue;
	}
	
	public void genCode(MethodVisitor mv) {
		mv.visitIntInsn(getType().getOpcode(Opcodes.ILOAD), this.idxLVT);
	}
	
	@Override
	public Type getType() {
		if(null != this.lastValue)
			return this.lastValue.getType();
		else
			return this.type;
	}	
}
