package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ANEWARRAY;
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
	public ArrayList<IndexPair> indices = new ArrayList<IndexPair>();
	
	public static class IndexPair {
		public ExprNode idxS;
		public ExprNode idxE;
		public IndexPair(ExprNode idxS, ExprNode idxE) {
			this.idxE = idxE;
			this.idxS = idxS;
		}
		public String toString() {
			return idxS+":"+idxE;
		}
	}
	
	public ArrayAccessNode(VariableNode var) {
		this.var = var;
	}
	
	public void addIndex(ExprNode idxS, ExprNode idxE) {
		indices.add(new IndexPair(idxS, idxE));
	}
	
	public String toString() {
		return var+"["+this.indices+"]";
	}
	
	@Override
	public Type getType() {
		return getType(this.indices.size());
	}
	
	/**
	 * 1,2,3...
	 * @param dim
	 * @return
	 */
	public Type getType(int dim) {
		Type ret = var.getType();
		for(int i=0; i<dim; i++) {
			IndexPair p = this.indices.get(this.indices.size()-1-i);
			if(null == p.idxE) {
				if(var.getType().getDescriptor().equals(Type.getType(List.class).getDescriptor()))
					return Type.getType(Object.class);//TODO
				else {
					if(null == ret)
						ret = Tools.getElementType(var.getType());
					else
						ret = Tools.getElementType(ret);
				}
			} else {
				if(null == ret)
					ret = var.getType();
			}
		}
		return ret;
	}
	
	public void genCode(MethodGenHelper mg) {
		var.genCode(mg);
		boolean isRange = true;
		VariableNode tmpVar = var;
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
						mg.visitInsn(getType(this.indices.size()-i).getOpcode(IALOAD));
					else
						mg.visitInsn(Opcodes.AALOAD);
						
				} else {
					throw new RuntimeException(var+" has wrong type.");
				}
				isRange = false;
			} else {
				if(var.getType().getDescriptor().equals(Type.getType(List.class).getDescriptor())) {
					idxS.genCode(mg);
					idxE.genCode(mg);
					mg.visitInsn(ICONST_1);
					mg.visitInsn(IADD);
					mg.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "subList", "(II)Ljava/util/List;", true);
				} else if(var.getType().getSort() == Type.ARRAY) {
					VariableNode retVar = mg.newLocalVariable(var.name+"_ret_"+i, getType(this.indices.size()-i));
					
					SubNode sub = new SubNode(idxE, idxS);
					sub.genCode(mg);
					mg.visitInsn(ICONST_1);
					mg.visitInsn(IADD);
					
					if(Tools.getElementType(retVar.getType()).getSort() == Type.OBJECT ||
							Tools.getElementType(retVar.getType()).getSort() == Type.ARRAY) {
						mg.visitTypeInsn(ANEWARRAY, Tools.getElementType(retVar.getType()).getDescriptor());
					} else {
						mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(retVar.getType(), true));
					}
					mg.visitIntInsn(ASTORE, retVar.idxLVT);
					
					//Shallow copy??
					//System.arraycopy(src, srcPos, dest, destPos, length);
					if(isRange) mg.visitVarInsn(ALOAD, tmpVar.idxLVT); //src
					idxS.genCode(mg);                                  //srcPos
					mg.visitVarInsn(ALOAD, retVar.idxLVT);             //dest
					mg.visitInsn(ICONST_0);                            //destPos
					mg.visitVarInsn(ALOAD, retVar.idxLVT);             //dest.length
					mg.visitInsn(ARRAYLENGTH);
					
					mg.visitMethodInsn(INVOKESTATIC, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
					
					//return retVar
					mg.visitVarInsn(ALOAD, retVar.idxLVT);
					
					tmpVar = retVar;
				} else {
					throw new RuntimeException(var+" has wrong type.");
				}
				isRange = true;
			}
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
	
	public static Object test3(List<Integer> a) {
		a.subList(10, 20);
		return a.get(1);
	}
	
	public static void test4(int[][] src) {
		int[][] dest = new int[10][];
		System.arraycopy(src, 1, dest, 0, dest.length);
	}
	
	public static void main(String[] args) {
		System.out.println(Type.getType(double[].class).getElementType());
	}
	
}
