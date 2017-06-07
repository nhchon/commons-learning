// CatchAllThreadExceptionHandler.java
package org.chonnguyen.learning.java8.features.threads;

public class CatchAllThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Caught Exception from Thread:" + t.getName());
    }
}
