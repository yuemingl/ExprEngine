package io.lambdacloud.node.arithmetric;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.UnaryOp;
import io.lambdacloud.node.VariableNode;

public class IncNode extends UnaryOp {

	public IncNode(VariableNode var) {
		this.expr = var;
	}

	public String toString() {
		return expr + "++";
	}

	@Override
	public void genCode(MethodGenHelper mg) {
		VariableNode var = (VariableNode) expr;

		Type myType = this.getType();
		if (myType.getSort() == Type.LONG) {
			expr.genCode(mg);
			mg.visitInsn(Opcodes.DUP2);
			mg.visitInsn(Opcodes.LCONST_1);
			mg.visitInsn(Opcodes.LADD);
			mg.visitVarInsn(Opcodes.LSTORE, var.idxLVT);
		} else {
			mg.visitIincInsn(var.idxLVT, 1);
		}
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.idxLVT);
		}
	}

	public int test(int a) {
		int c = a++;
		return c;
	}

	public long test(long a) {
		long c = a++;
		return c;
	}
}