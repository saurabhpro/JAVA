/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package MyStatement;

import java.sql.*;

/**
 * Created by Saurabh on 1/18/2016.
 * A java.sql.CallableStatement is used to call stored procedures in a database.
 * <p>
 * A stored procedure is like a function or method in a class, except it lives inside the database.
 * Some database heavy operations may benefit performance-wise from being executed inside the same
 * memory space as the database server, as a stored procedure.
 */
public class MyCallableStatements {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

			Statement s = conn.createStatement();

			CallableStatement callableStatement = conn.prepareCall(" {call recin88(?,?)}");
			callableStatement.setInt(1, 2019);
			callableStatement.setString(2, "ducat109");
			callableStatement.addBatch();

			callableStatement.setInt(1, 2016);
			callableStatement.setString(2, "ramu");
			callableStatement.addBatch();

			int[] updateCounts = callableStatement.executeBatch();

			ResultSet resultSet = callableStatement.executeQuery("SELECT * FROM emp66");

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
			}


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
