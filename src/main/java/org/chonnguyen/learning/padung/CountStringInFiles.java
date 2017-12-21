/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.padung;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.chonnguyen.learning.jackson.SolrRecord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by nhchon on 12/21/2017 1:43 PM.
 */
public class CountStringInFiles {
    public static final String BASE_DIR = "D:\\Metabiota-Docs\\Dung";

    public static void main(String[] args) throws Exception {
        // UI feature
        List<CountResult> uiResults = doIt(BASE_DIR, "UIfeature\\list use to compare.txt", "UIfeature\\Files");
        // API feature
        List<CountResult> apiResults = doIt(BASE_DIR, "APIfeature\\list use to compare.txt", "APIfeature\\Files\\Files");

//        List<String> uiIssues = readFileToList(BASE_DIR, "UIfeature\\list use to compare.txt");
//        List<String> filesNames = Files.list(Paths.get(FilenameUtils.concat(BASE_DIR, "UIfeature\\Files")))
//                .filter(Files::isRegularFile)
//                .map(f -> f.toFile().getAbsolutePath())
//                .collect(Collectors.toList());
//        filesNames.forEach(System.out::println);
//
//        for (String issue : uiIssues) {
//            CountResult result = new CountResult(issue);
//            for (String fileName : filesNames) {
//                // Check need to read file or not
//                List<String> lines = linesOfFile.get(fileName);
//                if (lines == null) {
//                    lines = readFileToList(fileName);
//                    linesOfFile.put(fileName, lines);
//                }
//                //
//                for (String line : lines) {
//                    if (StringUtils.containsIgnoreCase(line, issue)) {
//                        result.setFileNames(fileName);
//                        break;
//                    }
//                }
//            }
//
//            results.add(result);
//        }
//        results.sort(Comparator.comparing(a -> -1 * a.getFileNames().size()));
//        results.forEach(System.out::println);
        //uiResults.forEach(System.out::println);

        writeToFile(uiResults, "UIfeature_result.txt");
        writeToFile(apiResults, "APIfeature_result.txt");
    }

    public static  List<CountResult> doIt(String baseDir, String issueFileName, String folderName) throws Exception {
        List<CountResult> results = new ArrayList<>();
        Map<String, List<String>> linesOfFile = new HashMap<>();

        List<String> uiIssues = readFileToList(baseDir, issueFileName);
        List<String> filesNames = Files.list(Paths.get(FilenameUtils.concat(baseDir, folderName)))
                .filter(Files::isRegularFile)
                .map(f -> f.toFile().getAbsolutePath())
                .collect(Collectors.toList());

        filesNames.forEach(System.out::println);

        for (String issue : uiIssues) {
            CountResult result = new CountResult(issue);
            for (String fileName : filesNames) {
                System.out.println(fileName);
                // Check need to read file or not
                List<String> lines = linesOfFile.get(fileName);
                if (lines == null) {
                    lines = readFileToList(fileName);
                    linesOfFile.put(fileName, lines);
                }
                //
                for (String line : lines) {
                    if (StringUtils.containsIgnoreCase(line, issue)) {
                        result.setFileNames(fileName);
                        break;
                    }
                }
            }

            results.add(result);
        }
        results.sort(Comparator.comparing(a -> -1 * a.getFileNames().size()));

        return results;
    }

    public static List<String> readFileToList(String baseDir, String fileName) {
        try {
            return new BufferedReader(new FileReader(FilenameUtils.concat(baseDir, fileName))).lines().filter(l -> l != null && !"".equals(l.trim())).collect(Collectors.toList());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return null;
    }

    public static List<String> readFileToList(String fullPath) {
        try {
            return new BufferedReader(new FileReader(fullPath)).lines().filter(l -> l != null && !"".equals(l.trim())).collect(Collectors.toList());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return null;
    }

    public static void writeToFile(List<CountResult> records, String fileName) {
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
