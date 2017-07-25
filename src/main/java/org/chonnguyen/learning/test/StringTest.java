/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.test;

/**
 * Created by nhchon on 7/4/2017 4:29 PM.
 */
public class StringTest {
    public static void main(String[] args) {
        String str = null;

        StringBuilder b = new StringBuilder();
        b.append(str);


        System.out.println(b.toString());

    }
}
