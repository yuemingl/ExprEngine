package io.lambdacloud.statement;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class ForNode extends ExprNode {
	public List<ExprNode>  init = new ArrayList<ExprNode>();
	public ExprNode cond;
	public List<ExprNode>  inc = new ArrayList<ExprNode>();
	public List<ExprNode> block = new ArrayList<ExprNode>();

	@Override
	public void genCode(MethodVisitor mv) {
		for(int i=init.size()-1; i>=0; i--) {
			init.get(i).genCode(mv);
		}
		
		Label labelCondition = new Label();
		mv.visitJumpInsn(Opcodes.GOTO, labelCondition);
		
		Label labelBlock = new Label();
		mv.visitLabel(labelBlock);
		for(int i=block.size()-1; i>=0; i--) {
			block.get(i).genCode(mv);
		}
		
		for(int i=inc.size()-1; i>=0; i--) {
			inc.get(i).genCode(mv);
		}
		mv.visitLabel(labelCondition);
		cond.genCode(mv);
		mv.visitJumpInsn(Opcodes.IFNE, labelBlock);
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
	public Type getType() {
		return block.get(0).getType();
	}
	
	@Override
	public String toString() {
		return "for("+this.init+";"+this.cond+";"+this.inc+") {"+this.block+"}";
	}
}


