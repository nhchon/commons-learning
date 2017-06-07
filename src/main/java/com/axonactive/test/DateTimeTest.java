/*************************************************************************
 *  Copyright (c) ChonNguyen Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to ChonNguyen Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to ChonNguyen Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from ChonNguyen Incorporated.
 *************************************************************************/
package com.axonactive.test;

import java.util.Date;

/**
 * Created by nhchon on 4/5/2017 2:51 PM.
 */
public class DateTimeTest {
    public static void main(String[] args){
        long epoch = 347155199999L;
        Date d = new Date(epoch);

        System.out.println(d.getTime());
    }
}
