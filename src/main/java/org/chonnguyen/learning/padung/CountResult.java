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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhchon on 12/21/2017 1:53 PM.
 */
public class CountResult {
    private String issue;
    private List<String> fileNames;

    public CountResult(String issue, List<String> fileNames) {
        this.issue = issue;
        this.fileNames = fileNames;
    }

    public CountResult(String issue) {
        this.issue = issue;
        fileNames = new ArrayList<>();
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    public void setFileNames(String fileName) {
        this.fileNames.add(fileName);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(issue);
        b.append(":");
        b.append(System.lineSeparator());

        for (String l : fileNames) {
            b.append("\t\t\t");
            b.append(l);
        }

        b.append(System.lineSeparator());

        return b.toString();
    }
}
