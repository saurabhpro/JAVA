/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package DateTime;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

/**
 * Created by Saurabh on 1/17/2016.
 * Java's java.sql.Timestamp class is used in the JDBC API. If you need to set a date + time
 * on a java.sql.PreparedStatement or get a date + time from a java.sql.ResultSet,
 * you will interact with java.sql.Timestamp.
 * <p>
 * Actually, java.sql.Timestamp extends java.util.Date, so anything you can do with a java.util.Date
 * you can also do with a java.sql.Timestamp. Check out java.util.Date for more details.
 * <p>
 * The biggest difference between java.sql.Date and java.sql.Timestamp is that the java.sql.Date
 * only keeps the date, not the time, of the date it represents.
 * <p>
 * So, for instance, if you create a java.sql.Date using the date and time 2009-12-24 23:20,
 * then the time (23:20) would be cut off. If you use a java.sql.Timestamp then the time is kept.
 * <p>
 * Nanoseconds
 * One difference in the java.sql.Timestamp from its superclass java.util.Date is its ability to hold
 * the nanoseconds of a date too. You can get and set the nanoseconds using the getNanos() and setNanos().
 * Here is how:
 * <p>
 * long time = System.currentTimeMillis();
 * java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
 * <p>
 * timestamp.setNanos(123456);
 * int nanos = timestamp.getNanos(); // nanos = 123456
 */

public class GetTimestamp {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(OracleDriver.class.getName());
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

		Statement st = conn.createStatement();
		//    st.executeUpdate("CREATE TABLE emptime(id  NUMBER(3), myDate TIMESTAMP)");

		String INSERT_RECORD = "INSERT INTO emptime(id , myDate) VALUES (?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(INSERT_RECORD);
		pstmt.setInt(1, 1);

		//java.sql.Time sqlDate = new java.sql.Time(new java.util.Date().getTime());
		//only stores current time, date is 1970-01-01 only but Timestamp get current date and time

		java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
		pstmt.setTimestamp(2, sqlDate);

		pstmt.executeUpdate();

		ResultSet rs = st.executeQuery("SELECT * FROM emptime");

		while (rs.next()) {
			System.out.println("timestamp: " + rs.getTimestamp(2) + " " + "time: " + rs.getTime(2));
		}

		rs.close();
		conn.close();
		st.close();
		pstmt.close();
	}
}
