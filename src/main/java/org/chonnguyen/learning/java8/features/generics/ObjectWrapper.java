// ObjectWrapper.java
package org.chonnguyen.learning.java8.features.generics;

public class ObjectWrapper {
	private Object ref;

	public ObjectWrapper(Object ref) {
		this.ref = ref;
	}

	public Object get() {
		return ref;
	}

	public void set(Object reference) {
		this.ref = ref;
	}
}
