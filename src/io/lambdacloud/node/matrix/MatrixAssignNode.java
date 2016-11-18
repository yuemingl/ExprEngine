package io.lambdacloud.node.matrix;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

import java.util.ArrayList;
import java.util.Deque;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.BytecodeSupport;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.RangeNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.node.VariableNode;
import io.lambdacloud.node.tool.IndexPair;
import io.lambdacloud.util.CSList;
import io.lambdacloud.util.ObjectArray;
public class MatrixAssignNode extends ExprNode {
	public VariableNode var;
	public ExprNode value;
	public ArrayList<IndexPair> indices = new ArrayList<IndexPair>();
	
	private CellAssignNode cellAssignNode;

	public boolean needInitialize = false;
	
	public MatrixAssignNode(VariableNode var, ExprNode value) {
		this.var = var;
		this.value = value;
	}
	
	public void addIndex(ExprNode idxS, ExprNode idxE) {
		indices.add(new IndexPair(this, idxS, idxE));
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=this.indices.size()-1; i>=0; i--)
			sb.append("["+this.indices.get(i)+"]");
		sb.append("=").append(this.value);
		return var+sb.toString();
	}

	public static void test() {
		Jama.Matrix a = new Jama.Matrix(1,1);
	}
	@Override
	public void _genCode(MethodGenHelper mg) {
//		if(cellAssignNode == null) {
//		if(Type.getType(ObjectArray.class).equals(var.getType())) {
//			cellAssignNode = this.toCellAssignNode();
//			cellAssignNode.needInitialize = this.needInitialize;
//			cellAssignNode.genCode(mg);
//			return;
//		}
//	} else {
//		cellAssignNode.needInitialize = this.needInitialize;
//		cellAssignNode.genCode(mg);
//		return;
//	}
		
		Type myType = this.getType();

		if(this.indices.size() > 2) {
			throw new UnsupportedOperationException();
		}

		if(var instanceof VariableNode && needInitialize) {
			VariableNode varNode = (VariableNode)var;
			Type ty = this.getType();
			mg.visitTypeInsn(Opcodes.NEW, "Jama/Matrix");
			mg.visitInsn(Opcodes.DUP);
			mg.visitInsn(Opcodes.ICONST_0);
			mg.visitInsn(Opcodes.ICONST_0);
			mg.visitMethodInsn(Opcodes.INVOKESPECIAL, "Jama/Matrix", "<init>", "(II)V", false);
			mg.visitIntInsn(ty.getOpcode(Opcodes.ISTORE), varNode.getLVTIndex(ty));
		}

		//A(:)=Value
		if(this.indices.size() == 1 && null == this.indices.get(0).idxS) {
			var.genCode(mg);

			mg.visitInsn(Opcodes.ICONST_0);
			var.genCode(mg);
			mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "getRowDimension", "()I", false);
			mg.visitInsn(Opcodes.ICONST_1);
			mg.visitInsn(Opcodes.ISUB);
			mg.visitInsn(Opcodes.ICONST_0);
			var.genCode(mg);
			mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "getColumnDimension", "()I", false);
			mg.visitInsn(Opcodes.ICONST_1);
			mg.visitInsn(Opcodes.ISUB);
			this.value.genCode(mg);
			if(this.value.getType().getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor())) {
				mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "setMatrix", "(IIIILJama/Matrix;)V", false);
			} else {
				Tools.insertConversionInsn(mg, this.value.getType(), Type.DOUBLE_TYPE);
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "setMatrix", "(LJama/Matrix;IIIID)V", false);
			}
			if (genLoadInsn) {
				mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
			}
			return;
		}
		
		//A(B)=Value
		if(this.indices.size() == 1 && null != this.indices.get(0).idxS) {
			ExprNode idx = this.indices.get(0).idxS;
			if(idx.getType().equals(Type.getType(Jama.Matrix.class))) {
				var.genCode(mg);
				idx.genCode(mg);
				this.value.genCode(mg);
				if(this.value.getType().equals(Type.getType(Jama.Matrix.class))) {
					mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "setMatrix", "(LJama/Matrix;LJama/Matrix;LJama/Matrix;)LJama/Matrix;", false);
				} else {
					Tools.insertConversionInsn(mg, this.value.getType(), Type.DOUBLE_TYPE);
					mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "setMatrix", "(LJama/Matrix;LJama/Matrix;D)LJama/Matrix;", false);
				}
				if (genLoadInsn) {
					mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
				}
			} else if(idx.getType().getSort() == Type.INT) {
				var.genCode(mg);
				idx.genCode(mg);
				Tools.insertConversionInsn(mg, idx.getType(), Type.INT_TYPE);
				if(MatrixAccessNode.INDEX_BASE == 1) {
					mg.visitInsn(Opcodes.ICONST_1);
					mg.visitInsn(Opcodes.ISUB);
				}
				ExprNode idxE = this.indices.get(0).idxE;
				if(null == idxE) { //A(5)=50
					this.value.genCode(mg);
					Tools.insertConversionInsn(mg, this.value.getType(), Type.DOUBLE_TYPE);
					mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "setElement", "(LJama/Matrix;ID)V", false);
				} else { //A(1:10)=C or A(1:end)=C
					idxE.genCode(mg);
					Tools.insertConversionInsn(mg, idxE.getType(), Type.INT_TYPE);
					this.value.genCode(mg);
					Tools.insertConversionInsn(mg, this.value.getType(), Type.DOUBLE_TYPE);
					mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "setMatrix", "(LJama/Matrix;IILJama/Matrix;)LJama/Matrix;", false);
				}
			} else {
				throw new UnsupportedOperationException("Unknown start index: "+idx.toString());
			}
			if (genLoadInsn) {
				mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
			}
			return;
		}
		
		var.genCode(mg);
		int type = 0x0;
		for(int i=this.indices.size()-1; i>=0; i--) {
			IndexPair ip = this.indices.get(i);
			if(null == ip.idxS) {
				mg.visitInsn(Opcodes.ICONST_0);
				var.genCode(mg);
				if(i == 1) {
					mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "getRowDimension", "()I", false);
					mg.visitInsn(Opcodes.ICONST_1);
					mg.visitInsn(Opcodes.ISUB);
				} else if(i == 0) {
					mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "getColumnDimension", "()I", false);
					mg.visitInsn(Opcodes.ICONST_1);
					mg.visitInsn(Opcodes.ISUB);
				}
				else
					throw new RuntimeException();
			} else {
				if(ip.idxS instanceof RangeNode) {
					if(MatrixAccessNode.INDEX_BASE == 1) {
						((RangeNode)ip.idxS).INDEX_SHIFT=1;
					}
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
				//TODO for Jama.Matrix
				} else {
					ip.idxS.genCode(mg);
					Tools.insertConversionInsn(mg, ip.idxS.getType(), Type.INT_TYPE);
					if(MatrixAccessNode.INDEX_BASE == 1) {
						mg.visitInsn(Opcodes.ICONST_1);
						mg.visitInsn(Opcodes.ISUB);
					}
					if(null == ip.idxE) 
						mg.visitInsn(Opcodes.DUP);
					else {
						ip.idxE.genCode(mg);
						Tools.insertConversionInsn(mg, ip.idxE.getType(), Type.INT_TYPE);
						if(MatrixAccessNode.INDEX_BASE == 1) {
							mg.visitInsn(Opcodes.ICONST_1);
							mg.visitInsn(Opcodes.ISUB);
						}
					}
				}
			}
		}
		this.value.genCode(mg);
		if(this.value.getType().equals(Type.getType(Jama.Matrix.class))) {
			if(type == 0x0)
				mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "setMatrix", "(IIIILJama/Matrix;)V", false);
			else if(type == 0x1)
				mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "setMatrix", "([IIILJama/Matrix;)V", false);
			else if(type == 0x2)
				mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "setMatrix", "(II[ILJama/Matrix;)V", false);
			else if(type == 0x3)
				mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "setMatrix", "([I[ILJama/Matrix;)V", false);
			}
		else {
			Tools.insertConversionInsn(mg, this.value.getType(), Type.DOUBLE_TYPE);
			if(type == 0x0)
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "setMatrix", "(LJama/Matrix;IIIID)V", false);
			else if(type == 0x1)
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "setMatrix", "(LJama/Matrix;[IIID)V", false);
			else if(type == 0x2)
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "setMatrix", "(LJama/Matrix;II[ID)V", false);
			else if(type == 0x3)
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "setMatrix", "(LJama/Matrix;[I[ID)V", false);
		}
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
		}
	}
	
	@Override
	public Type getType(Deque<Object> stack) {
		//If var is of type ObjectArray, we should use CellAssignNode instead of MatrixAssignNode
		//e.g. A={1,2,3;4,5,6}; A(1,2)=100; %it should be a CellAssignNode
		if(cellAssignNode == null) {
			if(Type.getType(ObjectArray.class).equals(var.getType())) {
				cellAssignNode = this.toCellAssignNode();
				return cellAssignNode.getType();
			}
		} else {
			return cellAssignNode.getType();
		}
		return Type.getType(Jama.Matrix.class);
	}

	@Override
	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		
		value.updateType(stack);
		stack.pop();
		
		Type rType = value.getType(stack);
		if(Type.getType(ObjectArray.class).equals(rType) ||
				Type.getType(Jama.Matrix.class).equals(rType) )
			var.setType(rType);
		else {
			//Don't change the type of var of the type is not null
			//e.g. a={1,2,3}; a(1,2)=10 % the type of a is not changed after the assignment
			if(null == var.getType())
				var.setType(Type.getType(Jama.Matrix.class));
		}
	}
	
	public CellAssignNode toCellAssignNode() {
		CellAssignNode n = new CellAssignNode(this.var, this.value);
		n.indices = this.indices;
		n.needInitialize = this.needInitialize;
		return n;
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
		if(this.value.contains(target))
			return true;
		return false;
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		if(this.var == oldNode)
			this.var = (VariableNode)newNode;
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
		this.value.updateTree(mg);
		
		for(int i=0; i<this.indices.size(); i++) {
			IndexPair p = this.indices.get(i);
			if(null != p.idxS) {
				p.idxS.updateTree(mg);
			}
			if(null != p.idxE) {
				p.idxS.updateTree(mg);
			}
		}
		
		if(Type.getType(ObjectArray.class).equals(var.getType())) {
			this.getParent().replaceChild(this, this.toCellAssignNode());
		}
		
	}

	@Override
	public void updateParam(String name, Object value) {
		this.value.updateParam(name, value);
		
		//Pass down the update if there is any
		if(null != name) {
			for(int i=0; i<this.indices.size(); i++) {
				IndexPair p = this.indices.get(i);
				if(null != p.idxS) {
					p.idxS.updateParam(name, value);
				}
				if(null != p.idxE) {
					p.idxS.updateParam(name, value);
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
