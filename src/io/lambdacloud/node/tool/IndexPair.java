package io.lambdacloud.node.tool;

import io.lambdacloud.node.ExprNode;

//This is used to efficiently get a sub-matrix
//Using RangeNode needs to generate an intermediate array which is not efficient
public class IndexPair {
	public ExprNode idxS; //start index
	public ExprNode idxE; //end index
	public IndexPair(ExprNode idxS, ExprNode idxE) {
		this.idxE = idxE;
		this.idxS = idxS;
	}
	
	public String toString() {
		if(null == idxE)
			return idxS.toString();
		else
			return idxS+":"+idxE;
	}
}