package derby;

import java.sql.*;

/**
 * Created by saurabhkumar on 28/05/17.
 */
public class DerbyDemo {
	public static void main(String[] args) {

		DBFacade instance = DBFacade.getInstance();

		Connection conn = instance.getConnection();

		try (Statement statement = conn.createStatement()) {

			instance.createTable(statement);
			instance.insertRows(statement);

			ResultSet resultSet = statement.executeQuery("SELECT * FROM Address2");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

			int columnCount = resultSetMetaData.getColumnCount();
			for (int i = 1; i < columnCount; i++) {
				System.out.print(resultSetMetaData.getColumnName(i) + " | ");
			}
			System.out.println();

			while (resultSet.next()) {
				for (int i = 1; i < columnCount; i++) {
					System.out.print(resultSet.getString(i) + " | ");
				}
				System.out.println();
			}

			if (statement != null) statement.close();
			if (conn != null) conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
