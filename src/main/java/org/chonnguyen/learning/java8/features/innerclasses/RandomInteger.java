// RandomInteger.java
package org.chonnguyen.learning.java8.features.innerclasses;

import java.util.Random;

public class RandomInteger {
	protected Random rand = new Random();

	public int getValue() {
		return rand.nextInt();
	}
}
