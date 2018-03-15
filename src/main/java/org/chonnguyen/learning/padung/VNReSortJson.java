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
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.chonnguyen.learning.jackson.SolrUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by nhchon on 3/14/2018 3:08 PM.
 */
public class VNReSortJson {
    public static final String BASE_DIR = "D:\\Metabiota-Docs\\VuongNgo";
    public static void main(String[] args) throws Exception {
        List<File> fs = new ArrayList(FileUtils.listFiles(new File(BASE_DIR), new String[]{"json"}, true));
        for (File f : fs) {
            // new FileInputStream(FilenameUtils.concat(BASE_DIR, "Influenza_Deaths_M1_geosummary_CN_New.json"))
            String json = readFileToString(new FileInputStream(f));

            JSONObject jObj = new JSONObject(json);

            JSONArray data = jObj.getJSONArray("data");
            List<JSONObject> objList = new ArrayList<>();

            for(int i = 0, len = data.length(); i < len; i++) {
                JSONObject obj = data.getJSONObject(i);
                objList.add(obj);
            }

            // sort
            objList.sort(Comparator.comparing(obj -> StringUtils.leftPad(obj.getString("state"), 5, "0")));

            jObj.put("data", new JSONArray(objList));

            System.out.println(jObj.toString());

            SolrUtils.writeToFile(jObj, BASE_DIR, "Sorted_"+f.getName());
        }
    }

    public static String readFileToString(FileInputStream f) throws Exception{
        return IOUtils.toString(f , StandardCharsets.UTF_8);
    }
}
