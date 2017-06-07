// OuterTest.java
package org.chonnguyen.learning.java8.features.innerclasses;

public class OuterTest {
	public static void main(String[] args) {
		Outer out = new Outer();
		Outer.Inner in = out.new Inner();

		// Print the value 
		out.printValue();
		in.printValue();
		
		// Set a new value 
		out.setValue(828);
		
		// Print the value 
		out.printValue();
		in.printValue();
	}
}
