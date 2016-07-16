package io.lambdacloud.statement;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public abstract class ExprNode {
	boolean freezeType = false;
	// protected Type type;
	protected Object tag;
	protected boolean genLoadInsn = false;

	public abstract void genCode(MethodGenHelper mg);

	public abstract Type getType();

	public void setType(Type type) {
	}

	public void freezeType(boolean isFreeze) {
		this.freezeType = isFreeze;
	}

	// Pass all the way down to the leave of the expresson tree
	// public void fixType(Map<String, VariableNode> varMap) {
	// }

	public ExprNode setTag(Object tag) {
		this.tag = tag;
		return this;
	}

	public Object getTag() {
		return this.tag;
	}

	public String toString() {
		return getType() + ":" + tag;
	}

	/**
	 * Generate LOAD instruction for assign like operators =, +=, -=, *=, /=,
	 * %=, ++, --
	 * 
	 * @param flag
	 */
	public void genLoadInsn(boolean flag) {
		this.genLoadInsn = flag;
	}

	public void fixType() {
	}
}
