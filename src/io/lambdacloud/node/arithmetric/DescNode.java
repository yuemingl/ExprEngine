package io.lambdacloud.node.arithmetric;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.UnaryOp;
import io.lambdacloud.node.VariableNode;

/**
 * Decrease node: i--
 * 
 * @author yueming.liu
 *
 */
public class DescNode extends UnaryOp {

	public DescNode(VariableNode var) {
		super(var);
	}

	public String toString() {
		return expr + "--";
	}

	@Override
	public void _genCode(MethodGenHelper mg) {
		VariableNode var = (VariableNode) expr;

		Type myType = this.getType();
		if(null == myType)
			return;

		if (myType.getSort() == Type.LONG) {
			var.genCode(mg);
			mg.visitInsn(Opcodes.DUP2);
			mg.visitInsn(Opcodes.LCONST_1);
			mg.visitInsn(Opcodes.LSUB);
			mg.visitVarInsn(Opcodes.LSTORE, var.getLVTIndex());
		} else
			mg.visitIincInsn(var.getLVTIndex(), -1);
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex());
		}
	}
}