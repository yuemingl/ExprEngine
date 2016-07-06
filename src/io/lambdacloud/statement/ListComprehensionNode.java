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
	public LForNode forNode;
	public static AtomicInteger seq = new AtomicInteger(); 
	{
		seq.set(0);
	}

	//For node in list comprehension: [exprNode for varName in setNode]
	//for example: [x+1 for x in setA]
	public static class LForNode extends ExprNode {
		public String varName;
		public ExprNode setNode;
		public ExprNode exprNode;
		
		public LForNode(String varName, ExprNode setNode, ExprNode exprBody) {
			this.varName = varName;
			this.setNode = setNode;
			this.exprNode = exprBody;
		}

		@Override
		public Type getType() {
			ExprNode bn = this.exprNode;
			while(bn instanceof LForNode) {
				bn = ((LForNode)bn).exprNode;
			}
			return bn.getType();
		}

		@Override
		public void genCode(MethodGenHelper mg) {
			if(null == mg.retNodeTag) 
				throw new RuntimeException("The return node of list comprehension "+this.toString()+"is null!");
			
			/**
			 * Generate code for range() in list comprehension
			 * [x*2 for x in range(s,e)]
			 * ==>
			 * List<ElementType> ret = new ArrayList<ElementType>();
			 * for(int x=s; x<s; x++) {
			 *   ret.add(x*2);
			 * }
			 * return ret;
			 */
			if(setNode instanceof RangeNode) {
				VariableNode x = mg.varMap.get(varName);
				x.setType(Type.getType(int.class));
				
				RangeNode range = (RangeNode)setNode;
				//x = s;
				range.genStartCode(mg);
				mg.visitVarInsn(ISTORE, x.idxLVT);
				
				//Label in 'for(;*HERE*;)'
				Label forCond = new Label();
				mg.visitJumpInsn(GOTO, forCond);
				
				//Label in 'for(;;) { *HERE* }'
				Label forBody = new Label();
				mg.visitLabel(forBody);

				//for body
				//ret.add(x+1);
				//Pass ret to inner loop
				Label iInc = new Label();
				if(this.exprNode instanceof LForNode) {
					this.exprNode.genCode(mg); //Generate code for exprNode
				} else if(this.exprNode instanceof LIfNode){
					mg.labelForIncStackTag.push(iInc);
					this.exprNode.genCode(mg); //Generate code for exprNode
				} else {
					mg.visitIntInsn(ALOAD, mg.retNodeTag.idxLVT);
					this.exprNode.genCode(mg); //Generate code for exprNode
					if(this.getType().getSort() == Type.DOUBLE) {
						mg.visitMethodInsn(INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;", false);
					} else if(this.getType().getSort() == Type.INT) {
						mg.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
					} else if(this.getType().getSort() == Type.LONG) {
						mg.visitMethodInsn(INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
					} else if(this.getType().getSort() == Type.BOOLEAN) {
						mg.visitMethodInsn(INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
					} else {
						//do nothing
					}
					mg.visitMethodInsn(INVOKEINTERFACE, "java/util/List", "add", "(Ljava/lang/Object;)Z", true);
					mg.visitInsn(POP);
				}				
				
				//i++
				mg.visitLabel(iInc);
				mg.visitIincInsn(x.idxLVT, 1);
				//i<set.length
				mg.visitLabel(forCond);
				mg.visitVarInsn(ILOAD, x.idxLVT);
				range.genEndCode(mg);
				mg.visitJumpInsn(IF_ICMPLT, forBody);
				
				
				return;
			}
			
			
			VariableNode setA = mg.newLocalVariable("setA"+seq.getAndIncrement(), setNode.getType());
			VariableNode i = mg.newLocalVariable("i"+seq.getAndIncrement(), Type.getType(int.class));
			VariableNode x = mg.varMap.get(varName);
			//x is set to double by default. The type of x is corrected here.
			x.setType(setA.getType().getElementType());
			
			//[x+1 for x in setA]
			setNode.genCode(mg);
			//Declare a local variable setA to keep the evaluation of the set
			mg.visitVarInsn(Opcodes.ASTORE, setA.idxLVT);
			
			//i = 0;
			mg.visitInsn(ICONST_0);
			mg.visitVarInsn(ISTORE, i.idxLVT);
			
			//Label in 'for(;*HERE*;)'
			Label forCond = new Label();
			mg.visitJumpInsn(GOTO, forCond);
			
			//Label in 'for(;;) { *HERE* }'
			Label forBody = new Label();
			mg.visitLabel(forBody);
			
			//x = setA[i];
			mg.visitVarInsn(ALOAD, setA.idxLVT);
			mg.visitVarInsn(ILOAD, i.idxLVT);
			mg.visitInsn(setA.getType().getElementType().getOpcode(IALOAD));
			Tools.insertConversionInsn(mg, setA.getType().getElementType(), x.getType());
			mg.visitIntInsn(x.getType().getOpcode(ISTORE), x.idxLVT);
			
			//ret.add(x+1);
			//Pass ret to inner loop
			Label iInc = new Label();
			if(this.exprNode instanceof LForNode) {
				this.exprNode.genCode(mg); //Generate code for exprNode
			} else if(this.exprNode instanceof LIfNode){
				mg.labelForIncStackTag.push(iInc);
				this.exprNode.genCode(mg); //Generate code for exprNode
			} else {
				mg.visitIntInsn(ALOAD, mg.retNodeTag.idxLVT);
				this.exprNode.genCode(mg); //Generate code for exprNode
				if(this.getType().getSort() == Type.DOUBLE) {
					mg.visitMethodInsn(INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;", false);
				} else if(this.getType().getSort() == Type.INT) {
					mg.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
				} else if(this.getType().getSort() == Type.LONG) {
					mg.visitMethodInsn(INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
				} else if(this.getType().getSort() == Type.BOOLEAN) {
					mg.visitMethodInsn(INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
				} else {
					//do nothing
				}
				mg.visitMethodInsn(INVOKEINTERFACE, "java/util/List", "add", "(Ljava/lang/Object;)Z", true);
				mg.visitInsn(POP);
			}
			
			//i++
			mg.visitLabel(iInc);
			mg.visitIincInsn(i.idxLVT, 1);
			//i<set.length
			mg.visitLabel(forCond);
			mg.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mg.visitVarInsn(ILOAD, i.idxLVT);
			mg.visitVarInsn(ALOAD, setA.idxLVT);
			mg.visitInsn(ARRAYLENGTH);
			mg.visitJumpInsn(IF_ICMPLT, forBody);
			
		}
		public String toString() {
			return "[ "+this.exprNode+" for "+this.varName+" in "+this.setNode+" ]";
		}
	}
	
	public ListComprehensionNode() {
	}
	
	//[expression for varName in set if logic_expression]
	public static class LIfNode extends ExprNode {
		public ExprNode condExpr;
		public ExprNode bodyExpr;
		
		public LIfNode(ExprNode condExpr, ExprNode bodyExpr) {
			this.condExpr = condExpr;
			this.bodyExpr = bodyExpr;
		}
		
		@Override
		public void genCode(MethodGenHelper mg) {
			
			this.condExpr.genCode(mg);
			mg.visitJumpInsn(Opcodes.IFEQ, mg.labelForIncStackTag.pop());
			
			if(this.bodyExpr instanceof LForNode) {
				this.bodyExpr.genCode(mg); //Generate code for exprNode
			} else if(this.bodyExpr instanceof LIfNode){
				throw new RuntimeException();
			} else {
				mg.visitIntInsn(ALOAD, mg.retNodeTag.idxLVT);
				this.bodyExpr.genCode(mg); //Generate code for exprNode
				if(this.getType().getSort() == Type.DOUBLE) {
					mg.visitMethodInsn(INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;", false);
				} else if(this.getType().getSort() == Type.INT) {
					mg.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
				} else if(this.getType().getSort() == Type.LONG) {
					mg.visitMethodInsn(INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
				} else if(this.getType().getSort() == Type.BOOLEAN) {
					mg.visitMethodInsn(INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
				} else {
					//do nothing
				}
				mg.visitMethodInsn(INVOKEINTERFACE, "java/util/List", "add", "(Ljava/lang/Object;)Z", true);
				mg.visitInsn(POP);
			}
		}
		
		public String toString() {
			return "if("+this.condExpr+") { "+this.bodyExpr+" }";
		}
		
		@Override
		public Type getType() {
			//return Tools.getArrayType(this.forIf.getType());
			return this.bodyExpr.getType();
		}
		
	}
	
	@Override
	public Type getType() {
		//return Tools.getArrayType(this.forIf.getType());
		return Type.getType(List.class);
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		//Define a local variable for the returned value of this list comprehension
		VariableNode ret = mg.newLocalVariable("ret"+seq.getAndIncrement(), Type.getType(List.class));
		
		//List ret = new ArrayList();
		mg.visitTypeInsn(NEW, "java/util/ArrayList");
		mg.visitInsn(DUP);
		mg.visitMethodInsn(INVOKESPECIAL, "java/util/ArrayList", "<init>", "()V", false);
		mg.visitVarInsn(ASTORE, ret.idxLVT);
		
		//Gen code for 'forIf' by providing the return list 'ret'
		mg.retNodeTag = ret;
		this.forNode.genCode(mg);
		
		//return list directly (ret)
		mg.visitVarInsn(ALOAD, ret.idxLVT);
		//return primitive array from ret
//		if(getType().getElementType().getSort() == Type.DOUBLE)
//			mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/statement/Tools", "listToDoubleArray2", "(Ljava/util/List;)[[D", false);
//			//mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/statement/Tools", "listToDoubleArray", "(Ljava/util/List;)[D", false);
//		else if(getType().getElementType().getSort() == Type.BOOLEAN)
//			mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/statement/Tools", "listToIntegrArray", "(Ljava/util/List;)[I", false);
//		else if(getType().getElementType().getSort() == Type.INT)
//			mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/statement/Tools", "listToBooleanArray", "(Ljava/util/List;)[Z", false);
//		else
//			mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/statement/Tools", "listToObjectArray", "(Ljava/util/List;)[A", false);
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
			if(set[i] > 4.0)
			ret.add(100+set[i]);
		}
		return null;//ret.toArray(new Integer[]{});
	}
	
	public String toString() {
		return this.forNode.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(Type.getType(double[][][].class).getElementType());
	}
}
