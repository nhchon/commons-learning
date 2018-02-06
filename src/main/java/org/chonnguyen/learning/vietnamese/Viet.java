/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.vietnamese;

import java.text.RuleBasedCollator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/**
 * Created by nhchon on 2/6/2018 4:12 PM.
 */
public class Viet {
    //More about RuleBasedCollator see https://docs.oracle.com/javase/tutorial/i18n/text/rule.html
    public static void main(String s[]) throws Exception {
        // copy from JackV
        Vector<String> list = new Vector<String>(Arrays.
                asList(new String[]{"Duy", "Dũng", "Trinh", "Lan", "Đạt", "1", "a"}));
        final String rules = "<0<1<2<3<4<5<6<7<8<9<@"+
                "<a,A<á<à<ả<ã<ạ<ă<ắ<ằ<ẳ<ẵ<ặ<â<ấ<ầ<ẩ<ẫ<ậ"+
                "<b<c<d,D<đ,Đ<e<é<è<ẻ<ẽ<ẹ<ê<ế<ề<ể<ễ<ệ<f<g<h"+
                "<i<í<ì<ỉ<ĩ<ị<j<k<l<m<n<o<ó<ò<ỏ<õ<ọ<ô<ố<ồ<ỗ"+
                "<ộ<ơ<ớ<ờ<ở<ỡ<ợ<p<q<r<s<t"+
                "<u<ú<ù<ủ<ũ<ụ<ư<ứ<ừ<ử<ữ"+
                "<v<w<x<y<ý<ỳ<ỷ<ỹ<ỵ<z";
        RuleBasedCollator ru = new RuleBasedCollator(rules);
        Collections.sort(list, ru);
        for (int i = 0, l = list.size(); i < l; i++)
            System.out.println(list.elementAt(i));
    }
}
