package com.axonactive.test;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by nhchon on 3/23/2017 2:00 PM.
 */
public class SortTest {
    public  static void main(String args[]){
        String sort = "";
        System.out.println(ham(sort));

        sort = "cases";
        System.out.println(ham(sort));

        sort = "+a";
        System.out.println(ham(sort));

        sort = "-a";
        System.out.println(ham(sort));
    }

    public static boolean ham(String sort){
        return !(StringUtils.isEmpty(sort) || sort.startsWith("-"));
    }

}
