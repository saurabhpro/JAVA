/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package BatchUpdateStatements;


import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

/**
 * Created by Saurabh on 1/10/2016.
 */
public class UsingStatements {
	public static void main(String[] args) {
		try {
			Class.forName(OracleDriver.class.getName());
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

			Statement s = conn.createStatement();
			String s0 = "DROP TABLE empbatch";
			String s1 = "CREATE TABLE empbatch (id NUMBER,name VARCHAR2(25), salary NUMBER )";
			String s2 = "INSERT INTO empbatch VALUES (49,'ram',40000)";
			String s3 = "UPDATE empbatch SET id=47 WHERE id=49";

			s.addBatch(s0);
			s.addBatch(s1);
			s.addBatch(s2);
			s.addBatch(s3);

			s.executeBatch();
			/*
			 *  The int[] array returned by the executeBatch() method is an array of int telling
			 *  how many records were affected by each executed SQL statement in the batch.
			 */

			ResultSet resultSet = s.executeQuery("SELECT * FROM empbatch");
			while (resultSet.next()) {
				System.out.println("id = " + resultSet.getString(1) +
						"\tname = " + resultSet.getString(2) +
						"\tsalary = " + resultSet.getString(3));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
