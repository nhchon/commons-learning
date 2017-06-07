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

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by nhchon on 2/7/2017 2:27 PM.
 */
public class RandomStringCheck {
    public static void main(String[] args){

        for(int i = 0; i<100; i++){

            String z = RandomStringUtils.randomAlphabetic(0, 2);
            System.out.println(z + " : " + (z == null));
        }

    }
}
