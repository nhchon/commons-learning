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

import java.util.Objects;

/**
 * Created by nhchon on 12/26/2017 5:52 PM.
 */
public class GeonameRecord {
    protected String geonameId;
    protected String countryCode;
    protected String stateCode;
    protected String fCode;

    public GeonameRecord(String geonameId, String countryCode, String stateCode, String fCode) {
        this.geonameId = geonameId;
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.fCode = fCode;
    }

    public GeonameRecord() {
    }

    public String getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(String geonameId) {
        this.geonameId = geonameId;
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

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public boolean duplicateCountryStateAndFCode(GeonameRecord other) {
        if (other == null)
            return false;

        return Objects.equals(this.countryCode, other.getCountryCode())
                && Objects.equals(this.stateCode, other.getStateCode())
                && Objects.equals(this.getfCode(), other.getfCode());
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(geonameId);
        b.append('\t');
        b.append(countryCode);
        b.append('\t');
        b.append(stateCode);
        b.append('\t');
        b.append(fCode);

        return b.toString();
    }
}
