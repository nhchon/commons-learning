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
