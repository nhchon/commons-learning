package com.axonactive.test;

import java.util.*;

/**
 * Created by nhchon on 4/5/2017 2:51 PM.
 */
public class DateTimeTest {
    public static void main(String[] args){
        long epoch = 347155199999L;
        Date d = new Date(epoch);

        System.out.println(d.getTime());

        Map<String, List<String>> dateFieldAndPatterns = new HashMap<>();
        String field = "a";
        String format = "xxx";
        List<String> patterns = dateFieldAndPatterns.getOrDefault(field, new ArrayList<>());
        if (patterns.isEmpty()) {
            patterns.add(format);
            dateFieldAndPatterns.put(field, patterns);
        }
        else {
            patterns.add(format);
        }

        patterns.add("yyyy");
        List<String> patterns2 = dateFieldAndPatterns.get(field);
        System.out.println(patterns2);
        System.out.println(patterns);
        System.out.println(patterns.equals(patterns2));


        Byte b = new Byte("1");
        Integer i = new Integer("1");
        Long l = new Long("1");
        Float f = new Float("1");
        Double aDouble = new Double("1");

        if (b instanceof Number) {
            System.out.println("b is geonameId");
        }
        if (i instanceof Number) {
            System.out.println("i is geonameId");
        }
        if (l instanceof Number) {
            System.out.println("l is geonameId");
        }
        if (f instanceof Number) {
            System.out.println("f is geonameId");
        }
        if (aDouble instanceof Number) {
            System.out.println("d is geonameId");
        }
    }
}
