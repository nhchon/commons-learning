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
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by nhchon on 12/20/2017 10:27 AM.
 */
public class UpdateSolrDataValidation {
    public static final String BASE_DIR = "C:\\Users\\nhchon\\Pictures\\Metabiota\\GB-24351\\SolrData\\UpdateData";
    public static final String ORIGINAL_BASE_DIR = "C:\\Users\\nhchon\\Pictures\\Metabiota\\GB-24351\\SolrData\\OriginData";
    public static final String QUERY_FCODE_BY_GEONAMEID = "select feature_code from geoname where geonameid = ?";
    public static final String ADM1 = "ADM1";
    public static List<SolrRecord> solrDataList;
    public static List<SolrRecord> modelingDataList;

    public static void main(String[] args) throws Exception {
        solrDataList = readSolrData("D:\\Projects-Axon\\db-schema\\geoname", "admin1CodesASCII.txt");
        modelingDataList = readModelingData("Modeling-States-Name.csv");

        System.out.println("solrDataList.size(): " + solrDataList.size());
        System.out.println("modelingDataList.size(): " + modelingDataList.size());

        checkAllSateCodeFromModelingTeamExistInUpdateSolrData();

        checkDuplicateCountryCodeAndStateCodeAfterUpdateSolrData();

        checkDuplicateGeonameId();

        checkAllGeonameIdsHaveFCodeADM1();
    }

    public static void checkAllGeonameIdsHaveFCodeADM1() throws Exception{
        solrDataList = readSolrData("admin1CodesASCII.txt");
        List<String> notADM1FCodeList = new ArrayList<>();

        DBI jdbi = new DBI("jdbc:mysql://solr-mysql.int.metabiota.com.local:3306/geonames",
                "dbroot", "[YOUR_PASSWORD_HERE]");
        try (Handle handle = jdbi.open()) {
            for (SolrRecord solrRecord : solrDataList) {
                String fCode = handle.createQuery(QUERY_FCODE_BY_GEONAMEID)
                        .bind(0, Integer.parseInt(solrRecord.getGeonameId()))
                        .mapTo(String.class)
                        .first();
                if (!ADM1.equals(fCode)) {
                    notADM1FCodeList.add(solrRecord + " has fcode " + fCode);
                } else {
                    System.out.println(solrRecord + ": OK");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // print out error record
        notADM1FCodeList.forEach(System.out::println);
    }

    public static void checkDuplicateGeonameId() throws Exception {
        // read solr data again
        solrDataList = readSolrData("admin1CodesASCII.txt");

        for (Iterator<SolrRecord> iterator = solrDataList.iterator(); iterator.hasNext();) {
            SolrRecord solrRecord = iterator.next();

            /*
             Remove this element for check duplicate
             Note that Iterator.remove is the only safe way to modify a collection during iteration
             https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
             */
            iterator.remove();
            //System.out.println("solrDataList.size(): " + solrDataList.size() + " Current record: " + solrRecord.toString());

            Optional<SolrRecord> solrRecordOpt = solrDataList.stream().filter(s -> Objects.equals(s.getGeonameId(), solrRecord.getGeonameId())).findFirst();
            if (solrRecordOpt.isPresent()) {
                System.out.println(solrRecord + " is duplicate geonameId");
                System.exit(-1);
            }
        }
        System.out.println("No duplicate geonamId records");
    }

    public static void checkDuplicateCountryCodeAndStateCodeAfterUpdateSolrData() {
        for (Iterator<SolrRecord> iterator = solrDataList.iterator(); iterator.hasNext();) {
            SolrRecord solrRecord = iterator.next();

            /*
             Remove this element for check duplicate
             Note that Iterator.remove is the only safe way to modify a collection during iteration
             https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
             */
            iterator.remove();
            //System.out.println("solrDataList.size(): " + solrDataList.size() + " Current record: " + solrRecord.toString());

            Optional<SolrRecord> solrRecordOpt = solrDataList.stream().filter(s -> isSameCountryCodeAndStateCode(s, solrRecord)).findFirst();
            if (solrRecordOpt.isPresent()) {
                System.out.println(solrRecord + " is duplicate");
                System.exit(-1);
            }
        }
        System.out.println("No duplicate records");
    }

    public static void checkAllSateCodeFromModelingTeamExistInUpdateSolrData() {
        for (final SolrRecord mRecord : modelingDataList) {
            Optional<SolrRecord> solrRecordOpt = solrDataList.stream().filter(s -> isSameCountryCodeAndStateCode(s, mRecord)).findFirst();
            if (!solrRecordOpt.isPresent()) {
                System.out.println(mRecord + " does not exist in final Solr Data");
                System.exit(-1);
            }
        }
        System.out.println("All Data from Modeling Team exist in Solr Data Update List");
    }

    public static boolean isSameCountryCodeAndStateCode(SolrRecord solrRecord, SolrRecord modelingRecord) {
        return Objects.equals(solrRecord.getCountryCode(), modelingRecord.getCountryCode())
            && Objects.equals(solrRecord.getStateCode(), modelingRecord.getStateCode());
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
        return records;
    }

    public static List<SolrRecord> readSolrData(String baseDir, String fileName) throws Exception {
        List<SolrRecord> records = new ArrayList<>();
        String[] record = null;
        try {
            CSVReader reader = new CSVReader(new FileReader(FilenameUtils.concat(baseDir, fileName)), '\t');
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

                if (StringUtils.isEmpty(stateName) || StringUtils.isEmpty(stateAsciiname)) {
                    System.out.println("Record without enough data: " + Arrays.toString(record));
                }
                records.add(new SolrRecord(countryCode, stateCode, stateName, stateAsciiname, geonameId));
            }
        } catch (Exception ex) {
            System.out.println(Arrays.toString(record));
            ex.printStackTrace();
        }
        // sort list object
        records.sort(Comparator.comparing(a -> a.getCountryCode() + a.getStateCode()));
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
        return records;
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
}
