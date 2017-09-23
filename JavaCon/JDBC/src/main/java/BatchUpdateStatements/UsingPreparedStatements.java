/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package BatchUpdateStatements;

import java.sql.*;

/**
 * Created by Saurabh on 1/10/2016.
 */
public class UsingPreparedStatements {
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

			Statement s = conn.createStatement();

			preparedStatement = conn.prepareStatement("UPDATE empbatch SET salary=? WHERE id=?");

			preparedStatement.setInt(1, 60000);
			preparedStatement.setInt(2, 45);

			preparedStatement.addBatch();

			int[] count = preparedStatement.executeBatch();
			/**
			 * The int[] array returned by the executeBatch() method is an array of int telling
			 * how many records were affected by each executed SQL statement in the batch.
			 */

			ResultSet resultSet = s.executeQuery("SELECT * FROM empbatch");
			while (resultSet.next()) {
				System.out.println("id = " + resultSet.getString(1) +
						"\tname = " + resultSet.getString(2) +
						"\tsalary = " + resultSet.getString(3));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
