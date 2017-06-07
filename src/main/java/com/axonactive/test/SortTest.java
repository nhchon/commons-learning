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

import org.apache.commons.lang3.StringUtils;

/**
 * Created by nhchon on 3/23/2017 2:00 PM.
 */
public class SortTest {
    public  static void main(String args[]){
        String sort = "";
        System.out.println(ham(sort));

        sort = "cases";
        System.out.println(ham(sort));

        sort = "+a";
        System.out.println(ham(sort));

        sort = "-a";
        System.out.println(ham(sort));
    }

    public static boolean ham(String sort){
        return !(StringUtils.isEmpty(sort) || sort.startsWith("-"));
    }

}
