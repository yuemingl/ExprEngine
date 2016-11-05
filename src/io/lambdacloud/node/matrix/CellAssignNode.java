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
import io.lambdacloud.util.ObjectArray;
public class CellAssignNode extends ExprNode {
	public VariableNode var;
	public ExprNode value;
	public ArrayList<IndexPair> indices = new ArrayList<IndexPair>();
	
	public CellAssignNode(VariableNode var, ExprNode value) {
		this.var = var;
		this.value = value;
	}
	
	public void addIndex(ExprNode idxS, ExprNode idxE) {
		indices.add(new IndexPair(idxS, idxE));
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=this.indices.size()-1; i>=0; i--)
			sb.append("["+this.indices.get(i)+"]");
		sb.append("=").append(this.value);
		return var+sb.toString();
	}

	@Override
	public void _genCode(MethodGenHelper mg) {
		
		String ObjAryDesc = Type.getType(ObjectArray.class).getDescriptor();
		String ObjDesc = Type.getType(Object.class).getDescriptor();
		
		Type myType = this.getType();

		if(this.indices.size() > 2) {
			throw new UnsupportedOperationException();
		}

		//A(:)=Value
		if(this.indices.size() == 1 && null == this.indices.get(0).idxS) {
			var.genCode(mg);

			mg.visitInsn(Opcodes.ICONST_0);
			var.genCode(mg);
			mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "getRowDimension", "()I", false);
			mg.visitInsn(Opcodes.ICONST_1);
			mg.visitInsn(Opcodes.ISUB);
			mg.visitInsn(Opcodes.ICONST_0);
			var.genCode(mg);
			mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), "getColumnDimension", "()I", false);
			mg.visitInsn(Opcodes.ICONST_1);
			mg.visitInsn(Opcodes.ISUB);
			this.value.genCode(mg);
			if(this.value.getType().equals(Type.getType(ObjectArray.class))) {
				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), 
						"set", "(IIII"+ObjAryDesc+")"+ObjAryDesc, false);
			} else {
				Tools.insertConversionInsn(mg, this.value.getType(), Type.getType(Object.class));
				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), 
						"set", "(IIII"+ObjDesc+")"+ObjAryDesc, false);
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
				if(this.value.getType().equals(Type.getType(ObjectArray.class))) {
					mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class),
							"set", "(LJama/Matrix;"+ObjAryDesc+")"+ObjAryDesc, false);
				} else {
					Tools.insertConversionInsn(mg, this.value.getType(), Type.getType(Object.class));
					mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class),
							"set", "(LJama/Matrix;"+ObjDesc+")"+ObjAryDesc, false);
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
					Tools.insertConversionInsn(mg, this.value.getType(), Type.getType(Object.class));
					if(this.value.getType().equals(Type.getType(ObjectArray.class))) {
						mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), 
								"set", "(I"+ObjAryDesc+")"+ObjAryDesc, false);
					} else {
						mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), 
								"set", "(I"+ObjDesc+")"+ObjAryDesc, false);
					}
				} else { //A(1:10)=C or A(1:end)=C
					idxE.genCode(mg);
					Tools.insertConversionInsn(mg, idxE.getType(), Type.INT_TYPE);
					if(MatrixAccessNode.INDEX_BASE == 1) {
						mg.visitInsn(Opcodes.ICONST_1);
						mg.visitInsn(Opcodes.ISUB);
					}
					this.value.genCode(mg);
					if(this.value.getType().equals(Type.getType(ObjectArray.class))) {
						mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), 
								"setAs1DArray", "(II"+ObjAryDesc+")"+ObjAryDesc, false);
					} else {
						Tools.insertConversionInsn(mg, idxE.getType(), Type.getType(Object.class));
						mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), 
								"setAs1DArray", "(II"+ObjDesc+")"+ObjAryDesc, false);
					}
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
				} else if(ip.idxS instanceof MatrixInitNode) {
					if(MatrixAccessNode.INDEX_BASE == 1) {
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
		if(this.value.getType().equals(Type.getType(ObjectArray.class))) {
			if(type == 0x0)
				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class),
						"set", "(IIII"+ObjAryDesc+")"+ObjAryDesc, false);
			else if(type == 0x1)
				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class),
						"set", "([III"+ObjAryDesc+")"+ObjAryDesc, false);
			else if(type == 0x2)
				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class),
						"set", "(II[I"+ObjAryDesc+")"+ObjAryDesc, false);
			else if(type == 0x3)
				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class),
						"set", "([I[I"+ObjAryDesc+")"+ObjAryDesc, false);
			}
		else {
			Tools.insertConversionInsn(mg, this.value.getType(), Type.getType(Object.class));
			if(type == 0x0)
				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class),
						"set", "(IIII"+ObjDesc+")"+ObjAryDesc, false);
			else if(type == 0x1)
				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class),
						"set", "([III"+ObjDesc+")"+ObjAryDesc, false);
			else if(type == 0x2)
				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class),
						"set", "(II[I"+ObjDesc+")"+ObjAryDesc, false);
			else if(type == 0x3)
				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class),
						"set", "([I[I"+ObjDesc+")"+ObjAryDesc, false);
		}
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
		}
	}
	
	@Override
	public Type getType(Deque<Object> stack) {
		return Type.getType(ObjectArray.class);
	}

	@Override
	public void updateType(Deque<Object> stack) {
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
	
}
