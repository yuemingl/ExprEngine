package io.lambdacloud.node.matrix;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

import java.util.ArrayList;
import java.util.Deque;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import Jama.Matrix;
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
			var.genCode(mg);
			if(this.indices.size() > 2) {
				throw new UnsupportedOperationException();
			}
			
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
							Tools.insertConversionInsn(mg, ip.idxS.getType(), Type.INT_TYPE);
							type |= 0x1;
						} else if(i == 0) {
							ip.idxS.genCode(mg);
							Tools.insertConversionInsn(mg, ip.idxS.getType(), Type.INT_TYPE);
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
			if(this.value.getType().getDescriptor().equals(Type.getType(Jama.Matrix.class).getDescriptor())) {
				this.value.genCode(mg);
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
				this.value.genCode(mg);
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
