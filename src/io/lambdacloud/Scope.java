package io.lambdacloud;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.VariableNode;

public class Scope {
	private String name;
	
	public Deque<ExprNode> stack = new LinkedList<ExprNode>();
	
	//Variable map which is generated after parsing
	//Another place is the phase of code generation
	//public SortedMap<String, VariableNode> varMap = new TreeMap<String, VariableNode>();
	public Map<String, VariableNode> varMap = new LinkedHashMap<String, VariableNode>();
	
	public Scope(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
