/*
 * Copyright (c) 2018 Saurabh Kumar
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
