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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by nhchon on 2/8/2018 2:52 PM.
 */
public class MinimumOfThree {
    public static void main(String[] args) {
        try {
            //Get file from resources folder
            File f = new File("src/main/resources/MinimumOfThree.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            // total count line
            String readLine = b.readLine();
            int[] result = new int[Integer.parseInt(readLine)];

            int index = 0;
            while ((readLine = b.readLine()) != null) {
                String[] numbers = readLine.split(" ");
                int n1 = Integer.parseInt(numbers[0]);
                int n2 = Integer.parseInt(numbers[1]);
                int n3 = Integer.parseInt(numbers[2]);

                result[index] = Math.min(n1, Math.min(n2, n3));
                index++;
            }
            b.close();

            System.out.println(Arrays.toString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
