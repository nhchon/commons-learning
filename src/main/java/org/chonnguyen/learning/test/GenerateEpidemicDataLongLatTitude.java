package org.chonnguyen.learning.test;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nhchon on 6/9/2017 8:57 AM.
 */
public class GenerateEpidemicDataLongLatTitude {
    public static void main(String[] args) {
        NumberFormat nFormat = new DecimalFormat("#0.000000000000000");

        String filePath = "C:\\Users\\nhchon\\Desktop\\RES_AGGREGATED_EPIDEMIC_DATA_201706140954-Sandbox-15.csv";

        String newFilePath = "C:\\Users\\nhchon\\Desktop\\RES_AGGREGATED_EPIDEMIC_DATA_longlat.csv";
        String headerFile = "UNIQUE_KEY,EVENT_ID,LOCATION_LEVEL,COUNTRY,COUNTRY_CODE,STATE,INFECTED,HOSP,DEATHS,ROW_TYPE,GENDER,AGE_BUCKET,LATITUDE,LONGITUDE";

        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            System.out.println("The file " +
                    path.toAbsolutePath() + " does not exist.");
            return;
        }

        List<String> newLines = new ArrayList<>();
        try {
            List<String> lines = Files.lines(path).collect(Collectors.toList());
            for (int i = 1; i < lines.size(); i++) {
                String reLine = StringUtils.chop(lines.get(i));
                String newPhase = nFormat.format(RandomUtils.nextDouble(0, 100)) + "," + nFormat.format(RandomUtils.nextDouble(0, 100));
                String newLine = reLine + newPhase;
//                System.out.println(lines.get(i));
//                System.out.println(reLine);
//                System.out.println(newLine);
                //
                newLines.add(newLine);
            }

            Utils.writeCSVFile(newLines, headerFile, newFilePath);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


//        try(Stream<String> lines = Files.lines(path)) {
//            // Read and print all lines
//            // System.out::println
//            lines.forEach(l -> {
//                char last = l.charAt(l.length()-1);
//
//            });
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
