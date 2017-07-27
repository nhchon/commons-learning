/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by nhchon on 7/27/2017 3:59 PM.
 */
public class YearMonthDay {

    @JsonProperty
    private int year;

    @JsonProperty
    private int month;

    @JsonProperty
    private int day;

    public  YearMonthDay(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
