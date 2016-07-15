package io.lambdacloud;

import java.util.Deque;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;

import io.lambdacloud.statement.ExprNode;
import io.lambdacloud.statement.VariableNode;

public class Scope {
	private String name;
	
	public Deque<ExprNode> stack = new LinkedList<ExprNode>();
	
	//Variable map which is generated after parsing
	//Another place is the phase of code generation
	public SortedMap<String, VariableNode> varMap = new TreeMap<String, VariableNode>();
	
	public Scope(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
