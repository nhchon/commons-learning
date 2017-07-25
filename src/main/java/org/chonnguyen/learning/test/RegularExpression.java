/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.test;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by nhchon on 6/27/2017 4:12 PM.
 */
public class RegularExpression {
    public static void main(String[] args) {
        String pattern ="^V[0-9]+";
        String patternDummy ="^V[0-9]+_DUMMY";

        try (Stream<Path> paths = Files.walk(Paths.get("D:\\Metabiota-Docs\\metabiota_modeling-res_deliverables-0628f5734f9c"))) {
            paths.forEach(p -> {
                if (Files.isDirectory(p)) {
                    String filePath = p.toString();
                    String name = FilenameUtils.getName(filePath);
                    if (name != null && name.startsWith("V")) {
                        String parent = FilenameUtils.getFullPath(filePath);
                        System.out.println(filePath);
                        System.out.println(parent);
                        System.out.println(name.matches(pattern));
                        System.out.println(name.matches(patternDummy));
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
