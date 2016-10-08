package io.lambdacloud.node.tool;

import java.util.HashMap;

public class Cell extends HashMap<Object, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cell() {
		
	}

	public Cell(double[] data) {
		for(int i=0; i<data.length; i++) {
			this.put(i, data[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
