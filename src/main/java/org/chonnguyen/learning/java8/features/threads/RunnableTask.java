// RunnableTask.java
package org.chonnguyen.learning.java8.features.threads;

import java.util.Random;

public class RunnableTask implements Runnable {
	private int taskId;
	private int loopCounter; 
	private Random random = new Random();
	
	public RunnableTask(int taskId, int loopCounter) {
		this.taskId = taskId;
		this.loopCounter = loopCounter;
	}

	public void run() {
		for(int i = 1; i <= loopCounter; i++) {
			try {
				int sleepTime = random.nextInt(10) + 1;
				System.out.println("Task #" + this.taskId + " - Iteration #" + i 				  + " is going to sleep for " +  sleepTime + " seconds.");

				Thread.sleep(sleepTime * 1000);
			}
			catch(Exception e) {
				System.out.println("Task #" + this.taskId + 
				                   " has been interrupted.");
				break;
			}
		}
	}
}
