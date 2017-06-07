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
import com.axonactive.model.PathogenReportsDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhchon on 3/14/2017 9:56 AM.
 */
public class PathogenIntersection {
    public static void main(String[] args){
        List<Pathogen> p = new ArrayList<>();
        p.add(new Pathogen(21343123L, "A"));
        p.add(new Pathogen(3634654L, "B"));
        p.add(new Pathogen(56875686L, "C"));
        p.add(new Pathogen(456456L, "D"));
        p.add(new Pathogen(456456L, "E"));
        p.add(new Pathogen(null, "F"));
        p.add(new Pathogen(3634654L, "G"));
        p.add(new Pathogen(56875686L, "H"));

        List<PathogenDTO> pDTO = new ArrayList<>();
        pDTO.add(new PathogenDTO("C"));//1455032869121
        pDTO.add(new PathogenDTO("D"));
        pDTO.add(new PathogenDTO("G"));
        pDTO.add(new PathogenDTO("S"));
        pDTO.add(new PathogenDTO("Z"));


        //p.stream().a
    }
}
