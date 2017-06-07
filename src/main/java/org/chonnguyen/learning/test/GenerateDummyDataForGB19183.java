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

import org.apache.commons.lang3.RandomUtils;
import org.chonnguyen.learning.model.ResLifeLoss;

import java.io.*;
import java.util.*;

/**
 * Created by nhchon on 6/6/2017 3:16 PM.
 */
public class GenerateDummyDataForGB19183 {
    public static final String GLOBAL = "Global";
    public static final String LIFE_LOSS_CSV_HEADR = "EVENT_ID,LIFE_LOSS,LOCATION,LOCATION_LEVEL,POPULATION," +
            "SECTOR_1_ABSENT,SECTOR_2_ABSENT,SECTOR_3_ABSENT,SECTOR_4_ABSENT,SECTOR_5_ABSENT,SECTOR_6_ABSENT,TOTAL_ABSENT,STATE";
    public static final String LIFE_LOSS_CSV_FILE_PATH = "D:\\Metabiota-Docs\\RES-Dummy-Data\\AutoGenerate\\RES_LIFE_LOSS_DATA_Auto.csv";

    public static void main(String[] args) throws Exception{
        Map<Integer, String> countries = getListCountryCode();
        Map<Integer, String> states = getStateCode();

        // Generate life loss sample data
        int startEventId = 100;
        List<ResLifeLoss> rs = new ArrayList<>();
        for(int i = startEventId; i <= startEventId + 50; i++) {
            int locationLevel = RandomUtils.nextInt(0, 3); // range 0 - 2
            String location = locationLevel == 0 ? GLOBAL : (locationLevel == 2 ? "US" : countries.get(RandomUtils.nextInt(0, countries.keySet().size())));
            String state = location.equals("US") ? states.get(RandomUtils.nextInt(0, states.keySet().size())) : null;

            ResLifeLoss r = generateResLifeLossModel(i, location, locationLevel+"", state);
            rs.add(r);
            System.out.println(r);
        }

        writeLifeLossFile(rs);
    }

    public static void writeLifeLossFile(List<ResLifeLoss> rs) throws IOException {
        File fout = new File(LIFE_LOSS_CSV_FILE_PATH);
        try (
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        ) {
            bw.write(LIFE_LOSS_CSV_HEADR);
            bw.newLine();
            for(ResLifeLoss r : rs) {
                bw.write(r.toString());
                bw.newLine();
            }
        }
    }
    public static Map<Integer, String> getListCountryCode() {
        int count = 0;
        Map<Integer, String> countries = new HashMap<>();
        for (String iso : Locale.getISOCountries()) {
            countries.put(count, iso);
            count++;
        }

        return countries;
    }

    public static Map<Integer, String> getStateCode() {
        Map<Integer, String> states = new HashMap<Integer, String>();
        states.put(1,"AL");
        states.put(2,"AK");
        states.put(3,"AB");
        states.put(4,"AS");
        states.put(5,"AZ");
        states.put(6,"AR");
        states.put(7,"AE");
        states.put(8,"AA");
        states.put(9,"AP");
        states.put(10,"BC");
        states.put(11,"CA");
        states.put(12,"CO");
        states.put(13,"CT");
        states.put(14,"DE");
        states.put(15,"DC");
        states.put(16,"FL");
        states.put(17,"GA");
        states.put(18,"GU");
        states.put(19,"HI");
        states.put(20,"ID");
        states.put(21,"IL");
        states.put(22,"IN");
        states.put(23,"IA");
        states.put(24,"KS");
        states.put(25,"KY");
        states.put(26,"LA");
        states.put(27,"ME");
        states.put(28,"MB");
        states.put(29,"MD");
        states.put(30,"MA");
        states.put(31,"MI");
        states.put(32,"MN");
        states.put(33,"MS");
        states.put(34,"MO");
        states.put(35,"MT");
        states.put(36,"NE");
        states.put(37,"NV");
        states.put(38,"NB");
        states.put(39,"NH");
        states.put(40,"NJ");
        states.put(41,"NM");
        states.put(42,"NY");
        states.put(43,"NF");
        states.put(44,"NC");
        states.put(45,"ND");
        states.put(46,"NT");
        states.put(47,"NS");
        states.put(48,"NU");
        states.put(49,"OH");
        states.put(50,"OK");
        states.put(51,"ON");
        states.put(52,"OR");
        states.put(53,"PA");
        states.put(54,"PE");
        states.put(55,"PR");
        states.put(56,"QC");
        states.put(57,"RI");
        states.put(58,"SK");
        states.put(59,"SC");
        states.put(60,"SD");
        states.put(61,"TN");
        states.put(62,"TX");
        states.put(63,"UT");
        states.put(64,"VT");
        states.put(65,"VI");
        states.put(66,"VA");
        states.put(67,"WA");
        states.put(68,"WV");
        states.put(69,"WI");
        states.put(70,"WY");
        states.put(71,"YT");

        return states;
    }

    public static void generateResLifeLossData() {

    }

    public static ResLifeLoss generateResLifeLossModel(int eventId, String location, String locationLevel, String state) {
        ResLifeLoss r = new ResLifeLoss();
        r.setEventId(eventId);
        r.setLocation(location);
        r.setLocationLevel(locationLevel);
        r.setState(state);

        r.setPopulation(RandomUtils.nextInt());
        r.setLifeLoss(RandomUtils.nextInt());

        r.setTotalAbsent(RandomUtils.nextDouble(0, 1));
        r.setSector1Absent(RandomUtils.nextDouble(0, 1));
        r.setSector2Absent(RandomUtils.nextDouble(0, 1));
        r.setSector3Absent(RandomUtils.nextDouble(0, 1));
        r.setSector4Absent(RandomUtils.nextDouble(0, 1));
        r.setSector5Absent(RandomUtils.nextDouble(0, 1));
        r.setSector6Absent(RandomUtils.nextDouble(0, 1));

        return r;
    }
}
