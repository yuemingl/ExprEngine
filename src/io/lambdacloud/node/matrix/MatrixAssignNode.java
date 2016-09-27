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
public class MatrixAssignNode extends ExprNode {
		public VariableNode var;
		public ExprNode value;
		public ArrayList<IndexPair> indices = new ArrayList<IndexPair>();
		
		public MatrixAssignNode(VariableNode var, ExprNode value) {
			this.var = var;
			this.value = value;
		}
		
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
		public void genCode(MethodGenHelper mg) {
			Type myType = this.getType();

			if(this.indices.size() > 2) {
				throw new UnsupportedOperationException();
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
			if(this.value.getType().getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor())) {
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
			return Type.getType(Jama.Matrix.class);
		}

		@Override
		public void updateType(Deque<Object> stack) {
		}
	}
