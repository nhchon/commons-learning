// WrongSoftRef.java
package org.chonnguyen.learning.java8.features.gc;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class WrongSoftRef {
	public static void main(String[] args) {
		// Create a big object with an id 101 for caching
		BigObject bigObj = new BigObject(101);
				
		// Wrap soft reference inside a soft reference
		SoftReference<BigObject> sr = new SoftReference<BigObject>(bigObj);
		
		// Let us try to create many big objects storing their 
		// references in an array list, just to use up big memory.
		ArrayList<BigObject> bigList = new ArrayList<BigObject>();
		long counter = 102;
		while (true) {
			bigList.add(new BigObject(counter++) );
		}
	}
}