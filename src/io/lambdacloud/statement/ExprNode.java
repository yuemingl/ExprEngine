package io.lambdacloud.statement;

import java.util.Map;
import java.util.SortedMap;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public abstract class ExprNode {
	protected Type type;
	protected Object tag;
	protected boolean genLoadInsn = false;
	
	public abstract void genCode(MethodGenHelper mg);
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

// Pass all the way down to the leave of the expresson tree
//	public void fixType(Map<String, VariableNode> varMap) {
//	}
	
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
