/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package MetaData;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

/**
 * Created by Saurabh on 1/18/2016.
 */
public class GetTableViewDatabaseMetaData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(OracleDriver.class.getName());
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
		Statement st = conn.createStatement();

		getTables(conn);

		st.close();
		conn.close();
	}

	private static void getTables(Connection conn) throws SQLException {
		String TABLE_NAME = "TABLE_NAME";
		String TABLE_SCHEMA = "TABLE_SCHEMA";
		String[] TABLE_AND_VIEWS_TYPES = {"TABLE"};
		//  String[] TABLE_AND_VIEWS_TYPES = {"VIEWS"};

		DatabaseMetaData dbmd = conn.getMetaData();

		ResultSet rs = dbmd.getTables(null, null, null, TABLE_AND_VIEWS_TYPES);

		while (rs.next()) {
			System.out.println(rs.getString(3));
		}
	}
}
