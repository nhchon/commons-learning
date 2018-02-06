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
 * Created by nhchon on 2/5/2018 3:46 PM.
 */
public class ReadInt {
    public static void main(String[] args) {
        System.out.println("input data:");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();

        System.out.println();
        System.out.println("answer:");
        System.out.println(i + j);
    }
}
