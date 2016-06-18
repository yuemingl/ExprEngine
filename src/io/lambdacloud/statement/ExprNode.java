package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public abstract class ExprNode {
	protected Type type;
	protected Object tag;
	protected boolean genLoadInsn = false;
	
	public abstract void genCode(MethodVisitor mv);
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public void setTag(Object tag) {
		this.tag = tag;
	}
	public Object getTag() {
		return this.tag;
	}
	public String toString() {
		return type+":"+tag;
	}
	
	/**
	 * Generate LOAD instruction for assign like operators
	 * =, +=, -=, *=, /=, %=, ++, --
	 * 
	 * @param flag
	 */
	public void genLoadInsn(boolean flag) {
		this.genLoadInsn = flag;
	}
}
