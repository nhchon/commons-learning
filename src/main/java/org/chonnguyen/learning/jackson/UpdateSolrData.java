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

import com.opencsv.CSVReader;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by nhchon on 12/18/2017 2:12 PM.
 */
public class UpdateSolrData {
    public static final String BASE_DIR = "C:\\Users\\nhchon\\Pictures\\Metabiota\\GB-24351\\SolrData";
    public static final String ADM1 = "ADM1";
    public static final String NO_STATE_NAME_IN_CSCII = "NO-STATE-NAME-IN-ASCII";

    public static void main(String[] args) throws Exception{
        updateAdmin1CodesASCII();
        processRemainingModelingDataList();
    }

    public static void processRemainingModelingDataList() throws Exception{
        List<SolrRecord> solrDataList = readSolrData("UPDATE-admin1CodesASCII.txt");
        List<SolrRecord> remainModelingDataList = readModelingData("REMAIN-LIST-MODELING-DATA.csv");
        // have to get geonameId manually
        List<SolrRecord> canNotGetGeonameIdList = new ArrayList<>();

        for (SolrRecord mRecord : remainModelingDataList) {
            Integer onlineGeonameId = readGeonameId(mRecord.getCountryCode(), mRecord.getStateName(), NO_STATE_NAME_IN_CSCII);
            if (onlineGeonameId == null) {
                System.out.println("Can not get geonameId for " + mRecord.getCountryCode() + " - " + mRecord.getStateName());
                canNotGetGeonameIdList.add(mRecord);
            } else {
                // check if this geonameId already exist in Solr Data
                Optional<SolrRecord> existSolrRecordOpt = solrDataList.stream().filter(s -> s.getGeonameId().equals(onlineGeonameId.toString())).findFirst();
                if (existSolrRecordOpt.isPresent()) {
                    // update state code
                    System.out.println("Solr Data contains geonameId for " + mRecord.toString() + " with value " + onlineGeonameId + ". Just Update Geoname ID");
                    SolrRecord existSolrRecord = existSolrRecordOpt.get();
                    existSolrRecord.setStateCode(mRecord.getStateCode());
                } else {
                    // Add new record
                    solrDataList.add(new SolrRecord(mRecord.getCountryCode(), mRecord.getStateCode(), mRecord.getStateName(), mRecord.getStateName(), onlineGeonameId.toString()));
                }
            }
        }

        if (canNotGetGeonameIdList.size() > 0) {
            writeToFile(canNotGetGeonameIdList, "CAN-NOT-GET-GEONAME-ID.csv");
        } else {
            System.out.println("All records have geonameId");
        }

        writeToFile(solrDataList, "2nd-update-admin1CodesASCII.txt");
    }

    public static void updateAdmin1CodesASCII() throws Exception {
        List<SolrRecord> solrDataList = readSolrData("admin1CodesASCII.txt");
        List<SolrRecord> modelingDataList = readModelingData("Modeling-States-Name.csv");
//        System.out.println("solrDataList size: " + solrDataList.size());
//        System.out.println("modelingDataList size:" + modelingDataList.size());
//        System.exit(0);

        List<SolrRecord> newSolrDataList = new ArrayList<>();
        List<SolrRecord> duplicateCountryCodeAndStateNameModelingDataList = new ArrayList<>();
        List<String> differentGeonameId = new ArrayList<>();

        int countDuplicateCountryCodeAndStateName = 0;
        SolrRecord updateSolrRecord = null;
        for (SolrRecord solrRecord : solrDataList) {
            System.out.println("Work on solr data record " + solrRecord.toString());
            updateSolrRecord = new SolrRecord(solrRecord);
            // get an Iterator
            for (Iterator<SolrRecord> iterator = modelingDataList.iterator(); iterator.hasNext();) {
                SolrRecord mRecord = iterator.next();
                boolean theSameRecord = mRecord.getCountryCode().equals(solrRecord.getCountryCode())
                        && (compareStateName(mRecord.getStateName(), solrRecord.getStateName()) || compareStateName(mRecord.getStateName(), solrRecord.getStatenameInAscii()));
                if (theSameRecord) {
                    countDuplicateCountryCodeAndStateName++;
                    System.out.println("Duplicate: " + mRecord.toString() + " <---> " + solrRecord.toString());

                    // check geonameId
                    Integer onlineGeonameId = readGeonameId(solrRecord.getCountryCode(), solrRecord.getStateName(), solrRecord.getStatenameInAscii());
                    if (onlineGeonameId == null) {
                        System.out.println("Can not get geonameId for " + solrRecord.getCountryCode() + " - " + solrRecord.getStateName());
                        System.exit(-1);
                    }

                    String finalGeonameId = solrRecord.getGeonameId();
                    if (onlineGeonameId != null && finalGeonameId.equals(onlineGeonameId.toString())) {
                        System.out.println("The same geonameId " + finalGeonameId);
                    } else {
                        differentGeonameId.add("Different geonameId: online geonameId: " + onlineGeonameId + " solr geonameId: " + solrRecord.getGeonameId());
                        finalGeonameId = onlineGeonameId.toString();
                    }

                    updateSolrRecord = new SolrRecord(solrRecord.getCountryCode(), mRecord.getStateCode(), solrRecord.getStateName(), solrRecord.getStatenameInAscii(), finalGeonameId);

                    duplicateCountryCodeAndStateNameModelingDataList.add(mRecord);
                    // Note that Iterator.remove is the only safe way to modify a collection during iteration
                    // https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
                    iterator.remove();
                    break;
                }
            }
            newSolrDataList.add(updateSolrRecord);
        }

        System.out.println("modelingDataList size:" + modelingDataList.size());

        writeToFile(modelingDataList, "REMAIN-LIST-MODELING-DATA.csv");
        writeToFile(newSolrDataList, "1st-update-admin1CodesASCII.txt");

        System.out.println("Number of Duplicate countryCode and stateName: " + countDuplicateCountryCodeAndStateName);
        if (differentGeonameId.size() == 0) {
            System.out.println("No different geonameId");
        } else {
            differentGeonameId.forEach(System.out::println);
        }
    }

