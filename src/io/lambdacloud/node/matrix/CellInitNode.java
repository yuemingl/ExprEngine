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
import io.lambdacloud.node.tool.Cell;

/**
 * Copied from MatrixInitNode
 * 
 * The underlining container has class Cell
 * 
 * @author yueming.liu
 *
 */
public class CellInitNode extends ExprNode {
	public List<ExprNode> initExprList = new ArrayList<ExprNode>();
	public List<Integer> colLenList = new ArrayList<Integer>();
	
	public void addInitValues(ExprNode val) {
		initExprList.add(val);
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
			
				//return a Matrix
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
		} else if(eleType.getSort() == Type.DOUBLE || eleType.getSort() == Type.INT) {
			mg.visitTypeInsn(Opcodes.NEW, Tools.getClassNameForASM(Cell.class));
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
			
//			if(colLenList.get(0) == this.initExprList.size())
//				mg.visitLdcInsn(getValidNumberOfElement());
//			else
//				mg.visitLdcInsn(colLenList.get(0));
			
			mg.visitMethodInsn(Opcodes.INVOKESPECIAL, Tools.getClassNameForASM(Cell.class), "<init>", "([D)V", false);
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
		return Type.getType(Cell.class);
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
}
