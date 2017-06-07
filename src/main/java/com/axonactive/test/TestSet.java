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
