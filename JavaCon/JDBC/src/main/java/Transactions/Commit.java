/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package Transactions;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

/**
 * Created by Saurabh on 1/17/2016.
 */
public class Commit {
	public static void main(String[] args) {
		try {
			Class.forName(OracleDriver.class.getName());
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
			Statement st = conn.createStatement();

			conn.setAutoCommit(false);
			/*
			 * by default it is set to true, so any execute also committed the changes to the actual database,
			 * but for transactions we need all queries to be completed at one go, so we make changes in
			 * temporary buffer and the when commit() is called to real database
			 */

			//  st.executeUpdate("CREATE TABLE emptrans (id NUMBER, name VARCHAR2(20), salary NUMBER)");
			st.executeUpdate("INSERT INTO emptrans VALUES (16,'abc',40000)");
			int x = st.executeUpdate("UPDATE emptrans SET name = 'new abc' WHERE id = 16");

			ResultSet rs = st.executeQuery("SELECT * FROM emptrans ");

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

			conn.commit();
			/*
			 * if we comment the above line then all the changes done above will not be passed
			 * to actual database from the temporary buffer.
			 */

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
