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
 * Created by nhchon on 10/18/2017 9:40 AM.
 */
public class EventSummary  implements Serializable {

    private int lifeLossInsurance;
    private int deaths;
    private int infected;


    public int getLifeLossInsurance() {
        return lifeLossInsurance;
    }

    public void setLifeLossInsurance(int lifeLossInsurance) {
        this.lifeLossInsurance = lifeLossInsurance;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }
}
