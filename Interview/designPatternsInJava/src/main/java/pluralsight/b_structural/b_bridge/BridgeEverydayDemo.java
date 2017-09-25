/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.b_structural.b_bridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BridgeEverydayDemo {

	public static void main(String args[]) {

		try {
			//JDBC is an API
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver()); // <- Driver

			String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";

			Connection conn = DriverManager.getConnection(dbUrl);

			Statement sta = conn.createStatement();

			//This client is an abstraction and can work with any database that has a driver
			sta.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20),"
					+ " City VARCHAR(20))");

			System.out.println("Table created");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
