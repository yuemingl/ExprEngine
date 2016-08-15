package io.lambdacloud.node.matrix;

import static org.objectweb.asm.Opcodes.ANEWARRAY;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.IASTORE;
import static org.objectweb.asm.Opcodes.NEWARRAY;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import Jama.Matrix;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;

public class MatrixInitNode extends ExprNode {
	public List<ExprNode> init = new ArrayList<ExprNode>();
	public int nCols = 0;
	
	/**
	 * Construct a matrix from a one-dimensional array with matlab style
	 * e.g. A=[1 2 3; 4 5 6] is a 2 rows by 3 columns matrix
	 * 
	 * @param nCols
	 */
	public MatrixInitNode(int nCols) {
		this.nCols = nCols;
	}
	
	public void addInitValues(ExprNode val) {
		init.add(val);
	}

	public Matrix test() {
		double[] a = { 1, 2, 3 };
		Matrix m = new Matrix(a, a.length);
		return m;
	}
	
	public Matrix test2() {
		double[][] a = { {1, 2}, {3,4} };
		Matrix m = new Matrix(a);
		m.transpose();
		return m;
	}

	public static void test3() {
		Jama.Matrix mat = new Jama.Matrix(new double[]{1,2,3,4}, 4).transpose();
	}
	
	public Type getElementType() {
		Type eleType = init.get(0).getType();
		if (init.size() > 1) {
			for (int i = 1; i < init.size(); i++)
				eleType = Tools.typeConversion(eleType, init.get(i).getType());
		}
		return eleType;
	}
	@Override
	public void genCode(MethodGenHelper mg) {

		if(init.size() == 0) {
			mg.visitTypeInsn(Opcodes.NEW, "Jama/Matrix");
			mg.visitInsn(DUP);
			mg.visitLdcInsn(0);
			mg.visitLdcInsn(0);
			mg.visitMethodInsn(Opcodes.INVOKESPECIAL, "Jama/Matrix", "<init>", "(II)V", false);
			return;
		}
		
		Type eleType = getElementType();
		if (eleType.getSort() == Type.OBJECT || eleType.getSort() == Type.ARRAY) {
			//Get element type
			mg.visitLdcInsn(init.size()); //size of new array
			mg.visitTypeInsn(ANEWARRAY, eleType.getInternalName());
			//An array of Jama.Matrix
			int idx = 0;
			for (int i = init.size() - 1; i >= 0; i--) {
				mg.visitInsn(DUP);
				mg.visitLdcInsn(idx++);
				init.get(i).genCode(mg);
				mg.visitInsn(eleType.getOpcode(IASTORE));
			}
		} else {
			mg.visitTypeInsn(Opcodes.NEW, "Jama/Matrix");
			mg.visitInsn(DUP);
			//Get element type
			mg.visitLdcInsn(init.size()); //size of new array
			eleType = Type.DOUBLE_TYPE;
			mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(Type.DOUBLE_TYPE, false));
			int idx = 0;
			for (int i = init.size() - 1; i >= 0; i--) {
				mg.visitInsn(DUP);
				mg.visitLdcInsn(idx++);
				init.get(i).genCode(mg);
				Tools.insertConversionInsn(mg, init.get(i).getType(), eleType);
				mg.visitInsn(eleType.getOpcode(IASTORE));
			}
			
			//mg.visitInsn(DUP);
			//mg.visitInsn(Opcodes.ARRAYLENGTH);
			mg.visitLdcInsn(nCols);
			mg.visitMethodInsn(Opcodes.INVOKESPECIAL, "Jama/Matrix", "<init>", "([DI)V", false);
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "transpose", "()LJama/Matrix;", false);
		}
	}

	public String toString() {
		return this.init.toString();
	}

	@Override
	public Type getType(Deque<Object> stack) {
		Type eleType = getElementType();
		if (eleType.getSort() == Type.OBJECT || eleType.getSort() == Type.ARRAY) {
			return Type.getType(Jama.Matrix[].class);
		} else {
			return Type.getType(Jama.Matrix.class);
		}
	}
	
	@Override
	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		for (int i = init.size() - 1; i >= 0; i--) {
			this.init.get(i).updateType(stack);
		}
		stack.pop();
	}
	public Jama.Matrix[] test4() {
		Jama.Matrix[] ret = new Jama.Matrix[10];
		return ret;
	}
}
