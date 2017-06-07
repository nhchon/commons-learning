// HelloAnonymous.java
package org.chonnguyen.learning.java8.features.innerclasses;

public class HelloAnonymous {
	public static void main(String[] args) {
		new Object() {
			// An instance initializer 
			{
				System.out.println ("Hello from an anonymous class.");
			}
		}; // A semi-colon is necessary to end the statement 
	}
}
