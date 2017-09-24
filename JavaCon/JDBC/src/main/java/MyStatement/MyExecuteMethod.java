/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package MyStatement;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

/**
 * Created by Saurabh on 1/17/2016.
 */
public class MyExecuteMethod {
	public static void main(String[] args) {
		Connection conn = null;

		try {

			Class.forName(OracleDriver.class.getName());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
			Statement st = conn.createStatement();

			//this query can be update query or can be select query
			String update = "UPDATE emp66 SET name = 'bhalu' WHERE id = 123";
			String query = "SELECT * FROM emp66";

			boolean status1 = st.execute(update);
			boolean status = st.execute(query);

			if (status) {
				//query is a select query
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2));
				}
				rs.close();

			} else {
				int count = st.getUpdateCount();
				System.out.println("total record updated: " + count);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
