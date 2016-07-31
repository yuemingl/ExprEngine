package io.lambdacloud.node.matrix;

import java.util.ArrayList;
import java.util.Deque;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import Jama.Matrix;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
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
		for(int i=this.indices.size()-1; i>=0; i--) {
			IndexPair ip = this.indices.get(i);
			ip.idxS.genCode(mg);
			if(null == ip.idxE) 
				mg.visitInsn(Opcodes.DUP);
			else
				ip.idxE.genCode(mg);
		}
		
		mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "getMatrix", "(IIII)LJama/Matrix;", false);
		//mg.visitInsn(ARETURN);

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
