package io.lambdacloud.statement;

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
	public void setType(Type type) {
		this.type = type;
	}

	public void genCode(MethodGenHelper mg) {
		if(type.getSort() == Type.DOUBLE) {
			mg.visitLdcInsn(getDouble());
		} else if(type.getSort() == Type.INT) {
			mg.visitLdcInsn(getInt());
		} else if(type.getSort() == Type.BOOLEAN) {
			mg.visitLdcInsn(getBoolean());
		} else {
			throw new RuntimeException("Nothing to generate!");
		}
	}
}

//dvr5grtry7r7ytttgtyrtyiybvvthbrrggyjhytyyfthgguytbyfderfbtjhibybfghguyhhtyhghbygjyjh ghghghftfgrttutyt6y6utu56j8ytu7k76lynb8hujiojkjy7ik66ujyttytytygjvybuhjbughhuuyyhiyu7oyytby4e2fthtjtuhngyjtyyhjhmghjnyguyhnyhjohkuykhkkhnujkjmiyhhjky,ujjgrtjjhghhmtg67u5766l6hyr6tr9ygyhyhguhtgfrdrwd5tgayha7wygerduhgjynghyjjyjtyjy978uyt5r5tujr57t7y6rr6tu

