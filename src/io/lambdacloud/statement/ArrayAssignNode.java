package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.IASTORE;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class ArrayAssignNode extends ExprNode {
	public VariableNode var;
	public ExprNode idxS;
	public ExprNode idxE;
	public VariableNode retAry;
	public ExprNode val;
	
	public ArrayAssignNode(VariableNode var, ExprNode idxS, ExprNode idxE, VariableNode retAry, ExprNode val) {
		this.var = var;
		this.idxS = idxS;
		this.idxE = idxE;
		this.retAry = retAry;
		this.type = Type.INT_TYPE;
		this.val = val;
	}
	
	public String toString() {
		if(null == idxE)
			return var+"["+idxS+"]="+val;
		return var+"["+idxS+":"+idxE+"]="+val;
	}
	
	@Override
	public Type getType() {
		if(null == idxE)
			return Tools.getElementType(var.getType());
		else
			return var.getType();
	}
	
	public void genCode(MethodVisitor mv) {
		var.genCode(mv); //ALOAD
		if(null == idxE) {
			idxS.genCode(mv);
			val.genCode(mv);
			mv.visitInsn(getType().getOpcode(IASTORE));
		} else {
			//TODO a[1:3]=3
			//TODO a[1:3]=[1,2,3]
//			SubNode sub = new SubNode(idxE, idxS);
//			sub.genCode(mv);
//			mv.visitInsn(ICONST_1);
//			mv.visitInsn(IADD);
//			mv.visitIntInsn(NEWARRAY, getTypeForNEWARRAY(var.getType()));
//			mv.visitIntInsn(ASTORE, retAry.idxLVT);
//			mv.visitVarInsn(ALOAD, var.idxLVT);
//			idxS.genCode(mv);
//			mv.visitVarInsn(ALOAD, retAry.idxLVT);
//			mv.visitInsn(ICONST_0);
//			mv.visitVarInsn(ALOAD, retAry.idxLVT);
//			mv.visitInsn(ARRAYLENGTH);
//			mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
//			mv.visitVarInsn(ALOAD, retAry.idxLVT);
		}
	}
	
	public int test(int[] a) {
		a[2]=10;
		return a[2];
	}
	public int[] test2(int[] a) {
		int[] ret = new int[3];
		System.arraycopy(a, 1, ret, 0, ret.length);
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(Tools.getElementType(Type.getType(double[].class)));
	}
	
}
