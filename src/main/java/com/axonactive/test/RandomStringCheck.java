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
