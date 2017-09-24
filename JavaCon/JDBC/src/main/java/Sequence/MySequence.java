/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package Sequence;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

/**
 * Created by Saurabh on 1/10/2016.
 */
public class MySequence {
	public static void main(String[] args) {
		try {
			Class.forName(OracleDriver.class.getName());
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

			Statement st = conn.createStatement();

			// st.executeUpdate("DROP SEQUENCE seq");
			// st.executeUpdate("DROP TABLE empsequence");

			// st.executeUpdate("CREATE SEQUENCE seq INCREMENT BY 5 START WITH 100 MAXVALUE 2000");
			// st.executeUpdate("CREATE TABLE empsequence(id NUMBER)");
			st.executeUpdate("INSERT INTO empsequence VALUES (seq.nextval)");

			ResultSet resultSet = st.executeQuery("SELECT * FROM empsequence");
			while (resultSet.next()) {
				System.out.println("id = " + resultSet.getString(1));
			}
			st.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
