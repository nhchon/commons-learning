package com.axonactive.test;

import java.util.Date;

/**
 * Created by nhchon on 4/5/2017 2:51 PM.
 */
public class DateTimeTest {
    public static void main(String[] args){
        long epoch = 347155199999L;
        Date d = new Date(epoch);

        System.out.println(d.getTime());
    }
}
