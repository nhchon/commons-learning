// FieldAccessTest.java
package org.chonnguyen.learning.java8.features.reflection;

import java.lang.reflect.Field;
    
public class FieldAccessTest {
	public static void main(String[] args) {
		Class<PublicPerson> ppClass = PublicPerson.class;
		try {
			// Create an object of PublicPerson class  
			PublicPerson p = ppClass.newInstance();

			// Get the reference of name field  
			Field name = ppClass.getField("name");

			// Get the current value of name field  
			String nameValue = (String) name.get(p);
			System.out.println("Current name is " + nameValue);
			
			// Set the value of name to Ann  
			name.set(p, "Ann");
			
			// Get the new value of name field  
			nameValue = (String) name.get(p);
			System.out.println("New name is " + nameValue);
		}
		catch (InstantiationException | IllegalAccessException | 
		       NoSuchFieldException | SecurityException | 
		       IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
