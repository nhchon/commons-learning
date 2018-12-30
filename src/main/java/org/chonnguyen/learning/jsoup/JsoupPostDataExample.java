package org.chonnguyen.learning.jsoup;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupPostDataExample {
    private static String[] Beginning = { "Kr", "Ca", "Ra", "Mrok", "Cru",
            "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
            "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
            "Mar", "Luk" };
    private static String[] Middle = { "air", "ir", "mi", "sor", "mee", "clo",
            "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
            "marac", "zoir", "slamar", "salmar", "urak" };
    private static String[] End = { "d", "ed", "ark", "arc", "es", "er", "der",
            "tron", "med", "ure", "zur", "cred", "mur" };

    final static java.util.Random rand = new java.util.Random();

    public static void main(String[] args) {
		int count = 0;
        for (; ;) {
            String maThe = RandomStringUtils.randomNumeric(13);
            String seri = RandomStringUtils.randomNumeric(11);
            String name = generateName() + " " + generateName();
            System.out.println(maThe + ", " + seri + ", " + name);
            try {
				System.out.println("Record: " + (++count));
                String response =
                        Jsoup.connect("http://quacongty179.com/ajax/card.php")
								.proxy("192.241.132.133", 80) // sets a HTTP proxy
                                .userAgent("Mozilla/5.0")
                                .timeout(10 * 1000)
								.ignoreContentType(true)
								//.header("Accept", "application/json, text/javascript, */*; q=0.01")
								.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                                .method(Method.POST)
                                .data("card_type_id", "Viettel")
                                .data("menhgia", "1.000.000")
                                .data("seri", seri)
                                .data("pin", maThe) // ma the
								.data("ten", name)
                                // .followRedirects(true)
                                .execute()
								.body();;
				System.out.println(response);
                // parse the document from response
                // Document document = response.parse();
                // System.out.println(document.html());
                // get cookies
                // Map<String, String> mapCookies = response.cookies();

                /*
                 * You may need to send all the cookies you received
                 * from the post response to the subsequent requests.
                 *
                 * You can do that using cookies method of Connection
                 */
            } catch (IOException ioe) {
                System.out.println("Exception: " + ioe);
                System.exit(0);
            }

            try {
                System.out.println("Sleep 5 seconds");
                Thread.sleep(5000);
            } catch (InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    public static String generateName() {
        return Beginning[rand.nextInt(Beginning.length)] +
                Middle[rand.nextInt(Middle.length)]+
                End[rand.nextInt(End.length)];

    }
}
