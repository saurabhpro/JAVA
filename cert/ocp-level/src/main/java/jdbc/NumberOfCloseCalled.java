package jdbc;

import jdbc.setup.DB_Path;

import java.sql.*;

/**
 * 4
 */
public class NumberOfCloseCalled {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:derby:" + DB_Path.dbPath;

		try (Connection conn = DriverManager.getConnection(url);
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery("SELECT count(*) FROM animal")
		) {

			if (rs.next()) System.out.println(rs.getInt(1));

			ResultSet rs2 = stmt.executeQuery("SELECT count(*) FROM animal");                       // 1

			int num = stmt.executeUpdate("UPDATE animal SET name = 'clear' WHERE name = 'other'");  // 2

			// statement // conn        // 4

		}
	}
}
