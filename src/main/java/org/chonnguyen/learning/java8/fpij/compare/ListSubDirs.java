/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package  org.chonnguyen.learning.java8.fpij.compare;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ListSubDirs {
    public static void listTheHardWay() {
        List<File> files = new ArrayList<>();

        File[] filesInCurrentDir = new File(".").listFiles();
        for (File file : filesInCurrentDir) {
            File[] filesInSubDir = file.listFiles();
            if (filesInSubDir != null) {
                files.addAll(Arrays.asList(filesInSubDir));
            } else {
                files.add(file);
            }
        }

        System.out.println("Count: " + files.size());
    }

    public static void betterWay() throws Exception {
        List<File> files =
                Stream.of(new File("D:\\Metabiota-Docs\\metabiota_modeling-res_deliverables-0628f5734f9c").listFiles())
                        .flatMap(file -> file.listFiles() == null ?
                                Stream.of(file) : Stream.of(file.listFiles()))
                        .collect(toList());
        files.forEach(f -> {
            try {
                System.out.println("===================================================================================");
                System.out.println(f.getAbsolutePath());
                System.out.println(f.getCanonicalPath());
                System.out.println(f.getName());
                System.out.println(f.getParent());
                System.out.println(f.getPath());
                System.out.println("===================================================================================");
            }
            catch (Exception ex) {}
        });
        System.out.println("Count: " + files.size());
    }

    public static void main(String[] args) throws Exception{
        System.out.println("START:HARDWAY_OUTPUT");
        listTheHardWay();
        System.out.println("END:HARDWAY_OUTPUT");
        betterWay();
    }
}
