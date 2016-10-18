package io.lambdacloud.node.matrix;

import static org.objectweb.asm.Opcodes.DUP;

import java.util.Deque;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.util.Struct;

/**
 * 
 * @author yueming.liu
 *
 */
public class StructInitNode extends ExprNode {
	
	@Override
	public void genCode(MethodGenHelper mg) {
			mg.visitTypeInsn(Opcodes.NEW, Tools.getClassNameForASM(Struct.class));
			mg.visitInsn(DUP);
			mg.visitMethodInsn(Opcodes.INVOKESPECIAL, Tools.getClassNameForASM(Struct.class), "<init>", "()V", false);
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.getType(Struct.class);
	}
	
	@Override
	public void updateType(Deque<Object> stack) {
	}
}
