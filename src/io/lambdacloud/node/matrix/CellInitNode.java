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
			mg.visitMethodInsn(Opcodes.INVOKESPECIAL, Tools.getClassNameForASM(Cell.class), "<init>", "()V", false);
			return;
		}
		
		mg.visitTypeInsn(Opcodes.NEW, Tools.getClassNameForASM(Cell.class));
		mg.visitInsn(DUP);
		
		mg.visitLdcInsn(getValidNumberOfElement()); //size of new array
		mg.visitTypeInsn(ANEWARRAY, "java/lang/Object");
		int idx = 0;
		for (int i = initExprList.size() - 1; i >= 0; i--) {
			if(null == this.initExprList.get(i).getType()) continue;
			mg.visitInsn(DUP);
			mg.visitLdcInsn(idx++);
			initExprList.get(i).genCode(mg);
			Tools.insertConversionInsn(mg, initExprList.get(i).getType(), Type.getType(Object.class));
			mg.visitInsn(Opcodes.AASTORE);
		}
		
		mg.visitMethodInsn(Opcodes.INVOKESPECIAL, Tools.getClassNameForASM(Cell.class), "<init>", "([Ljava/lang/Object;)V", false);
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
	public static void test() {
		Object[] o = new Object[]{1L,2.0,"3",true};
		System.out.println(o);
	}
	/**
	 * 
mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "test", "()V", null, null);
mv.visitCode();
Label l0 = new Label();
mv.visitLabel(l0);
mv.visitLineNumber(116, l0);
mv.visitInsn(ICONST_4);
mv.visitTypeInsn(ANEWARRAY, "java/lang/Object");
mv.visitInsn(DUP);
mv.visitInsn(ICONST_0);
mv.visitInsn(LCONST_1);
mv.visitMethodInsn(INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
mv.visitInsn(AASTORE);
mv.visitInsn(DUP);
mv.visitInsn(ICONST_1);
mv.visitLdcInsn(new Double("2.0"));
mv.visitMethodInsn(INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;", false);
mv.visitInsn(AASTORE);
mv.visitInsn(DUP);
mv.visitInsn(ICONST_2);
mv.visitLdcInsn("3");
mv.visitInsn(AASTORE);
mv.visitInsn(DUP);
mv.visitInsn(ICONST_3);
mv.visitInsn(ICONST_1);
mv.visitMethodInsn(INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
mv.visitInsn(AASTORE);
mv.visitVarInsn(ASTORE, 0);
Label l1 = new Label();
mv.visitLabel(l1);
mv.visitLineNumber(117, l1);
mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
mv.visitVarInsn(ALOAD, 0);
mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/Object;)V", false);
Label l2 = new Label();
mv.visitLabel(l2);
mv.visitLineNumber(118, l2);
mv.visitInsn(RETURN);
Label l3 = new Label();
mv.visitLabel(l3);
mv.visitLocalVariable("o", "[Ljava/lang/Object;", null, l1, l3, 0);
mv.visitMaxs(5, 1);
mv.visitEnd();

	 */
}
