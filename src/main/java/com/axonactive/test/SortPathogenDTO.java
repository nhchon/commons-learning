package com.axonactive.test;

import com.axonactive.model.PathogenDTO;
import com.axonactive.model.PathogenReportsDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nhchon on 1/24/2017.
 */
public class SortPathogenDTO {

    public static void main(String[] args){

        List<PathogenDTO> l = new ArrayList<>();
        l.add(new PathogenDTO(null, null, null));//1455032869121
        l.add(new PathogenDTO("", null, null));
        l.add(new PathogenDTO("1455032869", null, new PathogenReportsDTO()));
        l.add(new PathogenDTO("1464711447711", null, null));
        l.add(new PathogenDTO("1455032869121", null, new PathogenReportsDTO()));

        /** sort */
        //
        List<String> bIds = l.stream().map(PathogenDTO::getBatchId).collect(Collectors.toList());
        // get max length of batchId
        int maxLength = Collections.max(bIds, Comparator.comparing(s -> (s == null ? 0: s.length()))).length();

        //System.out.println(maxLength);
        //System.out.println("".length());
        //System.out.println(StringUtils.leftPad("1455032869", maxLength, '0'));

        Comparator<PathogenDTO> sortByIsPrimary = (pathogen1, pathogen2) -> {
            String b1 = pathogen1.getBatchId();
            String b2 = pathogen2.getBatchId();

            if(b1 == null) return Integer.MAX_VALUE;
            if(b2 == null) return Integer.MIN_VALUE;

            if(b1.length() < maxLength) b1 = StringUtils.leftPad(b1, maxLength, '0');
            if(b2.length() < maxLength) b2 = StringUtils.leftPad(b2, maxLength, '0');

            // BatchId_1 > BatchId_2
            if(b1.compareTo(b2) > 0 ) return Integer.MIN_VALUE;

            // BatchId_1 < BatchId_2
            if(b1.compareTo(b2) < 0 ) return Integer.MAX_VALUE;

            // BatchId_1 == BatchId_2
            if(b1.compareTo(b2) == 0){
                if (Boolean.TRUE.equals(pathogen1.getPrimary())) return Integer.MIN_VALUE;
                if (Boolean.TRUE.equals(pathogen2.getPrimary())) return Integer.MAX_VALUE;
            }

            return Integer.MAX_VALUE;
        };

        //l.sort(Comparator.comparing(PathogenDTO::getBatchId).reversed().thenComparing(PathogenDTO::getPrimary));
        //l.sort(Comparator.comparing(PathogenDTO::getBatchId, Comparator.nullsLast(Comparator.naturalOrder())).reversed().thenComparing//(PathogenDTO::getPrimary,  Comparator.nullsLast(Comparator.naturalOrder())));

        //l = l.stream().sorted(sortByIsPrimary).collect(Collectors.toList());

        l.stream().filter(p -> p.getPrimary() == true).findFirst().ifPresent(value -> {
            System.out.println("value == null: " + (value==null));
        });

        System.out.println(l);

        System.out.println(null == Boolean.TRUE);

        //System.out.println(null == true);

        //System.out.println(true == null);
    }
}
