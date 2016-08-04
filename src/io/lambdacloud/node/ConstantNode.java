package io.lambdacloud.node;

import java.util.Deque;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class ConstantNode extends ExprNode {
	Type type;
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
	public Long getLong() {
		return Long.parseLong(this.value);
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
	
	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return this.type;
	}

	@Override
	public void setType(Type type) {
		this.type = type;
	}

	public void genCode(MethodGenHelper mg) {
		if(type.getSort() == Type.DOUBLE) {
			mg.visitLdcInsn(getDouble());
		} else if(type.getSort() == Type.INT) {
			mg.visitLdcInsn(getInt());
		} else if(type.getSort() == Type.LONG) {
			mg.visitLdcInsn(getLong());
		} else if(type.getSort() == Type.BOOLEAN) {
			mg.visitLdcInsn(getBoolean());
		} else {
			throw new RuntimeException("Nothing to generate!");
		}
	}

	@Override
	public void fixType(Deque<Object> stack) {
	}

}
