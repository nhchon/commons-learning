package com.axonactive.fs;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Created by nhchon on 3/1/2017 3:20 PM.
 */
public final class DistinctByKey<T> {
    Map<Object,Boolean> seen = new ConcurrentHashMap<>();
    Function<T,Object> keyExtractor;

    public DistinctByKey(Function<T,Object> ke) {
        this.keyExtractor = ke;
    }

    public boolean filter(T t) {
        return seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
