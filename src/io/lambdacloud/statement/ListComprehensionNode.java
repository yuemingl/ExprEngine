package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARRAYLENGTH;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.DASTORE;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.IALOAD;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.IF_ICMPLT;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.ISTORE;
import static org.objectweb.asm.Opcodes.NEWARRAY;

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
			VariableNode setA = mg.newLocalVariable("set"+seq.getAndIncrement(), set.getType());
			VariableNode i = mg.newLocalVariable("i"+seq.getAndIncrement(), Type.getType(int.class));
			VariableNode ret = mg.newLocalVariable("ret"+seq.getAndIncrement(), Type.getType(double[].class));
			VariableNode x = mg.varMap.get(varName);

			
			//[x+1 for x in setA]
			set.genCode(mg);
			
			//set = y
			mg.visitVarInsn(Opcodes.ASTORE, setA.idxLVT);
			
			//ret = new double[set.length]
			mg.visitVarInsn(ALOAD, setA.idxLVT);
			mg.visitInsn(ARRAYLENGTH);
			mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(ret.getType()));
			mg.visitVarInsn(ASTORE, ret.idxLVT);
			
			//i=0
			mg.visitInsn(ICONST_0);
			mg.visitVarInsn(ISTORE, i.idxLVT);
			Label forCond = new Label();
			mg.visitJumpInsn(GOTO, forCond);
			Label forBody = new Label();
			mg.visitLabel(forBody);
			
			//x=set[i]
			mg.visitVarInsn(ALOAD, setA.idxLVT);
			mg.visitVarInsn(ILOAD, i.idxLVT);
			mg.visitInsn(setA.getType().getElementType().getOpcode(IALOAD));
			Tools.insertConversionInsn(mg, setA.getType().getElementType(), x.getType());
			mg.visitIntInsn(x.getType().getOpcode(ISTORE), x.idxLVT);
			
			//ret[i] = x+1
			mg.visitVarInsn(ALOAD, ret.idxLVT);
			mg.visitVarInsn(ILOAD, i.idxLVT);
			this.exprBody.genCode(mg);
			mg.visitInsn(DASTORE); //type???
			
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
}
