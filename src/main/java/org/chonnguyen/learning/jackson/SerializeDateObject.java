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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by nhchon on 7/27/2017 3:47 PM.
 */
public class SerializeDateObject extends JsonSerializer<Date> {
    @Override
    public void serialize(Date tmpDate,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(tmpDate);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; //months start at 0
        int day = cal.get(Calendar.DAY_OF_MONTH);

        ;
        jsonGenerator.writeObject(new YearMonthDay(year, month, day));
    }
}
