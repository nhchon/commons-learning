package com.axonactive.model;

/*************************************************************************
 * Copyright (c) Metabiota Incorporated - All Rights Reserved
 * ------------------------------------------------------------------------
 * This material is proprietary to Metabiota Incorporated. The
 * intellectual and technical concepts contained herein are proprietary
 * to Metabiota Incorporated. Reproduction or distribution of this
 * material, in whole or in part, is strictly forbidden unless prior
 * written permission is obtained from Metabiota Incorporated.
 *************************************************************************/

public class PathogenInfo {

    public PathogenInfo() {
    }

    public PathogenInfo(String batchId, String pathogenName, String displayName, String tagline, String pathogenType,
                        String pathogenDetail1, String pathogenDetail2, String symptoms, String prophylacticOptions, String prophylacticOptionsSrcUrl,
                        String incubationPeriod, String incubationPeriodSrcUrl, String infectivePeriod, String infectivePeriodSrcUrl,
                        String treatmentOptions, String treatmentOptionsSrcUrl, String transmissionPathways, String transmissionPathwaysSrcUrl,
                        String geographicDistribution, String geographicDistributionSrcUrl, String freq, String freqSrcUrl,
                        String standardResponse, String standardResponseSrcUrl, String relativeMorbidity, String relativeMorbiditySrcUrl,
                        String relativeMortality, String relativeMortalitySrcUrl, String isSelectAgent,
                        Boolean primaryAirborne, Boolean secondaryAirborne, Boolean primaryVectorborne, Boolean secondaryVectorborne,
                        Boolean primaryWaterborne, Boolean secondaryWaterborne, Boolean primaryFoodborne, Boolean secondaryFoodborne,
                        Boolean primaryFomite, Boolean secondaryFomite, Boolean primaryAnimal, Boolean secondaryAnimal,
                        Boolean primaryVerticalTransmission, Boolean secondaryVerticalTransmission, Boolean primarySexualTransmission,
                        Boolean secondarySexualTransmission, Boolean primaryBloodborne, Boolean secondaryBloodborne,
                        Boolean primaryFecalOral, Boolean secondaryFecalOral, Boolean primaryDirectContact, Boolean secondaryDirectContact,
                        Boolean unclassified, Boolean unverified) {
        this.batchId = batchId;
        this.pathogenName = pathogenName;
        this.displayName = displayName;
        this.tagline = tagline;
        this.pathogenType = pathogenType;
        this.pathogenDetail1 = pathogenDetail1;
        this.pathogenDetail2 = pathogenDetail2;
        this.symptoms = symptoms;
        this.prophylacticOptions = prophylacticOptions;
        this.prophylacticOptionsSrcUrl = prophylacticOptionsSrcUrl;
        this.incubationPeriod = incubationPeriod;
        this.incubationPeriodSrcUrl = incubationPeriodSrcUrl;
        this.infectivePeriod = infectivePeriod;
        this.infectivePeriodSrcUrl = infectivePeriodSrcUrl;
        this.treatmentOptions = treatmentOptions;
        this.treatmentOptionsSrcUrl = treatmentOptionsSrcUrl;
        this.transmissionPathways = transmissionPathways;
        this.transmissionPathwaysSrcUrl = transmissionPathwaysSrcUrl;
        this.geographicDistribution = geographicDistribution;
        this.geographicDistributionSrcUrl = geographicDistributionSrcUrl;
        this.freq = freq;
        this.freqSrcUrl = freqSrcUrl;
        this.standardResponse = standardResponse;
        this.standardResponseSrcUrl = standardResponseSrcUrl;
        this.relativeMorbidity = relativeMorbidity;
        this.relativeMorbiditySrcUrl = relativeMorbiditySrcUrl;
        this.relativeMortality = relativeMortality;
        this.relativeMortalitySrcUrl = relativeMortalitySrcUrl;
        this.isSelectAgent = isSelectAgent;
        this.primaryAirborne = primaryAirborne;
        this.secondaryAirborne = secondaryAirborne;
        this.primaryVectorborne = primaryVectorborne;
        this.secondaryVectorborne = secondaryVectorborne;
        this.primaryWaterborne = primaryWaterborne;
        this.secondaryWaterborne = secondaryWaterborne;
        this.primaryFoodborne = primaryFoodborne;
        this.secondaryFoodborne = secondaryFoodborne;
        this.primaryFomite = primaryFomite;
        this.secondaryFomite = secondaryFomite;
        this.primaryAnimal = primaryAnimal;
        this.secondaryAnimal = secondaryAnimal;
        this.primaryVerticalTransmission = primaryVerticalTransmission;
        this.secondaryVerticalTransmission = secondaryVerticalTransmission;
        this.primarySexualTransmission = primarySexualTransmission;
        this.secondarySexualTransmission = secondarySexualTransmission;
        this.primaryBloodborne = primaryBloodborne;
        this.secondaryBloodborne = secondaryBloodborne;
        this.primaryFecalOral = primaryFecalOral;
        this.secondaryFecalOral = secondaryFecalOral;
        this.primaryDirectContact = primaryDirectContact;
        this.secondaryDirectContact = secondaryDirectContact;
        this.unclassified = unclassified;
        this.unverified = unverified;

    }

