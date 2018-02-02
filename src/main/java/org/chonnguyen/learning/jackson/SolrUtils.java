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

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nhchon on 12/26/2017 11:08 AM.
 */
public class SolrUtils {
    public static String searchJSONByGeonameId(String geonameId) {
        try {
            // https://stackoverflow.com/questions/4737841/urlencoder-not-able-to-translate-space-character
            String url = "http://api.geonames.org/getJSON?geonameId=" + geonameId + "&username=chonnh";
            System.out.println(url);
            InputStream in = new URL( url).openStream();
            return IOUtils.toString( in , StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
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
                    // No ascii name
                    stateAsciiname = stateName;
                    geonameId = record[2];
                } else {
                    stateAsciiname = record[2];
                    geonameId = record[3];
                }

                if (StringUtils.isEmpty(stateName) || StringUtils.isEmpty(stateAsciiname)) {
                    System.out.println("Record without enough data: " + Arrays.toString(record));
                    if (StringUtils.isEmpty(stateName)) {
                        stateName = stateAsciiname;
                    }

                    if (StringUtils.isEmpty(stateAsciiname)) {
                        stateAsciiname = stateName;
                    }
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

    public static <T extends Object> void writeToFile(List<T> records, String baseDir, String fileName) {
        String content = records.stream()
                .map( n -> n.toString() )
                .collect(Collectors.joining(System.lineSeparator()));
        try {
            Files.write(Paths.get(FilenameUtils.concat(baseDir, fileName)), content.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String readFileToString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)),StandardCharsets.UTF_8);
    }
}
