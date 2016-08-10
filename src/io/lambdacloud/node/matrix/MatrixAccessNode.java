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
import io.lambdacloud.node.FuncCallNode;
import io.lambdacloud.node.RangeNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.node.VariableNode;

public class MatrixAccessNode extends ExprNode {
	public static int INDEX_BASE = 1;
	
	public VariableNode var;
	public ArrayList<IndexPair> indices = new ArrayList<IndexPair>();
	
	public MatrixAccessNode(VariableNode var) {
		this.var = var;
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
		return var+sb.toString();
	}

	@Override
	public void genCode(MethodGenHelper mg) {
		if(this.indices.size() > 2) {
			throw new UnsupportedOperationException();
		}
		
		if(this.indices.size() == 1 && null == this.indices.get(0).idxS) {
			FuncCallNode func = new FuncCallNode(BytecodeSupport.class.getName(),"matToVec", false);
			func.args.add(var);
			func.genCode(mg);
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
					if(INDEX_BASE == 1) {
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
					if(INDEX_BASE == 1) {
						mg.visitInsn(Opcodes.ICONST_1);
						mg.visitInsn(Opcodes.ISUB);
					}
					if(null == ip.idxE) 
						mg.visitInsn(Opcodes.DUP);
					else {
						ip.idxE.genCode(mg);
						Tools.insertConversionInsn(mg, ip.idxS.getType(), Type.INT_TYPE);
						if(INDEX_BASE == 1) {
							mg.visitInsn(Opcodes.ICONST_1);
							mg.visitInsn(Opcodes.ISUB);
						}
					}
				}
			}
		}
		if(type == 0x0)
			mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "getMatrix", "(IIII)LJama/Matrix;", false);
		else if(type == 0x1)
			mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "getMatrix", "([III)LJama/Matrix;", false);
		else if(type == 0x2)
			mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "getMatrix", "(II[I)LJama/Matrix;", false);
		else if(type == 0x3)
			mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "getMatrix", "([I[I)LJama/Matrix;", false);
	}
	
	public Matrix test(Matrix A) {
		return A.getMatrix(1, 2, 1, 2);
	}
	public double test2(Matrix A) {
		return A.get(1, 2);
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.getType(Jama.Matrix.class);
	}

	@Override
	public void fixType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		for(int i=this.indices.size()-1; i>=0; i--) {
			IndexPair p = this.indices.get(i);
			ExprNode idxS = p.idxS;
			ExprNode idxE = p.idxE;
			if(null != idxS) idxS.fixType(stack);
			if(null != idxE) idxE.fixType(stack);
		}
		stack.pop();
	}
}
