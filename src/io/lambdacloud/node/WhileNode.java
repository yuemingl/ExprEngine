package io.lambdacloud.node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.arithmetric.AddAsignNode;
import io.lambdacloud.node.arithmetric.DivAsignNode;
import io.lambdacloud.node.arithmetric.MulAsignNode;
import io.lambdacloud.node.arithmetric.SubAsignNode;

public class WhileNode extends ExprNode {
	public ExprNode condition;
	public List<ExprNode> block = new ArrayList<ExprNode>();

	@Override
	public void genCode(MethodGenHelper mg) {
		Label labelCondition = new Label();
		mg.visitJumpInsn(Opcodes.GOTO, labelCondition);
		
		Label labelBlock = new Label();
		mg.visitLabel(labelBlock);
		for(int i=block.size()-1; i>=0; i--) {
			ExprNode node = block.get(i);
			if(node instanceof AssignNode || 
					node instanceof FuncCallNode ||
					node instanceof AddAsignNode ||
					node instanceof SubAsignNode ||
					node instanceof MulAsignNode ||
					node instanceof DivAsignNode ||
					node instanceof IfNode ||
					node instanceof WhileNode ||
					node instanceof FuncDefNode ||
					node instanceof ForNode
				) {
					if(node instanceof FuncCallNode)
						((FuncCallNode)node).isPopReturn = true;
					else
						node.genLoadInsn(false);
					node.genCode(mg);
				} else {
					System.out.println("Code generation for '"+node.toString()+"' is ignored.");
				}
		}
		
		mg.visitLabel(labelCondition);
		condition.genCode(mg);
		mg.visitJumpInsn(Opcodes.IFNE, labelBlock);
	}
	public static int testWhile(int x, int y) {
		while(x<y) {
			x += 1;
		}
		return x;
	}
	public static void main(String[] args) {
		System.out.println(testWhile(1,4));
	}
	/*
Label l1 = new Label();
mv.visitJumpInsn(GOTO, l1);
Label l2 = new Label();
mv.visitLabel(l2);
mv.visitLineNumber(55, l2);
mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
mv.visitVarInsn(ILOAD, 1);
mv.visitVarInsn(ILOAD, 2);
mv.visitInsn(IADD);
mv.visitVarInsn(ISTORE, 1);
mv.visitLabel(l1);
mv.visitLineNumber(54, l1);
mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
mv.visitVarInsn(ILOAD, 1);
mv.visitVarInsn(ILOAD, 2);
mv.visitJumpInsn(IF_ICMPLT, l2);
	 */
	
	@Override
	public String toString() {
		return "while("+this.condition+") {"+this.block+"}";
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.VOID_TYPE;
//		//circle check
//		if(stack.contains(this)) return null;
//		stack.push(this);
//
//		for(int i=0; i<this.block.size(); i++) {
//			ExprNode node = this.block.get(i);
//			Type retType = node.getType(stack);
//			if(null != retType) {
//				stack.pop();
//				return retType;
//			}
//		}
//		throw new RuntimeException("Cannot infer return type!");
	}
	@Override
	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		for(int i=block.size()-1; i>=0; i--) {
			block.get(i).updateType(stack);
		}
		condition.updateType(stack);
		stack.pop();
	}
}

