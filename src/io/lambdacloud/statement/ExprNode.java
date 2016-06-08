package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;

public interface ExprNode {
	void genCode(MethodVisitor mv);
	String getType();
}
