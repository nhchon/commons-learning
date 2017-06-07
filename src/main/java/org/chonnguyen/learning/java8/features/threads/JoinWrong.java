// JoinWrong.java 
package org.chonnguyen.learning.java8.features.threads;

public class JoinWrong {
	public static void main(String[] args) {
		Thread t1 = new Thread(JoinWrong::print);
		t1.start();
		System.out.println("We are done.");
	}

	public static void print() {
		for (int i = 1; i <= 5; i++) {
			try {
				System.out.println("Counter: " + i);
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
