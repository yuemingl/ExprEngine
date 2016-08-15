package io.lambdacloud.node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;

public class VariableNode extends ExprNode {
	private String name;
	private Type type;
	
	//Local Variable Table Index for each type of the variable
	private HashMap<String, Integer> mapLVTIndex = new HashMap<String, Integer>(); 
	
	//Variable Scope Type: 1 parameter; 2 local variable; 3 global?
	private int varLoc; 
	
	//This is mainly used to carry type info for arrays generated from list comprehension
	//public ExprNode lastValue;
	
	//It is no need to keep a list of values for a VariableNode.
	//What we really need is the type for each assignment 
	
	//private ArrayList<ExprNode> valueList = new ArrayList<ExprNode>(); 
	
	public String getName() {
		return name;
	}
	public String getName(String typeDesc) {
		return name+typeDesc.replaceAll("/", "_").replaceAll(";", "").replaceAll("\\[", "_");
	}
	
	public ArrayList<String> getVarTypes() {
////		this.updateLVTIndex();
		ArrayList<String> ret = new ArrayList<String>();
		ret.addAll(this.mapLVTIndex.keySet());
		return ret;
	}
	
	public void setLVTIndex(String typeDesc, int idx) {
		this.mapLVTIndex.put(typeDesc, idx);
	}
	
	public int getLVTIndex() {
		return this.mapLVTIndex.get(type.getDescriptor());
	}
	
	public int getLVTIndex(String typeDesc) {
		Integer idx =  this.mapLVTIndex.get(typeDesc);
		//if(idx == null || idx == -1) {
		if(idx == null) {
			throw new RuntimeException("The LVT index of "+typeDesc+" is "+idx);
		}
		return idx;
	}
	
//	public void addValue(ExprNode val) {
//		this.valueList.add(val);
//		//We don't need to get type from value when adding value expression to the variable
//		//The type information (mapLVTIndex) can be obtained in the call of updateType()
//		
//		//if(null != val.getType())
//		//	this.mapLVTIndex.put(val.getType().getDescriptor(), -1);
//		//this.type = val.getType();
//	}
	
	public boolean isParameter() {
		return varLoc == 1;
	}
	
	public boolean isLocalVar() {
		return varLoc == 2;
	}
	
	public void setAsParameter() {
		this.varLoc = 1;
	}
	
	public void setAsLocalVar() {
		this.varLoc = 2;
	}
	
	/**
	 * Create a parameter variable in LVT
	 * @param name
	 * @param type 'null' is allowed for type
	 * @return
	 */
	public static VariableNode newParameter(String name, Type type) {
		VariableNode node = new VariableNode();
		node.name = name;
		node.type = type;
		if(null != type)
			node.mapLVTIndex.put(type.getDescriptor(), -1);
		node.varLoc = 1;
		return node;
	}
	
	/**
	 * Create a locate variable in LVT
	 * @param name
	 * @param type 'null' is allowed for type
	 * @return
	 */
	public static VariableNode newLocalVar(String name, Type type) {
		VariableNode node = new VariableNode();
		node.name = name;
		node.type = type;
		if(null != type)
			node.mapLVTIndex.put(type.getDescriptor(), -1);
		node.varLoc = 2;
		return node;
	}
	
	private VariableNode() {
	}
	
//	@Override 
//	public Type getType() {
//		if(null != this.lastValue && this != this.lastValue) {
//			return this.lastValue.getType();
//		} else {
//			return type;
//		}
//	}
	
	public String toString() {
		String loc = "local";
		if(this.varLoc == 1) loc = "param";
		return this.name + ":" + type + ":" + loc + ":" + this.mapLVTIndex.toString();
	}
	
	public void genCode(MethodGenHelper mg) {
		mg.visitIntInsn(getType().getOpcode(Opcodes.ILOAD), this.getLVTIndex());
	}

	@Override
	public void setType(Type type) {
		if(null == type) {
			this.type = null;
			return;
		}
		Integer idx = this.mapLVTIndex.get(type.getDescriptor());
		//Clear the map for function parameter since arguments should be at the beginning of LVT with write type
		//no other types are needed.
		if(this.isParameter()) {
			this.mapLVTIndex.clear();
		}
		if(null == idx) {
			this.mapLVTIndex.put(type.getDescriptor(), -1);
		} else {
			this.mapLVTIndex.put(type.getDescriptor(), idx);
		}
		this.type = type;
	}

	@Override
	public Type getType(Deque<Object> stack) {
//		/////////////Use this to avoid fixType() call
//		if(null != this.lastValue)
//			return this.lastValue.getType(stack);
//		///////////////////////////////
		return this.type;
	}

	@Override
	public void updateType(Deque<Object> stack) {
//		if(null != this.lastValue)
//			this.lastValue.fixType(stack);
//		
//		throw new RuntimeException("This is deprecated");
	}
	
//	public void updateLVTIndex() {
//		for(ExprNode expr : this.valueList) {
//			Type ty = expr.getType();
//			Integer idx = this.mapLVTIndex.get(ty.getDescriptor());
//			if(null == idx)
//				this.mapLVTIndex.put(ty.getDescriptor(), -1);
//		}
//	}
}