package com.axonactive.test;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void convert2Date(long timeStamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH) + 1;
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
        int mHour = calendar.get(Calendar.HOUR_OF_DAY);
        int mMinute = calendar.get(Calendar.MINUTE);
        int mSecond = calendar.get(Calendar.SECOND);
        int mMili = calendar.get(Calendar.MILLISECOND);

        System.out.println();
        System.out.println("batId: " + timeStamp + "  ~  " + mYear + "-" + mMonth + "-" + mDay + " " + mHour + ":" + mMinute + ":" + mSecond + " " + mMili);
    }

    public static void main(String[] args) {
	    // write your code here
        //System.out.println(System.currentTimeMillis());
        long[] tSs = {1455032869121L, 1464711447711L, 1478725120601L, 1478725627329L, 1478725762445L, 1455032869121L, 1478725120601L, 1478725627329L, 1478725762445L};

        long[] tSs2 = {1490258842044L, 1490258842044L, 1490258842044L, 1490258842059L};

        long[] tSs3 = {1490258975797L, 1490258975812L, 1490258975812L, 1490258975812L};

        //Begin Arrays.parallelSort:1490258842044
        //End Arrays.parallelSort:1490258842044
        //Begin parallelStream:1490258842044
        //End parallelStream:1490258842059

        //Begin Arrays.parallelSort:1490258975797
        //End Arrays.parallelSort:1490258975812
        //Begin parallelStream:1490258975812
        //End parallelStream:1490258975812

        long[] tSs4 = {946684800000L, 1487980800000L, 1447632000000L, 1483142400000L};

        //Begin Arrays.parallelSort:1490259425737
        //End Arrays.parallelSort:1490259425742
        //Begin parallelStream:1490259425743
        //End parallelStream:1490259425746

        //Begin Arrays.parallelSort:1490259567919
        //End Arrays.parallelSort:1490259567920
        //Begin parallelStream:1490259567920
        //End parallelStream:1490259567923

        //Begin Arrays.parallelSort:1490259635280L
        //End Arrays.parallelSort:1490259635296L
        //Begin parallelStream:1490259635296L
        //End parallelStream:1490259635296L

        System.out.println("Test 4");
        for(int i=0; i < tSs4.length; i++){
            convert2Date(tSs4[i]);
        }

        Instant ins = Instant.ofEpochMilli(1293840000000L);
        System.out.println(Date.from(ins));
    }
}
