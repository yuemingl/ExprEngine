package io.lambdacloud.statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import static org.objectweb.asm.Opcodes.*;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class ListComprehensionNode extends ExprNode {
	public ExprNode expression;
	public List<LForNode> forIf = new ArrayList<LForNode>();

	
	public static class LForNode extends ExprNode {
		private Map<String, VariableNode> localVarMap;
		public String varName;
		public ExprNode set;
		public ExprNode exprBody;
		
		public LForNode(String varName, ExprNode set, 
				Map<String, VariableNode> localVarMap) {

			this.type = Type.getType(double[].class);
			
			this.localVarMap = localVarMap;
			this.varName = varName;
			this.set = set;
		}

		@Override
		public void genCode(MethodGenHelper mg) {
			//define a local variable node for this.set
			VariableNode tmpSet = VariableNode.newLocalVar("__tmpSet", set.getType());
			int idx = Tools.getNextIndexLVT(localVarMap, localVarMap, set.getType());
			//For double variable, we need 2 slot in LVT
			//If x has index idx the coming variable should have index idx+2
			tmpSet.idxLVT = idx+1; //????????????
			localVarMap.put(tmpSet.name, tmpSet);

			VariableNode i = VariableNode.newLocalVar("__i", Type.getType(int.class));
			int idxI = Tools.getNextIndexLVT(localVarMap, localVarMap, Type.getType(int.class));
			i.idxLVT = idxI;
			localVarMap.put(i.name, i);

			VariableNode ret = VariableNode.newLocalVar("__ret", Type.getType(double[].class));
			int idxRet = Tools.getNextIndexLVT(localVarMap, localVarMap, Type.getType(double[].class));
			ret.idxLVT = idxRet;
			localVarMap.put(ret.name, ret);

			
			//[x+1 for x in y]
			set.genCode(mg);
			
			//set = y
			mg.visitVarInsn(Opcodes.ASTORE, tmpSet.idxLVT);
			
			//ret = new double[set.length]
			mg.visitVarInsn(ALOAD, tmpSet.idxLVT);
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
			VariableNode x = this.localVarMap.get(varName);
			mg.visitVarInsn(ALOAD, tmpSet.idxLVT);
			mg.visitVarInsn(ILOAD, i.idxLVT);
			mg.visitInsn(tmpSet.getType().getElementType().getOpcode(IALOAD));
			Tools.insertConversionInsn(mg, tmpSet.getType().getElementType(), x.getType());
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
			mg.visitVarInsn(ALOAD, tmpSet.idxLVT);
			mg.visitInsn(ARRAYLENGTH);
			mg.visitJumpInsn(IF_ICMPLT, forBody);
			
			//return ret
			mg.visitVarInsn(ALOAD, ret.idxLVT);
		}
	}
	
	public ListComprehensionNode(Map<String, VariableNode> localVarMap) {
		this.type = Type.getType(double[].class);
	}
	
	public static class LIfNode extends ExprNode {

		@Override
		public void genCode(MethodGenHelper mg) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		forIf.get(0).exprBody = this.expression;
		this.forIf.get(0).genCode(mg);
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
