package Transactions;

import java.sql.*;

/**
 * Created by Saurabh on 1/17/2016.
 */
public class SavePoint {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
			Statement st = conn.createStatement();

			conn.setAutoCommit(false);
			/**
			 * by default it is set to true, so any execute also committed the changes to the actual database,
			 * but for transactions we need all queries to be completed at one go, so we make changes in
			 * temporary buffer and the when commit() is called to real database
			 */

			//  st.executeUpdate("CREATE TABLE emptrans (id NUMBER, name VARCHAR2(20), salary NUMBER)");
			int x = st.executeUpdate("UPDATE emptrans SET name = 'new3 abc' WHERE id = 14");
			st.executeUpdate("INSERT INTO emptrans VALUES (16,'rohit',89000)");


			Savepoint savepoint = conn.setSavepoint("anyName");
			/**
			 * Defines a new savepoint. It also returns a Savepoint object.
			 */


			x = st.executeUpdate("DELETE  FROM emptrans WHERE id=14");
			st.executeUpdate("INSERT INTO emptrans VALUES (18,'rahul',50000)");


			conn.rollback(savepoint);
			/**
			 * rolls back work to the specified savepoint.
			 * now everything from here till the savepoint creation line will be ignored and the rest can be
			 * updated using commit()
			 *
			 * this violates the A property in ACID but can be useful when we want to change some and ignore some
			 * queries
			 */

			conn.releaseSavepoint(savepoint);
			/**
			 * Deletes a savepoint. Notice that it requires a Savepoint object as a parameter.
			 * This object is usually a savepoint generated by the setSavepoint() method.
			 */


			conn.commit();
			/**
			 * if we comment the above line then all the changes done above will not be passed
			 * to actual database from the temporary buffer.
			 */

			ResultSet rs = st.executeQuery("SELECT * FROM emptrans");

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}