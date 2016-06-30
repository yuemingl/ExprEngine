package io.lambdacloud.statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import static org.objectweb.asm.Opcodes.*;
import org.objectweb.asm.Type;

public class ListComprehensionNode extends ExprNode {
	public ExprNode expression;
	public List<LForNode> forIf = new ArrayList<LForNode>();

	
	public static class LForNode extends ExprNode {
		private Map<String, VariableNode> localVarMap;
		private Map<String, VariableNode> paramMap;
		public String varName;
		public ExprNode set;
		public ExprNode exprBody;
		
		public LForNode(String varName, ExprNode set, 
				Map<String, VariableNode> localVarMap,
				Map<String, VariableNode> paramMap) {

			this.type = Type.getType(double[].class);
			
			this.localVarMap = localVarMap;
			this.paramMap = paramMap;
			this.varName = varName;
			this.set = set;
		}

		@Override
		public void genCode(MethodVisitor mv) {
			//define a local variable node for this.set
			VariableNode tmpSet = new VariableNode("__tmpSet", set.getType());
			int idx = Tools.getNextIndexLVT(localVarMap, paramMap, set.getType());
			//For double variable, we need 2 slot in LVT
			//If x has index idx the coming variable should have index idx+2
			tmpSet.idxLVT = idx+1; //????????????
			localVarMap.put(tmpSet.name, tmpSet);

			VariableNode i = new VariableNode("__i", Type.getType(int.class));
			int idxI = Tools.getNextIndexLVT(localVarMap, paramMap, Type.getType(int.class));
			i.idxLVT = idxI;
			localVarMap.put(i.name, i);

			VariableNode ret = new VariableNode("__ret", Type.getType(double[].class));
			int idxRet = Tools.getNextIndexLVT(localVarMap, paramMap, Type.getType(double[].class));
			ret.idxLVT = idxRet;
			localVarMap.put(ret.name, ret);

			
			//[x+1 for x in y]
			set.genCode(mv);
			
			//set = y
			mv.visitVarInsn(Opcodes.ASTORE, tmpSet.idxLVT);
			
			//ret = new double[set.length]
			mv.visitVarInsn(ALOAD, tmpSet.idxLVT);
			mv.visitInsn(ARRAYLENGTH);
			mv.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(ret.getType()));
			mv.visitVarInsn(ASTORE, ret.idxLVT);
			
			//i=0
			mv.visitInsn(ICONST_0);
			mv.visitVarInsn(ISTORE, i.idxLVT);
			Label forCond = new Label();
			mv.visitJumpInsn(GOTO, forCond);
			Label forBody = new Label();
			mv.visitLabel(forBody);
			
			//x=set[i]
			VariableNode x = this.localVarMap.get(varName);
			mv.visitVarInsn(ALOAD, tmpSet.idxLVT);
			mv.visitVarInsn(ILOAD, i.idxLVT);
			mv.visitInsn(tmpSet.getType().getElementType().getOpcode(IALOAD));
			Tools.insertConversionInsn(mv, tmpSet.getType().getElementType(), x.getType());
			mv.visitIntInsn(x.getType().getOpcode(ISTORE), x.idxLVT);
			
			//ret[i] = x+1
			mv.visitVarInsn(ALOAD, ret.idxLVT);
			mv.visitVarInsn(ILOAD, i.idxLVT);
			this.exprBody.genCode(mv);
			mv.visitInsn(DASTORE); //type???
			
			//i++
			mv.visitIincInsn(i.idxLVT, 1);
			//i<set.length
			mv.visitLabel(forCond);
			mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mv.visitVarInsn(ILOAD, i.idxLVT);
			mv.visitVarInsn(ALOAD, tmpSet.idxLVT);
			mv.visitInsn(ARRAYLENGTH);
			mv.visitJumpInsn(IF_ICMPLT, forBody);
			
			//return ret
			mv.visitVarInsn(ALOAD, ret.idxLVT);
		}
	}
	
	public ListComprehensionNode(Map<String, VariableNode> localVarMap,
			Map<String, VariableNode> paramMap) {
		this.type = Type.getType(double[].class);
	}
	
	public static class LIfNode extends ExprNode {

		@Override
		public void genCode(MethodVisitor mv) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Override
	public void genCode(MethodVisitor mv) {
		forIf.get(0).exprBody = this.expression;
		this.forIf.get(0).genCode(mv);
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
