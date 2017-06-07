/*************************************************************************
 *  Copyright (c) ChonNguyen Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to ChonNguyen Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to ChonNguyen Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from ChonNguyen Incorporated.
 *************************************************************************/
package com.axonactive.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by nhchon on 2/27/2017 6:17 PM.
 */
public class VietFuckingLot {
    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> fuckVietlot = generateRandom();
        String dafuck = "";
        for (String fuck : fuckVietlot) {
            dafuck += fuck + " ";
        }
        System.out.println(dafuck);
    }

    public static List<String> generateRandom() {
        List<String> vietFkLot = new ArrayList<>();
        while (vietFkLot.size() < 6) {
            Random rand = new Random();
            int random = rand.nextInt(44) + 1;
            String number = "";
            number = (random / 10 == 0) ? "0" + String.valueOf(random) : String.valueOf(random);

            if (!vietFkLot.contains(number)) {
                vietFkLot.add(number);
            }
        }
        Collections.sort(vietFkLot) ;
        return vietFkLot;
    }
}
