/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
