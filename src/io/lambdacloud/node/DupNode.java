package io.lambdacloud.node;


import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

/**
 * Generate DUP base on type
 * 
 * @author yueming.liu
 *
 */
public class DupNode extends UnaryOp {
	public DupNode(ExprNode expr) {
		super(expr);
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
