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

/**
 * Created by nhchon on 2/2/2018 2:49 PM.
 */
public class OrderItem {
    private final int id;
    private final int price;

    public OrderItem(int theId, int thePrice) {
        id = theId;
        price = thePrice;
    }

    public int getId() { return id; }
    public int getPrice() { return price; }

    public String toString() { return String.format("id: %d price: %d", id, price); }
}
