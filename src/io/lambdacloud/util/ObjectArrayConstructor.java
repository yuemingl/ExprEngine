package io.lambdacloud.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Construct an ObjectArray object from Object(s) and/or ObjectArray(s)
 * 
 * @author yueming.liu
 *
 */
public class ObjectArrayConstructor {
	List<Object> data = new ArrayList<Object>();
	
	public ObjectArrayConstructor() {
	}
	
	public ObjectArrayConstructor add(Object o) {
		this.data.add(o);
		return this;
	}
	
	public ObjectArrayConstructor add(ObjectArray oa) {
		for(Object o : oa.getColumnPackedCopy())
			this.data.add(o);
		return this;
	}
	
	/**
	 * Return ObjectArray type for function return list
	 * @return
	 */
	public ObjectArray getObjectArray() {
		return ObjectArray.newObjectArray(this.data.toArray());
	}
	
	/**
	 * Return CSList for testing function return list
	 * @return
	 */
	public CSList getCSList() {
		return new CSList(this.data.toArray());
	}
}
