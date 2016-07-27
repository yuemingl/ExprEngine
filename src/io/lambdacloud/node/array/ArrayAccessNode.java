package io.lambdacloud.node.array;

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
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.ListComprehensionNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.node.VariableNode;
import io.lambdacloud.node.arithmetric.SubNode;

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
			if(null == idxE)
				return idxS.toString();
			else
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
		StringBuilder sb = new StringBuilder();
		for(int i=this.indices.size()-1; i>=0; i--)
			sb.append("["+this.indices.get(i)+"]");
		return var+sb.toString();
	}
	
	@Override
	public Type getType() {
		return getType(this.indices.size());
	}
	
	@Override
	public Type getType(Deque<Object> stack) {
		return getType(stack, this.indices.size());
	}
	
	public Type getType(int dim) {
		Deque<Object> stack = new LinkedList<Object>();
		return getType(stack, dim);
	}
	
	/**
	 * 1,2,3...
	 * @param dim
	 * @return
	 */
	public Type getType(Deque<Object> stack, int dim) {
		//circle check
		if(stack.contains(this)) 
			return null;
		stack.push(this);
		
		Type ret = var.getType();
		ExprNode valNode = var.lastValue;
		for(int i=0; i<dim; i++) {
			int dimToIndex = this.indices.size()-1-i;
			IndexPair p = this.indices.get(dimToIndex);
			if(null == p.idxE) {
				
				if(valNode != null && valNode instanceof ListComprehensionNode) {
					ListComprehensionNode lstNode = (ListComprehensionNode)valNode;
					valNode = lstNode.getElementNode();
					ret = valNode.getType(stack);
					if(ret.getSort() != Type.ARRAY) {
						stack.pop();
						return Type.getType(Object.class); //don't return primitive type
					}
				} else if(ret.getDescriptor().equals(Type.getType(List.class).getDescriptor())) {
					stack.pop();
					return Type.getType(Object.class);
				} else if(ret.getSort() == Type.ARRAY){
					
					ret = Tools.getElementType(ret);
				} else {
					//Do nothing
					//throw new RuntimeException(ret.toString());
				}
			} else {
				//Do nothing
			}
		}
		stack.pop();
		return ret;
	}
	
	/**
    ALOAD 1
    ICONST_0
    INVOKEINTERFACE java/util/List.get (I)Ljava/lang/Object;
    CHECKCAST java/lang/Integer
    ARETURN
mv.visitVarInsn(ALOAD, 1);
mv.visitInsn(ICONST_0);
mv.visitMethodInsn(INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;", true);
mv.visitTypeInsn(CHECKCAST, "java/lang/Integer");
mv.visitInsn(ARETURN);
mv.visitLocalVariable("arg", "Ljava/util/List;", "Ljava/util/List<Ljava/lang/Integer;>;", l0, l1, 1);
	 * @param arg
	 * @return
	 */
	public Integer test(List<Integer> arg) {
		return arg.get(0);
	}
	public int[] test2(List<int[]> arg) {
		return arg.get(0);
	}
	
	public void genCode(MethodGenHelper mg) {
		
		var.genCode(mg);
		
		boolean isRange = true;
		ExprNode valNode = var.lastValue;
		Type aryType = var.getType();
		Type eleType = getType(1);
		VariableNode srcVar = var;
		for(int i=this.indices.size()-1; i>=0; i--) {
			IndexPair p = this.indices.get(i);
			
			ExprNode idxS = p.idxS;
			ExprNode idxE = p.idxE;
			
			if(null == idxE) {
				idxS.genCode(mg);
				if(aryType.getDescriptor().equals(Type.getType(List.class).getDescriptor())) {
					mg.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;", true);
					if(eleType.getSort() == Type.ARRAY) {
						mg.visitTypeInsn(Opcodes.CHECKCAST, eleType.getInternalName());
					}
					//cann't cast Integer to int
//					else if(eleType.getSort() != Type.OBJECT){
//						mg.visitTypeInsn(Opcodes.CHECKCAST, eleType.getDescriptor());
//					}
				} else if(aryType.getSort() == Type.ARRAY) {
					if(i == 0) {
						//checkcase
						mg.visitInsn(eleType.getOpcode(IALOAD));
					} else {
						mg.visitInsn(Opcodes.AALOAD);
					}
						
				} else {
					throw new RuntimeException("Wrong type: "+aryType.getDescriptor());
				}
				
				if(valNode != null && valNode instanceof ListComprehensionNode) {
					ListComprehensionNode lstNode = (ListComprehensionNode)valNode;
					valNode = lstNode.getElementNode();
					aryType = valNode.getType();
					if(aryType.getSort() == Type.ARRAY) {
						//get primitive type instead of Object returned from getType(dim)
						eleType = Tools.getElementType(aryType); 
					} else if(valNode instanceof ListComprehensionNode) {
						eleType = ((ListComprehensionNode)valNode).getElementNode().getType();
					} else {
						eleType = null;
					}
				} else {
					int dim = this.indices.size()-i;
					aryType = getType(dim);
					if(dim+1 <= this.indices.size())
						eleType = getType(dim+1);
					else
						eleType = null;
				}
				
				isRange = false;
			} else {
				if(valNode != null && valNode.getType().getDescriptor().equals(Type.getType(List.class).getDescriptor())) {
					idxS.genCode(mg);
					idxE.genCode(mg);
					mg.visitInsn(ICONST_1);
					mg.visitInsn(IADD);
					mg.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "subList", "(II)Ljava/util/List;", true);
				} else if(valNode == null || valNode.getType().getSort() == Type.ARRAY) {
					VariableNode dstVar = mg.newLocalVariable(var.name+"_ret_"+i, getType(this.indices.size()-i));
					
					//_len = idxE - idxS + 1
					SubNode sub = new SubNode(idxE, idxS);
					sub.genCode(mg);
					mg.visitInsn(ICONST_1);
					mg.visitInsn(IADD);
					
					//dstVar = new ElementType[_len]
					Type dstType = dstVar.getType();
					if(Tools.getElementType(dstType).getSort() == Type.OBJECT ||
							Tools.getElementType(dstType).getSort() == Type.ARRAY) {
						mg.visitTypeInsn(ANEWARRAY, Tools.getElementType(dstType).getDescriptor());
					} else {
						mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(dstType, true));
					}
					mg.visitIntInsn(ASTORE, dstVar.idxLVT);
					
					//Shallow copy: System.arraycopy(src, srcPos, dest, destPos, length);
					if(isRange) mg.visitVarInsn(ALOAD, srcVar.idxLVT); //src
					idxS.genCode(mg);                                  //srcPos
					mg.visitVarInsn(ALOAD, dstVar.idxLVT);             //dest
					mg.visitInsn(ICONST_0);                            //destPos
					mg.visitVarInsn(ALOAD, dstVar.idxLVT);             //dest.length
					mg.visitInsn(ARRAYLENGTH);
					
					mg.visitMethodInsn(INVOKESTATIC, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
					
					//return retVar
					mg.visitVarInsn(ALOAD, dstVar.idxLVT);
					
					srcVar = dstVar;
				} else {
					throw new RuntimeException(var+" has wrong type.");
				}
				
				int dim = this.indices.size()-i;
				aryType = getType(dim);
				if(dim+1 <= this.indices.size())
					eleType = getType(dim+1);
				else
					eleType = null;

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
		System.out.println(Type.getType(double.class).getInternalName());
	}
}
