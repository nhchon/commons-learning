// ChangeLogs.java
package org.chonnguyen.learning.java8.features.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ChangeLogs {
	ChangeLog[] value();
}
