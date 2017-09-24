/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package DateTime;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

/**
 * Created by Saurabh on 1/17/2016.
 * Java's java.sql.Date class is used in the JDBC API. If you need to set a date on a java.sql.PreparedStatement
 * or get a date from a java.sql.ResultSet, you will interact with java.sql.Date.
 * <p>
 * Actually, java.sql.Date extends java.util.Date, so anything you can do with a java.util.Date you can also do
 * with a java.sql.Date. Check out java.util.Date for more details.
 * <p>
 * Here is how to instantiate a java.sql.Date
 * <p>
 * long time = System.currentTimeMillis();
 * java.sql.Date date = new java.sql.Date(time);
 * <p>
 * The biggest difference between java.sql.Date and java.util.Date is that the java.sql.Date only keeps the date,
 * not the time, of the date it represents. So, for instance, if you create a java.sql.Date using
 * the date and time 2009-12-24 23:20, then the time (23:20) would be cut off. If you need to keep the time,
 * use a java.sql.Timestamp instead.
 */
public class GetDate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(OracleDriver.class.getName());
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

		Statement st = conn.createStatement();
		//      st.executeUpdate("CREATE TABLE empdate(id  NUMBER(3), myDate DATE DEFAULT sysdate)");

		String INSERT_RECORD = "INSERT INTO empdate(id , myDate) VALUES (?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(INSERT_RECORD);
		pstmt.setInt(1, 1);

		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		pstmt.setDate(2, sqlDate);

		pstmt.executeUpdate();

		ResultSet rs = st.executeQuery("SELECT * FROM empdate");

		while (rs.next()) {
			System.out.println("date: " + rs.getDate(2));
		}

		rs.close();
		conn.close();
		st.close();
		pstmt.close();
	}
}
