package org.chonnguyen.learning.test;

import java.math.BigDecimal;

/**
 * Created by nhchon on 5/31/2017 4:21 PM.
 */
public class Item {
    private String name;
    private int qty;
    private BigDecimal price;

    //constructors, getter/setters


    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