    private String batchId;
    public String getBatchId() { return batchId; }
    public void setBatchId(String batchId) { this.batchId = batchId; }

    private String pathogenName;
    public String getPathogenName() {return pathogenName;}
    public void setPathogenName(String pathogenName) {this.pathogenName = pathogenName;}

    private String displayName;
    public String getDisplayName() {return displayName;}
    public void setDisplayName(String displayName) {this.displayName = displayName;}

    private String tagline;
    public String getTagline() {return tagline;}
    public void setTagline(String tagline) {this.tagline = tagline;}

    private String pathogenType;
    public String getPathogenType() {return pathogenType;}
    public void setPathogenType(String pathogenType) {this.pathogenType = pathogenType;}

    private String pathogenDetail1;
    public String getPathogenDetail1() { return pathogenDetail1; }
    public void setPathogenDetail1(String pathogenDetail1) { this.pathogenDetail1 = pathogenDetail1; }

    private String pathogenDetail2;
    public String getPathogenDetail2() { return pathogenDetail2; }
    public void setPathogenDetail2(String pathogenDetail2) { this.pathogenDetail2 = pathogenDetail2; }

    private String symptoms;
    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    private String prophylacticOptions;
    public String getProphylacticOptions() { return prophylacticOptions; }
    public void setProphylacticOptions(String prophylacticOptions) { this.prophylacticOptions = prophylacticOptions; }

    private String prophylacticOptionsSrcUrl;
    public String getProphylacticOptionsSrcUrl() {return prophylacticOptionsSrcUrl; }
    public void setProphylacticOptionsSrcUrl(String prophylacticOptionsSrcUrl) { this.prophylacticOptionsSrcUrl = prophylacticOptionsSrcUrl; }

    private String incubationPeriod;
    public String getIncubationPeriod() { return incubationPeriod; }
    public void setIncubationPeriod(String incubationPeriod) { this.incubationPeriod = incubationPeriod; }

    private String incubationPeriodSrcUrl;
    public String getIncubationPeriodSrcUrl() { return incubationPeriodSrcUrl; }
    public void setIncubationPeriodSrcUrl(String incubationPeriodSrcUrl) { this.incubationPeriodSrcUrl = incubationPeriodSrcUrl; }

    private String infectivePeriod;
    public String getInfectivePeriod() { return infectivePeriod; }
    public void setInfectivePeriod(String infectivePeriod) { this.infectivePeriod = infectivePeriod; }

    private String infectivePeriodSrcUrl;
    public String getInfectivePeriodSrcUrl() { return infectivePeriodSrcUrl; }
    public void setInfectivePeriodSrcUrl(String infectivePeriodSrcUrl) { this.infectivePeriodSrcUrl = infectivePeriodSrcUrl; }

    private String treatmentOptions;
    public String getTreatmentOptions() { return treatmentOptions; }
    public void setTreatmentOptions(String treatmentOptions) { this.treatmentOptions = treatmentOptions; }

    private String treatmentOptionsSrcUrl;
    public String getTreatmentOptionsSrcUrl() { return treatmentOptionsSrcUrl; }
    public void setTreatmentOptionsSrcUrl(String treatmentOptionsSrcUrl) { this.treatmentOptionsSrcUrl = treatmentOptionsSrcUrl; }

    private String transmissionPathways;
    public String getTransmissionPathways() { return transmissionPathways; }
    public void setTransmissionPathways(String transmissionPathways) { this.transmissionPathways = transmissionPathways; }

