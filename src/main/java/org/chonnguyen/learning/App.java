package org.chonnguyen.learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Set<String> s = new HashSet<>();
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");

        List<Integer> l = new ArrayList(s);

        l.forEach(x -> System.out.println(x));


    }
}
