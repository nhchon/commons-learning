/*************************************************************************
 *  Copyright (c) ChonNguyen Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to ChonNguyen Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to ChonNguyen Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from ChonNguyen Incorporated.
 *************************************************************************/
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