    private String transmissionPathwaysSrcUrl;
    public String getTransmissionPathwaysSrcUrl() { return transmissionPathwaysSrcUrl; }
    public void setTransmissionPathwaysSrcUrl(String transmissionPathwaysSrcUrl) { this.transmissionPathwaysSrcUrl = transmissionPathwaysSrcUrl; }

    private String geographicDistribution;
    public String getGeographicDistribution() { return geographicDistribution; }
    public void setGeographicDistribution(String geographicDistribution) { this.geographicDistribution = geographicDistribution; }

    private String geographicDistributionSrcUrl;
    public String getGeographicDistributionSrcUrl() { return geographicDistributionSrcUrl; }
    public void setGeographicDistributionSrcUrl(String geographicDistributionSrcUrl) { this.geographicDistributionSrcUrl = geographicDistributionSrcUrl; }

    private String freq;
    public String getFreq() { return freq; }
    public void setFreq(String freq) { this.freq = freq; }

    private String freqSrcUrl;
    public String getFreqSrcUrl() { return freqSrcUrl; }
    public void setFreqSrcUrl(String freqSrcUrl) { this.freqSrcUrl = freqSrcUrl; }

    private String standardResponse;
    public String getStandardResponse() { return standardResponse; }
    public void setStandardResponse(String standardResponse) { this.standardResponse = standardResponse; }

    private String standardResponseSrcUrl;
    public String getStandardResponseSrcUrl() { return standardResponseSrcUrl; }
    public void setStandardResponseSrcUrl(String standardResponseSrcUrl) { this.standardResponseSrcUrl = standardResponseSrcUrl; }

    private String relativeMorbidity;
    public String getRelativeMorbidity() { return relativeMorbidity; }
    public void setRelativeMorbidity(String relativeMorbidity) { this.relativeMorbidity = relativeMorbidity; }

    private String relativeMorbiditySrcUrl;
    public String getRelativeMorbiditySrcUrl() { return relativeMorbiditySrcUrl; }
    public void setRelativeMorbiditySrcUrl(String relativeMorbiditySrcUrl) { this.relativeMorbiditySrcUrl = relativeMorbiditySrcUrl; }

    private String relativeMortality;
    public String getRelativeMortality() { return relativeMortality; }
    public void setRelativeMortality(String relativeMortality) { this.relativeMortality = relativeMortality; }

    private String relativeMortalitySrcUrl;
    public String getRelativeMortalitySrcUrl() { return relativeMortalitySrcUrl; }
    public void setRelativeMortalitySrcUrl(String relativeMortalitySrcUrl) { this.relativeMortalitySrcUrl = relativeMortalitySrcUrl; }

    private String isSelectAgent;
    public String getIsSelectAgent() { return isSelectAgent; }
    public void setIsSelectAgent(String selectAgent) { isSelectAgent = selectAgent; }

    private Boolean primaryAirborne;
    public Boolean getPrimaryAirBorne() { return primaryAirborne; }
    public void setPrimaryAirborne(Boolean primaryAirborne) { this.primaryAirborne = primaryAirborne; }

    private Boolean secondaryAirborne;
    public Boolean getSecondaryAirborne() { return secondaryAirborne; }
    public void setSecondaryAirborne(Boolean secondaryAirborne) { this.secondaryAirborne = secondaryAirborne; }

    private Boolean primaryVectorborne;
    public Boolean getPrimaryVectorborne() { return primaryVectorborne; }
    public void setPrimaryVectorborne(Boolean primaryVectorborne) { this.primaryVectorborne = primaryVectorborne; }

    private Boolean secondaryVectorborne;
    public Boolean getSecondaryVectorBorne() { return secondaryVectorborne; }
    public void setSecondaryVectorBorne(Boolean secondaryVectorborne) { this.secondaryVectorborne = secondaryVectorborne; }

    private Boolean primaryWaterborne;
    public Boolean getPrimaryWaterborne() { return primaryWaterborne; }
    public void setPrimaryWaterborne(Boolean primaryWaterborne) { this.primaryWaterborne = primaryWaterborne; }

    private Boolean secondaryWaterborne;
    public Boolean getSecondaryWaterborne() { return secondaryWaterborne; }
    public void setSecondaryWaterborne(Boolean secondaryWaterborne) { this.secondaryWaterborne = secondaryWaterborne; }

