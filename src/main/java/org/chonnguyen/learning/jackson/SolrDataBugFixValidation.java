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

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhchon on 12/26/2017 11:01 AM.
 */
public class SolrDataBugFixValidation {
    public static final String PROJECT_DIR = "D:\\Projects-Axon\\db-schema\\geoname";
    public static final String ADM1 = "ADM1";
    public static final String ADM1H = "ADM1H";

    public static void main(String[] args) throws Exception {
        checkAllRecordsHaveGeonameIdAndCorrectCountryCode();
    }

    /**
     * This check prevent case we copy incorrect geonameId from one countryCode to anotherCountry
     * For bug GB-25190
     */
    public static void checkAllRecordsHaveGeonameIdAndCorrectCountryCode() throws Exception {
        List<SolrRecord> solrRecords = SolrUtils.readSolrData(PROJECT_DIR, "admin1CodesASCII.txt");
        List<String> errors = new ArrayList<>();

        System.out.println("solrRecords.size(): " + solrRecords.size());

        for (int i=0; i<solrRecords.size(); i++) {
            SolrRecord solr = solrRecords.get(i);

            String searchContent = SolrUtils.searchJSONByGeonameId(solr.getGeonameId());
            JSONObject geoNameObj = new JSONObject(searchContent);

            String fCode = geoNameObj.getString("fcode");
            boolean isADM1 = ADM1.equals(fCode);
            boolean isADM1H = ADM1H.equals(fCode);

            String countryCode = geoNameObj.getString("countryCode");

            if (!(isADM1 || isADM1H)
                    || !solr.getCountryCode().equals(countryCode)) {
                errors.add("Geonames.org value: " + fCode + ", " + countryCode + "; " + solr.toString());
            } else {
                System.out.println(solr.toString() + ": OK");
            }
        }

        for (String error : errors) {
            System.out.println(error);
        }
    }
}
