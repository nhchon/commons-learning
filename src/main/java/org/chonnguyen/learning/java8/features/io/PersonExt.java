// PersonExt.java
package org.chonnguyen.learning.java8.features.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class PersonExt implements Externalizable {	
	private String name   = "Unknown";
	private String gender = "Unknown" ;
	private double height = Double.NaN;
	
	// We must define a no-arg constructor for this class. It is 
	// used to construct the object during deserialization process 
	// before the readExternal() method of this class is called
	public PersonExt() {
	}
	
	public PersonExt(String name, String gender, double height) {
		this.name   = name;
		this.gender = gender;
		this.height = height;
	}
	
	// Override the toString() method to return the person description
	public String toString() {
		return "Name: " + this.name + ", Gender: " + this.gender + 
		       ", Height: " + this.height ;   
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// Read name and gender in the same order they were written
		this.name   = in.readUTF();
		this.gender = in.readUTF();		
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		// we write only the name and gender to the stream
		out.writeUTF(this.name);
		out.writeUTF(this.gender);		 
	}
}
