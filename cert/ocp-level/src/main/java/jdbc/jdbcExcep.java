package jdbc;

import jdbc.setup.DB_Path;

import java.sql.*;

public class jdbcExcep {
	public static void main(String[] args) {
		String url = "jdbc:derby:" + DB_Path.dbPath;

		try (Connection conn = DriverManager.getConnection(url);
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery("SELECT not_a_column FROM animal")) {
			while (rs.next())
				System.out.println(rs.getString(1));

		} catch (SQLException e) {
			// Column 'NOT_A_COLUMN' is either not in any table in the FROM list or appears within a join specification and is outside the scope of the join specification or appears in a HAVING clause and is not in the GROUP BY list. If this is a CREATE or ALTER TABLE  statement then 'NOT_A_COLUMN' is not a column in the target table.
			System.out.println(e.getMessage());

			final int i = (int) 30L;

			// generic 42X04 you can google with
			System.out.println(e.getSQLState());

			// database specific 30000
			System.out.println(e.getErrorCode());
		}

		try (Connection conn = DriverManager.getConnection(url);
		     Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT count(*) FROM species");
			//int num = stmt.executeUpdate("INSERT INTO species VALUES (6, 'Ant', .05)"); // rs closed here
			int result = stmt.executeUpdate("UPDATE species SET name = name WHERE id = 1"); // name = name means the name will remain unchnaged in db
			//rs.next();  // SQLException ResultSet not open. Operation 'next' not permitted. Verify that autocommit is off.
			// System.out.println(rs.getInt(1));

			rs = stmt.executeQuery("SELECT * FROM species");
			if (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
