/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhchon on 1/19/2018 4:16 PM.
 */
public class WorkerThread extends Thread {
    private List<String> l = new ArrayList<>();
    public WorkerThread(List<String> l) {
        this.l = l;
        // When false, (i.e. when it's a user thread),
        // the Worker thread continues to run.
        // When true, (i.e. when it's a daemon thread),
        // the Worker thread terminates when the main
        // thread terminates.
        setDaemon(true);
    }

    public void run() {
        int count = 0;
        System.out.println("Hello from Worker "+count++);
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            // handle exception here
        }

        System.out.println(l.toString());
    }
}
