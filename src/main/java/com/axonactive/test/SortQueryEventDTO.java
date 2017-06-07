package com.axonactive.test;

import com.axonactive.model.QueryEventDTO;
import com.axonactive.model.QueryEventDTO;
import com.axonactive.utils.RandomObjectFiller;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by nhchon on 3/22/2017 11:43 AM.
 */
public class SortQueryEventDTO {
    public static final String PLUS_SIGN = "+"; // ascending sorting
    public static final String MINUS_SIGN = "-"; // descending  sorting
    public static final String EVENT_LOCATION_FIELD = "location";
    public static final String EVENT_PATHOGEN_FIELD = "pathogen";
    public static final String EVENT_CASES_FIELD = "cases";
    public static final String EVENT_DEATHS_FIELD = "deaths";
    public static final String EVENT_START_DATE_FIELD = "startDate";
    public static final String EVENT_END_DATE_FIELD = "endDate";
    public static final String EVENT_FIRST_REPORTED_FIELD = "firstReported";
    public static final String EVENT_SOURCE_FIELD = "source";

    public static final int MAX = 1000000;

    public static void main(String[] args) throws Exception{
        RandomObjectFiller genData = new RandomObjectFiller();
        List<QueryEventDTO> l = new ArrayList<>();
        for(int i=0; i<100; i++) {
            l.add(genData.createAndFill(QueryEventDTO.class));
        }

        int offset = l.size();
        int limit = 5;
        int toIndex = offset + limit;

        l = sortQueryEventByFieldName(l, "source");
        //List<QueryEventDTO> subL = l.subList(offset, toIndex);
        //System.out.println(subL);

        System.out.println("==========================================");
        int fromIndex = offset;
        toIndex  = fromIndex;//offset + limit; //fromIndex;//
        int totalRow = l.size();
        System.out.println("total row: " + totalRow);
        //if last page then return remain column (remain < limit)
        if(offset < totalRow && toIndex > totalRow){
            toIndex = totalRow;
        }
        try {
            List<QueryEventDTO> subL2 =  l.subList(fromIndex , toIndex);
            System.out.println(subL2);
        }
        catch (Exception exception){
            System.out.println("Could not paginate " + exception.getMessage());
        }

    }

