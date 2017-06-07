// ThreadState.java
package org.chonnguyen.learning.java8.features.threads;

public class ThreadState extends Thread {
	private boolean keepRunning = true;
	private boolean wait = false;
	private Object syncObject = null;

	public ThreadState(Object syncObject) {
		this.syncObject = syncObject;
	}

	public void run() {
		while (keepRunning) {
			synchronized (syncObject) {
				if (wait) {
					try {
						syncObject.wait();
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void setKeepRunning(boolean keepRunning) {
		this.keepRunning = keepRunning;
	}

	public void setWait(boolean wait) {
		this.wait = wait;
	}
}
