/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.concurrency;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

/**
 * Created by nhchon on 9/13/2017 4:23 PM.
 */
public class LinkFinder implements Runnable {

    private String url;
    private LinkHandler linkHandler;
    /**
     * Used fot statistics
     */
    private static final long t0 = System.nanoTime();

    public LinkFinder(String url, LinkHandler handler) {
        this.url = url;
        this.linkHandler = handler;
    }

    @Override
    public void run() {
        getSimpleLinks(url);
    }

    private void getSimpleLinks(String url) {
        //if not already visited
        if (!linkHandler.visited(url)) {
            try {
                URL uriLink = new URL(url);
                Parser parser = new Parser(uriLink.openConnection());
                NodeList list = parser.extractAllNodesThatMatch(new NodeClassFilter(LinkTag.class));
                List<String> urls = new ArrayList<String>();

                for (int i = 0; i < list.size(); i++) {
                    LinkTag extracted = (LinkTag) list.elementAt(i);

                    if (!extracted.getLink().isEmpty()
                            && !linkHandler.visited(extracted.getLink())) {

                        urls.add(extracted.getLink());
                    }

                }
                //we visited this url
                linkHandler.addVisited(url);

                if (linkHandler.size() == 1500) {
                    System.out.println("Time to visit 1500 distinct links = " + (System.nanoTime() - t0));
                }

                for (String l : urls) {
                    linkHandler.queueLink(l);
                }

            } catch (Exception e) {
                //ignore all errors for now
            }
        }
    }
}