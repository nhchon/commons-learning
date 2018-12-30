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
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * Created by nhchon on 1/19/2018 3:16 PM.
 */
public class EveryNth<C> {

    private final int nth;
    private final List<List<C>> lists = new ArrayList<>();
    private int next = 0;

    private EveryNth(int nth) {
        this.nth = nth;
        IntStream.range(0, nth).forEach(i -> lists.add(new ArrayList<>()));
    }

    private void accept(C item) {
        lists.get(next++ % nth).add(item);
    }

    private EveryNth<C> combine(EveryNth<C> other) {
        other.lists.forEach(l -> lists.get(next++ % nth).addAll(l));
        next += other.next;
        return this;
    }

    private List<C> getResult() {
        return lists.get(0);
    }

    public static Collector<Integer, ?, List<Integer>> collector(int nth) {
        return Collector.of(() -> new EveryNth(nth),
                EveryNth::accept, EveryNth::combine, EveryNth::getResult);
    }
}