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

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

/**
 * a[0]
 * a[1:5]
 * 
 * a[0][1]
 * a[1:3][5:8]
 *
 */
public class ArrayAccessNode extends ExprNode {
	
	public VariableNode var;
	public ExprNode idxS;
	public ExprNode idxE;
	public ArrayList<IndexPair> indices = new ArrayList<IndexPair>();
	public VariableNode retVar;
	
	public static class IndexPair {
		public ExprNode idxS;
		public ExprNode idxE;
		public IndexPair(ExprNode idxS, ExprNode idxE) {
			this.idxE = idxE;
			this.idxS = idxS;
		}
	}
	
	public ArrayAccessNode(VariableNode var) {
		this.var = var;
	}
	
	public ArrayAccessNode(VariableNode var, ExprNode idxS, ExprNode idxE, 
			VariableNode retVar) {
		this.var = var;
		this.idxS = idxS;
		this.idxE = idxE;
		this.retVar = retVar;
		this.type = Type.INT_TYPE;
	}
	
	public void addIndex(ExprNode idxS, ExprNode idxE) {
		indices.add(new IndexPair(idxS, idxE));
	}
	
	public String toString() {
		if(null == idxE)
			return var+"["+idxS+"]";
		return var+"["+idxS+":"+idxE+"]";
	}
	
	@Override
	public Type getType() {
		Type retType = null;
		for(int i=0; i<this.indices.size(); i++) {
			if(null == idxE) {
				if(var.getType().getDescriptor().equals(Type.getType(List.class).getDescriptor()))
					return Type.getType(Object.class);//TODO
				else {
					if(null == retType)
						retType = Tools.getElementType(var.getType());
					else
						retType = Tools.getElementType(retType);
				}
			} else {
				if(null == retType)
					retType = var.getType();
			}
		}
		return retType;
	}
	
	public void genCode(MethodGenHelper mg) {
		
//		if(aic.arithmetic_expr().size() > 1) {
//		String retName = varName+"_ret_"+i;
//		retVal = VariableNode.newLocalVar(retName, Type.getType(int[].class));
//		this.varMap.put(retName, retVal);
//	}

		var.genCode(mg);
		for(int i=this.indices.size()-1; i>=0; i--) {
			IndexPair p = this.indices.get(i);
			
			ExprNode idxS = p.idxS;
			ExprNode idxE = p.idxE;
			
			if(null == idxE) {
				idxS.genCode(mg);
				if(var.getType().getDescriptor().equals(Type.getType(List.class).getDescriptor())) {
					mg.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;", true);
				} else if(var.getType().getSort() == Type.ARRAY) {
					if(i == 0)
						mg.visitInsn(getType().getOpcode(IALOAD));
					else
						mg.visitInsn(Opcodes.AALOAD);
						
				} else {
					throw new RuntimeException(var+" has wrong type.");
				}
			} else {
				if(var.getType().getDescriptor().equals(Type.getType(List.class).getDescriptor())) {
					idxS.genCode(mg);
					idxE.genCode(mg);
					mg.visitInsn(ICONST_1);
					mg.visitInsn(IADD);
					mg.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "subList", "(II)Ljava/util/List;", true);
				} else if(var.getType().getSort() == Type.ARRAY) {
					SubNode sub = new SubNode(idxE, idxS);
					sub.genCode(mg);
					mg.visitInsn(ICONST_1);
					mg.visitInsn(IADD);
					mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(var.getType(), true));
					mg.visitIntInsn(ASTORE, retVar.idxLVT);
					mg.visitVarInsn(ALOAD, var.idxLVT);
					idxS.genCode(mg);
					mg.visitVarInsn(ALOAD, retVar.idxLVT);
					mg.visitInsn(ICONST_0);
					mg.visitVarInsn(ALOAD, retVar.idxLVT);
					mg.visitInsn(ARRAYLENGTH);
					mg.visitMethodInsn(INVOKESTATIC, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
					mg.visitVarInsn(ALOAD, retVar.idxLVT);
					//mv.visitInsn(ARETURN);
				} else {
					throw new RuntimeException(var+" has wrong type.");
				}
			}
		}
	
		
//		var.genCode(mg);
//		if(null == idxE) {
//			idxS.genCode(mg);
//			if(var.getType().getDescriptor().equals(Type.getType(List.class).getDescriptor())) {
//				mg.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;", true);
//			} else if(var.getType().getSort() == Type.ARRAY) {
//				mg.visitInsn(getType().getOpcode(IALOAD));
//			} else {
//				throw new RuntimeException(var+" has wrong type.");
//			}
//		} else {
//			if(var.getType().getDescriptor().equals(Type.getType(List.class).getDescriptor())) {
//				idxS.genCode(mg);
//				idxE.genCode(mg);
//				mg.visitInsn(ICONST_1);
//				mg.visitInsn(IADD);
//				mg.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "subList", "(II)Ljava/util/List;", true);
//			} else if(var.getType().getSort() == Type.ARRAY) {
//				SubNode sub = new SubNode(idxE, idxS);
//				sub.genCode(mg);
//				mg.visitInsn(ICONST_1);
//				mg.visitInsn(IADD);
//				mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(var.getType(), true));
//				mg.visitIntInsn(ASTORE, retVar.idxLVT);
//				mg.visitVarInsn(ALOAD, var.idxLVT);
//				idxS.genCode(mg);
//				mg.visitVarInsn(ALOAD, retVar.idxLVT);
//				mg.visitInsn(ICONST_0);
//				mg.visitVarInsn(ALOAD, retVar.idxLVT);
//				mg.visitInsn(ARRAYLENGTH);
//				mg.visitMethodInsn(INVOKESTATIC, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
//				mg.visitVarInsn(ALOAD, retVar.idxLVT);
//				//mv.visitInsn(ARETURN);
//			} else {
//				throw new RuntimeException(var+" has wrong type.");
//			}
//		}
	}
	
	public int test(int[] a) {
		return a[2];
	}
	public int[] test2(int[] a) {
		int[] ret = new int[3];
		System.arraycopy(a, 1, ret, 0, ret.length);
		return ret;
	}
	
	public static Object test3(List<Integer> a) {
		a.subList(10, 20);
		return a.get(1);
	}
	public static void main(String[] args) {
		System.out.println(Type.getType(double[].class).getElementType());
	}
	
}
