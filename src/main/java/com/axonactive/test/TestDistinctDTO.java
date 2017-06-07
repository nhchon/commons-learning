/*************************************************************************
 *  Copyright (c) ChonNguyen Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to ChonNguyen Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to ChonNguyen Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from ChonNguyen Incorporated.
 *************************************************************************/
package com.axonactive.test;

import com.axonactive.fs.DistinctByKey;
import com.axonactive.model.PathogenDTO;
import com.axonactive.model.QueryPathogenDTO;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by nhchon on 3/1/2017 10:26 AM.
 */
public class TestDistinctDTO {
    public static void main(String[] args){
        QueryPathogenDTO p1 = new QueryPathogenDTO();
        p1.setName("A");

        QueryPathogenDTO p2 = new QueryPathogenDTO();
        p2.setName("B");

        QueryPathogenDTO p3 = new QueryPathogenDTO();
        p3.setName("B");

        QueryPathogenDTO p4 = new QueryPathogenDTO();
        p4.setName("C");

        QueryPathogenDTO p5 = new QueryPathogenDTO();
        p5.setName("D");

        QueryPathogenDTO p6 = new QueryPathogenDTO();
        p6.setName("C");

        Set<QueryPathogenDTO> queryPathogens = new HashSet<>();
        queryPathogens.add(p1);
        queryPathogens.add(p2);
        queryPathogens.add(p3);
        queryPathogens.add(p4);
        queryPathogens.add(p5);
        queryPathogens.add(p6);

        //System.out.println("size: " + queryPathogens.size());

        queryPathogens.stream().map(QueryPathogenDTO::getName).forEach(x -> {
            //System.out.println(x);
        } );


        //System.out.println("Pathogens received from platform: "  + queryPathogens.parallelStream()
        //        .map(QueryPathogenDTO::getName)
        //        .collect(Collectors.joining(",")));

        List<QueryPathogenDTO> returnedPathogens = queryPathogens.parallelStream().filter(distinctByKey(p -> p.getName()))
                                                            .sorted(Comparator.comparing(QueryPathogenDTO::getName))
                                                            .collect(Collectors.toList());

        //System.out.println("Returned Pathogens: " + returnedPathogens);

        PathogenDTO pDTO1 = new PathogenDTO("A");
        PathogenDTO pDTO2 = new PathogenDTO("B");
        PathogenDTO pDTO3 = new PathogenDTO("B");
        PathogenDTO pDTO4 = new PathogenDTO("C");
        PathogenDTO pDTO5 = new PathogenDTO("D");
        PathogenDTO pDTO6 = new PathogenDTO("E");
        PathogenDTO pDTO7 = new PathogenDTO("E");
        PathogenDTO pDTO8 = new PathogenDTO("F");
        PathogenDTO pDTO9 = new PathogenDTO("G");
        PathogenDTO pDTO10 = new PathogenDTO("G");
        PathogenDTO pDTO11 = new PathogenDTO("G");
        PathogenDTO pDTO12 = new PathogenDTO("H");
        PathogenDTO pDTO13 = new PathogenDTO("H");
        PathogenDTO pDTO14 = new PathogenDTO("E");
        PathogenDTO pDTO15 = new PathogenDTO("E");

        List<PathogenDTO> pathogens = new ArrayList<>();
        pathogens.add(pDTO1);
        pathogens.add(pDTO2);
        pathogens.add(pDTO3);
        pathogens.add(pDTO4);
        pathogens.add(pDTO5);
        pathogens.add(pDTO6);
        pathogens.add(pDTO7);
        pathogens.add(pDTO8);
        pathogens.add(pDTO9);
        pathogens.add(pDTO10);
        pathogens.add(pDTO11);
        pathogens.add(pDTO12);
        pathogens.add(pDTO13);
        pathogens.add(pDTO14);
        pathogens.add(pDTO15);

        List<QueryPathogenDTO> queryPathogens2 = pathogens.parallelStream().filter(new DistinctByKey<PathogenDTO>(p -> p.getName())::filter)
                                                    .sorted(Comparator.comparing(PathogenDTO::getName))
                                                    .map(p -> new QueryPathogenDTO(p.getName()))
                                                    .collect(Collectors.toList());
        System.out.println("Returned Pathogens: " + queryPathogens2);

    }

    public static <T> Predicate<T> distinctByKey(Function<? super T,Object> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static void printL(List<String> list){
        list.forEach(l -> System.out.println(l));
    }
}
