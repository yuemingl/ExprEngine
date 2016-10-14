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
import io.lambdacloud.BytecodeSupport;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;

public class MatrixInitNode extends ExprNode {
	public List<ExprNode> initExprList = new ArrayList<ExprNode>();
	public List<Integer> colLenList = new ArrayList<Integer>();
	//public int nCols = 0;
	
	/**
	 * 
	 * function [A B]=myfun(), A=[1 2; 3 4]; B=[5 6; 7 8]; end 
	 * When calling myfun(), we want to return two matrices A and B
	 * instead of a big matrix that is the same as vertcat(A,B) 
	 * if flag is set to 1, a array of matrix is returned. A and B can be assigned by the returned array of matrices
	 * if flag is set to 2, a single concatenated matrix is returned.
	 * 
	 * Note: an array of matrix cannot be constructed using Matlab gramma so far
	 */
	private int flag = 0; //0: return Jama.Matrix; 1 return an array
	
//	/**
//	 * Construct a matrix from a one-dimensional array with matlab style
//	 * e.g. A=[1 2 3; 4 5 6] is a 2 rows by 3 columns matrix
//	 * 
//	 * @param nCols
//	 */
//	public MatrixInitNode(int nCols) {
//		this.nCols = nCols;
//	}
	
	public void addInitValues(ExprNode val) {
		initExprList.add(val);
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
		if(initExprList.size() == 0)
			return Type.DOUBLE_TYPE;
		Type eleType = null;
		for (int i = 0; i < initExprList.size(); i++) {
			Type tmp = this.initExprList.get(i).getType();
			if(null != tmp) {
				eleType = tmp;
				break;
			}
		}
		if (initExprList.size() > 1) {
			for (int i = 0; i < initExprList.size(); i++) {
				Type tmp = this.initExprList.get(i).getType();
				if(null != tmp)
					eleType = Tools.typeConversion(eleType, initExprList.get(i).getType());
			}
		}
		return eleType;
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {

		if(initExprList.size() == 0) {
			mg.visitTypeInsn(Opcodes.NEW, "Jama/Matrix");
			mg.visitInsn(DUP);
			mg.visitLdcInsn(0);
			mg.visitLdcInsn(0);
			mg.visitMethodInsn(Opcodes.INVOKESPECIAL, "Jama/Matrix", "<init>", "(II)V", false);
			return;
		}
		
		//Get element type
		Type eleType = getElementType();
		if (eleType.getSort() == Type.OBJECT) { //Jama.Matrix
			
			mg.visitLdcInsn(this.initExprList.size()); //size of new array
			mg.visitTypeInsn(ANEWARRAY, eleType.getInternalName());
			int idx = 0;
			for (int i = this.initExprList.size() - 1; i >= 0; i--) {
				mg.visitInsn(DUP);
				mg.visitLdcInsn(idx++);
				initExprList.get(i).genCode(mg);
				mg.visitInsn(eleType.getOpcode(IASTORE));
			}
			
			if(flag == 0) {//return a Matrix
				mg.visitLdcInsn(this.colLenList.size()); //size of new array
				mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(Type.INT_TYPE, false));
				idx = 0;
				for (int i=0; i<this.colLenList.size(); i++) {
					mg.visitInsn(DUP);
					mg.visitLdcInsn(idx++);
					mg.visitLdcInsn(this.colLenList.get(i));
					mg.visitInsn(IASTORE);
				}
				mg.visitMethodInsn(Opcodes.INVOKESTATIC, BytecodeSupport.getMyName(), "getMatrix", "([LJama/Matrix;[I)LJama/Matrix;", false);
			} else {
				//return an array
				//Do nothing. 
			}
		} else if(eleType.getSort() == Type.DOUBLE || eleType.getSort() == Type.INT) {
			mg.visitTypeInsn(Opcodes.NEW, "Jama/Matrix");
			mg.visitInsn(DUP);
			
			//mg.visitLdcInsn(initExprList.size()); //size of new array
			mg.visitLdcInsn(getValidNumberOfElement()); //size of new array
			
			eleType = Type.DOUBLE_TYPE;
			mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(Type.DOUBLE_TYPE, false));
			int idx = 0;
			for (int i = initExprList.size() - 1; i >= 0; i--) {
				if(null == this.initExprList.get(i).getType()) continue;
				mg.visitInsn(DUP);
				mg.visitLdcInsn(idx++);
				initExprList.get(i).genCode(mg);
				Tools.insertConversionInsn(mg, initExprList.get(i).getType(), eleType);
				mg.visitInsn(eleType.getOpcode(IASTORE));
			}
			
			//mg.visitInsn(DUP);
			//mg.visitInsn(Opcodes.ARRAYLENGTH);
			
			//mg.visitLdcInsn(colLenList.get(0));
			if(colLenList.get(0) == this.initExprList.size())
				mg.visitLdcInsn(getValidNumberOfElement());
			else
				mg.visitLdcInsn(colLenList.get(0)); // each row should has the same columns
			
			mg.visitMethodInsn(Opcodes.INVOKESPECIAL, "Jama/Matrix", "<init>", "([DI)V", false);
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "transpose", "()LJama/Matrix;", false);
		} else {
			throw new RuntimeException("Unsupported type: "+eleType);
		}
	}

	public int getValidNumberOfElement() {
		int n = 0;
		for(int i=0; i<this.initExprList.size(); i++) {
			if(null != this.initExprList.get(i).getType())
				n++;
		}
		return n;
	}
	public String toString() {
		return this.initExprList.toString();
	}

	@Override
	public Type getType(Deque<Object> stack) {
		Type eleType = getElementType();
		if (eleType.getSort() == Type.OBJECT || eleType.getSort() == Type.ARRAY) {
			if(flag == 0)
				return Type.getType(Jama.Matrix.class);
			else
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
		for (int i = initExprList.size() - 1; i >= 0; i--) {
			this.initExprList.get(i).updateType(stack);
		}
		stack.pop();
	}
	public Jama.Matrix[] test4() {
		Jama.Matrix[] ret = new Jama.Matrix[10];
		return ret;
	}
	public void returnAsArray() {
		this.flag = 1;
	}
	public void returnAsMatrix() {
		this.flag = 0;
	}
}
