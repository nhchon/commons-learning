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
 * Created by nhchon on 12/15/2017 10:38 AM.
 */
public class SolrRecord {
    private String countryCode;
    private String stateCode;
    private String stateName;
    private String statenameInAscii;
    private String geonameId;

    public SolrRecord(String countryCode, String stateCode, String stateName, String statenameInAscii, String geonameId) {
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.statenameInAscii = statenameInAscii;
        this.geonameId = geonameId;
    }

    public SolrRecord(SolrRecord record) {
        this.countryCode = record.getCountryCode();
        this.stateCode = record.getStateCode();
        this.stateName = record.getStateName();

        this.statenameInAscii = record.getStatenameInAscii();
        this.geonameId = record.getGeonameId();
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

    public String getStatenameInAscii() {
        return statenameInAscii;
    }

    public void setStatenameInAscii(String statenameInAscii) {
        this.statenameInAscii = statenameInAscii;
    }

    public String getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(String geonameId) {
        this.geonameId = geonameId;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(countryCode);
        b.append(".");
        b.append(stateCode);
        b.append("\t");
        b.append(stateName);

        if (statenameInAscii != null) {
            b.append("\t");
            b.append(statenameInAscii);
        }

        if (geonameId != null) {
            b.append("\t");
            b.append(geonameId);
        }

        return b.toString();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                this.countryCode, this.stateCode, this.stateName, this.statenameInAscii, this.geonameId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }

        final SolrRecord other = (SolrRecord) obj;
        return Objects.equals(countryCode, other.countryCode)
               && Objects.equals(stateCode, other.stateCode)
               && Objects.equals(stateName, other.stateName)
               && Objects.equals(statenameInAscii, other.statenameInAscii)
               && Objects.equals(geonameId, other.geonameId);
    }
}
