package io.lambdacloud.node;

import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

import java.util.ArrayList;
import java.util.Deque;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.comparion.EQNode;
import io.lambdacloud.node.tool.SimpleAssign;
import io.lambdacloud.util.CSList;
import io.lambdacloud.util.ObjectArray;

public class AssignNode extends BinaryOp {
	public ArrayList<VariableNode> multiAssignVars = new ArrayList<VariableNode>();
	
	//Indicate if the right hand side is a comma-separated list (CSList)
	boolean isCSList = false;
	
	private boolean isUpdatedType = false;

	public AssignNode(VariableNode left, ExprNode right) {
		super(left, right);
	}

	public String toString() {
		return left + "=" + right;
	}
	
	public static Object test2() {
		ObjectArray a = new ObjectArray(1,1);
		return a.getColumnPackedCopy()[0];
	}

	public void _genCode(MethodGenHelper mg) {
		Type myType = this.getType();
		if(null == myType) return;

		VariableNode var = (VariableNode)left;

		if(right.contains(left)) {
			VariableNode flag = mg.newLocalVariable(var.getName()+"_flag_", Type.INT_TYPE);
			mg.updateLVTIndex();
			SimpleAssign flag0 = new SimpleAssign(flag, new ConstantNode(0));
			flag0.genCode(mg);
			
			IfNode ifnode = new IfNode();
			ifnode.condition = new EQNode(flag, new ConstantNode(0));
			ifnode.ifBlockExprs.add(new SimpleAssign(flag, new ConstantNode(1)));
			ifnode.ifBlockExprs.add(new SimpleAssign(var, right));
			if(Tools.canTypeConversion(var.getType(), myType)) { 
				ifnode.elseBlockExprs.add(new SimpleAssign(var, right, myType));
			}
			
			ifnode.genCode(mg);
		} else {
			right.genCode(mg);
			
			var.setType(myType);
			mg.updateLVTIndex();
			
			if (right instanceof AssignNode) {
				AssignNode r = (AssignNode) right;
				mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), ((VariableNode)(r.left)).getLVTIndex(myType.getDescriptor()));
			}
			mg.visitIntInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(myType.getDescriptor()));
		}
		
