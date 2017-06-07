package com.axonactive.test;

import com.axonactive.model.Pathogen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhchon on 3/8/2017 3:31 PM.
 */
public class DistinctByCondition {
    public static void main(String[] args){
        List<Pathogen> l = new ArrayList<>();
        l.add(new Pathogen(21343123L, "A"));
        l.add(new Pathogen(3634654L, "A"));
        l.add(new Pathogen(56875686L, "B"));
        l.add(new Pathogen(456456L, "C"));
        l.add(new Pathogen(456456L, "D"));
        l.add(new Pathogen(null, "D"));
        l.add(new Pathogen(3634654L, "E"));
        l.add(new Pathogen(56875686L, "E"));
        l.add(new Pathogen(234234L, "F"));
        l.add(new Pathogen(234234L, "G"));


    }
}
