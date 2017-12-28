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
public class MergedGeonameRecord {
    private String geonameId;
    private String countryCode;
    private String stateCode;
    private String fCode;

    private String oriGeonameId;
    private String oriCountryCode;
    private String oriStateCode;
    private String oriStateName;
    private String oriFCode;

    public MergedGeonameRecord(String geonameId, String countryCode, String stateCode, String fCode) {
        this.geonameId = geonameId;
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.fCode = fCode;
    }

    public MergedGeonameRecord() {
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

    public String getOriGeonameId() {
        return oriGeonameId;
    }

    public void setOriGeonameId(String oriGeonameId) {
        this.oriGeonameId = oriGeonameId;
    }

    public String getOriCountryCode() {
        return oriCountryCode;
    }

    public void setOriCountryCode(String oriCountryCode) {
        this.oriCountryCode = oriCountryCode;
    }

    public String getOriStateCode() {
        return oriStateCode;
    }

    public void setOriStateCode(String oriStateCode) {
        this.oriStateCode = oriStateCode;
    }

    public String getOriFCode() {
        return oriFCode;
    }

    public void setOriFCode(String oriFCode) {
        this.oriFCode = oriFCode;
    }

    public String getOriStateName() {
        return oriStateName;
    }

    public void setOriStateName(String oriStateName) {
        this.oriStateName = oriStateName;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(geonameId);
        b.append(',');
        b.append(countryCode);
        b.append(',');
        b.append(stateCode);
        b.append(',');
        b.append(fCode);
        b.append(',');
        b.append(',');
        b.append(',');
        b.append(oriFCode);
        b.append(',');
        b.append(oriCountryCode);
        b.append(',');
        b.append(oriStateCode);
        b.append(',');
        b.append(oriStateName);
        b.append(',');
        b.append(oriFCode);

        return b.toString();
    }
}