//		//move this after mg.updateLVTIndex() to handle the case like sum=0; for cond, sum=sum+0.1 end;
//		//that is to say, update the type of var first then generate code for RHS
//		//right.genCode(mg);
//		
//		/**
//		 *  No need to insert type conversion since the type of var should be the same as the type of right
//		 *  We are 'over writing' the type of left. We need call setType of left to indicate 
//		 *  that left has the type from right
//		 *  for example: "a=1; a=a+1.1;"
//		 *   
//		 */
//		//Tools.insertConversionInsn(mg, right.getType(), left.getType());
//		////var.setType(myType); //don't change the type of var, use var.getLVTIndex(myType.getDescriptor()) instead
//		var.setType(myType); //we still need to change this since a variable could be assigned to many types
//		mg.updateLVTIndex();
//
//		//Update the type of var first then generate code for RHS
//		right.genCode(mg);
//
//		if(multiAssignVars.size() > 0) {
//		} else {
//			if(isCSList) {
//				mg.visitLdcInsn(0);
//				mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(CSList.class), 
//						"get", "(I)"+Type.getType(Object.class), false);
//			}
//		}
//		
//		//Load right node in case of a=b=c;
//		if (right instanceof AssignNode) {
//			AssignNode r = (AssignNode) right;
//			mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), ((VariableNode)(r.left)).getLVTIndex(myType.getDescriptor()));
//		}
//		mg.visitIntInsn(myType.getOpcode(Opcodes.ISTORE), var.getLVTIndex(myType.getDescriptor()));
//		
		//Update shadow variables for initialize purpose
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
			//If RHS is an array of Jama.Matrix, assign each element to the variables on the LHS
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
				if(this.isCSList) {
					for(int i=0; i<this.multiAssignVars.size(); i++) {
						VariableNode v =  this.multiAssignVars.get(i);
						
						//we still need to change this since a variable could be assigned to many types
						mg.updateLVTIndex();
						mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
						
						//the first row
						mg.visitLdcInsn(i);
						mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(CSList.class), 
								"get", "(I)"+Type.getType(Object.class), false);
						mg.visitIntInsn(Opcodes.ASTORE, v.getLVTIndex(myType.getDescriptor()));
					}
				} else {
					for(int i=0; i<this.multiAssignVars.size(); i++) {
						VariableNode v =  this.multiAssignVars.get(i);
						v.setType(Type.DOUBLE_TYPE);
						
						//we still need to change this since a variable could be assigned to many types
						mg.updateLVTIndex();
						mg.visitIntInsn(myType.getOpcode(Opcodes.ILOAD), var.getLVTIndex(myType.getDescriptor()));
						
						//the first row
						mg.visitLdcInsn(0);
						mg.visitLdcInsn(i);
						mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "get", "(II)D", false);
						mg.visitIntInsn(Type.DOUBLE_TYPE.getOpcode(Opcodes.ISTORE), v.getLVTIndex(Type.DOUBLE_TYPE.getDescriptor()));
					}
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
		if(!isUpdatedType)
			throw new RuntimeException("updateType() must be called before calling getType()");
		
		// circle check
		if (stack.contains(this))
			return null;
		stack.push(this);

		//Here we use right.getType() since the type form right will override the type of left
		Type retType = right.getType(stack);
		
		//Flag isCSList should be updated in updateType()
		if(this.isCSList) {
			Type t = Type.getType(Object.class);
			
			stack.pop();
			return t;
		}
		
		//We don't need to update the type of variables in multiple assign here (see updateType())
		stack.pop();
		return retType;
	}

	public void updateType(Deque<Object> stack) {
		isUpdatedType = true;
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		
		right.updateType(stack);
		stack.pop();
		
		Type rType = right.getType(stack);
		if(null == rType) {
			//Do nothing if we cannot get the type of right
			//Don't affect the type of left side in this case.
			//example: ???
			//left.setType(null);
		} else { //Update the type of left
			
			//In case of comma-separated list, set Object type for left
			if(rType.equals(Type.getType(CSList.class))) {
				this.isCSList = true;
				Type t = Type.getType(Object.class);
				((VariableNode)left).setType(t);
			} else {
				((VariableNode)left).setType(rType);
			}
			
			//TODO Better way?
			//fix 
			// a  = CSList
			//[a] = CSList
			if(isCSList && this.multiAssignVars.size() == 0) {
				this.multiAssignVars.add((VariableNode)left);
			}
			
			if(multiAssignVars.size() > 0) {
				Type typeJamaMatrix =  Type.getType(Jama.Matrix.class);
				//If RHS is an array of Jama.Matrix, set each variable on LHS to type of Jama.Matrix
				if(rType.equals(Type.getType(Jama.Matrix[].class))) {
					for(int i=0; i<this.multiAssignVars.size(); i++) {
						VariableNode v =  this.multiAssignVars.get(i);
						v.setType(typeJamaMatrix);
					}
				} else {
					if(this.isCSList) {
						for(int i=0; i<this.multiAssignVars.size(); i++) {
							VariableNode v =  this.multiAssignVars.get(i);
							v.setType(Type.getType(Object.class));
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
	
	@Override
	public void updateTree(MethodGenHelper mg) {
		//update tree for the case like
		//aD = aI + 1.5
		if(right.contains(left) && null != this.parent &&
				(this.parent instanceof ForNode ||
				 this .parent instanceof WhileNode) ) {
			Type myType = this.getType();
			if(null == myType) return;

			VariableNode var = (VariableNode)left;

			VariableNode flag = mg.newLocalVariable(var.getName()+"_flag_", Type.INT_TYPE);
			mg.updateLVTIndex();
			SimpleAssign flag0 = new SimpleAssign(flag, new ConstantNode(0));
			
			IfNode ifnode = new IfNode();
			ifnode.condition = new EQNode(flag, new ConstantNode(0));
			ifnode.ifBlockExprs.add(new SimpleAssign(flag, new ConstantNode(1)));
			ifnode.ifBlockExprs.add(new SimpleAssign(var, right));
			if(Tools.canTypeConversion(var.getType(), myType)) { 
				ifnode.elseBlockExprs.add(new SimpleAssign(var, right, myType));
			}
			this.parent.replaceChild(this, ifnode);
			this.parent.insertBefore(flag0);
		}
	}
}
