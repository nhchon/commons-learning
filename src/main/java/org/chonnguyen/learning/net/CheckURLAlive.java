/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.net;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Calendar;

/**
 * Created by nhchon on 11/28/2017 11:16 AM.
 */
public class CheckURLAlive {

    /**
     * Issues a ping request to check if the server is alive
     *
     * @return <tt>true</tt> if the the SolrServer is alive
     */
    public boolean checkSolrServerIsAlive(String host, int port) {
        try{
            // Construct Solr URL
            URI uri = new URI("http", null, host, port, null, null, null);

            // Open http connection
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setConnectTimeout(10000); // ten secs
            connection.setReadTimeout(10000);
            connection.setRequestMethod("HEAD");

            // get and check response code
            int responseCode = connection.getResponseCode();
            return (200 <= responseCode && responseCode <= 399);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Solr Server is down at " + Calendar.getInstance().getTime());
        }

        return false;
    }
}
