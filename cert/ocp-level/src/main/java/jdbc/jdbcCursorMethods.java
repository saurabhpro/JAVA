package jdbc;

import jdbc.setup.DB_Path;

import java.sql.*;

public class jdbcCursorMethods {
	public static void main(String[] args) throws SQLException {

		String url = "jdbc:derby:" + DB_Path.dbPath;

		try (Connection conn = DriverManager.getConnection(url);
		) {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("SELECT id FROM animal ORDER BY id");

			rs.afterLast();
			System.out.println(rs.previous()); // true
			System.out.println(rs.getInt(1));
			System.out.println(rs.previous());
			System.out.println(rs.getInt(1));
			System.out.println(rs.last());
			System.out.println(rs.getInt(1));
			System.out.println(rs.first());
			System.out.println(rs.getInt(1));
			//rs.beforeFirst();
			System.out.println(rs.getInt(1));   // Invalid cursor state - no current row. if read from an empty row

			rs.absolute(0);
			System.out.println(rs.absolute(2));
			System.out.println(rs.getString("id"));
			System.out.println(rs.absolute(0));
			System.out.println(rs.absolute(5));
			System.out.println(rs.getString("id"));
			System.out.println(rs.absolute(-2));
			System.out.println(rs.getString("id"));


			rs.absolute(0);
			System.out.println(rs.next());
			System.out.println(rs.getString("id"));
			System.out.println(rs.relative(2));
			System.out.println(rs.getString("id"));
			System.out.println(rs.relative(-1));
			System.out.println(rs.getString("id"));
			//System.out.println(rs.relative(4));
			first(conn);


		}
	}

	private static void first(Connection conn) throws SQLException {
		// Now let’s look at an example where the query doesn’t return any rows:

		// The first parameter is the ResultSet type. The second parameter is the ResultSet concurrency mode.
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = stmt.executeQuery("SELECT id FROM species WHERE id = -99");
		System.out.println(rs.first()); // false
		System.out.println(rs.last()); // false

	}
}
