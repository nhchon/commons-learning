/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.codeabbey;

import java.util.Scanner;

/**
 * Created by nhchon on 2/5/2018 3:56 PM.
 */
public class SumInLoop {
    public static void main(String[] args) {
        System.out.println("input data:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += in.nextInt();
        }

        System.out.println("answer:");
        System.out.println(total);
    }
}
