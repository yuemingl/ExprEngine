package io.lambdacloud.node;

import java.util.ArrayList;
import java.util.Deque;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class StatementNode extends ExprNode {
	public ArrayList<ExprNode> exprs = new ArrayList<ExprNode>();

	@Override
	public void genCode(MethodGenHelper mg) {
		for(int i=exprs.size()-1; i>=0; i--) {
			exprs.get(i).genCode(mg);
		}
	}

	@Override
	public Type getType(Deque<Object> stack) {
		for(int i=exprs.size()-1; i>=0; i--) {
			Type ty = exprs.get(i).getType(stack);
			if(null != ty) return ty;
		}
		return null;
	}

	@Override
	public void updateType(Deque<Object> stack) {
		for(int i=exprs.size()-1; i>=0; i--) {
			exprs.get(i).updateType(stack);
		}
	}

	@Override
	public boolean contains(ExprNode target) {
		if(this == target)
			return true;
		for(ExprNode e : this.exprs) {
			if(e.contains(target))
				return true;
		}
		return false;
	}
}
