/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.files;

import org.apache.commons.io.FilenameUtils;
import org.chonnguyen.learning.jackson.OriginalGeonameRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/**
 * Created by nhchon on 2/28/2018 3:18 PM.
 */
public class CheckDuplicateRows {

    public static final String ID_SEPARATOR = ":";
    public static final String BASE_DIR = "C:\\Users\\nhchon\\Pictures\\Metabiota\\GB-25619";

    public static void main(String[] args) throws Exception {
        Set<String> distinctUniqueIds = new HashSet<>();
        Set<String> distinctLines = new HashSet<>();
        Map<Integer, String> duplicateLines = new HashMap<>();
        Set<String> duplicatedGroupTitle = new HashSet<>();
        int duplicateLine = 0;
        try(BufferedReader in = new BufferedReader(new FileReader(FilenameUtils.concat(BASE_DIR, "khoahoang-generic_file-56MB-duplicated.csv")))) {
            // ignore header line
            String line = in.readLine();

            // process data lines
            int lineNum = 0;
            while ((line = in.readLine()) != null) {
                lineNum++;
                duplicateLines.put(lineNum, line);

                // process line here
                String[] arr = line.split(",");
                // build unique id
                // GroupTitle,Units,StreetAddress,City,State,Zip,Country,Latitude,Longitude
                StringBuffer b = new StringBuffer();
                b.append(arr[0]); // GroupTitle
                b.append(ID_SEPARATOR);
                b.append(arr[2]); // StreetAddress
                b.append(ID_SEPARATOR);
                b.append(arr[3]); // City
                b.append(ID_SEPARATOR);
                b.append(arr[4]); // State
                b.append(ID_SEPARATOR);
                b.append(arr[5]); // Zip
                b.append(ID_SEPARATOR);
                b.append(arr[6]); // Country
                b.append(ID_SEPARATOR);
                b.append(arr[7]); // Latitude
                b.append(ID_SEPARATOR);
                b.append(arr[8]); // Longitude
                String uniqueId = b.toString();

                if (distinctUniqueIds.contains(uniqueId)) {
                    duplicateLine++;
                    System.out.println("Duplicate line: " + duplicateLine + " : " + uniqueId);
                    duplicatedGroupTitle.add(arr[0]);
                } else {
                    distinctUniqueIds.add(uniqueId);
                    distinctLines.add(line);
                }
            }
        }

        System.out.println("Num of duplicate line: " + duplicateLine);
        System.out.println("Num of distinct line: " + distinctUniqueIds.size());

        // write distinct lines to files
        FileWriter fw = new FileWriter(FilenameUtils.concat(BASE_DIR, "khoahoang-generic_file-56MB-distinct-duplicated-lines.csv"));
        fw.write("GroupTitle,Units,StreetAddress,City,State,Zip,Country,Latitude,Longitude");
        fw.write(System.lineSeparator());

        for (String line : distinctLines) {
            fw.write(line);
            fw.write(System.lineSeparator());
        }

        fw.close();
        System.out.println("Finish writing file");
//        duplicatedGroupTitle.forEach(System.out::println);
//
//        // write duplicate line to new file
//
//        FileWriter fw = new FileWriter(FilenameUtils.concat(BASE_DIR, "khoahoang-generic_file-56MB-duplicated.csv"));
//        fw.write("GroupTitle,Units,StreetAddress,City,State,Zip,Country,Latitude,Longitude");
//        fw.write(System.lineSeparator());
//
//        try(BufferedReader in = new BufferedReader(new FileReader(FilenameUtils.concat(BASE_DIR, "khoahoang-generic_file-56MB.csv")))) {
//            // ignore header line
//            String line = in.readLine();
//
//            // process data lines
//            int lineNum = 0;
//            while ((line = in.readLine()) != null) {
//                lineNum++;
//
//                // process line here
//                String[] arr = line.split(",");
//                if (duplicatedGroupTitle.contains(arr[0])) { // GroupTitle
//                    fw.write(line);
//                    fw.write(System.lineSeparator());
//                }
//            }
//        }
//        fw.close();
    }
}
