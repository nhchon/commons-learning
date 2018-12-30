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
public class DaemonTest {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("a");
        test.add("b");
        test.add("c");
        new WorkerThread(test).start();

//        try {
//            Thread.sleep(7500);
//        } catch (InterruptedException e) {
//            // handle here exception
//        }
//
        test.clear();
        System.out.println("Main Thread ending") ;
    }
}
