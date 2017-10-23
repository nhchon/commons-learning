package org.chonnguyen.learning;

import org.chonnguyen.learning.basic.AbstractProcessor;
import org.chonnguyen.learning.basic.ConcreteProcessorA;
import org.chonnguyen.learning.basic.ConcreteProcessorB;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
    }
}
