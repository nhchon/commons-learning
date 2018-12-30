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

import java.io.Serializable;

/**
 * Created by nhchon on 10/18/2017 9:44 AM.
 */
public class HasEventSummary  implements Serializable {
    private EventSummary eventSummary;

    public EventSummary getEventSummary() {
        return eventSummary;
    }

    public void setEventSummary(EventSummary eventSummary) {
        this.eventSummary = eventSummary;
    }
}
