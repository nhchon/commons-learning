/*************************************************************************
 *  Copyright (c) ChonNguyen Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to ChonNguyen Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to ChonNguyen Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from ChonNguyen Incorporated.
 *************************************************************************/
package com.axonactive.utils;

import com.axonactive.model.PathogenInfo;
import com.opencsv.CSVReader;
import com.opencsv.bean.*;

import java.beans.IntrospectionException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nhchon on 2/21/2017 11:22 AM.
 */
public class ParseCSV {
    public static final Map<String, String> colMapPathInfo = new HashMap<String, String>();

    public static void main(String[] args) throws Exception{
        parseCSVWithHeader();
        //readLineCSV();
        System.out.println(",,,Virus,,,,,,,,,,,,,,,,,,,,,,,,IsSelectAgent,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE");
        String tmp = ",,,Virus,,,,,,,,,,,,,,,,,,,,,,,,IsSelectAgent,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE";
        int count = 0;
        for(int i=0; i<tmp.length(); i++){
            if(tmp.charAt(i) == ',') count++;
        }

        System.out.println("Char , :" + count);
    }

    public static void readLineCSV() throws IOException {
        //Build reader instance
        //Read data.csv
        //Default seperator is comma
        //Default quote character is double quote
        //Start reading from line number 2 (line numbers start from zero)
        CSVReader reader = new CSVReader(new FileReader("D:\\tmpPathogen\\newPathogens\\pathogens_info.csv"), ',' , '"' , 1);

        //Read CSV line by line and use the string array as you want
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                //Verifying the read data here
                System.out.println(Arrays.toString(nextLine));
                for(int i=0; i<nextLine.length; i++){
                    System.out.println(i + " : " + nextLine[i]);
                }
            }
        }
    }
    // returning list of Employee for CSVWriter example demo data
    public static List<PathogenInfo> parseCSVWithHeader() throws IOException {
        colMapPathInfo.put("PathogenName", "pathogenName");
        colMapPathInfo.put("DisplayName", "displayName");
        colMapPathInfo.put("Tagline", "tagline");
        colMapPathInfo.put("PathogenType", "pathogenType");
        colMapPathInfo.put("PathogenDetail1", "pathogenDetail1");
        colMapPathInfo.put("PathogenDetail2", "pathogenDetail2");
        colMapPathInfo.put("Symptoms", "symptoms");
        colMapPathInfo.put("ProphylacticOptions", "prophylacticOptions");
        colMapPathInfo.put("ProphylacticOptionsSrcUrl", "prophylacticOptionsSrcUrl");
        colMapPathInfo.put("IncubationPeriod", "incubationPeriod");
        colMapPathInfo.put("IncubationPeriodSrcUrl", "incubationPeriodSrcUrl");
        colMapPathInfo.put("InfectivePeriod", "infectivePeriod");
        colMapPathInfo.put("InfectivePeriodSrcUrl", "infectivePeriodSrcUrl");
        colMapPathInfo.put("TreatmentOptions", "treatmentOptions");
        colMapPathInfo.put("TreatmentOptionsSrcUrl", "treatmentOptionsSrcUrl");
        colMapPathInfo.put("TransmissionPathways", "transmissionPathways");
        colMapPathInfo.put("TransmissionPathwaysSrcUrl", "transmissionPathwaysSrcUrl");
        colMapPathInfo.put("GeographicDistribution", "geographicDistribution");
        colMapPathInfo.put("GeographicDistributionSrcUrl", "geographicDistributionSrcUrl");
        colMapPathInfo.put("Freq", "freq");
        colMapPathInfo.put("FreqSrcUrl", "freqSrcUrl");
        colMapPathInfo.put("StandardResponse", "standardResponse");
        colMapPathInfo.put("StandardResponseSrcUrl", "standardResponseSrcUrl");
        colMapPathInfo.put("RelativeMorbidity", "relativeMorbidity");
        colMapPathInfo.put("RelativeMorbiditySrcUrl", "relativeMorbiditySrcUrl");
        colMapPathInfo.put("RelativeMortality", "relativeMortality");
        colMapPathInfo.put("RelativeMortalitySrcUrl", "relativeMortalitySrcUrl");
        colMapPathInfo.put("IsSelectAgent", "isSelectAgent");

        colMapPathInfo.put("PrimaryAirborne", "primaryAirborne");
        colMapPathInfo.put("SecondaryAirborne", "secondaryAirborne");
        colMapPathInfo.put("PrimaryVectorborne", "primaryVectorborne");
        colMapPathInfo.put("SecondaryVectorborne", "secondaryVectorborne");

        colMapPathInfo.put("PrimaryWaterborne", "primaryWaterborne");
        colMapPathInfo.put("SecondaryWaterborne", "secondaryWaterborne");
        colMapPathInfo.put("PrimaryFoodborne", "primaryFoodborne");
        colMapPathInfo.put("SecondaryFoodborne", "secondaryFoodborne");

        colMapPathInfo.put("PrimaryFomite", "primaryFomite");
        colMapPathInfo.put("SecondaryFomite", "secondaryFomite");

        colMapPathInfo.put("PrimaryAnimal", "primaryAnimal");
        colMapPathInfo.put("SecondaryAnimal", "secondaryAnimal");

        colMapPathInfo.put("PrimaryVerticalTransmission", "primaryVerticalTransmission");
        colMapPathInfo.put("SecondaryVerticalTransmission", "secondaryVerticalTransmission");

        colMapPathInfo.put("PrimarySexualTransmission", "primarySexualTransmission");
        colMapPathInfo.put("SecondarySexualTransmission", "secondarySexualTransmission");

        colMapPathInfo.put("PrimaryBloodborne", "primaryBloodborne");
        colMapPathInfo.put("SecondaryBloodborne", "secondaryBloodborne");

        colMapPathInfo.put("PrimaryFecalOral", "primaryFecalOral");
        colMapPathInfo.put("SecondaryFecalOral", "secondaryFecalOral");

        colMapPathInfo.put("PrimaryDirectContact", "primaryDirectContact");
        colMapPathInfo.put("SecondaryDirectContact", "secondaryDirectContact");

        colMapPathInfo.put("Unclassified", "unclassified");
        colMapPathInfo.put("Unverified", "unverified");

        CSVReader reader = new CSVReader(new FileReader("D:\\tmpPathogen\\newPathogens2\\pathogens_info.csv"), ',');

        HeaderColumnNameTranslateMappingStrategy<PathogenInfo> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<PathogenInfo>();
        beanStrategy.setType(PathogenInfo.class);
        beanStrategy.setColumnMapping(colMapPathInfo);

        CsvToBean<PathogenInfo> csvToBean = new CsvToBean<PathogenInfo>();
        List<PathogenInfo> emps = csvToBean.parse(beanStrategy, reader);

        System.out.println( beanStrategy.getColumnName(0));
        System.out.println( beanStrategy.getColumnName(1));
        System.out.println(emps);
        reader.close();

        return emps;
    }
}
