/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package  org.chonnguyen.learning.java8.fpij.designing;

public class MailBuilder {
  public  org.chonnguyen.learning.java8.fpij.designing.MailBuilder from(final String address) { /*... */; return this; }
  public  org.chonnguyen.learning.java8.fpij.designing.MailBuilder to(final String address)   { /*... */; return this; }
  public  org.chonnguyen.learning.java8.fpij.designing.MailBuilder subject(final String line) { /*... */; return this; }
  public  org.chonnguyen.learning.java8.fpij.designing.MailBuilder body(final String message) { /*... */; return this; }
  public void send() { System.out.println("sending..."); }

  //...
  public static void main(final String[] args) {
    new  org.chonnguyen.learning.java8.fpij.designing.MailBuilder()
      .from("build@agiledeveloper.com")
      .to("venkats@agiledeveloper.com")
      .subject("build notification")
      .body("...it sucks less...")
      .send();
  }
}
