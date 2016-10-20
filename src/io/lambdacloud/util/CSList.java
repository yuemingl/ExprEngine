package io.lambdacloud.util;

/**
 * Comma-separated list
 * 
 * @author yueming.liu
 *
 */
public class CSList {
	Object[] data;
	public CSList(Object[] data) {
		this.data = data;
	}
	
	public Object get(int i) {
		return data[i];
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<data.length-1; i++) {
			sb.append(data[i]).append(", ");
		}
		if(data.length > 0)
			sb.append(data[data.length-1]);
		return sb.toString();
	}
}
