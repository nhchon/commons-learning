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

import java.util.Arrays;
import java.util.List;

/**
 * Created by nhchon on 1/19/2018 3:17 PM.
 */
public class TestEveryNth {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Anne", "Bill", "Chris", "Dean", "Eve", "Fred", "George");
        //list.stream().parallel().collect(EveryNth.collector(3)).forEach(System.out::println);
    }
}
