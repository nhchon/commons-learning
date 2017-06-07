/*************************************************************************
 *  Copyright (c) ChonNguyen Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to ChonNguyen Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to ChonNguyen Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from ChonNguyen Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomUtils;
import org.chonnguyen.learning.model.Countries;
import org.chonnguyen.learning.model.Country;
import org.chonnguyen.learning.model.ResEpicurve;
import org.chonnguyen.learning.model.ResLifeLoss;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * Created by nhchon on 6/6/2017 3:16 PM.
 */
public class GenerateDummyDataForGB19183 {
    public static final String GLOBAL = "Global";

    //
    public static final String LIFE_LOSS_CSV_HEADR = "EVENT_ID,LIFE_LOSS,LOCATION,LOCATION_LEVEL,POPULATION," +
            "SECTOR_1_ABSENT,SECTOR_2_ABSENT,SECTOR_3_ABSENT,SECTOR_4_ABSENT,SECTOR_5_ABSENT,SECTOR_6_ABSENT,TOTAL_ABSENT,STATE";
    public static final String LIFE_LOSS_CSV_FILE_PATH = "D:\\ChonNguyen-Docs\\RES-Dummy-Data\\AutoGenerate\\RES_LIFE_LOSS_DATA_Auto.csv";

    public static final String RES_EPICURVE_DATA_CSV_HEADR = "EVENT_ID,LOCATION,COUNTRY_CODE,STATE,LOCATION_LEVEL,DAY,INFECTED,HOSP,DEATHS";
    public static final String RES_EPICURVE_DATA_CSV_FILE_PATH = "D:\\ChonNguyen-Docs\\RES-Dummy-Data\\AutoGenerate\\RES_EPICURVE_DATA_Auto.csv";

    // RES_DEMOGRAPHIC_DATA
    public static final String RES_DEMOGRAPHIC_DATA_CSV_HEADR = "EVENT_ID,LOCATION,LOCATION_LEVEL,GENDER,AGE,INFECTED,HOSP,DEATHS,STATE";
    public static final String RES_DEMOGRAPHIC_DATA_CSV_FILE_PATH = "D:\\ChonNguyen-Docs\\RES-Dummy-Data\\AutoGenerate\\RES_DEMOGRAPHIC_DATA_Auto.csv";

    public static Map<Integer, String> countries;
    public static Map<Integer, String> states;
    public static int START_EVENT_ID = 100;
    public static int NUM_OF_EVENT = 50;

    public static void main(String[] args) throws Exception{
        countries = getListCountryCode();
        states = getStateCode();

        List<ResLifeLoss> resLifeLosses = new ArrayList<>();
        List<ResEpicurve> resEpicurves = new ArrayList<>();
        for(int eventId = START_EVENT_ID; eventId <= START_EVENT_ID + 50; eventId++) {
            int locationLevel = RandomUtils.nextInt(0, 3); // range 0 - 2
            String location = locationLevel == 0 ? GLOBAL : (locationLevel == 2 ? "US" : countries.get(RandomUtils.nextInt(0, countries.keySet().size())));
            String state = location.equals("US") ? states.get(RandomUtils.nextInt(0, states.keySet().size())) : null;

            // RES_LIFE_LOSS_DATA
            ResLifeLoss r = generateResLifeLossModel(eventId, location, locationLevel+"", state);
            resLifeLosses.add(r);
            //System.out.println(r);

            // RES_EPICURVE_DATA
            ResEpicurve resEpicurve = generateResEpicurveData(eventId + "", location, locationLevel+"", state);
            resEpicurves.add(resEpicurve);
            System.out.println(resEpicurve);
        }


        // Generate life loss sample data
        writeLifeLossFile(resLifeLosses);

        // create file RES_EPICURVE_DATA.csv
        writeFile(resEpicurves, RES_EPICURVE_DATA_CSV_HEADR, RES_EPICURVE_DATA_CSV_FILE_PATH);
    }

    public static ResEpicurve generateResEpicurveData(String eventId, String location, String locationLevel, String state) {
        ResEpicurve rEpi = new ResEpicurve();
        rEpi.setEventId(eventId);
        rEpi.setLocation(location);
        rEpi.setCountryCode(location);
        rEpi.setLocationLevel(locationLevel);
        rEpi.setState(state);

        rEpi.setDay(Utils.getRandomDateOfBirth());
        rEpi.setInfected(RandomUtils.nextLong(0, 2000000));
        rEpi.setHospitalized(RandomUtils.nextLong(0, 2000000));
        rEpi.setDeaths(RandomUtils.nextLong(0, 2000000));

        return rEpi;
    }

    /**
     *
     * @throws Exception
     */
    public static void generateResLifeLossData() throws Exception {
        int startEventId = START_EVENT_ID;
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

    public static <T extends Object> void writeFile(List<T> objs, String csvHeaderLine, String fileName) throws Exception {
        File fout = new File(fileName);
        try (
                FileOutputStream fos = new FileOutputStream(fout);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        ) {
            bw.write(csvHeaderLine);
            bw.newLine();
            for(T r : objs) {
                bw.write(r.toString());
                bw.newLine();
            }
        }
    }

    /**
     *
     * @param rs
     * @throws IOException
     */
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

}
