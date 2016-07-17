package io.lambdacloud.statement;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

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
				ifBlockExprs.get(i).genCode(mg);
			}
			Label ifend = new Label();
			mg.visitJumpInsn(Opcodes.GOTO, ifend);
			mg.visitLabel(elseBranch);
			for(int i=elseBlockExprs.size()-1; i>=0; i--) {
				elseBlockExprs.get(i).genCode(mg);
			}
			mg.visitLabel(ifend);
		} else {
			//if(...){...}
			Label ifend = new Label();
			mg.visitJumpInsn(Opcodes.IFEQ, ifend);
			for(int i=ifBlockExprs.size()-1; i>=0; i--) {
				ifBlockExprs.get(i).genCode(mg);
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
	public Type getType() {
		return ifBlockExprs.get(0).getType();
	}
	
	@Override
	public String toString() {
		if(this.elseBlockExprs.size() == 0)
			return "if("+this.condition+") {"+this.ifBlockExprs+"}";
		else
			return "if("+this.condition+") {"+this.ifBlockExprs+"} else {"+this.elseBlockExprs+"}";
	}	
	
	public void fixType() {
		this.condition.fixType();
		for(ExprNode e : this.ifBlockExprs) {
			e.fixType();
		}
		if(null != this.elseBlockExprs) {
			for(ExprNode e : this.elseBlockExprs) {
				e.fixType();
			}
		}
	}
}
