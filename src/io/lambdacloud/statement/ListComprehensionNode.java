package io.lambdacloud.statement;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.MethodVisitor;

public class ListComprehensionNode extends ExprNode {
	public ExprNode expression;
	public List<ForNode> forIf = new ArrayList<ForNode>();

	@Override
	public void genCode(MethodVisitor mv) {
		// TODO Auto-generated method stub
		
	}

}
