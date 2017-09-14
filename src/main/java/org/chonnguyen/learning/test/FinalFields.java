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

/**
 * Created by nhchon on 8/10/2017 3:42 PM.
 */
public class FinalFields {
    public final int abc;

    public FinalFields() {
        abc =10;
    }

    public FinalFields(int value) {
        abc = value;
    }


    public static void main(String[] args) {
        FinalFields f1 = new FinalFields();
        FinalFields f2 = new FinalFields(99);
        //FinalFields f3 = new FinalFields("dummy");

        System.out.println(f1.abc);

        System.out.println(f2.abc);

        boolean b1 = true;

        Boolean b2 = null;

        b1 = b2;

        System.out.println(b1);

        //f3.abc = 11;
        //System.out.println(f3.abc);
    }

}
