package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class ConstantNode extends ExprNode {
	String value;
	public ConstantNode(String value) {
		this.value = value;
		this.type = Type.DOUBLE_TYPE; //TODO
	}
	
	public Double getDouble() {
		return Double.parseDouble(this.value);
	}
	public Integer getInt() {
		return Integer.parseInt(this.value);
	}
	public Boolean getBoolean() {
		return "true".equalsIgnoreCase(this.value);
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
}
