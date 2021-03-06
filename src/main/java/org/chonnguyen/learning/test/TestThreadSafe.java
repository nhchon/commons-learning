package org.chonnguyen.learning.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Asus on 7/7/2017.
 */
public class TestThreadSafe {
    public static void main(String[] args) {
        final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        ExecutorService ex = Executors.newFixedThreadPool(1000);
        for (;;) {
            ex.execute(new Runnable() {
                public void run() {
                    try {
                        f.format(new Date(new Random().nextLong()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                };
            });
        }
    }
}
