package io.lambdacloud.util;

import java.util.HashMap;

public class Struct extends HashMap<Object, Object> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Struct() {
		
	}

	public Struct(Object[] data) {
		for(int i=0; i<data.length; i++) {
			this.put(i, data[i]);
		}
	}
	
	public Struct putAll(String keys, Object value) {
		String[] keyList = keys.split("\\.");
		Struct st = this;
		for(int i=0; i<keyList.length-1; i++) {
			Struct o = (Struct)st.get(keyList[i]);
			if(o == null) {
				o = new Struct();
				st.put(keyList[i], o);
			}
			st = o;
		}
		st.put(keyList[keyList.length -1], value);
		return this;
	}

}
