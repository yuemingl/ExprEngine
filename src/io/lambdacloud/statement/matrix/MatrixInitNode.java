package io.lambdacloud.statement.matrix;

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
import io.lambdacloud.statement.ExprNode;
import io.lambdacloud.statement.Tools;

public class MatrixInitNode extends ExprNode {
	public List<ExprNode> init = new ArrayList<ExprNode>();
	public int rows = 0;
	
	//Construct a matrix from a one-dimensional packed array
	public MatrixInitNode(int rows) {
		this.rows = rows;
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

	@Override
	public void genCode(MethodGenHelper mg) {
		mg.visitTypeInsn(Opcodes.NEW, "Jama/Matrix");
		mg.visitInsn(DUP);

		mg.visitLdcInsn(init.size());

		Type eleType = init.get(0).getType();
		if (init.size() > 1) {
			for (int i = 1; i < init.size(); i++)
				eleType = Tools.typeConversion(eleType, init.get(i).getType());
		}
		if (eleType.getSort() == Type.OBJECT || eleType.getSort() == Type.ARRAY) {
			mg.visitTypeInsn(ANEWARRAY, eleType.getInternalName());
		} else {
			eleType = Type.DOUBLE_TYPE;
			mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(Type.DOUBLE_TYPE, false));
		}
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
		mg.visitLdcInsn(rows);
		mg.visitMethodInsn(Opcodes.INVOKESPECIAL, "Jama/Matrix", "<init>", "([DI)V", false);
		mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "transpose", "()LJama/Matrix;", false);
		
		
	}

	public String toString() {
		return this.init.toString();
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.getType(Jama.Matrix.class);
	}
}
