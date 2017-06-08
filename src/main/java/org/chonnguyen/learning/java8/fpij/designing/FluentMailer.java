/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package  org.chonnguyen.learning.java8.fpij.designing;

import java.util.function.Consumer;

public class FluentMailer {
  private FluentMailer() {}
  
  public  org.chonnguyen.learning.java8.fpij.designing.FluentMailer from(final String address) { /*... */; return this; }
  public  org.chonnguyen.learning.java8.fpij.designing.FluentMailer to(final String address)   { /*... */; return this; }
  public  org.chonnguyen.learning.java8.fpij.designing.FluentMailer subject(final String line) { /*... */; return this; }
  public  org.chonnguyen.learning.java8.fpij.designing.FluentMailer body(final String message) { /*... */; return this; }
  
  public static void send(final Consumer< org.chonnguyen.learning.java8.fpij.designing.FluentMailer> block) {
    final  org.chonnguyen.learning.java8.fpij.designing.FluentMailer mailer = new  org.chonnguyen.learning.java8.fpij.designing.FluentMailer();
    block.accept(mailer); 
    System.out.println("sending..."); 
  }

  //...
  public static void main(final String[] args) {
    org.chonnguyen.learning.java8.fpij.designing.FluentMailer.send(mailer ->
      mailer.from("build@agiledeveloper.com")
            .to("venkats@agiledeveloper.com")
            .subject("build notification")
            .body("...much better..."));
  }
}
