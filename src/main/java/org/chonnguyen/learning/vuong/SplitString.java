/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.vuong;

import java.util.Arrays;

/**
 * Created by nhchon on 2/6/2018 10:04 AM.
 */
public class SplitString {
    public static void main(String[] args) {
        final String MY_SPECIAL_DELI = "=#=";
        String str = "abc,def, dungpham,khoahoang, vuong2";

        str = str.replace(", ", MY_SPECIAL_DELI);

        //System.out.println(str);

        String[] expectedArg = str.split(",");

        //System.out.println(Arrays.toString(expectedArg));
        for (int i = 0; i<expectedArg.length; i++) {
            if (expectedArg[i].indexOf(MY_SPECIAL_DELI) >=0) {
                expectedArg[i] = expectedArg[i].replace(MY_SPECIAL_DELI, ", ");
            }

            System.out.println(expectedArg[i]);
        }
    }
}
