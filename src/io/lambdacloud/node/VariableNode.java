package io.lambdacloud.node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;

/**
 * VariableNode represents a variable (or a function parameter).
 *
 * @author yueming.liu
 *
 */
public class VariableNode extends ExprNode {
	private String name;
	private Type activeType;
	//Local Variable Table Index for each type of the variable
	private Map<Type, Integer> mapTypeLVTIdx = new LinkedHashMap<Type, Integer>(); 
	
	//Variable Scope Type: 1 parameter; 2 local variable; 3 global (TODO)
	private int varLoc; 
	
	//It is no need to keep a list of values for a VariableNode.
	//What we really need is the type for each assignment statement. 
	//private ArrayList<ExprNode> valueList = new ArrayList<ExprNode>(); 
	
	//Indicate if a function parameter is optional
	//Ignore this flag for local/gobal variables
	private boolean isOptionalParam = false;
	
	public String getName() {
		return name;
	}
	public String getName(String typeDesc) {
		return name+typeDesc.replaceAll("/", "_").replaceAll(";", "").replaceAll("\\[", "_");
	}
	
	/**
	 * Contains the element type of the container types
	 * mainly used for Struct
	 */
	private Map<Type, Map<String, Type>> mapTypeType = new LinkedHashMap<Type, Map<String, Type>>();
	
	/**
	 * Get a list of variable types
	 * @return
	 */
	public ArrayList<String> getVarTypes() {
		ArrayList<String> ret = new ArrayList<String>();
		for(Entry<Type, Integer> e : this.mapTypeLVTIdx.entrySet()) {
			Type ty = e.getKey();
			ret.add(ty.getDescriptor());
		}
		return ret;
	}
	
	public void setLVTIndex(String typeDesc, int idx) {
		this.mapTypeLVTIdx.put(Type.getType(typeDesc), idx);
	}

	public void setLVTIndex(Type type, int idx) {
		this.mapTypeLVTIdx.put(type, idx);
	}
	
	public int getLVTIndex() {
		if(null == this.activeType)
			return Integer.MAX_VALUE;
		return this.mapTypeLVTIdx.get(this.activeType).intValue();
	}
	
	public int getLVTIndex(String typeDesc) {
		return getLVTIndex(Type.getType(typeDesc));
	}
	
	public int getLVTIndex(Type type) {
		Integer idx =  this.mapTypeLVTIdx.get(type);
		if(idx == null) {
			throw new RuntimeException("The variable "+name+" cannot be of type "+type.getDescriptor());
		}
		return idx;
	}
	
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
	 * Create a parameter variable
	 * @param name
	 * @param type 'null' is allowed for type
	 * @return
	 */
	public static VariableNode newParameter(String name, Type type) {
		VariableNode node = new VariableNode();
		node.name = name;
		node.setActiveType(type);
		if(null != type)
			node.mapTypeLVTIdx.put(type, -1);
		node.varLoc = 1;
		return node;
	}
	
	/**
	 * Create a locate variable
	 * @param name
	 * @param type 'null' is allowed for type
	 * @return
	 */
	public static VariableNode newLocalVar(String name, Type type) {
		VariableNode node = new VariableNode();
		node.name = name;
		node.setActiveType(type);
		if(null != type)
			node.mapTypeLVTIdx.put(type, -1);
		node.varLoc = 2;
		return node;
	}
	
	public String toString() {
		String loc = "L";
		if(this.varLoc == 1) loc = "P";
		if(this.isOptionalParam) loc += "?";
		if(this.activeType != null)
			return this.name + ":" + activeType.getDescriptor() + "_" + loc + this.mapTypeLVTIdx.toString();
		else
			return this.name + ":null_" + loc + this.mapTypeLVTIdx.toString();
	}
	
	public void _genCode(MethodGenHelper mg) {
		Type ty = this.getType();
		if(ty != null) {
			mg.visitIntInsn(ty.getOpcode(Opcodes.ILOAD), this.getLVTIndex());
		}
	}

	/**
	 * Set type of the variable.
	 * For a variable with more than one types, this type is set as currently active type
	 * of the variable
	 */
	@Override
	public void setType(Type type) {
		if(null == type) {
			setActiveType(null);
			return;
		}
		Integer idx = this.mapTypeLVTIdx.get(type);
		
		//Clear the map for function arguments since a argument (or parameter) should be 
		//at the very beginning of LVT with the desired type
		//No more than two types are allowed for a argument.
		if(this.isParameter()) {
			this.mapTypeLVTIdx.clear();
		}
		
		if(null == idx) {
			this.mapTypeLVTIdx.put(type, -1); //-1 for undetermined type
		} else {
			this.mapTypeLVTIdx.put(type, idx);
		}
		setActiveType(type);
	}
	
	@Override
	public Type getType(Deque<Object> stack) {
		return this.activeType;
	}
	
	public void setElementType(Type type, String key, Type elementType) {
		Map<String, Type> map = this.mapTypeType.get(type);
		if(null == map) {
			map = new HashMap<String, Type>();
			this.mapTypeType.put(type, map);
		}
		map.put(key, elementType);
	}
	
	public Type getElementType(String key) {
		return this.mapTypeType.get(this.activeType).get(key);
	}

	@Override
	public void updateType(Deque<Object> stack) {
		//Do nothing
	}
	
	public boolean isOptional() {
		return this.isOptionalParam;
	}
	
	public void setOptional(boolean isOptional) {
		this.isOptionalParam = isOptional;
	}
	
	private void setActiveType(Type ty) {
		this.activeType = ty;
	}
	@Override
	public boolean contains(ExprNode target) {
		if(this == target)
			return true;
		return false;
	}
	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
	}
}