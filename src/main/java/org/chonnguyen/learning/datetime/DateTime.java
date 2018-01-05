/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.datetime;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by nhchon on 1/4/2018 2:38 PM.
 */
public class DateTime {
    private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";

    public static void main(String[] args) {
        example2();
    }

    public static void example2() {
        final Date currentTime = new Date();

        final SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");

        // Give it to me in US-Pacific time.
        sdf.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        System.out.println("US-Pacific time: " + sdf.format(currentTime));

        // Give it to me in GMT-0 time.
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println("GMT time: " + sdf.format(currentTime));

        // Or maybe Zagreb local time.
        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Zagreb"));
        System.out.println("Zagreb time: " + sdf.format(currentTime));

        // Even 10 hours and 10 minutes ahead of GMT
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+0010"));
        System.out.println("10/10 ahead time: " + sdf.format(currentTime));

        sdf.setTimeZone(TimeZone.getTimeZone("GMT+0700"));
        System.out.println("07/00 ahead time: " + sdf.format(currentTime));

        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Saigon"));
        System.out.println("Asia/Saigon: " + sdf.format(currentTime));

        sdf.setTimeZone(TimeZone.getTimeZone("GMT-0800"));
        System.out.println("-08/00 ahead time: " + sdf.format(currentTime));
    }

    public static void example1() {
        String dateInString = "22-1-2015 10:15:55 AM";
        LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));

        ZoneId singaporeZoneId = ZoneId.of("Asia/Singapore");
        System.out.println("TimeZone : " + singaporeZoneId);

        //LocalDateTime + ZoneId = ZonedDateTime
        ZonedDateTime asiaZonedDateTime = ldt.atZone(singaporeZoneId);
        System.out.println("Date (Singapore) : " + asiaZonedDateTime);

        ZoneId newYokZoneId = ZoneId.of("America/New_York");
        System.out.println("TimeZone : " + newYokZoneId);

        ZonedDateTime nyDateTime = asiaZonedDateTime.withZoneSameInstant(newYokZoneId);
        System.out.println("Date (New York) : " + nyDateTime);

        ZoneId saiGonZoneId = ZoneId.of("Asia/Ho_Chi_Minh");
        System.out.println("TimeZone : " + saiGonZoneId);

        ZonedDateTime sgDateTime = asiaZonedDateTime.withZoneSameInstant(saiGonZoneId);
        System.out.println("Date (Ho_Chi_Minh) : " + sgDateTime);

        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
        System.out.println("\n---DateTimeFormatter---");
        System.out.println("Date (Singapore) : " + format.format(asiaZonedDateTime));
        System.out.println("Date (New York) : " + format.format(nyDateTime));
        System.out.println("Date (Sai Gon) : " + format.format(sgDateTime));

    }

    /**
     * Convert Date from one timezone to other timezone.
     * This method also takes care of daylight saving time
     * @param dt
     * @param from
     * @param to
     * @return
     */
    public static Date convertFromOneTimeZoneToOhter(Date dt,String from,String to ) {

        TimeZone fromTimezone =TimeZone.getTimeZone(from);//get Timezone object
        TimeZone toTimezone= TimeZone.getTimeZone(to);

        long fromOffset = fromTimezone.getOffset(dt.getTime());//get offset
        long toOffset = toTimezone.getOffset(dt.getTime());

        //calculate offset difference and calculate the actual time
        long convertedTime = dt.getTime() - (fromOffset - toOffset);
        Date d2 = new Date(convertedTime);

        return d2;
    }
}
