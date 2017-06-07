// EchoStdin.java
package org.chonnguyen.learning.java8.features.io;

import java.io.IOException;

public class EchoStdin {
	public static void main(String[] args) throws IOException{
		// Prompt the user to type a message
		System.out.print("Please type a message and press enter: ");

		// Display whatever user types in
		int c = '\n';
		while ((c = System.in.read()) != '\n') {
			System.out.print((char) c);
		}
	}
}
