package org.chonnguyen.learning.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class JsoupParseCountryCodeExample {
    public static void main(String[] args) {
//        System.out.println(parseNationalCode("787, or 939"));
//        System.out.println(parseNationalCode("264 (ANG)"));
//        System.out.println(parseNationalCode("268 (ANT)"));
//        System.out.println(parseNationalCode("242 (BAH)"));
//        System.out.println(parseNationalCode("246"));
//        System.out.println(parseNationalCode("767 (ROS)"));
//        System.out.println(parseNationalCode("809, 829, 849"));
//        System.out.println(parseNationalCode("6, or 7"));
//        System.out.println(parseNationalCode("664 (MOI)"));
//        System.out.println(parseNationalCode("787, or 939"));
//        System.out.println(parseNationalCode("284 (BVI)"));
//        System.out.println(parseNationalCode("809, 829, 849"));
//
//        System.out.println("".split(",").length);
//        System.out.println("809,829,849".split(",").length);

        doBusiness();
    }

    public static String parseNationalCode(String s) {
        if (s == null || s.trim().equals("")) {
            return "";
        }

        //
        return s.replaceAll("[^0-9,]","");
    }

    public static void doBusiness() {
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/text2talent";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "qaz123wsx");

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = "INSERT INTO country_data(" +
                    "name, country_calling_code, national_code_1, national_code_2, national_code_3)" +
                    "VALUES(?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            Document doc = Jsoup.connect("https://www.nationsonline.org/oneworld/international-calling-codes.htm")
                    .userAgent("Mozilla/5.0")
                    .timeout(10 * 1000).get();
            Elements tables = doc.select("table");
            System.out.println(tables.size());

            for (int i = 0; i < tables.size(); i++) {
                Element table = tables.get(i);
                Elements rows = table.select("tr");
                // first row is the col names so skip it.
                // second row is 'National Code ***' row
                for (int r = 2; r < rows.size(); r++) {
                    Elements tds = rows.get(r).select("td");
                    if (tds.size() > 1) {
                        String name = tds.get(1).text();
                        String countryCallingCode = tds.get(2).text();
                        String nationalCode = tds.get(3).text();
                        String idd = tds.get(4).text();
                        System.out.println(name + " " + countryCallingCode + " " + nationalCode + " " + idd);
                        preparedStmt.setString (1, name);
                        preparedStmt.setString (2, countryCallingCode);
                        // process national code
                        String[] nationalCodes = parseNationalCode((nationalCode)).split(",");
                        if (nationalCodes.length == 1) {
                            preparedStmt.setString   (3, nationalCodes[0]);
                            preparedStmt.setString(4, "");
                            preparedStmt.setString    (5, "");
                        } else if (nationalCodes.length == 2) {
                            preparedStmt.setString   (3, nationalCodes[0]);
                            preparedStmt.setString(4, nationalCodes[1]);
                            preparedStmt.setString    (5, "");
                        } else if (nationalCodes.length == 3) {
                            preparedStmt.setString   (3, nationalCodes[0]);
                            preparedStmt.setString(4, nationalCodes[1]);
                            preparedStmt.setString    (5, nationalCodes[2]);
                        } else {
                            preparedStmt.setString   (3, "");
                            preparedStmt.setString(4, "");
                            preparedStmt.setString    (5, "");
                        }

                        // execute the preparedstatement
                        preparedStmt.execute();
                    }
                }
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