    public static Integer readGeonameId(String countryCode, String stateName, String statenameInAscii) {
        String searchContent = searchJSON(stateName);
        System.out.println(searchContent);
        JSONObject jsonObject = new JSONObject(searchContent);
        JSONArray jsonArr = jsonObject.getJSONArray("geonames");

        for(int i = 0, len = jsonArr.length(); i < len; i++) {
            JSONObject geoNameObj = jsonArr.getJSONObject(i);
            boolean isADM1 = ADM1.equals(geoNameObj.getString("fcode"));
            if (isADM1) {
                boolean isSameCountryCode = countryCode.equals(geoNameObj.getString("countryCode"));
                if (isSameCountryCode) {
                    boolean isSameSateName =
                            stateName.equalsIgnoreCase(geoNameObj.getString("toponymName"))
                            || stateName.equalsIgnoreCase(geoNameObj.getString("name"))
                            || stateName.equalsIgnoreCase(geoNameObj.getString("adminName1"))
                            || stateName.equalsIgnoreCase(geoNameObj.getString("asciiName"))

                            || statenameInAscii.equalsIgnoreCase(geoNameObj.getString("toponymName"))
                            || statenameInAscii.equalsIgnoreCase(geoNameObj.getString("name"))
                            || statenameInAscii.equalsIgnoreCase(geoNameObj.getString("adminName1"))
                            || statenameInAscii.equalsIgnoreCase(geoNameObj.getString("asciiName"));

                    if (isSameSateName) {
                        System.out.println(countryCode + "." + stateName + ": The same state name");
                        return geoNameObj.getInt("geonameId");
                    }
                }
            }
        }

        return null;
    }

    public static String searchJSON(String stateName) {
        try {
            // https://stackoverflow.com/questions/4737841/urlencoder-not-able-to-translate-space-character
            String url = "http://api.geonames.org/searchJSON?q=" + URLEncoder.encode(stateName, StandardCharsets.UTF_8.toString()).replace("+", "%20") + "&username=zhangkan654&style=full";
            System.out.println(url);
            InputStream in = new URL( url).openStream();
            return IOUtils.toString( in , StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void writeToFile(List<SolrRecord> records, String fileName) {
        String content = records.stream()
                .map( n -> n.toString() )
                .collect(Collectors.joining(System.lineSeparator()));
        try {
            Files.write(Paths.get(FilenameUtils.concat(BASE_DIR, fileName)), content.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static List<SolrRecord> readModelingData(String fileName) throws Exception {
        List<SolrRecord> records = new ArrayList<>();
        String[] record = null;
        try {
            CSVReader reader = new CSVReader(new FileReader(FilenameUtils.concat(BASE_DIR, fileName)), '\t');
            while ((record = reader.readNext()) != null) {
                String[] countryState = record[0].split("\\.");
                String countryCode = countryState[0];
                String stateCode = countryState[1];
                String stateName = record[1];
                String stateAsciiname = null;
                String geonameId = null;
                records.add(new SolrRecord(countryCode, stateCode, stateName, stateAsciiname, geonameId));
            }
        } catch (Exception ex) {
            System.out.println(Arrays.toString(record));
            ex.printStackTrace();
        }

        // sort list object
        records.sort(Comparator.comparing(a -> a.getCountryCode() + a.getStateCode()));

        //records.forEach(System.out::println);

        return records;
    }

    public static List<SolrRecord> readSolrData(String fileName) throws Exception {
        List<SolrRecord> records = new ArrayList<>();
        String[] record = null;
        try {
            CSVReader reader = new CSVReader(new FileReader(FilenameUtils.concat(BASE_DIR, fileName)), '\t');
            while ((record = reader.readNext()) != null) {
                String[] countryState = record[0].split("\\.");
                String countryCode = countryState[0];
                String stateCode = countryState[1];
                String stateName = record[1];
                String stateAsciiname = null;
                String geonameId = null;
                if (record.length == 3) {
                    System.out.println("Record without ascii name: " + Arrays.toString(record));
                    // No ascii name
                    stateAsciiname = stateName;
                    geonameId = record[2];
                } else {
                    stateAsciiname = record[2];
                    geonameId = record[3];
                }
                records.add(new SolrRecord(countryCode, stateCode, stateName, stateAsciiname, geonameId));
            }
        } catch (Exception ex) {
            System.out.println(Arrays.toString(record));
            ex.printStackTrace();
        }

        // sort list object
        records.sort(Comparator.comparing(a -> a.getCountryCode() + a.getStateCode()));

        //records.forEach(System.out::println);

        return records;
    }

    public static boolean compareStateName(String modelingStateName, String solrStateName) {
        if (modelingStateName == null || solrStateName == null)
            return false;

        modelingStateName = StringUtils.normalizeSpace(modelingStateName);
        solrStateName = StringUtils.normalizeSpace(solrStateName);

        modelingStateName = modelingStateName.replace(' ', '-');
        solrStateName = solrStateName.replace(' ', '-');

        return modelingStateName.equalsIgnoreCase(solrStateName);
    }
}
