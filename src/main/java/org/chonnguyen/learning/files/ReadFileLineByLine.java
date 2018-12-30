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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nhchon on 11/27/2017 5:26 PM.
 */
public class ReadFileLineByLine {
    public static void main(String[] args) throws Exception {
        final String path = "D:\\Metabiota-Docs\\checkSolrServerAliveLog.txt";

        List<String> lines = Files.readAllLines(Paths.get(path));
        List<String> rs = new ArrayList<>();

        Pattern p = Pattern.compile("\\d{2}:\\d{2}:\\d{2}\\.\\d{3}");
//        Pattern p = Pattern.compile("\\d+:\\d+:\\d+.\\d+");
        lines.forEach(l -> {
            Matcher m = p.matcher(l);
            while (m.find()) {
                //System.out.println(m.group());
                rs.add(m.group());
            };
        });

        rs.sort((String n1, String n2) -> n1.compareTo(n2));

        rs.forEach(System.out::println);
    }
}
