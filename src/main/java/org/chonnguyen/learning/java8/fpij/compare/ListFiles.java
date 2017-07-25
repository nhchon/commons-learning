/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package  org.chonnguyen.learning.java8.fpij.compare;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {
  public static void main(String[] args) throws IOException {
  Files.list(Paths.get("D:\\Metabiota-Docs\\metabiota_modeling-res_deliverables-0628f5734f9c"))
       .forEach(System.out::println);
  }
}
