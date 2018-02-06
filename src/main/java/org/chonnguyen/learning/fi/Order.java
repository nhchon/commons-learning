/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.fi;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by nhchon on 2/2/2018 2:50 PM.
 */
public class Order {
    List<OrderItem> items;

    public Order(List<OrderItem> orderItems) {
        items = orderItems;
    }

    public void transformAndPrint(
            Transformer<Stream<OrderItem>> transformOrderItems) {

        transformOrderItems.transform(items.stream())
                .forEach(System.out::println);
    }
}
