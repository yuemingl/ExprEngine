package io.lambdacloud.node.matrix;

import java.util.ArrayList;
import java.util.Deque;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import Jama.Matrix;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.RangeNode;
import io.lambdacloud.node.VariableNode;
import static org.objectweb.asm.Opcodes.*;

public class MatrixAccessNode extends ExprNode {
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
					if(i == 1) {
						ip.idxS.genCode(mg);
						type |= 0x1;
					} else if(i == 0) {
						ip.idxS.genCode(mg);
						type |= 0x2;
					} else
						throw new RuntimeException();
				} else {
					ip.idxS.genCode(mg);
					if(null == ip.idxE) 
						mg.visitInsn(Opcodes.DUP);
					else
						ip.idxE.genCode(mg);
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
}
