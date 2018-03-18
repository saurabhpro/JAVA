/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package MyResultSet;

import java.sql.*;

/**
 * Created by Saurabh on 11/15/2015. my first jdbc program steps: 1. install oracle [any version] if you have express
 * edition database name is "xe" and on full version its "orcl" 2. if you want to run your jdbc program from ide, add
 * the library containing ojdbcX.jar into the project settings and for cmd set environment variable
 * classpath=C:\app\saurabhk\product\12.1.0\dbhome_1\jdbc\lib\ojdbc7.jar;.
 * <p>
 * 3. since oracle already gives you a database to work with you dont need to make the connection to that database and
 * you can directly perform CURD operations like creating a table etc.
 */
public class ResultSetRetrieve {

	public static void main(String[] args) throws SQLException {
		Statement st = null;
		ResultSet rs = null;

		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
			System.out.println("connection succesful");

			st = con.createStatement();
	   /*     st.execute("CREATE TABLE bank (" +
	                "accno NUMBER(10,0) NOT NULL PRIMARY KEY , " +
                    "holder_name VARCHAR2(20) NOT NULL," +
                    "income INTEGER NOT NULL )");*/

			st.executeUpdate("UPDATE person SET p_fname='gurmeet', p_lname='singh' WHERE p_id=6");
			st.execute("DELETE FROM person WHERE p_id=65");
			st.execute("COMMIT");

			rs = st.executeQuery("SELECT * FROM person");
			while (rs.next()) {
				System.out.println("Inside ResultSet");
				System.out.println(rs.getString(2) + " " + rs.getString(3));

				/**
				 * The ResultSet.next() method moves to the next row in the ResultSet, if there are anymore rows.
				 * If there are anymore rows, it returns true. If there were no more rows, it will return false.

				 You need to call next() at least one time before you can read any data. Before the first next()
				 call the ResultSet is positioned before the first row.

				 You can get the index of a given column by calling the ResultSet.findColumn() method, like this:
				 int columnIndex = result.findColumn("columnName");

				 When you are done iterating the ResultSet you need to close both the ResultSet and the Statement
				 object that created it (if you are done with it, that is). You do so by calling their close() methods,
				 like this:

				 result.close();
				 statement.close();
				 Of course you should call these mehtods inside a finally block to make sure that they are
				 called even if an exception occurs during ResultSet iteration.
				 */
			}

			rs = st.executeQuery("SELECT * FROM bank");
			while (rs.next()) {
				System.out.println("Inside ResultSet");
				System.out.println(rs.getString(2) + " " + rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (st != null) st.close();
		}

	}
}
