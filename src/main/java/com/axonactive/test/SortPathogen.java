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

import com.axonactive.model.Pathogen;
import com.axonactive.model.PathogenDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nhchon on 2/7/2017 1:34 PM.
 */
public class SortPathogen {
    public static void main(String[] args) {

        List<Pathogen> l = new ArrayList<>();
        l.add(new Pathogen(21343123L, false));
        l.add(new Pathogen(3634654L, false));
        l.add(new Pathogen(56875686L, false));
        l.add(new Pathogen(456456L, false));
        l.add(new Pathogen(456456L, true));
        l.add(new Pathogen(null, true));
        l.add(new Pathogen(3634654L, true));
        l.add(new Pathogen(56875686L, false));
        //l.add(new Pathogen(234234L, true));
        //l.add(new Pathogen(234234L, false));

        // Sort Pathogen by batchId
        Comparator<Pathogen> sortByBatchId = (pathogen1, pathogen2) -> {
            Long b1 = pathogen1.getBatchId();
            Long b2 = pathogen2.getBatchId();

            // check null
            if(b1 == null) return Integer.MAX_VALUE;
            if(b2 == null) return Integer.MIN_VALUE;

            if(b1.compareTo(b2)==0){
                if (Boolean.TRUE.equals(pathogen1.getPrimary())) return Integer.MIN_VALUE;
                if (Boolean.TRUE.equals(pathogen2.getPrimary())) return Integer.MAX_VALUE;
            }

            return b2.compareTo(b1);
        };

        l = l.stream().sorted(sortByBatchId).collect(Collectors.toList());
        //l.sort(Comparator.comparing(Pathogen::getBatchId).reversed().thenComparing(Pathogen::getPrimary));

        System.out.println(l);
    }
}
