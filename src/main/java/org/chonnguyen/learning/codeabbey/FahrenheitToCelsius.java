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
 * Created by nhchon on 2/8/2018 4:09 PM.
 */
public class FahrenheitToCelsius {
    public static void main(String[] args) {
        try {
            //Get file from resources folder
            File f = new File("src/main/resources/FahrenheitToCelsius.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = b.readLine();
            b.close();

            String[] numbers = readLine.split(" ");
            int n = Integer.parseInt(numbers[0]);
            int[] result = new int[n];
            for (int i=1; i< numbers.length; i++) {
                int fahrenheit = Integer.parseInt(numbers[i]);
                result[i-1] = Math.round((fahrenheit - 32)/1.8f);
            }

            System.out.println(Arrays.toString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
