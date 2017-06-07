/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package com.axonactive.test;

import com.axonactive.model.Name;
import com.axonactive.model.PathogenDTO;
import com.axonactive.model.QueryPathogenDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nhchon on 3/17/2017 8:37 AM.
 */
public class SortPathogenDTOByName {
    public static void main(String[] args){

        List<QueryPathogenDTO> l = new ArrayList<>();

        l.add(new QueryPathogenDTO("ABC02"));
        l.add(new QueryPathogenDTO("ABC01"));
        l.add(new QueryPathogenDTO("ABC03"));
        l.add(new QueryPathogenDTO("ABC04"));
        l.add(new QueryPathogenDTO("ABC06"));
        l.add(new QueryPathogenDTO("ABC05"));
        l.add(new QueryPathogenDTO("ABC08"));
        l.add(new QueryPathogenDTO("ABC09"));
        l.add(new QueryPathogenDTO("ABC10"));
        l.add(new QueryPathogenDTO("ABC15"));
        l.add(new QueryPathogenDTO("ABC12"));
        l.add(new QueryPathogenDTO("ABC11"));
        l.add(new QueryPathogenDTO("ABC14"));
        l.add(new QueryPathogenDTO("ABC16"));
        l.add(new QueryPathogenDTO("ABC26"));
        l.add(new QueryPathogenDTO("ABC25"));
        l.add(new QueryPathogenDTO("ABC22"));
        l.add(new QueryPathogenDTO("ABC29"));

        Comparator<QueryPathogenDTO> comparName = (q1, q2) -> {
            return q1.getName().compareTo(q2.getName());
        };

        Comparator<QueryPathogenDTO> comparator = Comparator.comparing(person -> person.getName());

        Set<Name> lName = l.stream().sorted(comparator).map(q -> new Name(q.getName())).collect(Collectors.toSet());

        System.out.println(lName);

        // Code's Tien


    }
}
