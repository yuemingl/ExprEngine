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
import io.lambdacloud.node.matrix.MatrixAssignNode;

public class IfNode extends ExprNode {
	public ExprNode condition;
	public List<ExprNode> ifBlockExprs = new ArrayList<ExprNode>();
	public List<ExprNode> elseBlockExprs = new ArrayList<ExprNode>();

	@Override
	public void genCode(MethodGenHelper mg) {
		this.condition.genCode(mg);
		//if(...){...} else{...}
		if(this.elseBlockExprs.size() > 0) {
			Label elseBranch = new Label();
			mg.visitJumpInsn(Opcodes.IFEQ, elseBranch);
			for(int i=ifBlockExprs.size()-1; i>=0; i--) {
				ExprNode node = ifBlockExprs.get(i);
				
				if(i>0 && (node instanceof AssignNode || 
						node instanceof FuncCallNode ||
						node instanceof AddAsignNode ||
						node instanceof SubAsignNode ||
						node instanceof MulAsignNode ||
						node instanceof DivAsignNode ||
						node instanceof IfNode ||
						node instanceof WhileNode ||
						node instanceof FuncDefNode ||
						node instanceof MatrixAssignNode ||
						node instanceof ForNode
					)) {
					if(node instanceof FuncCallNode)
						((FuncCallNode)node).isPopReturn = true;
					else
						node.genLoadInsn(false);
					node.genCode(mg);
				} else if(i==0) {
					node.genCode(mg);//Leave the last expression on the stack
				} else {
					System.out.println("Code generation for '"+node.toString()+"' is ignored.");
				}
			}
			Label ifend = new Label();
			mg.visitJumpInsn(Opcodes.GOTO, ifend);
			mg.visitLabel(elseBranch);
			for(int i=elseBlockExprs.size()-1; i>=0; i--) {
				ExprNode node = elseBlockExprs.get(i);
				if(i>0 && (node instanceof AssignNode || 
						node instanceof FuncCallNode ||
						node instanceof AddAsignNode ||
						node instanceof SubAsignNode ||
						node instanceof MulAsignNode ||
						node instanceof DivAsignNode ||
						node instanceof IfNode ||
						node instanceof WhileNode ||
						node instanceof FuncDefNode ||
						node instanceof MatrixAssignNode ||
						node instanceof ForNode
						)) {
					if(node instanceof FuncCallNode)
						((FuncCallNode)node).isPopReturn = true;
					else
						node.genLoadInsn(false);
					node.genCode(mg);
				} else if(i==0) {
					node.genCode(mg);//Leave the last expression on the stack
				} else {
					System.out.println("Code generation for '"+node.toString()+"' is ignored.");
				}
			}
			mg.visitLabel(ifend);
		} else {
			//if(...){...}
			Label ifend = new Label();
			mg.visitJumpInsn(Opcodes.IFEQ, ifend);
			for(int i=ifBlockExprs.size()-1; i>=0; i--) {
				ExprNode node = ifBlockExprs.get(i);
				//Clear stack in this case
				if(node instanceof AssignNode || 
						node instanceof FuncCallNode ||
						node instanceof AddAsignNode ||
						node instanceof SubAsignNode ||
						node instanceof MulAsignNode ||
						node instanceof DivAsignNode ||
						node instanceof IfNode ||
						node instanceof WhileNode ||
						node instanceof FuncDefNode ||
						node instanceof MatrixAssignNode ||
						node instanceof ForNode
						) {
					if(node instanceof FuncCallNode)
						((FuncCallNode)node).isPopReturn = true;
					else
						node.genLoadInsn(false);
					node.genCode(mg);
				} else if(i==0) {
					node.genCode(mg);
				} else {
					System.out.println("Code generation for '"+node.toString()+"' is ignored.");
				}
			}
			mg.visitLabel(ifend);
		}
		
	}
	public int testIf(int a, int b) {
		int ret = 0;
		if(a+b>0) {
			ret = a+1;
		} else {
			ret = b-1;
		}
		return ret+1;
	}
	/*
Label l1 = new Label();
mv.visitLabel(l1);
mv.visitLineNumber(20, l1);
mv.visitVarInsn(ILOAD, 1);
mv.visitVarInsn(ILOAD, 2);
mv.visitInsn(IADD);
Label l2 = new Label();
mv.visitJumpInsn(IFLE, l2);
Label l3 = new Label();
mv.visitLabel(l3);
mv.visitLineNumber(21, l3);
mv.visitVarInsn(ILOAD, 1);
mv.visitInsn(ICONST_1);
mv.visitInsn(IADD);
mv.visitVarInsn(ISTORE, 3);
Label l4 = new Label();
mv.visitLabel(l4);
mv.visitLineNumber(22, l4);
Label l5 = new Label();
mv.visitJumpInsn(GOTO, l5);
mv.visitLabel(l2);
mv.visitLineNumber(23, l2);
mv.visitFrame(Opcodes.F_APPEND,1, new Object[] {Opcodes.INTEGER}, 0, null);
mv.visitVarInsn(ILOAD, 2);
mv.visitInsn(ICONST_1);
mv.visitInsn(ISUB);
mv.visitVarInsn(ISTORE, 3);
mv.visitLabel(l5);
mv.visitLineNumber(25, l5);
mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
mv.visitVarInsn(ILOAD, 3);
mv.visitInsn(ICONST_1);
mv.visitInsn(IADD);
mv.visitInsn(IRETURN);
	 */
	
	@Override
	public String toString() {
		if(this.elseBlockExprs.size() == 0)
			return "if("+this.condition+") {"+this.ifBlockExprs+"}";
		else
			return "if("+this.condition+") {"+this.ifBlockExprs+"} else {"+this.elseBlockExprs+"}";
	}

	@Override
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return null;
		stack.push(this);
		
		for(int i=0; i<ifBlockExprs.size(); i++) {
			Type retType = ifBlockExprs.get(i).getType(stack);
			if(null != retType) {
				stack.pop();
				return retType;
			}
		}
		for(int i=0; i<elseBlockExprs.size(); i++) {
			Type retType = elseBlockExprs.get(i).getType(stack);
			if(null != retType) {
				stack.pop();
				return retType;
			}
		}
		throw new RuntimeException("Cannot infer type for if statement: "+this.toString());
	}
	@Override
	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		this.condition.updateType(stack);
		for(ExprNode e : this.ifBlockExprs) {
			e.updateType(stack);
		}
		if(null != this.elseBlockExprs) {
			for(ExprNode e : this.elseBlockExprs) {
				e.updateType(stack);
			}
		}
		stack.pop();
	}
}
