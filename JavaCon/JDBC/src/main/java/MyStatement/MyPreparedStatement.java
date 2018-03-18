/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package MyStatement;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

/**
 * Created by Saurabh on 12/1/2015.
 * If you want to use statement object many times, it usually reduces execution time to
 * use PreparedStatement object instead.
 * <p>
 * The main feature of PreparedStatement is that unlike the statement object it is given SQL statement when it is
 * created. The advantage of this is that in most cases this SQL statement is sent to the DBMS right away, where it is
 * compiled. As a result PreparedStatement object contains not just a SQL statement, but a SQL statement that has been
 * pre-compiled. This means that when the PreparedStatement is executed, the DBMS can just run the PreparedStatement SQL
 * statement without having to compile first.
 * <p>
 * A PreparedStatement is a special kind of statement object with some special features. Remember you need a statement
 * in parts to execute query or update. You can use the prepared statement instead of statement and benefits from the
 * features of PreparedStatement.
 * <p>
 * The prepared statement primary features are:-
 * <p>Easy to insert parameters into SQL statement statement
 * <p>Easy to reuse the PreparedStatement with new parameters
 * <p>May increase performance of executed statements.
 * <p>Enable easier batch update
 */


public class MyPreparedStatement {
	public static void main(String[] args) {
		try {
			Class.forName(OracleDriver.class.getName());

			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

			int t1 = 123;
			String t2 = "ram";

			Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			s.executeUpdate("CREATE TABLE emp66 (id NUMBER, name VARCHAR2(20))");
			s.close();


			PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO emp66 VALUES (?,?)",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			//PreparedStatement ps = conn.prepareStatement("insert into emp66 values(?,?)");
			prepareStatement.setInt(1, t1);
			prepareStatement.setString(2, t2);
			/*
			 * Once a PreparedStatement is created (prepared) for the above SQL statement,
			 * you can insert parameters at the location of the question mark.
			 * This is done using the many setXXX() methods.
			 *
			 * The first number (1) is the index of the parameter to insert the value for.
			 * The second number (t1) is the value to insert into the SQL statement.
			 */
			prepareStatement.executeUpdate();
			/*
			 * The executeUpdate() method is used when updating the database.
			 * It returns an int which tells how many records in the database were affected by the update.
			 */
			prepareStatement.close();

			prepareStatement = conn.prepareStatement("SELECT * FROM emp66 WHERE id=?");
			prepareStatement.setInt(1, t1);

			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
			}


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
