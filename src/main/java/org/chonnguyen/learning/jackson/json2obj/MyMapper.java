/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.jackson.json2obj;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by nhchon on 10/18/2017 9:42 AM.
 */
public class MyMapper {
    public static void main(String[] args) throws Exception {
        String eventSummaryJsonInString = "{" +
                "        \"lifeLossInsurance\": 0," +
                "        \"deaths\": 16048," +
                "        \"infected\": 110734088" +
                "    }";

        String jsonInString = "{\"eventSummary\": {" +
                "        \"lifeLossInsurance\": 0," +
                "        \"deaths\": 16048," +
                "        \"infected\": 110734088" +
                "    }}";

        ObjectMapper mapper = new ObjectMapper();

        EventSummary eventSummary = mapper.readValue(eventSummaryJsonInString, EventSummary.class);

        HasEventSummary hasEventSummary = mapper.readValue(jsonInString, HasEventSummary.class);

        // From eventSummary to hass array eventSummary
        HasArrEventSummary hasArrEventSummary = new HasArrEventSummary();
        hasArrEventSummary.setEventSummaries(new EventSummary[]{hasEventSummary.getEventSummary()});

        // Print out
        System.out.println(mapper.writeValueAsString(eventSummary));
        System.out.println(mapper.writeValueAsString(hasEventSummary));
        System.out.println(mapper.writeValueAsString(hasArrEventSummary));


        String jsonInString2 = "{\"eventSummaries\": [" +
                "        {\"lifeLossInsurance\": 0," +
                "        \"deaths\": 16048," +
                "        \"infected\": 110734088}" +
                "    ]}";

        HasArrEventSummary testHasArrEventSummary = mapper.readValue(jsonInString2, HasArrEventSummary.class);
    }
}
