// DefaultException.java
package org.chonnguyen.learning.java8.features.annotation;

public class DefaultException extends java.lang.Throwable {
	public DefaultException() {
	}

	public DefaultException(String msg) {
		super(msg);
	}
}
