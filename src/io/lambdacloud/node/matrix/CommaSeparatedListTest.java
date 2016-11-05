package io.lambdacloud.node.matrix;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.BytecodeSupport;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.RangeNode;
import io.lambdacloud.node.VariableNode;
import io.lambdacloud.node.arithmetric.IncNode;
import io.lambdacloud.node.comparion.LENode;
import io.lambdacloud.node.tool.IndexPair;

public class CommaSeparatedListTest extends ExprNode {
	public List<ExprNode> init = new ArrayList<ExprNode>();
	public ExprNode cond = null;
	public List<ExprNode> inc = new ArrayList<ExprNode>();
	public List<ExprNode> block = new ArrayList<ExprNode>();
	public ArrayList<IndexPair> indices = new ArrayList<IndexPair>();
	public ExprNode var;

	public CommaSeparatedListTest(ExprNode var) {
		this.var = var;
	}

	public void addIndex(ExprNode idxS, ExprNode idxE) {
		indices.add(new IndexPair(idxS, idxE));
	}

	@Override
	public void _genCode(MethodGenHelper mg) {
		IndexPair ip = indices.get(0);
		RangeNode r = (RangeNode) ip.idxS;

		VariableNode i = mg.newLocalVariable("i", Type.INT_TYPE);
		mg.updateLVTIndex();

		r.start.genCode(mg);
		mg.visitVarInsn(i.getType().getOpcode(Opcodes.ISTORE), i.getLVTIndex());

		Label labelCondition = new Label();
		mg.visitJumpInsn(Opcodes.GOTO, labelCondition);

		Label labelBlock = new Label();
		mg.visitLabel(labelBlock);

		// mg.visitFrame(Opcodes.F_APPEND,1, new Object[] {Opcodes.INTEGER}, 0,
		// null);
		// var.genCode(mg);
		i.genCode(mg);
		// if(MatrixAccessNode.INDEX_BASE == 1) {
		// mg.visitInsn(Opcodes.ICONST_1);
		// mg.visitInsn(Opcodes.ISUB);
		// }
		// mg.visitMethodInsn(INVOKEVIRTUAL,
		// Tools.getClassNameForASM(ObjectArray.class),
		// "get", "(I)"+Type.getType(Object.class), false);
		// mg.visitMethodInsn(Opcodes.H_INVOKESTATIC,
		// BytecodeSupport.getMyName(),
		// "println2", "("+Type.getType(Object.class)+")V", false);
		mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "println", "(I)I", false);

		// It doesn't work if we don't pop
		mg.visitInsn(Opcodes.POP);

		// i++
		new IncNode(i).genCode(mg);
		mg.visitLabel(labelCondition);

		// i<idxE
		new LENode(i, r.end).genCode(mg);
		mg.visitJumpInsn(Opcodes.IFNE, labelBlock);

	}

	@Override
	public Type getType(Deque<Object> stack) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateType(Deque<Object> stack) {
		// TODO Auto-generated method stub

	}

	public static void test() {
		for (int i = 0; i < 100; i++) {
			BytecodeSupport.println(i);
		}
	}

	@Override
	public boolean contains(ExprNode target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		// TODO Auto-generated method stub

	}

}
