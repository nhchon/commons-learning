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
//        doBusiness();
        updateCountryCode();
    }

    public static void updateCountryCode() {
        try {
            // create a mysql database connection
            Connection conn = getConnection();

            // the mysql insert statement
            String query = "UPDATE country_data " +
                    "SET alpha_2=?, alpha_3=?, un_code=? WHERE name=?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            Document doc = Jsoup.connect("https://www.nationsonline.org/oneworld/country_code_list.htm")
                    .userAgent("Mozilla/5.0")
                    .timeout(10 * 1000).get();
            Elements tables = doc.select("table");
            System.out.println(tables.size());

            for (int i = 0; i < tables.size(); i++) {
                Element table = tables.get(i);
                Elements rows = table.select("tr");
                // first row is the col names so skip it.
                for (int r = 1; r < rows.size(); r++) {
                    Elements tds = rows.get(r).select("td");
                    if (tds.size() > 2) {
                        String name = tds.get(1).text();
                        String alpha2 = tds.get(2).text();
                        String alpha3 = tds.get(3).text();
                        String unCode = tds.get(4).text();
                        System.out.println(name + " " + alpha2 + " " + alpha3 + " " + unCode);
                        preparedStmt.setString (1, alpha2);
                        preparedStmt.setString (2, alpha3);
                        preparedStmt.setString (3, unCode);
                        preparedStmt.setString (4, name);
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

    public static String parseNationalCode(String s) {
        if (s == null || s.trim().equals("")) {
            return "";
        }

        //
        return s.replaceAll("[^0-9,]","");
    }

    public static Connection getConnection() throws Exception {
        // create a mysql database connection
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost/text2talent";
        Class.forName(myDriver);
        return DriverManager.getConnection(myUrl, "root", "qaz123wsx");
    }

    public static void doBusiness() {
        try {
            // create a mysql database connection
            Connection conn = getConnection();

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
