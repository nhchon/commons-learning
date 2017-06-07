// SynchronizedCounter.java
package org.chonnguyen.learning.java8.features.threads;

public class SynchronizedCounter {
	private long value;
	
	public synchronized long next() {
		return ++value;
	}
}
