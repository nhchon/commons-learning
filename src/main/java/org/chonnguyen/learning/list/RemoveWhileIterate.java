/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhchon on 2/7/2018 11:09 AM.
 */
public class RemoveWhileIterate {
    public static void main(String[] args) {
        List<String> exposureDataDOList = new ArrayList<>();
        for (int i=0; i<1000000; i++) {
            exposureDataDOList.add("a");
        }

        exposureDataDOList.add("b");
        exposureDataDOList.add("b");

        exposureDataDOList.add("c");

        if (!exposureDataDOList.isEmpty()) {
            String currentFileId = exposureDataDOList.get(0);
            String tmpFileId;
            int count = 1;
            while (count < exposureDataDOList.size()) {
                tmpFileId = exposureDataDOList.get(count);
                if (currentFileId.equals(tmpFileId)) {
                    exposureDataDOList.remove(count);
                } else {
                    currentFileId = tmpFileId;
                    ++count;
                }
            }
        }

        exposureDataDOList.forEach(System.out::println);
    }
}
