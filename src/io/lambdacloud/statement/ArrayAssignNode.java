package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.statement.ArrayAccessNode.IndexPair;

/**
 * x = a[1]
 * y = a[5:10]
 *
 * a[0][1] = 10
 * a[1:5][0] = 20
 */
public class ArrayAssignNode extends ExprNode {
	public VariableNode var;
	public ArrayList<IndexPair> indices = new ArrayList<IndexPair>();
	public ExprNode value;
	
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
	
	public ArrayAssignNode(VariableNode var, ExprNode value) {
		this.var = var;
		this.value = value;
	}
	
	public void addIndex(ExprNode idxS, ExprNode idxE) {
		indices.add(new IndexPair(idxS, idxE));
	}
	
	public String toString() {
		return var+"["+this.indices+"]="+value;
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
	
	//TODO need to be changed to ArrayAccessNode.getCode()
	
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
					if(i == 0) {
						value.genCode(mg);
						mg.visitInsn(getType(this.indices.size()-i).getOpcode(IASTORE));
					} else {
						mg.visitInsn(Opcodes.AALOAD);
					}
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
		a[2]=10;
		return a[2];
	}
	public int[] test2(int[] a) {
		int[] ret = new int[3];
		System.arraycopy(a, 1, ret, 0, ret.length);
		return ret;
	}
	
	public void test3(int[][][] a) {
		a[0][1][2] = 1000;
	}
	
	public static void main(String[] args) {
		System.out.println(Type.getType(double[].class).getElementType());
	}
	
}
