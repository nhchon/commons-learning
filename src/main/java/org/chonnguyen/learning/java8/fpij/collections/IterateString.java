package  org.chonnguyen.learning.java8.fpij.collections;

/**
 * Created by Asus on 3/28/2017.
 */
public class IterateString {
    public static void main(String[] args){
        final String str = "w00t";

        str.chars().forEach(ch -> System.out.println(ch));
        str.chars().forEach(System.out::println);
    }
}