    private Boolean primaryFoodborne;
    public Boolean getPrimaryFoodborne() { return primaryFoodborne; }
    public void setPrimaryFoodborne(Boolean primaryFoodborne) { this.primaryFoodborne = primaryFoodborne; }

    private Boolean secondaryFoodborne;
    public Boolean getSecondaryFoodborne() { return secondaryFoodborne; }
    public void setSecondaryFoodborne(Boolean secondaryFoodborne) { this.secondaryFoodborne = secondaryFoodborne; }

    private Boolean primaryFomite;
    public Boolean getPrimaryFomite() { return primaryFomite; }
    public void setPrimaryFomite(Boolean primaryFomite) { this.primaryFomite = primaryFomite; }

    private Boolean secondaryFomite;
    public Boolean getSecondaryFomite() { return secondaryFomite; }
    public void setSecondaryFomite(Boolean secondaryFomite) { this.secondaryFomite = secondaryFomite; }

    private Boolean primaryAnimal;
    public Boolean getPrimaryAnimal() { return primaryAnimal; }
    public void setPrimaryAnimal(Boolean primaryAnimal) { this.primaryAnimal = primaryAnimal; }

    private Boolean secondaryAnimal;
    public Boolean getSecondaryAnimal() { return secondaryAnimal; }
    public void setSecondaryAnimal(Boolean secondaryAnimal) { this.secondaryAnimal = secondaryAnimal; }

    private Boolean primaryVerticalTransmission;
    public Boolean getPrimaryVerticalTransmission() { return primaryVerticalTransmission; }
    public void setPrimaryVerticalTransmission(Boolean primaryVerticalTransmission) { this.primaryVerticalTransmission = primaryVerticalTransmission; }

    private Boolean secondaryVerticalTransmission;
    public Boolean getSecondaryVerticalTransmission() { return secondaryVerticalTransmission; }
    public void setSecondaryVerticalTransmission(Boolean secondaryVerticalTransmission) { this.secondaryVerticalTransmission = secondaryVerticalTransmission; }

    private Boolean primarySexualTransmission;
    public Boolean getPrimarySexualTransmission() { return primarySexualTransmission; }
    public void setPrimarySexualTransmission(Boolean primarySexualTransmission) { this.primarySexualTransmission = primarySexualTransmission; }

    private Boolean secondarySexualTransmission;
    public Boolean getSecondarySexualTransmission() { return secondarySexualTransmission; }
    public void setSecondarySexualTransmission(Boolean secondarySexualTransmission) { this.secondarySexualTransmission = secondarySexualTransmission; }

    private Boolean primaryBloodborne;
    public Boolean getPrimaryBloodborne() { return primaryBloodborne; }
    public void setPrimaryBloodborne(Boolean primaryBloodborne) { this.primaryBloodborne = primaryBloodborne; }

    private Boolean secondaryBloodborne;
    public Boolean getSecondaryBloodborne() { return secondaryBloodborne; }
    public void setSecondaryBloodBorne(Boolean secondaryBloodborne) { this.secondaryBloodborne = secondaryBloodborne; }

    private Boolean primaryFecalOral;
    public Boolean getPrimaryFecalOral() { return primaryFecalOral; }
    public void setPrimaryFecalOral(Boolean primaryFecalOral) { this.primaryFecalOral = primaryFecalOral; }

    private Boolean secondaryFecalOral;
    public Boolean getSecondaryFecalOral() { return secondaryFecalOral; }
    public void setSecondaryFecalOral(Boolean secondaryFecalOral) { this.secondaryFecalOral = secondaryFecalOral; }

    private Boolean primaryDirectContact;
    public Boolean getPrimaryDirectContact() { return primaryDirectContact; }
    public void setPrimaryDirectContact(Boolean primaryDirectContact) { this.primaryDirectContact = primaryDirectContact; }

    private Boolean secondaryDirectContact;
    public Boolean getSecondaryDirectContact() { return secondaryDirectContact; }
    public void setSecondaryDirectContact(Boolean secondaryDirectContact) { this.secondaryDirectContact = secondaryDirectContact; }

    private Boolean unclassified;
    public Boolean getUnclassified() { return unclassified; }
    public void setUnclassified(Boolean unclassified) { this.unclassified = unclassified; }

