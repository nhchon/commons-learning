/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.jackson;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by nhchon on 1/9/2018 2:34 PM.
 */
public class ReadLabels {
    public static final String EVENT_NAME = "Congenital Zika syndrome_Suriname_2016";
    // Congenital Zika syndrome_Grenada_2016
    // Congenital Zika syndrome_Suriname_2016
    // Zika virus_Caribbean Netherlands_2017\
    // Hantavirus
    public static final String SOURCE = "Metabiota Best";
    public static final String BASE_DIR = "C:\\Users\\nhchon\\Pictures\\Metabiota\\GB-24445";

    public static void main(String[] args) throws Exception {
        String labelsJson = SolrUtils.readFileToString(FilenameUtils.concat(BASE_DIR, "labels_prod.txt"));
        JSONArray jsonArr = new JSONArray(labelsJson);

        List<String>  ids  = new ArrayList<>();

        for(int i = 0, len = jsonArr.length(); i < len; i++) {
            JSONObject labelObj = jsonArr.getJSONObject(i);
            String eventName = labelObj.getString("eventName");
            String source = labelObj.getString("source");

            if (Objects.equals(eventName, EVENT_NAME) && Objects.equals(source, SOURCE)) {
                System.out.println(labelObj.getString("id"));
                ids.add(labelObj.getString("id"));
            }
        }

        System.out.println(ids);
    }
}
