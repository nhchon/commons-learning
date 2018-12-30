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
 * Created by nhchon on 2/9/2018 2:43 PM.
 */
public class VowelCount {
    public static void main(String[] args) {
        try {
            final String VOWEL_STR = "aeiouyAEIOUY";
            //Get file from resources folder
            File f = new File("src/main/resources/VowelCount.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            // total count line
            String readLine = b.readLine();
            int[] result = new int[Integer.parseInt(readLine)];

            int index = 0;
            while ((readLine = b.readLine()) != null) {
                int vowelCount = 0;
                for (int i=0; i<readLine.length(); i++) {
                    char c = readLine.charAt(i);
                    if (VOWEL_STR.contains(c+"")) {
                        vowelCount++;
                    }
                }

                result[index] = vowelCount;
                index++;
            }
            b.close();

            System.out.println(Arrays.toString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
