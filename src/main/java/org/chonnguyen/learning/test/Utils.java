package org.chonnguyen.learning.test;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by nhchon on 6/7/2017 9:56 AM.
 */
public class Utils {
    public static String getRandomDateOfBirth() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2010);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return (gc.get(gc.YEAR) + "-" + StringUtils.leftPad((gc.get(gc.MONTH) + 1) + "", 2, '0') + "-" + StringUtils.leftPad(gc.get(gc.DAY_OF_MONTH) + "", 2, '0'));

    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public static <T extends Object> void writeCSVFile(List<T> objs, String csvHeaderLine, String fileName) throws Exception {
        File fout = new File(fileName);
        try (
                FileOutputStream fos = new FileOutputStream(fout);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8));
        ) {
            bw.write(csvHeaderLine);
            bw.newLine();
            for(T r : objs) {
                bw.write(r.toString());
                bw.newLine();
            }
        }
    }
}
