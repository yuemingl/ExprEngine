package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class ListComprehensionNode extends ExprNode {
	public LForNode forIf;
	public static AtomicInteger seq = new AtomicInteger(); 
	{
		seq.set(0);
	}

	//[x+1 for x in setA]
	public static class LForNode extends ExprNode {
		public String varName;
		public ExprNode set;
		public ExprNode exprBody;
		public VariableNode ret;
		
		public LForNode(String varName, ExprNode set, ExprNode exprBody) {
			this.varName = varName;
			this.set = set;
			this.exprBody = exprBody;
		}

		@Override
		public Type getType() {
			ExprNode bn = this.exprBody;
			while(bn instanceof LForNode) {
				bn = ((LForNode)bn).exprBody;
			}
			return bn.getType();
		}

		@Override
		public void genCode(MethodGenHelper mg) {
			if(null == ret) throw new RuntimeException("The return value need to be set!");
			
			VariableNode setA = mg.newLocalVariable("setA"+seq.getAndIncrement(), set.getType());
			VariableNode i = mg.newLocalVariable("i"+seq.getAndIncrement(), Type.getType(int.class));
			//VariableNode ret = mg.newLocalVariable("ret"+seq.getAndIncrement(), Type.getType(double[].class));
			VariableNode x = mg.varMap.get(varName);

			
			//[x+1 for x in setA]
			set.genCode(mg);
			
			//Declare a local variable setA to keep the set
			mg.visitVarInsn(Opcodes.ASTORE, setA.idxLVT);
			
			//ret = new double[set.length];
//			mg.visitVarInsn(ALOAD, setA.idxLVT);
//			mg.visitInsn(ARRAYLENGTH);
//			mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(ret.getType()));
//			mg.visitVarInsn(ASTORE, ret.idxLVT);
			
			//i = 0;
			mg.visitInsn(ICONST_0);
			mg.visitVarInsn(ISTORE, i.idxLVT);
			Label forCond = new Label();
			mg.visitJumpInsn(GOTO, forCond);
			Label forBody = new Label();
			mg.visitLabel(forBody);
			
			//x = set[i];
			mg.visitVarInsn(ALOAD, setA.idxLVT);
			mg.visitVarInsn(ILOAD, i.idxLVT);
			mg.visitInsn(setA.getType().getElementType().getOpcode(IALOAD));
			Tools.insertConversionInsn(mg, setA.getType().getElementType(), x.getType());
			mg.visitIntInsn(x.getType().getOpcode(ISTORE), x.idxLVT);
			
			//ret[i] = x+1;

			mg.visitVarInsn(ALOAD, ret.idxLVT);
			this.exprBody.genCode(mg);
			if(this.getType().getSort() == Type.DOUBLE) {
				mg.visitMethodInsn(INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;", false);
			} else if(this.getType().getSort() == Type.INT) {
				mg.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
			} else if(this.getType().getSort() == Type.BOOLEAN) {
				mg.visitMethodInsn(INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
			} else {
				//do nothing
			}
			mg.visitMethodInsn(INVOKEINTERFACE, "java/util/List", "add", "(Ljava/lang/Object;)Z", true);
			mg.visitInsn(POP);
			
			//i++
			mg.visitIincInsn(i.idxLVT, 1);
			//i<set.length
			mg.visitLabel(forCond);
			mg.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mg.visitVarInsn(ILOAD, i.idxLVT);
			mg.visitVarInsn(ALOAD, setA.idxLVT);
			mg.visitInsn(ARRAYLENGTH);
			mg.visitJumpInsn(IF_ICMPLT, forBody);
			
			//return ret
			mg.visitVarInsn(ALOAD, ret.idxLVT);
			mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/statement/Tools", "listToDoubleArray", "(Ljava/util/List;)[D", false);
			//mg.visitInsn(POP);
		}
	}
	
	public ListComprehensionNode() {
	}
	
	public static class LIfNode extends ExprNode {
		@Override
		public void genCode(MethodGenHelper mg) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Override
	public Type getType() {
		return Tools.getArrayType(this.forIf.getType());
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		//Define a local variable for the returned value of this list comprehension
		VariableNode ret = mg.newLocalVariable("ret"+seq.getAndIncrement(), Type.getType(List.class));
		mg.visitTypeInsn(NEW, "java/util/ArrayList");
		mg.visitInsn(DUP);
		mg.visitMethodInsn(INVOKESPECIAL, "java/util/ArrayList", "<init>", "()V", false);
		mg.visitVarInsn(ASTORE, ret.idxLVT);
		this.forIf.ret = ret;
		this.forIf.genCode(mg);
	}

	public static int[] test(int[] set) {
		int l = set.length;
		int[] ret = new int[l];
		for(int i=0; i<l; i++) {
			ret[i] = 100+set[i];
		}
		return null;
	}
	public static int[] test2(int[] set) {
		int l = set.length;
		List<Integer> ret = new ArrayList<Integer>();
		for(int i=0; i<l; i++) {
			ret.add(100+set[i]);
		}
		return null;//ret.toArray(new Integer[]{});
	}
}
