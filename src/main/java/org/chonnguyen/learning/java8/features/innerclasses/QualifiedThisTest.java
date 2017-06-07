// QualifiedThisTest.java
package org.chonnguyen.learning.java8.features.innerclasses;

public class QualifiedThisTest {
	public static void main(String[] args) {
		QualifiedThis qt = new QualifiedThis();
		System.out.println("printValue():");
		qt.printValue();

		System.out.println("\nprintHiddenValue():");
		qt.printHiddenValue();
	}
}
