/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.basic;

/**
 * Created by nhchon on 10/23/2017 4:24 PM.
 */
public class ConcreteProcessorA extends AbstractProcessor {
    @Override
    public void process() {
        concreteBusinessLogic();
    }

    public void concreteBusinessLogic() {
        System.out.println("ConcreteProcessorA");
    }
}
