package io.lambdacloud.node;


import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class DupNode extends UnaryOp {
	public DupNode(ExprNode expr) {
		this.expr = expr;
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		this.expr.genCode(mg);
		
		Type myType = this.getType();
		if(myType.getSort() == Type.DOUBLE || myType.getSort() == Type.LONG)
			mg.visitInsn(Opcodes.DUP2);
		else
			mg.visitInsn(Opcodes.DUP);
	}
}
