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

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * Created by nhchon on 2/2/2018 2:51 PM.
 */
public class Sample {
    public static void main(String[] args) {
        Order order = new Order(Arrays.asList(
                new OrderItem(1, 1225),
                new OrderItem(2, 983),
                new OrderItem(3, 1554)
        ));


        order.transformAndPrint(orderItems -> orderItems.sorted(comparing(OrderItem::getPrice)));
    }
}
