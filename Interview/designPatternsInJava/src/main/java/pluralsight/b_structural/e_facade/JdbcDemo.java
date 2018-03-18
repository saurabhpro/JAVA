/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.b_structural.e_facade;

import pluralsight.b_structural.e_facade.jdbcfacade.DbSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String args[]) {
		DbSingleton instance = DbSingleton.getInstance();

		try {
			Connection conn = instance.getConnection();

			Statement sta = conn.createStatement();
			int count = sta.executeUpdate("CREATE TABLE Address (ID INTEGER, StreetName "
					+ "VARCHAR(20), City VARCHAR(20))");

			System.out.println("Table created.");
			sta.close();

			sta = conn.createStatement();
			count = sta.executeUpdate("INSERT INTO Address (ID, StreetName, City) "
					+ "VALUES (1, '1234 Some street', 'Layton')");
			System.out.println(count + " record(s) created.");
			sta.close();

			sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM Address");

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
