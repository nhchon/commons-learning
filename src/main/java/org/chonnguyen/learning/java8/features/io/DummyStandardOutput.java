// DummyStandardOutput.java
package org.chonnguyen.learning.java8.features.io;

import java.io.OutputStream;
import java.io.IOException;

public class DummyStandardOutput extends OutputStream {
	public void write(int b) throws IOException {
		// Do not do anything. Swallow whatever is written
	}
}
