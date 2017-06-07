// NotSerializable.java
package org.chonnguyen.learning.java8.features.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class NotSerializable implements Serializable {
	private void readObject(ObjectInputStream ois) 
			throws IOException, ClassNotFoundException {
		// Throw an exception
		throw new IOException("Not meant for serialization!!!");
	}

	private void writeObject(ObjectOutputStream os) throws IOException { 
		// Throw an exception
		throw new IOException("Not meant for serialization!!!");
	}

	// Other code for the class goes here
}
