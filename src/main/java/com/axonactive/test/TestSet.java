package com.axonactive.test;

import com.axonactive.model.QueryPathogenDTO;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nhchon on 3/8/2017 1:48 PM.
 */
public class TestSet {
    public static void main(String[] args){

        QueryPathogenDTO q1 = new QueryPathogenDTO();
        q1.setName("A");

        QueryPathogenDTO q2 = new QueryPathogenDTO();
        q2.setName("A");

        System.out.println(q1.equals(q2));

        Set<QueryPathogenDTO> set = new HashSet<>();
        set.add(q1);
        set.add(q2);

        System.out.println("Set length: " + set.size());
    }
}
