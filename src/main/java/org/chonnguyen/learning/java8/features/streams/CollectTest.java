// CollectTest.java
package org.chonnguyen.learning.java8.features.streams;

import java.util.List;
import java.util.stream.Collectors;

public class CollectTest {
	public static void main(String[] args) {
		List<String> sortedNames = Person.persons()
                                 .stream()
		                                 .map(Person::getName)
		                                 .sorted()
		                                 .collect(Collectors.toList());
		System.out.println(sortedNames);
	}
}
