package org.chonnguyen.learning.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by nhchon on 5/18/2017 1:54 PM.
 */
public class DateTest {
    public static void main(String[] args) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String valueStr = "1-07-06";
        Date date = dateFormat.parse(valueStr);
        System.out.println(date);

//        Calendar a = getCalendar(233884800000L);
//        Calendar b = getCalendar(1487980800000L);
//
//        System.out.println(a.get(Calendar.YEAR));
//
//        System.out.println(b.get(Calendar.YEAR));
//        System.out.println(b.get(Calendar.YEAR) - a.get(Calendar.YEAR));
    }

    public static int getDiffYears(Long firstTimestamp, Long lastTimestamp) {
        if (firstTimestamp == null || lastTimestamp == null) {
            return 0;
        }

        Calendar a = getCalendar(firstTimestamp);
        Calendar b = getCalendar(lastTimestamp);
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        return diff;
    }

    public static Calendar getCalendar(Long timestamp) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.setTimeInMillis(timestamp);
        return cal;
    }

}