    public static void testSort() throws Exception{
        RandomObjectFiller genData = new RandomObjectFiller();
        List<QueryEventDTO> l = new ArrayList<>();
        List<QueryEventDTO> lSorted = new ArrayList<>();
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "The New England Journal of Medicine"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "Transactions of the Royal Society of Tropical Medicine and Hygiene"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "WHO DON"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "WHO DON"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "WHO DON"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "[Geographic] Centre for hygiene and public health"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "ChonNguyen Best"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "ChonNguyen Best"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "ChonNguyen Best"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "ChonNguyen Best (NRT)"));

        for(int i=0; i<100; i++) {
            l.add(genData.createAndFill(QueryEventDTO.class));
        }

        lSorted = sortQueryEventByFieldName(l, "source");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getSource());
        };
        System.out.println("==========================");

        lSorted = sortQueryEventByFieldName(l, "-source");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getSource());
        };
        System.out.println("================================================================");

        lSorted = sortQueryEventByFieldName(l, "firstReported");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getFirstReported());
        };
        System.out.println("============================================");

        lSorted = sortQueryEventByFieldName(l, "-firstReported");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getFirstReported());
        };
        System.out.println("================================================================");

        lSorted = sortQueryEventByFieldName(l, "endDate");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getEndDate());
        };
        System.out.println("============================================");

        lSorted = sortQueryEventByFieldName(l, "-endDate");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getEndDate());
        };
        System.out.println("================================================================");

        lSorted = sortQueryEventByFieldName(l, "startDate");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getStartDate());
        };
        System.out.println("============================================");

        lSorted = sortQueryEventByFieldName(l, "-startDate");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getStartDate());
        };
        System.out.println("================================================================");
        lSorted = sortQueryEventByFieldName(l, "deaths");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getDeaths());
        };
        System.out.println("============================================");

        lSorted = sortQueryEventByFieldName(l, "-deaths");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getDeaths());
        };
        System.out.println("================================================================");
        lSorted = sortQueryEventByFieldName(l, "cases");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getCases());
        };
        System.out.println("============================================");

        lSorted = sortQueryEventByFieldName(l, "-cases");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getCases());
        };
        System.out.println("================================================================");

        lSorted = sortQueryEventByFieldName(l, "pathogen");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getPathogen());
        };
        System.out.println("============================================");
        lSorted = sortQueryEventByFieldName(l, "-pathogen");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getPathogen());
        };
        System.out.println("============================================");

        lSorted = sortQueryEventByFieldName(l, "location");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getLocation());
        };
        System.out.println("============================================");
        lSorted = sortQueryEventByFieldName(l, "-location");
        for(int j=0; j<lSorted.size(); j++){
            System.out.println(lSorted.get(j).getLocation());
        };
        System.out.println("============================================");
    }

    public static void testPeromance() throws Exception{
        RandomObjectFiller genData = new RandomObjectFiller();
        List<QueryEventDTO> l1 = new ArrayList<>();
        QueryEventDTO[] l2 = new QueryEventDTO[MAX];

        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "The New England Journal of Medicine"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "Transactions of the Royal Society of Tropical Medicine and Hygiene"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "WHO DON"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "WHO DON"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "WHO DON"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "[Geographic] Centre for hygiene and public health"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "ChonNguyen Best"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "ChonNguyen Best"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "ChonNguyen Best"));
        //l.add(new QueryEventDTO(1175385600000L, 1184371200000L, 108, 0, "FM", "Federated States of Micronesia", "Zika virus", "ChonNguyen Best (NRT)"));

        System.out.println("TEST Perormance between Arrays.parallelSort and Stream.parallelStream : 1000000 elements");
        System.out.println("Generate 1000000 elements ... ");
        for(int i=0; i<MAX; i++) {
            l1.add(genData.createAndFill(QueryEventDTO.class));

            l2[i] = genData.createAndFill(QueryEventDTO.class);
        }
        System.out.println("Finish Generating 1000000 elements ... ");

        String sort = "-firstReported";
        boolean isAsc = false;

        System.out.println("Begin Arrays.parallelSort:" + convert2Date(System.currentTimeMillis()));
        Arrays.parallelSort(l2, getQueryEventComparator(sort, isAsc));
        System.out.println("End Arrays.parallelSort:" + convert2Date(System.currentTimeMillis()));

        System.out.println("Begin parallelStream:" + convert2Date(System.currentTimeMillis()));
        List<QueryEventDTO> queryEvents2 = l1.parallelStream().sorted(getQueryEventComparator(sort, isAsc)).collect(Collectors.toList());
        System.out.println("End parallelStream:" + convert2Date(System.currentTimeMillis()));
    }

    public static String convert2Date(long timeStamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
        int mHour = calendar.get(Calendar.HOUR_OF_DAY);
        int mMinute = calendar.get(Calendar.MINUTE);
        int mSecond = calendar.get(Calendar.SECOND);
        int mMili = calendar.get(Calendar.MILLISECOND);

        return ("  ~  " + mYear + "-" + mMonth + "-" + mDay + " " + mHour + ":" + mMinute + ":" + mSecond + " " + mMili);
    }

    /**
     * Sort the list of QueryEventDTO
     * the value of sort property is the field attr will be sorted, prefix + for ascending and - for descending
     *
     * @param queryEvents the list to be sorted
     * @return
     */
    public static List<QueryEventDTO> sortQueryEventByFieldName(List<QueryEventDTO> queryEvents, String sort){
        //StringUtils.trimToEmpty(getSort());
        boolean isAsc = !(StringUtils.isEmpty(sort) || sort.startsWith(MINUS_SIGN));
        // default is sort cases desc
        if(StringUtils.isEmpty(sort)) {
            sort = "cases";
        }

        // remove prefix +/-
        if(sort.startsWith(MINUS_SIGN) || sort.startsWith(PLUS_SIGN)){
            sort = sort.substring(1);
        }

        System.out.println("QueryEventFilters: sort: " + sort + " , isAsc: " + isAsc);

        QueryEventDTO[] queryEventArr = queryEvents.toArray(new QueryEventDTO[queryEvents.size()]);

        //System.out.println("Begin Arrays.parallelSort:" + convert2Date(System.currentTimeMillis()));
        Arrays.parallelSort(queryEventArr, getQueryEventComparator(sort, isAsc));
        //System.out.println("End Arrays.parallelSort:" + convert2Date(System.currentTimeMillis()));

        //System.out.println("Begin parallelStream:" + convert2Date(System.currentTimeMillis()));
        //List<QueryEventDTO> queryEvents2 = queryEvents.parallelStream().sorted(getQueryEventComparator(sort, isAsc)).collect(Collectors.toList());
        //System.out.println("End parallelStream:" + convert2Date(System.currentTimeMillis()));

        return Arrays.asList(queryEventArr);
    }


    /**
     * generate the QueryEventDTO comparator by field name
     *
     * @param sort the field attr will be sorted
     * @param isAsc ?
     * @return
     */
    public static Comparator<QueryEventDTO> getQueryEventComparator(final String sort, final boolean isAsc) {
        Comparator<QueryEventDTO> qeComparator = null;
        switch (StringUtils.trimToEmpty(sort)){
            case EVENT_LOCATION_FIELD:
                qeComparator = isAsc ?
                        Comparator.comparing(QueryEventDTO::getLocation, Comparator.nullsLast((e1, e2) -> e1.compareTo(e2))):
                        Comparator.comparing(QueryEventDTO::getLocation, Comparator.nullsLast((e1, e2) -> e2.compareTo(e1)));
                break;
            case EVENT_PATHOGEN_FIELD:
                qeComparator = isAsc ?
                        Comparator.comparing(QueryEventDTO::getPathogen, Comparator.nullsLast((e1, e2) -> e1.compareTo(e2))):
                        Comparator.comparing(QueryEventDTO::getPathogen, Comparator.nullsLast((e1, e2) -> e2.compareTo(e1)));
                break;
            case EVENT_CASES_FIELD:
                qeComparator = isAsc ?
                        Comparator.comparing(QueryEventDTO::getCases, Comparator.nullsLast((e1, e2) -> e1.compareTo(e2))):
                        Comparator.comparing(QueryEventDTO::getCases, Comparator.nullsLast((e1, e2) -> e2.compareTo(e1)));
                break;
            case EVENT_DEATHS_FIELD:
                qeComparator = isAsc ?
                        Comparator.comparing(QueryEventDTO::getDeaths, Comparator.nullsLast((e1, e2) -> e1.compareTo(e2))):
                        Comparator.comparing(QueryEventDTO::getDeaths, Comparator.nullsLast((e1, e2) -> e2.compareTo(e1)));
                break;
            case EVENT_START_DATE_FIELD:
                qeComparator = isAsc ?
                        Comparator.comparing(QueryEventDTO::getStartDate, Comparator.nullsLast((e1, e2) -> e1.compareTo(e2))):
                        Comparator.comparing(QueryEventDTO::getStartDate, Comparator.nullsLast((e1, e2) -> e2.compareTo(e1)));
                break;
            case EVENT_END_DATE_FIELD:
                qeComparator = isAsc ?
                        Comparator.comparing(QueryEventDTO::getEndDate, Comparator.nullsLast((e1, e2) -> e1.compareTo(e2))):
                        Comparator.comparing(QueryEventDTO::getEndDate, Comparator.nullsLast((e1, e2) -> e2.compareTo(e1)));
                break;
            case EVENT_FIRST_REPORTED_FIELD:
                qeComparator = isAsc ?
                        Comparator.comparing(QueryEventDTO::getFirstReported, Comparator.nullsLast((e1, e2) -> e1.compareTo(e2))):
                        Comparator.comparing(QueryEventDTO::getFirstReported, Comparator.nullsLast((e1, e2) -> e2.compareTo(e1)));
                break;
            case EVENT_SOURCE_FIELD:
                qeComparator = isAsc ?
                        Comparator.comparing(QueryEventDTO::getSource, Comparator.nullsLast((e1, e2) -> e1.compareTo(e2))):
                        Comparator.comparing(QueryEventDTO::getSource, Comparator.nullsLast((e1, e2) -> e2.compareTo(e1)));
                break;
            default:
                //  default is sort by cases desc
                qeComparator = Comparator.comparing(QueryEventDTO::getCases, Comparator.nullsLast((e1, e2) -> e2.compareTo(e1)));
        }

        return qeComparator;
    }
}
