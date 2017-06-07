/*************************************************************************
 *  Copyright (c) ChonNguyen Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to ChonNguyen Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to ChonNguyen Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from ChonNguyen Incorporated.
 *************************************************************************/
package com.axonactive.model;

/**
 * Created by nhchon on 2/7/2017 1:33 PM.
 */
public class Pathogen {
    private Long batchId;
    private String pathogen;
    private String prophylacticOptions;
    private String prophylacticOptionsSrcurl;
    private String incubationPeriod;
    private String incubationPeriodSrcurl;
    private String infectivePeriod;
    private String infectivePeriodSrcurl;
    private String treatmentOptions;
    private String treatmentOptionsSrcurl;
    private String transmissionPathways;
    private String transmissionPathwaysSrcurl;
    private String range;
    private String rangeSrcurl;
    private String freq;
    private String freqSrcurl;
    private String standardResponse;
    private String standardResponseSrcurl;
    private String relativeMorbidity;
    private String relativeMorbiditySrcurl;
    private String relativeMortality;
    private String relativeMortalitySrcurl;
    private Boolean isSelectAgent;
    private Boolean isPrimary;
    private String imgStorageUrl;
    private String imgPathogen;
    private String imgCredit;
    private String imgSrcName;
    private String imgSrcUrl;
    private String imgLicenseUrl;

    public Pathogen(Long batchId, Boolean isPrimary){
        this.batchId = batchId;
        this.isPrimary = isPrimary;
    }

    public Pathogen(Long batchId, String pathogen){
        this.batchId = batchId;
        this.pathogen = pathogen;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getPathogen() {
        return pathogen;
    }

    public void setPathogen(String pathogen) {
        this.pathogen = pathogen;
    }

    public String getProphylacticOptions() {
        return prophylacticOptions;
    }

    public void setProphylacticOptions(String prophylacticOptions) {
        this.prophylacticOptions = prophylacticOptions;
    }

    public String getProphylacticOptionsSrcurl() {
        return prophylacticOptionsSrcurl;
    }

    public void setProphylacticOptionsSrcurl(String prophylacticOptionsSrcurl) {
        this.prophylacticOptionsSrcurl = prophylacticOptionsSrcurl;
    }

    public String getIncubationPeriod() {
        return incubationPeriod;
    }

    public void setIncubationPeriod(String incubationPeriod) {
        this.incubationPeriod = incubationPeriod;
    }

    public String getIncubationPeriodSrcurl() {
        return incubationPeriodSrcurl;
    }

    public void setIncubationPeriodSrcurl(String incubationPeriodSrcurl) {
        this.incubationPeriodSrcurl = incubationPeriodSrcurl;
    }

    public String getInfectivePeriod() {
        return infectivePeriod;
    }

    public void setInfectivePeriod(String infectivePeriod) {
        this.infectivePeriod = infectivePeriod;
    }

    public String getInfectivePeriodSrcurl() {
        return infectivePeriodSrcurl;
    }

    public void setInfectivePeriodSrcurl(String infectivePeriodSrcurl) {
        this.infectivePeriodSrcurl = infectivePeriodSrcurl;
    }

    public String getTreatmentOptions() {
        return treatmentOptions;
    }

    public void setTreatmentOptions(String treatmentOptions) {
        this.treatmentOptions = treatmentOptions;
    }

    public String getTreatmentOptionsSrcurl() {
        return treatmentOptionsSrcurl;
    }

    public void setTreatmentOptionsSrcurl(String treatmentOptionsSrcurl) {
        this.treatmentOptionsSrcurl = treatmentOptionsSrcurl;
    }

    public String getTransmissionPathways() {
        return transmissionPathways;
    }

    public void setTransmissionPathways(String transmissionPathways) {
        this.transmissionPathways = transmissionPathways;
    }

    public String getTransmissionPathwaysSrcurl() {
        return transmissionPathwaysSrcurl;
    }

    public void setTransmissionPathwaysSrcurl(String transmissionPathwaysSrcurl) {
        this.transmissionPathwaysSrcurl = transmissionPathwaysSrcurl;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getRangeSrcurl() {
        return rangeSrcurl;
    }

    public void setRangeSrcurl(String rangeSrcurl) {
        this.rangeSrcurl = rangeSrcurl;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public String getFreqSrcurl() {
        return freqSrcurl;
    }

    public void setFreqSrcurl(String freqSrcurl) {
        this.freqSrcurl = freqSrcurl;
    }

    public String getStandardResponse() {
        return standardResponse;
    }

    public void setStandardResponse(String standardResponse) {
        this.standardResponse = standardResponse;
    }

    public String getStandardResponseSrcurl() {
        return standardResponseSrcurl;
    }

    public void setStandardResponseSrcurl(String standardResponseSrcurl) {
        this.standardResponseSrcurl = standardResponseSrcurl;
    }

    public String getRelativeMorbidity() {
        return relativeMorbidity;
    }

    public void setRelativeMorbidity(String relativeMorbidity) {
        this.relativeMorbidity = relativeMorbidity;
    }

    public String getRelativeMorbiditySrcurl() {
        return relativeMorbiditySrcurl;
    }

    public void setRelativeMorbiditySrcurl(String relativeMorbiditySrcurl) {
        this.relativeMorbiditySrcurl = relativeMorbiditySrcurl;
    }

    public String getRelativeMortality() {
        return relativeMortality;
    }

    public void setRelativeMortality(String relativeMortality) {
        this.relativeMortality = relativeMortality;
    }

    public String getRelativeMortalitySrcurl() {
        return relativeMortalitySrcurl;
    }

    public void setRelativeMortalitySrcurl(String relativeMortalitySrcurl) {
        this.relativeMortalitySrcurl = relativeMortalitySrcurl;
    }

    public Boolean getSelectAgent() {
        return isSelectAgent;
    }

    public void setSelectAgent(Boolean selectAgent) {
        isSelectAgent = selectAgent;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }

    public String getImgStorageUrl() {
        return imgStorageUrl;
    }

    public void setImgStorageUrl(String imgStorageUrl) {
        this.imgStorageUrl = imgStorageUrl;
    }

    public String getImgPathogen() {
        return imgPathogen;
    }

    public void setImgPathogen(String imgPathogen) {
        this.imgPathogen = imgPathogen;
    }

    public String getImgCredit() {
        return imgCredit;
    }

    public void setImgCredit(String imgCredit) {
        this.imgCredit = imgCredit;
    }

    public String getImgSrcName() {
        return imgSrcName;
    }

    public void setImgSrcName(String imgSrcName) {
        this.imgSrcName = imgSrcName;
    }

    public String getImgSrcUrl() {
        return imgSrcUrl;
    }

    public void setImgSrcUrl(String imgSrcUrl) {
        this.imgSrcUrl = imgSrcUrl;
    }

    public String getImgLicenseUrl() {
        return imgLicenseUrl;
    }

    public void setImgLicenseUrl(String imgLicenseUrl) {
        this.imgLicenseUrl = imgLicenseUrl;
    }

    @Override
    public String toString(){
        return "[ " + batchId + ", " + isPrimary + "]";
    }
}
