package io.lambdacloud.node;

import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

import java.util.ArrayList;
import java.util.Deque;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class AssignNode extends BinaryOp {
	public ArrayList<VariableNode> multiAssignVars = new ArrayList<VariableNode>();

	public AssignNode(VariableNode left, ExprNode right) {
		//left.genLoadInsn(true);???
		VariableNode var = left;
////		var.addValue(right);
		
		this.left = var;
		this.right = right;
		//this.right.genLoadInsn(true);???
	}

	public String toString() {
		return left + "=" + right;
	}

	public void genCode(MethodGenHelper mg) {
		VariableNode var = (VariableNode)left;
		
		Type myType = this.getType();
		
		//move this after mg.updateLVTIndex() to handle the case like sum=0; for cond, sum=sum+0.1 end;
		//that is to say, update the type of var first then generate code for RHS
		//right.genCode(mg);
		
		/**
		 *  No need to insert type conversion since the type of var should be the same as the type of right
		 *  We are 'over writing' the type of left. We need call setType of left to indicate 
		 *  that left has the type from right
		 *  for example: "a=1; a=a+1.1;"
		 *   
		 */
		//Tools.insertConversionInsn(mg, right.getType(), left.getType());
		////var.setType(myType); //don't change the type of var, use var.getLVTIndex(myType.getDescriptor()) instead
		var.setType(myType); //we still need to change this since a variable could be assigned to many types
		mg.updateLVTIndex();
		right.genCode(mg);
		
		//Load right node in case of a=b=c;
		if (right instanceof AssignNode) {
			AssignNode r = (AssignNode) right;
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), ((VariableNode)(r.left)).getLVTIndex(myType.getDescriptor()));
		}
		mg.visitIntInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(myType.getDescriptor()));
		
		//Update shadow variables
		ArrayList<String> allTypes = var.getVarTypes();
		if(allTypes.size() > 1) {
			for(String type : allTypes) {
				if(!type.equals(myType.getDescriptor())) {
					
					Type ty = Type.getType(type);
					if(Tools.canTypeConversion(myType, ty)) {
						right.genCode(mg);//if var exists in right, the type of var may be changed. e.g. sum=0; sum=sum+0.1;
						Tools.insertConversionInsn(mg, myType, ty);
						mg.visitIntInsn(ty.getOpcode(Opcodes.ISTORE), var.getLVTIndex(type));
					} else {
						if(ty.getSort() == Type.ARRAY || ty.getSort() == Type.OBJECT) {
							mg.visitInsn(Opcodes.ACONST_NULL);
							mg.visitIntInsn(ty.getOpcode(Opcodes.ISTORE), var.getLVTIndex(type));
						} else {
							mg.visitInsn(Opcodes.ICONST_0);
							Tools.insertConversionInsn(mg, Type.INT_TYPE, ty);
							mg.visitIntInsn(ty.getOpcode(Opcodes.ISTORE), var.getLVTIndex(type));
							
						}
					}
				}
			}
		}
		
		if (genLoadInsn) {
			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
		}
		//[a b c] = [1 2 3]
		if(multiAssignVars.size() > 0) {
			Type typeJamaMatrix =  Type.getType(Jama.Matrix.class);
			if(myType.getDescriptor().equals("[LJama/Matrix;")) {
				for(int i=0; i<this.multiAssignVars.size(); i++) {
					VariableNode v =  this.multiAssignVars.get(i);
					
					//we still need to change this since a variable could be assigned to many types
					v.setType(typeJamaMatrix);
					mg.updateLVTIndex();
					
					mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
					mg.visitLdcInsn(i);
					mg.visitInsn(Opcodes.AALOAD);
					mg.visitIntInsn(Opcodes.ASTORE, v.getLVTIndex(typeJamaMatrix.getDescriptor()));
				}
				
			} else {
				for(int i=0; i<this.multiAssignVars.size(); i++) {
					VariableNode v =  this.multiAssignVars.get(i);
					v.setType(Type.DOUBLE_TYPE);
					
					//we still need to change this since a variable could be assigned to many types
					mg.updateLVTIndex();
					mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
					
					mg.visitLdcInsn(0);
					mg.visitLdcInsn(i);
					mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "get", "(II)D", false);
					mg.visitIntInsn(Type.DOUBLE_TYPE.getOpcode(Opcodes.ISTORE), v.getLVTIndex(Type.DOUBLE_TYPE.getDescriptor()));
				}
			}
		}
	}
	
	public Jama.Matrix test() {
		Jama.Matrix[] m = new Jama.Matrix[10];
		return m[0];
	}
	
	@Override
	public Type getType(Deque<Object> stack) {
		// circle check
		if (stack.contains(this))
			return null;

		stack.push(this);
		//Here we use right.getType() since the type form right will override the type of left
		Type retType = right.getType(stack);
		stack.pop();
		
		//Do we need to update the type of variables in multiple assign here?
		if(multiAssignVars.size() > 0) {
			Type typeJamaMatrix =  Type.getType(Jama.Matrix.class);
			if(retType.getDescriptor().equals("[LJama/Matrix;")) {
				for(int i=0; i<this.multiAssignVars.size(); i++) {
					VariableNode v =  this.multiAssignVars.get(i);
					v.setType(typeJamaMatrix);
				}
			}
		}

		return retType;
	}

	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		right.updateType(stack);
		stack.pop();
		
		if(null == right.getType(stack)) {
			//throw new RuntimeException("Cannot get type for "+right);
			left.setType(null);
		} else {
			Type rType = right.getType(stack);
			left.setType(rType);
			if(multiAssignVars.size() > 0) {
				Type typeJamaMatrix =  Type.getType(Jama.Matrix.class);
				if(rType.getDescriptor().equals("[LJama/Matrix;")) {
					for(int i=0; i<this.multiAssignVars.size(); i++) {
						VariableNode v =  this.multiAssignVars.get(i);
						v.setType(typeJamaMatrix);
					}
				} else {
					for(int i=0; i<this.multiAssignVars.size(); i++) {
						VariableNode v =  this.multiAssignVars.get(i);
						v.setType(Type.DOUBLE_TYPE);
					}
				}

			} 
		}
	}
}
