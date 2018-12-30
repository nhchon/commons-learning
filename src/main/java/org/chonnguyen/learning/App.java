package org.chonnguyen.learning;

import org.apache.commons.io.FilenameUtils;
import org.chonnguyen.learning.basic.AbstractProcessor;
import org.chonnguyen.learning.basic.ConcreteProcessorA;
import org.chonnguyen.learning.basic.ConcreteProcessorB;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Hello world!
 *
 */
public class App {
    public static final String DEFAULT_BASE_DIR = "/opt/metabiota/platform-infra-upload-processing/";
    public static final String DEFAULT_CACHE_FOLDER = "./downloadCache";

    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );

//        Set<String> s = new HashSet<>();
//        s.add("1");
//        s.add("2");
//        s.add("3");
//        s.add("4");
//
//        List<Integer> l = new ArrayList(s);
//
//        l.forEach(x -> System.out.println(x));

        long n= 9;
        System.out.println(~n ^ (1L << 63) - 1);


        Double d = new Double(1.23442342386874234);
        System.out.println(d.toString());

        System.out.println("".substring("".length()));

        AbstractProcessor A = new ConcreteProcessorA();
        A.process();
        AbstractProcessor B = new ConcreteProcessorB();
        B.process();

        Long approved = Long.parseLong("1509139576520");



        Long graduated = Long.parseLong("1509139583415");

        Long remain = graduated - approved;
        System.out.println(approved < graduated);

        System.out.println(remain);

        long firstNum = 1;
        long lastNum = 1_000_000;
        List<Long> aList = LongStream.rangeClosed(firstNum, lastNum).boxed().collect(Collectors.toList());

//        ForkJoinPool customThreadPool = new ForkJoinPool(4);
//        long actualTotal = customThreadPool.submit(
//                () -> aList.parallelStream().parallel().reduce(0L, Long::sum)).get();

        //assertEquals((lastNum + firstNum) * lastNum / 2, actualTotal);

        System.out.println(FilenameUtils.concat(DEFAULT_BASE_DIR, DEFAULT_CACHE_FOLDER));
    }
}
