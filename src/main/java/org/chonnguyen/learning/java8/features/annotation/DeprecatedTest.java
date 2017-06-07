// DeprecatedTest.java
package org.chonnguyen.learning.java8.features.annotation;

@Deprecated
public class DeprecatedTest {
	private DeprecatedTest() {
	}

	public static DeprecatedTest getInstance() {
		// Using the deprecated class inside its own body
		DeprecatedTest dt = new DeprecatedTest();
		return dt;
	}
}