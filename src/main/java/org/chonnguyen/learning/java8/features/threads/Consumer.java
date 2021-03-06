// Consumer.java
package org.chonnguyen.learning.java8.features.threads;

public class Consumer extends Thread {
	private Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		int data;
		while(true) {
			// Consume the data from the buffer. We are not using the consumed 
			// data for any other puporse here  
			data = buffer.consume();
		}
	}
}
