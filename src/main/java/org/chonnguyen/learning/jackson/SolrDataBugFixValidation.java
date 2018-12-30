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
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by nhchon on 12/26/2017 11:01 AM.
 */
public class SolrDataBugFixValidation {
    public static final String BASE_DIR = "C:\\Users\\nhchon\\Pictures\\Metabiota\\GB-24351\\SolrData\\UpdateData";
    public static final String PROJECT_DIR = "D:\\Projects-Axon\\db-schema\\geoname";
    public static final String ADM1 = "ADM1";
    public static final String ADM1H = "ADM1H";

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://solr-mysql.int.metabiota.com.local:3306/geonames";
    private static final String DB_USER = "dbroot";
    private static final String DB_PASSWORD = "[YOUR_PASSWORD_HERE]";

    public static void main(String[] args) throws Exception {
        //checkAllRecordsHaveGeonameIdAndCorrectCountryCode();
        //checkDuplicateRecordByCountryCodeStateCodeAndFCode();

        //List<String> rs = readDuplicateRecordsFromAllCountriesTxt2("allCountries.txt");
        //rs.forEach(System.out::println);
        //readOriginalDuplicateRecords("OriginalDuplicateRecords.txt");
        mergeOriginalRecordsAndDuplicateRecords();
    }

    public static void mergeOriginalRecordsAndDuplicateRecords() throws Exception {
        List<MergedGeonameRecord> finalResult = new ArrayList<>();
        List<OriginalGeonameRecord> originalRecords = readOriginalDuplicateRecords("OriginalDuplicateRecords.txt");
        List<GeonameRecord> dupRecords = readDuplicateRecords("duplicateRecords.txt");

        for (GeonameRecord dRecord : dupRecords) {
            Optional<OriginalGeonameRecord> oRecord = originalRecords.stream().filter(o -> o.getGeonameId().equals(dRecord.getGeonameId())).findFirst();
            if (oRecord.isPresent()) {
                MergedGeonameRecord m = new MergedGeonameRecord(dRecord.getGeonameId(), dRecord.getCountryCode(), dRecord.getStateCode(), dRecord.getfCode());
                m.setOriCountryCode(oRecord.get().getCountryCode());
                m.setOriStateCode(oRecord.get().getStateCode());
                m.setOriFCode(oRecord.get().getfCode());
                m.setOriGeonameId(oRecord.get().getGeonameId());
                m.setOriStateName(oRecord.get().getStateName());

                finalResult.add(m);
            }
        }

        finalResult.forEach(System.out::println);

        SolrUtils.writeToFile(finalResult, BASE_DIR, "COMPARE-STATE-CODE.csv");
    }

    public static List<OriginalGeonameRecord> readOriginalDuplicateRecords(String fileName) throws Exception{
        List<OriginalGeonameRecord> originalRecords = new ArrayList<>();

        try(BufferedReader in = new BufferedReader(new FileReader(FilenameUtils.concat(BASE_DIR, fileName)))) {
            String line;
            while ((line = in.readLine()) != null) {
                // process line here.
                OriginalGeonameRecord originalRecord = new OriginalGeonameRecord();
                String[] arr = line.split("\t");
                System.out.println("");
                System.out.println("geonameId: " + arr[0]);
                originalRecord.setGeonameId(arr[0]);
                System.out.println("name: " + arr[1]);
                System.out.println("asciiName: " + arr[2]);
                originalRecord.setStateName(arr[2]);
                System.out.println("alternateNames: " + arr[3]);
                System.out.println("latitude: " + arr[4]);
                System.out.println("longitude: " + arr[5]);
                System.out.println("featureClass: " + arr[6]);
                System.out.println("featureCode: " + arr[7]);
                originalRecord.setfCode(arr[7]);
                System.out.println("countryCode: " + arr[8]);
                originalRecord.setCountryCode(arr[8]);
                System.out.println("cc2: " + arr[9]);
                System.out.println("admin1Code: " + arr[10]);
                originalRecord.setStateCode(arr[10]);
                System.out.println("admin2Code: " + arr[11]);
                System.out.println("admin3Code: " + arr[12]);
                System.out.println("admin4Code: " + arr[13]);
                System.out.println("elevation: " + arr[14]);
                System.out.println("dem: " + arr[15]);
                System.out.println("population: " + arr[16]);
                System.out.println("timezone: " + arr[17]);
                System.out.println("modificationDate: " + arr[18]);

                originalRecords.add(originalRecord);
            }
        }

        return originalRecords;
    }

    public static List<String> readDuplicateRecordsFromAllCountriesTxt2(String fileName) throws Exception {
        List<GeonameRecord> dupRecords = readDuplicateRecords("duplicateRecords.txt");
        System.out.println(dupRecords.size());

        List<String> recordsFromAllCountriesTxt = new ArrayList<>();
        int count = 0;
        try(BufferedReader in = new BufferedReader(new FileReader(FilenameUtils.concat(BASE_DIR, fileName)))) {
            String line;
            while ((line = in.readLine()) != null) {
                // process line here.
                String geonameId = line.split("\t")[0];
                Optional<GeonameRecord> dRecord = dupRecords.stream().filter(d -> d.getGeonameId().equals(geonameId)).findFirst();
                if (dRecord.isPresent()) {
                    System.out.println("Line " + ++count + ":" + line);
                    recordsFromAllCountriesTxt.add(line);
                }
            }
        }
        return recordsFromAllCountriesTxt;
    }

