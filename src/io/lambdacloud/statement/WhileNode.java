package io.lambdacloud.statement;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class WhileNode extends ExprNode {
	public ExprNode condition;
	public List<ExprNode> block = new ArrayList<ExprNode>();

	@Override
	public void genCode(MethodVisitor mv) {
		Label labelCondition = new Label();
		mv.visitJumpInsn(Opcodes.GOTO, labelCondition);
		
		Label labelBlock = new Label();
		mv.visitLabel(labelBlock);
		for(int i=block.size()-1; i>=0; i--) {
			block.get(i).genCode(mv);
		}
		
		mv.visitLabel(labelCondition);
		condition.genCode(mv);
		mv.visitJumpInsn(Opcodes.IFNE, labelBlock);
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
	public Type getType() {
		return block.get(0).getType();
	}
	
	@Override
	public String toString() {
		return "while("+this.condition+") {"+this.block+"}";
	}
}

