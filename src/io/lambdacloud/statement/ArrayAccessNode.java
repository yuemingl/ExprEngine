package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class ArrayAccessNode extends ExprNode {
	public VariableNode var;
	public ExprNode idxS;
	public ExprNode idxE;
	public VariableNode retAry;
	
	public ArrayAccessNode(VariableNode var, ExprNode idxS, ExprNode idxE, VariableNode retAry) {
		this.var = var;
		this.idxS = idxS;
		this.idxE = idxE;
		this.retAry = retAry;
		this.type = Type.INT_TYPE;
	}
	
	public String toString() {
		if(null == idxE)
			return var+"["+idxS+"]";
		return var+"["+idxS+":"+idxE+"]";
	}
	
	public static Type getElementType(Type arrayType) {
		return Type.getType(arrayType.getDescriptor().substring(1));
	}

	public static int getTypeForNEWARRAY(Type arrayType) {
		Type et = getElementType(arrayType);
		switch(et.getSort()) {
		case Type.DOUBLE:
			return T_DOUBLE;
		case Type.INT:
			return T_INT;
		case Type.LONG:
			return T_LONG;
		case Type.SHORT:
			return T_SHORT;
		case Type.BYTE:
			return T_BYTE;
		case Type.FLOAT:
			return T_FLOAT;
		case Type.CHAR:
			return T_CHAR;
		case Type.BOOLEAN:
			return T_BOOLEAN;
		}
		throw new RuntimeException();
	}
	
	@Override
	public Type getType() {
		if(null == idxE)
			return getElementType(var.getType());
		else
			return var.getType();
	}
	
	public void genCode(MethodVisitor mv) {
		var.genCode(mv);
		if(null == idxE) {
			idxS.genCode(mv);
			mv.visitInsn(getType().getOpcode(IALOAD));
		} else {
			SubNode sub = new SubNode(idxE, idxS);
			sub.genCode(mv);
			mv.visitInsn(ICONST_1);
			mv.visitInsn(IADD);
			mv.visitIntInsn(NEWARRAY, getTypeForNEWARRAY(var.getType()));
			mv.visitIntInsn(ASTORE, retAry.idxLVT);
			mv.visitVarInsn(ALOAD, var.idxLVT);
			idxS.genCode(mv);
			mv.visitVarInsn(ALOAD, retAry.idxLVT);
			mv.visitInsn(ICONST_0);
			mv.visitVarInsn(ALOAD, retAry.idxLVT);
			mv.visitInsn(ARRAYLENGTH);
			mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
			mv.visitVarInsn(ALOAD, retAry.idxLVT);
			mv.visitInsn(ARETURN);
		}
	}
	
	public int test(int[] a) {
		return a[2];
	}
	public int[] test2(int[] a) {
		int[] ret = new int[3];
		System.arraycopy(a, 1, ret, 0, ret.length);
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(getElementType(Type.getType(double[].class)));
	}
	
}
