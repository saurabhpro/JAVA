/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.a_creational.a_singleton.singleton;

import java.sql.*;
import java.util.logging.Logger;

public class DbSingletonDemo {

    static Logger logger = Logger.getLogger(DbSingletonDemo.class.getName());

    public static void main(String arg[]) {

        Connection conn = getConnection();

        Statement sta;
        try {
            sta = conn.createStatement();

            logger.info("executing DDL query to create table");
            int count = sta.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20)," + " City VARCHAR(20))");
            logger.info("Table created with " + count + " rows.");

            logger.info("Inserting 1 Row to the table Address");
            boolean th = sta.execute("INSERT INTO Address VALUES (18, 'Ashok Nagar', 'Delhi')");

            logger.info("Query to read data executing");
            ResultSet in = sta.executeQuery("SELECT * FROM Address");

            ResultSetMetaData rsmd = in.getMetaData();
            while (in.next()) {
                int columnsNumber = rsmd.getColumnCount();
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = in.getString(i);
                    System.out.print(columnValue + " -> " + rsmd.getColumnName(i));
                }
                System.out.println();
            }

            sta.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        long timeBefore;
        long timeAfter;

        DbSingleton instance = DbSingleton.getInstance();
        Connection conn;

        logger.info("initiating connection creation");
        timeBefore = System.currentTimeMillis();
        conn = instance.getConnection();
        timeAfter = System.currentTimeMillis();
        logger.info("Connection creation took: " + (timeAfter - timeBefore) + " ms");
        return conn;
    }

}
