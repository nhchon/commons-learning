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

/**
 * Created by nhchon on 12/14/2017 4:22 PM.
 */
public class CountryState {
    protected String countryCode;
    protected String stateCode;
    protected String stateName;

    public CountryState(){}
    public CountryState(String countryCode, String stateCode, String stateName) {
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.stateName = stateName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(countryCode);
        b.append(".");
        b.append(stateCode);
        b.append("\t");
        b.append(stateName);

        return b.toString();
    }
}