    private Boolean unverified;
    public Boolean getUnverified() { return unverified; }
    public void setUnverified(Boolean unverified) { this.unverified = unverified; }

    @Override
    public String toString() {
        String newline = System.getProperty("line.separator");
        return "PathogenInfo{" +
                "batchId[" + batchId + "]" + newline +
                " pathogenName[" + pathogenName + "]" + newline +
                " displayName[" + displayName + "]" + newline +
                " tagline[" + tagline + "]" + newline +
                " pathogenType[" + pathogenType + "]" + newline +
                " pathogenDetail1[" + pathogenDetail1 + "]" + newline +
                " pathogenDetail2[" + pathogenDetail2 + "]" + newline +
                " symptoms[" + symptoms + "]" + newline +
                " prophylacticOptions=" + prophylacticOptions +
                " prophylacticOptionsSrcUrl[" + prophylacticOptionsSrcUrl + "]" + newline +
                " incubationPeriod[" + incubationPeriod + "]" + newline +
                " incubationPeriodSrcUrl[" + incubationPeriodSrcUrl + "]" + newline +
                " infectivePeriod[" + infectivePeriod + "]" + newline +
                " infectivePeriodSrcUrl[" + infectivePeriodSrcUrl + "]" + newline +
                " treatmentOptions[" + treatmentOptions + "]" + newline +
                " treatmentOptionsSrcUrl[" + treatmentOptionsSrcUrl + "]" + newline +
                " transmissionPathways[" + transmissionPathways + "]" + newline +
                " transmissionPathwaysSrcUrl[" + transmissionPathwaysSrcUrl + "]" + newline +
                " geographicDistribution[" + geographicDistribution + "]" + newline +
                " geographicDistributionSrcUrl[" + geographicDistributionSrcUrl + "]" + newline +
                " freq[" + freq + "]" + newline +
                " freqSrcUrl[" + freqSrcUrl + "]" + newline +
                " standardResponse[" + standardResponse + "]" + newline +
                " standardResponseSrcUrl[" + standardResponseSrcUrl + "]" + newline +
                " relativeMorbidity[" + relativeMorbidity + "]" + newline +
                " relativeMorbiditySrcUrl[" + relativeMorbiditySrcUrl + "]" + newline +
                " relativeMortality[" + relativeMortality + "]" + newline +
                " relativeMortalitySrcUrl[" + relativeMortalitySrcUrl + "]" + newline +
                " isSelectAgent[" + isSelectAgent + "]" + newline +
                " primaryAirBorne[" + primaryAirborne + "]" + newline +
                " secondaryAirBorne[" + secondaryAirborne + "]" + newline +
                " primaryVectorBorne[" + primaryVectorborne + "]" + newline +
                " secondaryVectorBorne[" + secondaryVectorborne + "]" + newline +
                " primaryWaterBorne[" + primaryWaterborne + "]" + newline +
                " secondaryWaterBorne[" + secondaryWaterborne + "]" + newline +
                " primaryFoodborne[" + primaryFoodborne + "]" + newline +
                " secondaryFoodborne[" + secondaryFoodborne + "]" + newline +
                " primaryFomite[" + primaryFomite + "]" + newline +
                " secondaryFomite[" + secondaryFomite + "]" + newline +
                " primaryAnimal[" + primaryAnimal + "]" + newline +
                " secondaryAnimal[" + secondaryAnimal + "]" + newline +
                " primaryVerticalTransmission[" + primaryVerticalTransmission + "]" + newline +
                " secondaryVerticalTransmission[" + secondaryVerticalTransmission + "]" + newline +
                " primarySexualTransmission[" + primarySexualTransmission + "]" + newline +
                " secondarySexualTransmission[" + secondarySexualTransmission + "]" + newline +
                " primaryBloodborne[" + primaryBloodborne + "]" + newline +
                " secondaryBloodborne[" + secondaryBloodborne + "]" + newline +
                " primaryFecalOral[" + primaryFecalOral + "]" + newline +
                " secondaryFecalOral[" + secondaryFecalOral + "]" + newline +
                " primaryDirectContact[" + primaryDirectContact + "]" + newline +
                " secondaryDirectContact[" + secondaryDirectContact + "]" + newline +
                " unclassified[" + unclassified + "]" + newline +
                " unverified[" + unverified + "]" +
                '}';
    }
}
