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

/**
 * Created by nhchon on 10/18/2017 9:54 AM.
 */
public class HasArrEventSummary {

    private EventSummary[] eventSummaries;

    public EventSummary[] getEventSummaries() {
        return eventSummaries;
    }

    public void setEventSummaries(EventSummary[] eventSummaries) {
        this.eventSummaries = eventSummaries;
    }
}