    public static List<GeonameRecord> readDuplicateRecords(String fileName) throws Exception {
        List<GeonameRecord> records = new ArrayList<>();
        String[] line = null;
        try (CSVReader reader = new CSVReader(new FileReader(FilenameUtils.concat(BASE_DIR, fileName)), '\t');) {
            while ((line = reader.readNext()) != null) {
                GeonameRecord r = new GeonameRecord();
                r.setGeonameId(line[0]);
                r.setCountryCode(line[1]);
                r.setStateCode(line[2]);
                r.setfCode(line[3]);

                records.add(r);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // sort list object
        //records.sort(Comparator.comparing(a -> a.getCountryCode() + a.getStateCode()));
        return records;
    }

    public static List<String> readDuplicateRecordsFromAllCountriesTxt(String fileName) throws Exception {
        List<GeonameRecord> dupRecords = readDuplicateRecords("duplicateRecords.txt");

        System.out.println(dupRecords.size());

        List<String> recordsFromAllCountriesTxt = new ArrayList<>();
        String[] line = null;
        try (CSVReader reader = new CSVReader(new FileReader(FilenameUtils.concat(BASE_DIR, fileName)), '\t')) {
            int count = 0;
            while ((line = reader.readNext()) != null) {
                System.out.println(++count );
                if (count == 100000) {
                    System.exit(-1);
                }

                String geonameId = line[0];
                Optional<GeonameRecord> dRecord = dupRecords.stream().filter(d -> d.getGeonameId().equals(geonameId)).findFirst();
                if (dRecord.isPresent()) {
                    recordsFromAllCountriesTxt.add(String.join(", ", line));
                }
//                geonameId;
//                name;
//                asciiName;
//                alternateNames;
//                latitude;
//                longitude;
//                featureClass;
//                featureCode;
//                countryCode;
//                cc2;
//                admin1Code;
//                admin2Code;
//                admin3Code;
//                admin4Code;
//                elevation;
//                dem;
//                population;
//                timezone;
//                modificationDate;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // sort list object
        //records.sort(Comparator.comparing(a -> a.getCountryCode() + a.getStateCode()));
        return recordsFromAllCountriesTxt;
    }

    public static void checkDuplicateRecordByCountryCodeStateCodeAndFCode() {
        Map<GeonameRecord, List<GeonameRecord>> duplicateRecords = new HashMap<>();
        System.out.println("Working ...");
        try (Connection c = getDBConnection();
             PreparedStatement stat = c.prepareStatement("SELECT * FROM geoname WHERE feature_code='ADM1'",
                                                            ResultSet.TYPE_FORWARD_ONLY,
                                                            ResultSet.CONCUR_READ_ONLY);) {
            stat.setFetchSize(Integer.MIN_VALUE);
            ResultSet results = stat.executeQuery();
            while (results.next()) {
                GeonameRecord record = new GeonameRecord(results.getString("geonameid"), results.getString("cc"),
                        results.getString("admin1"), results.getString("feature_code"));

                Optional<GeonameRecord> dupGeonameRecord = duplicateRecords.keySet().stream().filter(k -> k.duplicateCountryStateAndFCode(record)).findFirst();
                if (dupGeonameRecord.isPresent()) {
                    duplicateRecords.get(dupGeonameRecord.get()).add(record);
                } else {
                    List<GeonameRecord> list = new ArrayList<>();
                    list.add(record);
                    duplicateRecords.put(record, list);
                }
            }

            results.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        // remove non-duplicate
        for (Iterator<GeonameRecord> iterator = duplicateRecords.keySet().iterator(); iterator.hasNext();) {
            GeonameRecord r = iterator.next();
            if (duplicateRecords.get(r).size() == 1) {
                iterator.remove();
            }
        }

        // concentrate
        List<GeonameRecord> finalDuplicateList = new ArrayList<>();
        for (Iterator<GeonameRecord> iterator = duplicateRecords.keySet().iterator(); iterator.hasNext();) {
            finalDuplicateList.addAll(duplicateRecords.get(iterator.next()));
        }

        // display
        finalDuplicateList.sort(Comparator.comparing(a -> a.getCountryCode() + a.getStateCode() + StringUtils.leftPad(a.getGeonameId(), 20, '0')));
        String content = finalDuplicateList.stream()
                .map( n -> n.toString() )
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(content);
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }


    /**
     * This check prevent case we copy incorrect geonameId from one countryCode to anotherCountry
     * For bug GB-25190
     */
    public static void checkAllRecordsHaveGeonameIdAndCorrectCountryCode() throws Exception {
        List<SolrRecord> solrRecords = SolrUtils.readSolrData(PROJECT_DIR, "admin1CodesASCII.txt");
        List<String> errors = new ArrayList<>();

        System.out.println("solrRecords.size(): " + solrRecords.size());

        for (int i=0; i<solrRecords.size(); i++) {
            SolrRecord solr = solrRecords.get(i);

            String searchContent = SolrUtils.searchJSONByGeonameId(solr.getGeonameId());
            JSONObject geoNameObj = new JSONObject(searchContent);

            String fCode = geoNameObj.getString("fcode");
            boolean isADM1 = ADM1.equals(fCode);
            boolean isADM1H = ADM1H.equals(fCode);

            String countryCode = geoNameObj.getString("countryCode");

            if (!(isADM1 || isADM1H)
                    || !solr.getCountryCode().equals(countryCode)) {
                errors.add("Geonames.org value: " + fCode + ", " + countryCode + "; " + solr.toString());
            } else {
                System.out.println(solr.toString() + ": OK");
            }
        }

        for (String error : errors) {
            System.out.println(error);
        }
    }
}
