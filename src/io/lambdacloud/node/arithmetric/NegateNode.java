package io.lambdacloud.node.arithmetric;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.UnaryOp;

public class NegateNode extends UnaryOp {

	public NegateNode(ExprNode expr) {
		super(expr);
		expr.genLoadInsn(true);
	}

	public String toString() {
		return "-" + expr;
	}

	public void _genCode(MethodGenHelper mg) {
		Type myType = this.getType();
		if(null == myType)
			return;
		
		expr.genCode(mg);
		if((myType.getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor()))) {
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "uminus", "()LJama/Matrix;", false);
		} else {
			mg.visitInsn(getType().getOpcode(Opcodes.INEG));
		}
		
	}
}