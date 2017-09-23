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

import java.sql.*;

/**
 * Created by Saurabh on 1/16/2016.
 * getColumnType return an interger which is then mapped to a type from Types class static feilds to get name
 */
public class ResultSetMetaDataSimple {
	public static void main(String[] args) throws SQLException {
		Connection conn = getOracleConnection();

		Statement st = conn.createStatement();

		// st.executeUpdate("CREATE TABLE empmeta (id NUMBER, name VARCHAR2(20), salary NUMBER)");
		ResultSet rs = st.executeQuery("SELECT * FROM empmeta");

		ResultSetMetaData rsmd = rs.getMetaData();

		int count = rsmd.getColumnCount();
		System.out.println("no of columns:" + count);

		for (int i = 1; i <= count; i++)
			System.out.println(rsmd.getColumnName(i) + "\t" + rsmd.getColumnTypeName(i));

	}

	public static Connection getOracleConnection() throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
		return c;
	}

}
