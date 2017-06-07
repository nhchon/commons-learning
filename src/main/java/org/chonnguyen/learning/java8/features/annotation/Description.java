// Description.java
package org.chonnguyen.learning.java8.features.annotation;

public @interface Description {
	Name name();
	Version version();
	String comments() default "";
}
