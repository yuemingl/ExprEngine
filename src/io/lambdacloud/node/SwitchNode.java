package io.lambdacloud.node;

import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.string.StringNode;

public class SwitchNode extends ExprNode {
	public ExprNode switchExpr;
	public ArrayList<ExprNode> caseExprs = new ArrayList<ExprNode>();
	public ArrayList<StatementNode> caseBlock = new ArrayList<StatementNode>();
	public StatementNode defaultBlock;
	

	@Override
	public void genCode(MethodGenHelper mg) {
		
		VariableNode svar = mg.newLocalVariable("switch_value", this.switchExpr.getType());
		Type svarType = svar.getType();
		AssignNode assign = new AssignNode(svar, this.switchExpr);
		
		Deque<Object> stack = new LinkedList<Object>();
		assign.updateType(stack);
		assign.genCode(mg);
		
		Label defaultLabel = new Label();
		Label[] caseLabels = new Label[this.caseExprs.size()];
		Label[] caseLabels2 = new Label[this.caseExprs.size()];
		Label endLabel = new Label();
		final int[] caseKeys = new int[caseLabels.length];
		Integer[] caseKeysIndex = new Integer[caseKeys.length];
		int idx = 0;
		for(int i=caseLabels.length-1; i>=0; i--) {
			ExprNode expr = this.caseExprs.get(i);
			if(expr instanceof ConstantNode) {
				ConstantNode c = (ConstantNode)expr;
				caseKeys[idx] = c.getInt();
			} else if(expr instanceof StringNode) {
				StringNode s = (StringNode)expr;
				caseKeys[idx] = s.strVal.hashCode();
			} else {
				throw new RuntimeException();
			}
			caseLabels[idx] = new Label();
			caseLabels2[idx] = new Label();
			caseKeysIndex[idx] = idx;
			idx++;
		}
		
		Arrays.sort(caseKeysIndex, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return caseKeys[o1] - caseKeys[o2];
			}
		});
		Arrays.sort(caseKeys);
		svar.genCode(mg);
		if(svarType.equals(Type.getType(String.class)))
			mg.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "hashCode", "()I", false);
		mg.visitLookupSwitchInsn(defaultLabel, caseKeys, caseLabels);

		//case
		idx = 0;
		for(int i=caseLabels.length-1; i>=0; i--) {
			mg.visitLabel(caseLabels[caseKeysIndex[idx]]);
			
			if(svarType.equals(Type.getType(String.class))) {
				svar.genCode(mg);
				this.caseExprs.get(i).genCode(mg);
				mg.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
				mg.visitJumpInsn(IFNE, caseLabels2[idx]);
				mg.visitJumpInsn(GOTO, defaultLabel);
			} else {
				this.caseBlock.get(i).genCode(mg);
				mg.visitJumpInsn(GOTO, endLabel);
			}
			idx++;
		}

		if(svarType.equals(Type.getType(String.class))) {
			idx = 0;
			for(int i=caseLabels.length-1; i>=0; i--) {
				mg.visitLabel(caseLabels2[idx]);
				this.caseBlock.get(i).genCode(mg);
				mg.visitJumpInsn(GOTO, endLabel);
				idx++;
			}
		}
		
		//default
		mg.visitLabel(defaultLabel);
		if(this.defaultBlock != null)
			this.defaultBlock.genCode(mg);
		
		mg.visitLabel(endLabel);
		
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.VOID_TYPE;
	}

	@Override
	public void updateType(Deque<Object> stack) {
		this.switchExpr.updateType(stack);
		for(int i=0; i<this.caseExprs.size(); i++) {
			this.caseExprs.get(i).updateType(stack);
		}
		for(int i=0; i<this.caseBlock.size(); i++) {
			this.caseBlock.get(i).updateType(stack);
		}
		if(null != this.defaultBlock)
			this.defaultBlock.updateType(stack);
		
	}

}
