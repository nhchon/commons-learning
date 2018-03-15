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

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by nhchon on 2/6/2018 3:14 PM.
 */
public class LietKeGBIssues {
    public static final String BASE_DIR = "D:\\Metabiota-Docs\\features\\catalogAnalyzer";

    public static void main(String[] args) {
        List<File> fs = new ArrayList(FileUtils.listFiles(new File(BASE_DIR), new String[]{"feature"}, true));

        List<String> rs = new ArrayList<>();
        int count = 0;
        for (File f : fs) {
            List<String> lines = readFileToList(f.getAbsolutePath());
            for (String line : lines) {
                //String pattern = "GB-\\d+";
                Pattern pattern = Pattern.compile("GB-\\d+");
                final Matcher m = pattern.matcher(line);
                while (m.find()) {
                    String issue = m.group(0);
                    if (!rs.contains(issue)) {
                        rs.add(issue);
                    }
                    //System.out.println(++count + " : " + m.group(0));
                }
            }
        }

        rs.sort(String::compareToIgnoreCase);
        for (int i=0; i<rs.size(); i++) {
            System.out.println(rs.get(i));
        }
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

}


