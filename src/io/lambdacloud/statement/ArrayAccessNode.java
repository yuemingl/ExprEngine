package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARRAYLENGTH;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.IADD;
import static org.objectweb.asm.Opcodes.IALOAD;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.NEWARRAY;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

/**
 * a[0]
 * a[1:5]
 *
 */
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
	
	@Override
	public Type getType() {
		if(null == idxE)
			return var.getType().getElementType();
		else
			return var.getType();
	}
	
	public void genCode(MethodGenHelper mg) {
		var.genCode(mg);
		if(null == idxE) {
			idxS.genCode(mg);
			mg.visitInsn(getType().getOpcode(IALOAD));
		} else {
			SubNode sub = new SubNode(idxE, idxS);
			sub.genCode(mg);
			mg.visitInsn(ICONST_1);
			mg.visitInsn(IADD);
			mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(var.getType(), true));
			mg.visitIntInsn(ASTORE, retAry.idxLVT);
			mg.visitVarInsn(ALOAD, var.idxLVT);
			idxS.genCode(mg);
			mg.visitVarInsn(ALOAD, retAry.idxLVT);
			mg.visitInsn(ICONST_0);
			mg.visitVarInsn(ALOAD, retAry.idxLVT);
			mg.visitInsn(ARRAYLENGTH);
			mg.visitMethodInsn(INVOKESTATIC, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
			mg.visitVarInsn(ALOAD, retAry.idxLVT);
			//mv.visitInsn(ARETURN);
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
		System.out.println(Type.getType(double[].class).getElementType());
	}
	
}
