/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package Transactions;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

/**
 * Created by Saurabh on 1/17/2016.
 */
public class Rollback {
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
			//st.executeUpdate("INSERT INTO emptrans VALUES (16,'abc',40000)");
			int x = st.executeUpdate("UPDATE emptrans SET name = 'new2 abc' WHERE id = 14");

			ResultSet rs = st.executeQuery("SELECT * FROM emptrans ");

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

			conn.rollback();
			/*
			 * due to rollback all the changes made upto this point in this program is discarded from
			 * temporary buffer and only the things after this line will be updated to real database once
			 * commit method is called in the end.
			 */

			System.out.println("after rollback");

			rs = st.executeQuery("SELECT * FROM emptrans");

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

/*
 * output
 * 14 new2 abc 40000
 * after rollback
 * 14 new abc 40000
 */