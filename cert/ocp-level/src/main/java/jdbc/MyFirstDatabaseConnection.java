package jdbc;

import jdbc.setup.DB_Path;

import java.sql.*;

public class MyFirstDatabaseConnection {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:derby:" + DB_Path.dbPath;

		try (Connection conn = DriverManager.getConnection(url);
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery("SELECT name FROM animal")) {

			while (rs.next())
				System.out.println(rs.getString(1));
		}

		Connection conn = DriverManager.getConnection(url);
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = stmt.executeQuery("SELECT id FROM species ORDER BY id");

		rs.afterLast();
		System.out.println(rs.previous()); // true
		System.out.println(rs.getInt(1)); // 2

		/*
		 * Moves the cursor to the previous row in this ResultSet object.
		 * returns false, if the cursor is positioned before the first row.
		 */
		System.out.println(rs.previous());
		System.out.println(rs.getInt(1));

		/*
		 * Moves the cursor to the last row in
		 * this ResultSet object.
		 */
		System.out.println(rs.last());  // false if no rows
		System.out.println(rs.getInt(1));

		System.out.println(rs.first());
		System.out.println(rs.getInt(1));

		/*
		 * Moves the cursor to the front of
		 * this ResultSet object, just before the first row.
		 * This method has no effect if the result set contains no rows.
		 */
		rs.beforeFirst();
		System.out.println(rs.getInt(1));   // ERROR 24000: Invalid cursor state - no current row.

	}

	public static void random() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");

		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ocp-book",
				"username",
				"password");
	}
}