package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class ConstantNode extends ExprNode {
	String value;
	public ConstantNode(String value, Type type) {
		this.value = value;
		this.type = type;
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
		if(type.getSort() == Type.DOUBLE) {
			mv.visitLdcInsn(Double.parseDouble(value));
		} else if(type.getSort() == Type.BOOLEAN) {
			mv.visitLdcInsn(getBoolean());
		} else {
			throw new RuntimeException("Nothing to generate!");
		}
	}
}
