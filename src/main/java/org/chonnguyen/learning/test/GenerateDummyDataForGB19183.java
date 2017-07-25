package org.chonnguyen.learning.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomUtils;
import org.chonnguyen.learning.model.*;

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
    public static final String LIFE_LOSS_CSV_FILE_PATH = "D:\\Metabiota-Docs\\RES-Dummy-Data\\AutoGenerate\\RES_LIFE_LOSS_DATA_Auto.csv";

    public static final String RES_EPICURVE_DATA_CSV_HEADR = "EVENT_ID,LOCATION,COUNTRY_CODE,STATE,LOCATION_LEVEL,DAY,INFECTED,HOSP,DEATHS";
    public static final String RES_EPICURVE_DATA_CSV_FILE_PATH = "D:\\Metabiota-Docs\\RES-Dummy-Data\\AutoGenerate\\RES_EPICURVE_DATA_Auto.csv";

    // RES_DEMOGRAPHIC_DATA
    public static final String RES_DEMOGRAPHIC_DATA_CSV_HEADR = "EVENT_ID,LOCATION,LOCATION_LEVEL,GENDER,AGE,INFECTED,HOSP,DEATHS,STATE";
    public static final String RES_DEMOGRAPHIC_DATA_CSV_FILE_PATH = "D:\\Metabiota-Docs\\RES-Dummy-Data\\AutoGenerate\\RES_DEMOGRAPHIC_DATA_Auto.csv";

    // RES_ABSENTEEISM_DATA
    public static final String RES_ABSENTEEISM_DATA_CSV_HEADR = "EVENT_ID,LOCATION,COUNTRY_CODE,STATE,DAY,LOCATION_LEVEL,TOTAL_ABSENT" +
            ",SECTOR_1_ABSENT,SECTOR_2_ABSENT,SECTOR_3_ABSENT,SECTOR_4_ABSENT,SECTOR_5_ABSENT,SECTOR_6_ABSENT";
    public static final String RES_ABSENTEEISM_DATA_CSV_FILE_PATH = "D:\\Metabiota-Docs\\RES-Dummy-Data\\AutoGenerate\\RES_ABSENTEEISM_DATA_Auto.csv";

    public static Map<Integer, String> countries;
    public static Map<String, List<State>> states;
    public static int NUM_OF_EVENT = 70;

    public static void main(String[] args) throws Exception{
        countries = getListCountryCode();
        states = getStateCode();
        List<String> countryHasState = new ArrayList<>(states.keySet());

        List<ResLifeLoss> resLifeLosses = new ArrayList<>();
        List<ResEpicurve> resEpicurves = new ArrayList<>();
        List<ResDemographic> resDemographics = new ArrayList<>();
        List<ResAbsenteeism> resAbsenteeisms = new ArrayList<>();
        for(int i = 0; i <= NUM_OF_EVENT; i++) {
            String eventId = RandomUtils.nextInt(1, 11) + ""; // 1 - 10
            int locationLevel = RandomUtils.nextInt(0, 3); // range 0 - 2
            String location = locationLevel == 0 ? null : (locationLevel == 2 ? countryHasState.get(RandomUtils.nextInt(0, countryHasState.size())) : countries.get(RandomUtils.nextInt(0, countries.keySet().size())));
            // get state from country that has sates
            String state = "";
            if (locationLevel == 2) {
                List<State> statesOfLocation = states.get(location);
                String rnd = RandomUtils.nextInt(0, statesOfLocation.size()) + "";

                State ss = statesOfLocation.stream().filter(s -> s.getCode().equals(rnd)).findFirst().orElse(null);
                if (ss != null) {
                    state = ss.getName();
                }

            }

            // RES_LIFE_LOSS_DATA
            ResLifeLoss r = generateResLifeLossModel(eventId, location, locationLevel+"", state);
            addElement2List(resLifeLosses, r);
            //System.out.println(r);

            // RES_EPICURVE_DATA
            ResEpicurve resEpicurve = generateResEpicurveData(eventId + "", location, locationLevel+"", state);
            addElement2List(resEpicurves, resEpicurve);
            //System.out.println(resEpicurve);

            ResDemographic resDemographic = generateResDemographicData(eventId + "", location, locationLevel+"", state, i+1);
            addElement2List(resDemographics, resDemographic);
            System.out.println(i +": Key duplicate");

            ResAbsenteeism resAbsenteeism = generateResAbsenteeism(eventId + "", location, locationLevel+"", state);
            addElement2List(resAbsenteeisms, resAbsenteeism);
            //System.out.println(resAbsenteeism.toString());
        }


        // Generate life loss sample data
        writeFile(resLifeLosses, LIFE_LOSS_CSV_HEADR, LIFE_LOSS_CSV_FILE_PATH);

        // create file RES_EPICURVE_DATA.csv
        writeFile(resEpicurves, RES_EPICURVE_DATA_CSV_HEADR, RES_EPICURVE_DATA_CSV_FILE_PATH);

        // create file RES_DEMOGRAPHIC_DATA.csv
        writeFile(resDemographics, RES_DEMOGRAPHIC_DATA_CSV_HEADR, RES_DEMOGRAPHIC_DATA_CSV_FILE_PATH);

        // create file RES_ABSENTEEISM_DATA.csv
        writeFile(resAbsenteeisms, RES_ABSENTEEISM_DATA_CSV_HEADR, RES_ABSENTEEISM_DATA_CSV_FILE_PATH);
    }

    /**
     *
     * @param list
     * @param lObj
     * @param <T>
     */
    public static <T extends Object> void addElement2List(List<T> list, T lObj) {
        if (list.stream().filter(l -> l.equals(lObj)).count() > 0) return;

        System.out.println(lObj.toString());

        list.add(lObj);
    }

    /**
     *
     * @param eventId
     * @param location
     * @param locationLevel
     * @param state
     * @return
     */
    public static ResAbsenteeism generateResAbsenteeism(String eventId, String location, String locationLevel, String state) {
        ResAbsenteeism r = new ResAbsenteeism();
        r.setEventId(eventId);
        r.setLocation(location);
        r.setCountryCode(location);
        r.setLocationLevel(locationLevel);
        r.setState(state);

        r.setDay(Utils.getRandomDateOfBirth());

        r.setTotalAbsent(RandomUtils.nextDouble(0, 1));
        r.setSector1(RandomUtils.nextDouble(0, 1));
        r.setSector2(RandomUtils.nextDouble(0, 1));
        r.setSector3(RandomUtils.nextDouble(0, 1));
        r.setSector4(RandomUtils.nextDouble(0, 1));
        r.setSector5(RandomUtils.nextDouble(0, 1));
        r.setSector6(RandomUtils.nextDouble(0, 1));

        return r;
    }

    public static ResDemographic generateResDemographicData(String eventId, String location, String locationLevel, String state) {
        ResDemographic resDemographic = new ResDemographic();
        resDemographic.setEventId(eventId);
        resDemographic.setLocation(location);
        resDemographic.setLocationLevel(locationLevel);
        resDemographic.setState(state);

        resDemographic.setAge(RandomUtils.nextInt(0, 121));
        resDemographic.setGender(RandomUtils.nextInt(0, 2) == 0 ? "F" : "M");
        resDemographic.setInfected(RandomUtils.nextInt(0, 10000));
        resDemographic.setHospitalized(RandomUtils.nextInt(0, 5000));
        resDemographic.setDeaths(RandomUtils.nextInt(0, 1000));

        return resDemographic;
    }

    public static ResDemographic generateResDemographicData(String eventId, String location, String locationLevel, String state, int age) {
        ResDemographic resDemographic = new ResDemographic();
        resDemographic.setEventId(eventId);
        resDemographic.setLocation(location);
        resDemographic.setLocationLevel(locationLevel);
        resDemographic.setState(state);

        resDemographic.setAge(age);
        resDemographic.setGender(RandomUtils.nextInt(0, 2) == 0 ? "F" : "M");
        resDemographic.setInfected(RandomUtils.nextInt(0, 10000));
        resDemographic.setHospitalized(RandomUtils.nextInt(0, 5000));
        resDemographic.setDeaths(RandomUtils.nextInt(0, 1000));

        return resDemographic;
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

    public static ResLifeLoss generateResLifeLossModel(String eventId, String location, String locationLevel, String state) {
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

    public static Map<String, List<State>> getStateCode() {
        Map<String, List<State>> states = new HashMap<>();
        // US
        List<State> usStates = new ArrayList<>();
        usStates.add(new State("1","AL"));
        usStates.add(new State("2","AK"));
        usStates.add(new State("3","AB"));
        usStates.add(new State("4","AS"));
        usStates.add(new State("5","AZ"));
        usStates.add(new State("6","AR"));
        usStates.add(new State("7","AE"));
        usStates.add(new State("8","AA"));
        usStates.add(new State("9","AP"));
        usStates.add(new State("10","BC"));
        usStates.add(new State("11","CA"));
        usStates.add(new State("12","CO"));
        usStates.add(new State("13","CT"));
        usStates.add(new State("14","DE"));
        usStates.add(new State("15","DC"));
        usStates.add(new State("16","FL"));
        usStates.add(new State("17","GA"));
        usStates.add(new State("18","GU"));
        usStates.add(new State("19","HI"));
        usStates.add(new State("20","ID"));
        usStates.add(new State("21","IL"));
        usStates.add(new State("22","IN"));
        usStates.add(new State("23","IA"));
        usStates.add(new State("24","KS"));
        usStates.add(new State("25","KY"));
        usStates.add(new State("26","LA"));
        usStates.add(new State("27","ME"));
        usStates.add(new State("28","MB"));
        usStates.add(new State("29","MD"));
        usStates.add(new State("30","MA"));
        usStates.add(new State("31","MI"));
        usStates.add(new State("32","MN"));
        usStates.add(new State("33","MS"));
        usStates.add(new State("34","MO"));
        usStates.add(new State("35","MT"));
        usStates.add(new State("36","NE"));
        usStates.add(new State("37","NV"));
        usStates.add(new State("38","NB"));
        usStates.add(new State("39","NH"));
        usStates.add(new State("40","NJ"));
        usStates.add(new State("41","NM"));
        usStates.add(new State("42","NY"));
        usStates.add(new State("43","NF"));
        usStates.add(new State("44","NC"));
        usStates.add(new State("45","ND"));
        usStates.add(new State("46","NT"));
        usStates.add(new State("47","NS"));
        usStates.add(new State("48","NU"));
        usStates.add(new State("49","OH"));
        usStates.add(new State("50","OK"));
        usStates.add(new State("51","ON"));
        usStates.add(new State("52","OR"));
        usStates.add(new State("53","PA"));
        usStates.add(new State("54","PE"));
        usStates.add(new State("55","PR"));
        usStates.add(new State("56","QC"));
        usStates.add(new State("57","RI"));
        usStates.add(new State("58","SK"));
        usStates.add(new State("59","SC"));
        usStates.add(new State("60","SD"));
        usStates.add(new State("61","TN"));
        usStates.add(new State("62","TX"));
        usStates.add(new State("63","UT"));
        usStates.add(new State("64","VT"));
        usStates.add(new State("65","VI"));
        usStates.add(new State("66","VA"));
        usStates.add(new State("67","WA"));
        usStates.add(new State("68","WV"));
        usStates.add(new State("69","WI"));
        usStates.add(new State("70","WY"));
        usStates.add(new State("71","YT"));

        states.put("US", usStates);
        // CD
        List<State> cdStates = new ArrayList<>();
        cdStates.add(new State("1","BC"));
        cdStates.add(new State("2","BN"));
        cdStates.add(new State("3","EQ"));
        cdStates.add(new State("4","KA"));
        cdStates.add(new State("5","KE"));
        cdStates.add(new State("6","KN"));
        cdStates.add(new State("7","KW"));
        cdStates.add(new State("8","NKSK"));
        cdStates.add(new State("9","OR"));

        states.put("CD", cdStates);

        // SL
        List<State> slStates = new ArrayList<>();
        slStates.add(new State("1","E"));
        slStates.add(new State("2","N"));
        slStates.add(new State("3","S"));
        slStates.add(new State("4","W"));

        states.put("SL", slStates);

        // CN
        List<State> cnStates = new ArrayList<>();
        cnStates.add(new State("1","11"));
        cnStates.add(new State("2","12"));
        cnStates.add(new State("3","13"));
        cnStates.add(new State("4","14"));
        cnStates.add(new State("5","15"));
        cnStates.add(new State("6","21"));
        cnStates.add(new State("7","22"));
        cnStates.add(new State("8","23"));
        cnStates.add(new State("9","31"));
        cnStates.add(new State("10","32"));
        cnStates.add(new State("11","33"));
        cnStates.add(new State("12","34"));
        cnStates.add(new State("13","35"));
        cnStates.add(new State("14","36"));
        cnStates.add(new State("15","37"));
        cnStates.add(new State("16","41"));
        cnStates.add(new State("17","42"));
        cnStates.add(new State("18","43"));
        cnStates.add(new State("19","44"));
        cnStates.add(new State("20","45"));
        cnStates.add(new State("21","46"));
        cnStates.add(new State("22","50"));
        cnStates.add(new State("23","51"));
        cnStates.add(new State("24","52"));
        cnStates.add(new State("25","53"));
        cnStates.add(new State("26","54"));
        cnStates.add(new State("27","61"));
        cnStates.add(new State("28","62"));
        cnStates.add(new State("29","63"));
        cnStates.add(new State("30","64"));
        cnStates.add(new State("31","65"));

        states.put("CN", cnStates);

        // IN
        List<State> inStates = new ArrayList<>();
        inStates.add(new State("1","AN"));
        inStates.add(new State("2","AP"));
        inStates.add(new State("3","AR"));
        inStates.add(new State("4","AS"));
        inStates.add(new State("5","BR"));
        inStates.add(new State("6","CT"));
        inStates.add(new State("7","DD"));
        inStates.add(new State("8","DL"));
        inStates.add(new State("9","DN"));
        inStates.add(new State("10","GA"));
        inStates.add(new State("11","GJ"));
        inStates.add(new State("12","HP"));
        inStates.add(new State("13","HR"));
        inStates.add(new State("14","JH"));
        inStates.add(new State("15","JK"));
        inStates.add(new State("16","KA"));
        inStates.add(new State("17","KL"));
        inStates.add(new State("18","MH"));
        inStates.add(new State("19","ML"));
        inStates.add(new State("20","MN"));
        inStates.add(new State("21","MP"));
        inStates.add(new State("22","MZ"));
        inStates.add(new State("23","NL"));
        inStates.add(new State("24","OR"));
        inStates.add(new State("25","PB"));
        inStates.add(new State("26","PY"));
        inStates.add(new State("27","RJ"));
        inStates.add(new State("28","SK"));
        inStates.add(new State("29","TG"));
        inStates.add(new State("30","TN"));
        inStates.add(new State("31","TR"));
        inStates.add(new State("32","UP"));
        inStates.add(new State("33","UT"));
        inStates.add(new State("34","WB"));

        states.put("IN", inStates);

        // JP
        List<State> jpStates = new ArrayList<>();
        jpStates.add(new State("1","1"));
        jpStates.add(new State("2","2"));
        jpStates.add(new State("3","3"));
        jpStates.add(new State("4","4"));
        jpStates.add(new State("5","5"));
        jpStates.add(new State("6","6"));
        jpStates.add(new State("7","7"));
        jpStates.add(new State("8","8"));
        jpStates.add(new State("9","9"));
        jpStates.add(new State("10","10"));
        jpStates.add(new State("11","11"));
        jpStates.add(new State("12","12"));
        jpStates.add(new State("13","13"));
        jpStates.add(new State("14","14"));
        jpStates.add(new State("15","15"));
        jpStates.add(new State("16","16"));
        jpStates.add(new State("17","17"));
        jpStates.add(new State("18","18"));
        jpStates.add(new State("19","19"));
        jpStates.add(new State("20","20"));
        jpStates.add(new State("21","21"));
        jpStates.add(new State("22","22"));
        jpStates.add(new State("23","23"));
        jpStates.add(new State("24","24"));
        jpStates.add(new State("25","25"));
        jpStates.add(new State("26","26"));
        jpStates.add(new State("27","27"));
        jpStates.add(new State("28","28"));
        jpStates.add(new State("29","29"));
        jpStates.add(new State("30","30"));
        jpStates.add(new State("31","31"));
        jpStates.add(new State("32","32"));
        jpStates.add(new State("33","33"));
        jpStates.add(new State("34","34"));
        jpStates.add(new State("35","35"));
        jpStates.add(new State("36","36"));
        jpStates.add(new State("37","37"));
        jpStates.add(new State("38","38"));
        jpStates.add(new State("39","39"));
        jpStates.add(new State("40","40"));
        jpStates.add(new State("41","41"));
        jpStates.add(new State("42","42"));
        jpStates.add(new State("43","43"));
        jpStates.add(new State("44","44"));
        jpStates.add(new State("45","45"));
        jpStates.add(new State("45","46"));
        jpStates.add(new State("47","47"));

        states.put("JP", jpStates);

        // KR
        List<State> krStates = new ArrayList<>();
        krStates.add(new State("1","26"));
        krStates.add(new State("2","27"));
        krStates.add(new State("3","28"));
        krStates.add(new State("4","29"));
        krStates.add(new State("5","30"));
        krStates.add(new State("6","31"));
        krStates.add(new State("7","41"));
        krStates.add(new State("8","42"));
        krStates.add(new State("9","43"));
        krStates.add(new State("10","44"));
        krStates.add(new State("11","45"));
        krStates.add(new State("12","46"));
        krStates.add(new State("12","47"));
        krStates.add(new State("12","48"));
        krStates.add(new State("12","49"));

        states.put("KR", krStates);

        // GB
        List<State> gbStates = new ArrayList<>();
        gbStates.add(new State("1","ENG"));
        gbStates.add(new State("2","NIR"));
        gbStates.add(new State("3","SCT"));
        gbStates.add(new State("4","WLS"));

        states.put("GB", gbStates);

        // AR
        List<State> arStates = new ArrayList<>();
        arStates.add(new State("1","A"));
        arStates.add(new State("2","B"));
        arStates.add(new State("3","D"));
        arStates.add(new State("4","E"));
        arStates.add(new State("5","F"));
        arStates.add(new State("6","G"));
        arStates.add(new State("7","H"));
        arStates.add(new State("8","J"));
        arStates.add(new State("9","K"));
        arStates.add(new State("10","L"));
        arStates.add(new State("11","M"));
        arStates.add(new State("12","N"));
        arStates.add(new State("12","P"));
        arStates.add(new State("12","Q"));
        arStates.add(new State("12","R"));
        arStates.add(new State("13","S"));
        arStates.add(new State("14","T"));
        arStates.add(new State("15","U"));
        arStates.add(new State("16","V"));
        arStates.add(new State("17","W"));
        arStates.add(new State("18","X"));
        arStates.add(new State("19","Y"));
        arStates.add(new State("20","Z"));

        states.put("AR", arStates);

        // BR
        List<State> brStates = new ArrayList<>();
        brStates.add(new State("1","AC"));
        brStates.add(new State("2","AL"));
        brStates.add(new State("3","AM"));
        brStates.add(new State("4","AP"));
        brStates.add(new State("5","BA"));
        brStates.add(new State("6","CE"));
        brStates.add(new State("7","DF"));
        brStates.add(new State("8","ES"));
        brStates.add(new State("9","GO"));
        brStates.add(new State("10","MA"));
        brStates.add(new State("11","MG"));
        brStates.add(new State("12","MS"));
        brStates.add(new State("12","MT"));
        brStates.add(new State("12","PA"));
        brStates.add(new State("12","PB"));
        brStates.add(new State("13","PE"));
        brStates.add(new State("14","PI"));
        brStates.add(new State("15","PR"));
        brStates.add(new State("16","RJ"));
        brStates.add(new State("17","RN"));
        brStates.add(new State("18","RO"));
        brStates.add(new State("19","RR"));
        brStates.add(new State("20","RS"));
        brStates.add(new State("21","SC"));
        brStates.add(new State("22","SE"));
        brStates.add(new State("23","SP"));
        brStates.add(new State("24","TO"));

        states.put("BR", brStates);

        // CA
        List<State> caStates = new ArrayList<>();
        caStates.add(new State("1","AB"));
        caStates.add(new State("2","BC"));
        caStates.add(new State("3","MB"));
        caStates.add(new State("4","NB"));
        caStates.add(new State("5","NL"));
        caStates.add(new State("6","NS"));
        caStates.add(new State("7","NT"));
        caStates.add(new State("8","NU"));
        caStates.add(new State("9","ON"));
        caStates.add(new State("10","PE"));
        caStates.add(new State("11","QC"));
        caStates.add(new State("12","SK"));
        caStates.add(new State("13","YT"));

        states.put("CA", caStates);

        // MX
        List<State> mxStates = new ArrayList<>();
        mxStates.add(new State("1","AGU"));
        mxStates.add(new State("2","BCN"));
        mxStates.add(new State("3","BCS"));
        mxStates.add(new State("4","CAM"));
        mxStates.add(new State("5","CHH"));
        mxStates.add(new State("6","CHP"));
        mxStates.add(new State("7","COA"));
        mxStates.add(new State("8","COL"));
        mxStates.add(new State("9","DIF"));
        mxStates.add(new State("10","DUR"));
        mxStates.add(new State("11","GRO"));
        mxStates.add(new State("12","GUA"));
        mxStates.add(new State("13","HID"));
        mxStates.add(new State("14","JAL"));
        mxStates.add(new State("15","MEX"));
        mxStates.add(new State("16","MIC"));
        mxStates.add(new State("17","MOR"));
        mxStates.add(new State("18","NAY"));
        mxStates.add(new State("19","NLE"));
        mxStates.add(new State("20","OAX"));
        mxStates.add(new State("21","PUE"));
        mxStates.add(new State("22","QUE"));
        mxStates.add(new State("23","ROO"));
        mxStates.add(new State("24","SIN"));
        mxStates.add(new State("25","SLP"));
        mxStates.add(new State("26","SON"));
        mxStates.add(new State("27","TAB"));
        mxStates.add(new State("28","TAM"));
        mxStates.add(new State("29","TLA"));
        mxStates.add(new State("30","VER"));
        mxStates.add(new State("31","YUC"));
        mxStates.add(new State("32","ZAC"));

        states.put("MX", mxStates);

        return states;
    }

}
