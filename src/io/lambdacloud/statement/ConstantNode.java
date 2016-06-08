package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;

public class ConstantNode implements ExprNode {
	String value;
	public ConstantNode(String value) {
		this.value = value;
	}
	
	public Double getDouble() {
		return Double.parseDouble(this.value);
	}
	public Integer getInt() {
		return Integer.parseInt(this.value);
	}
	public String getString() {
		return this.value;
	}
	
	public String toString() {
		return this.value;
	}
	
	public void genCode(MethodVisitor mv) {
		mv.visitLdcInsn(Double.parseDouble(value));
	}

	@Override
	public String getType() {
		return null;
	}	
}
