package io.lambdacloud.node.matrix;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

import java.util.ArrayList;
import java.util.Deque;

import org.objectweb.asm.Type;

import org.objectweb.asm.Opcodes;

import io.lambdacloud.BytecodeSupport;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.RangeNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.node.VariableNode;
import io.lambdacloud.node.tool.IndexPair;
import io.lambdacloud.util.CSList;
import io.lambdacloud.util.ObjectArray;

/**
 * Copied from MatrixAccessNode.
 * CellAccessNode has the same logic.
 * 
 * @author yueming.liu
 *
 */
public class CellAccessNode extends ExprNode {
	public static int INDEX_BASE = 1;
	private boolean isAccessObject = false;
	
	public ExprNode var;
	public ArrayList<IndexPair> indices = new ArrayList<IndexPair>();
	
	public boolean needInitialize = false;

	public CellAccessNode(ExprNode var) {
		this.var = var;
	}
	
	public void addIndex(ExprNode idxS, ExprNode idxE) {
		indices.add(new IndexPair(this, idxS, idxE));
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=this.indices.size()-1; i>=0; i--)
			sb.append("{"+this.indices.get(i)+"}");
		return var+sb.toString();
	}

	/**
	 * Return true if the return value is a number instead of a sub-matrix
	 * @return
	 */
	private boolean isAccessElement() {
		if(this.indices.size() == 1) {
			ExprNode idx = this.indices.get(0).idxS;
			if(null != idx && idx.getType().getSort() != Type.OBJECT) {
				ExprNode idxE = this.indices.get(0).idxE;
				if(null == idxE)
					return true;
			}
		} else if(this.indices.size() == 2) {
			ExprNode idx1S = this.indices.get(0).idxS;
			ExprNode idx1E = this.indices.get(0).idxE;
			ExprNode idx2S = this.indices.get(1).idxS;
			ExprNode idx2E = this.indices.get(1).idxE;
			if(null == idx1S  || null == idx2S) return false;
			if(!(idx1S instanceof RangeNode || idx1S instanceof MatrixInitNode) && null == idx1E &&
				!(idx2S instanceof RangeNode || idx1S instanceof MatrixInitNode) && null == idx2E ) {
				return true;
			}
		}
		return false;
	}
	
	public static void test2() {
		Object m = new ObjectArray();
		ObjectArray o = (ObjectArray)m;
		System.out.println(o);
	}
	@Override
	public void _genCode(MethodGenHelper mg) {
		if(this.indices.size() > 2) {
			throw new UnsupportedOperationException("");
		}
		
		if(var instanceof VariableNode && needInitialize) {
			VariableNode varNode = (VariableNode)var;
			Type ty = this.getType();
			mg.visitInsn(Opcodes.ACONST_NULL);
			mg.visitIntInsn(ty.getOpcode(Opcodes.ISTORE), varNode.getLVTIndex(ty));
		}
		
		//A{:} or A{B}
		if(this.indices.size() == 1) {
			if(null == this.indices.get(0).idxS) {  //A{:}
				var.genCode(mg);
				//TODO
				mg.visitTypeInsn(Opcodes.CHECKCAST, "io/lambdacloud/util/ObjectArray");

				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), 
						"to1DArray", "()"+Type.getType(ObjectArray.class), false);
				if(isAccessObject) {
//					mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "getColumnPackedCopy", 
//							"()"+Type.getType(Object[].class), false);
					mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "getCSList", 
							"()"+Type.getType(CSList.class), false);
				}
				return;
			} else {   //A{B} or A{5} or A{1:10} or A{1:2:10}
				ExprNode idxS = this.indices.get(0).idxS;
				if(idxS.getType().equals(Type.getType(Jama.Matrix.class))) { // A{B} or A{range}
					var.genCode(mg);
					idxS.genCode(mg);
					mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), 
							"get", "(LJama/Matrix;)"+Type.getType(ObjectArray.class), false);
					if(isAccessObject) {
//						mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "getColumnPackedCopy", 
//						"()"+Type.getType(Object[].class), false);
						mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "getCSList", 
								"()"+Type.getType(CSList.class), false);
					}
				} else if(idxS.getType().getSort() == Type.INT) {
					var.genCode(mg);
					idxS.genCode(mg);
					if(INDEX_BASE == 1) {
						mg.visitInsn(Opcodes.ICONST_1);
						mg.visitInsn(Opcodes.ISUB);
					}
					ExprNode idxE = this.indices.get(0).idxE;
					if(null == idxE) { //A{5}
						mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), 
								"getAsObjectArray", "(I)"+Type.getType(ObjectArray.class), false);
						if(isAccessObject) {
							mg.visitLdcInsn(0);
							mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "get", 
									"(I)"+Type.getType(Object.class), false);
						}

					} else { //A{1:10} or A{1:end}
						idxE.genCode(mg);
						Tools.insertConversionInsn(mg, idxE.getType(), Type.INT_TYPE);
						mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), 
								"getAs1DArray", "(II)"+Type.getType(ObjectArray.class), false);
						if(isAccessObject) {
//							mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "getColumnPackedCopy", 
//							"()"+Type.getType(Object[].class), false);
							mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "getCSList", 
									"()"+Type.getType(CSList.class), false);
						}
					}
				} else {
					throw new UnsupportedOperationException("Unknown start index: "+idxS.toString());
				}

				return;
			}
		}
		
		var.genCode(mg);

		if(isAccessElement()) { //A{1,2}
			ExprNode idx1S = this.indices.get(1).idxS;
			ExprNode idx2S = this.indices.get(0).idxS;
			idx1S.genCode(mg);
			Tools.insertConversionInsn(mg, idx1S.getType(), Type.INT_TYPE);
			if(INDEX_BASE == 1) {
				mg.visitInsn(Opcodes.ICONST_1);
				mg.visitInsn(Opcodes.ISUB);
			}
			idx2S.genCode(mg);
			Tools.insertConversionInsn(mg, idx2S.getType(), Type.INT_TYPE);
			if(INDEX_BASE == 1) {
				mg.visitInsn(Opcodes.ICONST_1);
				mg.visitInsn(Opcodes.ISUB);
			}
			mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), 
					"getAsObjectArray", "(II)"+Type.getType(ObjectArray.class), false);
			if(isAccessObject) {
				mg.visitLdcInsn(0);
				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "get", 
						"(I)"+Type.getType(Object.class), false);
			}
			return;
		}
		int type = 0x0;
		for(int i=this.indices.size()-1; i>=0; i--) {
			IndexPair ip = this.indices.get(i);
			if(null == ip.idxS) {
				mg.visitInsn(Opcodes.ICONST_0);
				var.genCode(mg);
				if(i == 1) {
					mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "getRowDimension", "()I", false);
					mg.visitInsn(Opcodes.ICONST_1);
					mg.visitInsn(Opcodes.ISUB);
				} else if(i == 0) {
					mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "getColumnDimension", "()I", false);
					mg.visitInsn(Opcodes.ICONST_1);
					mg.visitInsn(Opcodes.ISUB);
				}
				else
					throw new RuntimeException();
			} else {
				if(ip.idxS instanceof RangeNode) { //A{1:2:10,end:-1:5}
					if(INDEX_BASE == 1) {
						((RangeNode)ip.idxS).INDEX_SHIFT=1;
					}
					if(i == 1) {
						ip.idxS.genCode(mg);
						mg.visitMethodInsn(INVOKESTATIC, BytecodeSupport.getMyName(), "convert", "(LJama/Matrix;)[I", false);
						type |= 0x1;
					} else if(i == 0) {
						ip.idxS.genCode(mg);
						mg.visitMethodInsn(INVOKESTATIC, BytecodeSupport.getMyName(), "convert", "(LJama/Matrix;)[I", false);
						type |= 0x2;
					} else
						throw new RuntimeException();
				} else if(ip.idxS instanceof MatrixInitNode) {
					if(INDEX_BASE == 1) {
						if(i == 1) {
							ip.idxS.genCode(mg);
							mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "convert_m1", "(LJama/Matrix;)[I", false);
							type |= 0x1;
						} else if(i == 0) {
							ip.idxS.genCode(mg);
							mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "convert_m1", "(LJama/Matrix;)[I", false);
							type |= 0x2;
						} else
							throw new RuntimeException();
					} else {
						if(i == 1) {
							ip.idxS.genCode(mg);
							mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "convert", "(LJama/Matrix;)[I", false);
							type |= 0x1;
						} else if(i == 0) {
							ip.idxS.genCode(mg);
							mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "convert", "(LJama/Matrix;)[I", false);
							type |= 0x2;
						} else
							throw new RuntimeException();
					}
				} else { //A{1:10, 2:end}
					ip.idxS.genCode(mg);
					Tools.insertConversionInsn(mg, ip.idxS.getType(), Type.INT_TYPE);
					if(INDEX_BASE == 1) {
						mg.visitInsn(Opcodes.ICONST_1);
						mg.visitInsn(Opcodes.ISUB);
					}
					if(null == ip.idxE) //A{s:s}
						mg.visitInsn(Opcodes.DUP);
					else { //A{s1:e1,s2:e2} where e2=expr or 'end'
						ip.idxE.genCode(mg);
						Tools.insertConversionInsn(mg, ip.idxE.getType(), Type.INT_TYPE);
						if(INDEX_BASE == 1) {
							mg.visitInsn(Opcodes.ICONST_1);
							mg.visitInsn(Opcodes.ISUB);
						}
					}
				}
			}
		}
		if(type == 0x0)
			mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "get", 
					"(IIII)"+Type.getType(ObjectArray.class), false);
		else if(type == 0x1)
			mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "get", 
					"([III)"+Type.getType(ObjectArray.class), false);
		else if(type == 0x2)
			mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "get", 
					"(II[I)"+Type.getType(ObjectArray.class), false);
		else if(type == 0x3)
			mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "get", 
					"([I[I)"+Type.getType(ObjectArray.class), false);
		
		if(isAccessObject) {
//			mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "getColumnPackedCopy", 
//					"()"+Type.getType(Object[].class), false);
			mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "getCSList", 
					"()"+Type.getType(CSList.class), false);
		}
	}

	@Override
	public Type getType(Deque<Object> stack) {
		if(this.isAccessElement()) {
			if(this.isAccessObject)
				return Type.getType(Object.class);
		} else {
			if(this.isAccessObject) {
				return Type.getType(CSList.class);
			}
		}
		return Type.getType(ObjectArray.class);
	}

	@Override
	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		for(int i=this.indices.size()-1; i>=0; i--) {
			IndexPair p = this.indices.get(i);
			ExprNode idxS = p.idxS;
			ExprNode idxE = p.idxE;
			if(null != idxS) idxS.updateType(stack);
			if(null != idxE) idxE.updateType(stack);
		}
		stack.pop();
	}
	
	/**
	 * A{1.2}
	 */
	public void setToAccessObject() {
		this.isAccessObject = true;
	}
	
	/**
	 * A(1,2)
	 */
	public void setToAccessCell() {
		this.isAccessObject = false;
	}

	@Override
	public boolean contains(ExprNode target) {
		if(this == target)
			return true;
		if(var.contains(target))
			return true;
		for(IndexPair ip : this.indices) {
			if( (null != ip.idxS && ip.idxS.contains(target)) ||
				(null != ip.idxE && ip.idxE.contains(target)))
				return true;
		}
		return false;
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		if(this.var == oldNode)
			this.var = newNode;
		for(int i=0; i<this.indices.size(); i++) {
			IndexPair idx = this.indices.get(i);
			if(idx.idxS == oldNode)
				idx.idxS = newNode;
			if(idx.idxE == oldNode)
				idx.idxE = newNode;
			
			if(null != idx.idxS)
				idx.idxS.replaceChild(oldNode, newNode);
			if(null != idx.idxE)
				idx.idxE.replaceChild(oldNode, newNode);
		}
	}


	@Override
	public void updateTree(MethodGenHelper mg) {
		for(int i=0; i<this.indices.size(); i++) {
			IndexPair p = this.indices.get(i);
			if(null != p.idxS) {
				p.idxS.updateTree(mg);
			}
			if(null != p.idxE) {
				p.idxS.updateTree(mg);
			}
		}
	}

	@Override
	public void updateParam(String name, Object value) {
		//Pass down the update if there is any
		if(null != name) {
			for(int i=0; i<this.indices.size(); i++) {
				IndexPair p = this.indices.get(i);
				if(null != p.idxS) {
					p.idxS.updateParam(name, value);
				}
				if(null != p.idxE) {
					p.idxE.updateParam(name, value);
				}
			}
		}
		
		//update dim for 'end' index
		if(this.indices.size() == 1) {
			for(int i=0; i<this.indices.size(); i++) {
				IndexPair p = this.indices.get(i);
				if(null != p.idxS) {
					p.idxS.updateParam("end_dim", -1);
				}
				if(null != p.idxE) {
					p.idxE.updateParam("end_dim", -1);
				}
			}
		} else {
			int dim = this.indices.size();
			for(int i=0; i<this.indices.size(); i++) {
				IndexPair p = this.indices.get(i);
				if(null != p.idxS) {
					p.idxS.updateParam("end_dim", dim-i);
				}
				if(null != p.idxE) {
					p.idxE.updateParam("end_dim", dim-i);
				}
			}
		}
	}
}
