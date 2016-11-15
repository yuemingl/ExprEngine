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
import io.lambdacloud.node.tool.ArrayAccess;

public class ForNode extends ExprNode {
	public List<ExprNode>  init = new ArrayList<ExprNode>();
	public ExprNode cond = null;
	public List<ExprNode>  inc = new ArrayList<ExprNode>();
	public List<ExprNode> block = new ArrayList<ExprNode>();

	@Override
	public void _genCode(MethodGenHelper mg) {
		for(int i=init.size()-1; i>=0; i--) {
			init.get(i).genCode(mg);
		}
		
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
				node instanceof MatrixAssignNode ||
				node instanceof ArrayAccess ||
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
		
		for(int i=inc.size()-1; i>=0; i--) {
			inc.get(i).genCode(mg);
		}
		mg.visitLabel(labelCondition);
		cond.genCode(mg);
		mg.visitJumpInsn(Opcodes.IFNE, labelBlock);
	}
	
	public static int testWhile(int x) {
		for(int i=0; i<10; i++) {
			x += i;
		}
		return x;
	}
	
	public static void main(String[] args) {
		System.out.println(testWhile(1));
	}
	/*
Label l0 = new Label();
mv.visitLabel(l0);
mv.visitLineNumber(33, l0);
mv.visitInsn(ICONST_0);
mv.visitVarInsn(ISTORE, 1);
Label l1 = new Label();
mv.visitLabel(l1);
Label l2 = new Label();
mv.visitJumpInsn(GOTO, l2);
Label l3 = new Label();
mv.visitLabel(l3);
mv.visitLineNumber(34, l3);
mv.visitFrame(Opcodes.F_APPEND,1, new Object[] {Opcodes.INTEGER}, 0, null);
mv.visitVarInsn(ILOAD, 0);
mv.visitVarInsn(ILOAD, 1);
mv.visitInsn(IADD);
mv.visitVarInsn(ISTORE, 0);
Label l4 = new Label();
mv.visitLabel(l4);
mv.visitLineNumber(33, l4);
mv.visitIincInsn(1, 1);
mv.visitLabel(l2);
mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
mv.visitVarInsn(ILOAD, 1);
mv.visitIntInsn(BIPUSH, 10);
mv.visitJumpInsn(IF_ICMPLT, l3);
Label l5 = new Label();
mv.visitLabel(l5);
mv.visitLineNumber(36, l5);
mv.visitVarInsn(ILOAD, 0);
mv.visitInsn(IRETURN);
	 */
	
	@Override
	public String toString() {
		return "for("+this.init+";"+this.cond+";"+this.inc+") {"+this.block+"}";
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

		for(int i=init.size()-1; i>=0; i--) {
			init.get(i).updateType(stack);
		}
		
		for(int i=block.size()-1; i>=0; i--) {
			block.get(i).updateType(stack);
		}
		
		for(int i=inc.size()-1; i>=0; i--) {
			inc.get(i).updateType(stack);
		}
		cond.updateType(stack);
		
		stack.pop();
	}

	@Override
	public boolean contains(ExprNode target) {
		if(this == target)
			return true;
		for(ExprNode e : this.init) {
			if(e.contains(target))
				return true;
		}
		if(this.cond.contains(target))
			return true;
		
		for(ExprNode e : this.inc) {
			if(e.contains(target))
				return true;
		}
		
		for(ExprNode e : this.block) {
			if(e.contains(target))
				return true;
		}
		return false;
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		for(int i=0; i<this.init.size(); i++) {
			if(this.init.get(i) == oldNode)
				this.init.set(i, newNode);
		}
		for(int i=0; i<this.inc.size(); i++) {
			if(this.inc.get(i) == oldNode)
				this.inc.set(i, newNode);
		}
		for(int i=0; i<this.block.size(); i++) {
			if(this.block.get(i) == oldNode)
				this.block.set(i, newNode);
		}
		this.cond.replaceChild(oldNode, newNode);
		if(this.cond == oldNode)
			this.cond = newNode;
	}

	@Override
	public void updateTree(MethodGenHelper mg) {
		for(ExprNode e : this.init) {
			e.updateTree(mg);
		}
		this.cond.updateTree(mg);
		
		for(ExprNode e : this.inc) {
			e.updateTree(mg);
		}
		for(ExprNode e : this.block) {
			e.updateTree(mg);
		}
	}

	@Override
	public void updateParam(String name, Object value) {
		for(ExprNode e : this.init) {
			e.updateParam(name, value);
		}
		this.cond.updateParam(name, value);
		
		for(ExprNode e : this.inc) {
			e.updateParam(name, value);
		}
		for(ExprNode e : this.block) {
			e.updateParam(name, value);
		}
	}
}


