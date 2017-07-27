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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by nhchon on 7/27/2017 3:40 PM.
 */
public class EventEdgeValuesDTO {

    @JsonSerialize(using = SerializeDateObject.class)
    private Date minStartDate;

    //@JsonProperty
//    public YearMonthDay getMinStartDate() {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(minStartDate);
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH) + 1; //months start at 0
//        int day = cal.get(Calendar.DAY_OF_MONTH);
//
//        return new YearMonthDay(year, month, day);
//    }
//
    public void setMinStartDate(Date minStartDate) {
        this.minStartDate = minStartDate;
    }


    public static void main(String[] args) throws  Exception{
        EventEdgeValuesDTO e = new EventEdgeValuesDTO();
        e.setMinStartDate(Calendar.getInstance().getTime());

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(e));
    }
}
