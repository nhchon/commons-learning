// Priced.java
package org.chonnguyen.learning.java8.features.lambda;

public interface Priced {
	default double getPrice() {
		return 1.0;
	}
}
