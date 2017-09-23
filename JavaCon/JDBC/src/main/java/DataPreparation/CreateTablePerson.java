/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package DataPreparation;

import java.sql.*;

public class CreateTablePerson {
	public static void main(String[] args) {
		Statement s1 = null;
		ResultSet rs = null;

		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
			s1 = con.createStatement();

			s1.execute("CREATE TABLE person (" +
					"p_id NUMBER(10,0) NOT NULL PRIMARY KEY , " +
					"p_fname VARCHAR2(20) NOT NULL," +
					"p_lname VARCHAR2(20)," +
					"p_gender CHAR(1)," +
					"p_dob DATE," +
					"accno INTEGER," +
					"FOREIGN KEY (accno) REFERENCES bank(accno))");

			s1.executeUpdate("INSERT INTO person VALUES (1,'ram','singh','m',to_date('24/11/1987','dd/mm/yyyy'),61)");
			s1.executeUpdate("INSERT INTO person VALUES (2,'shyam','rai','m',to_date('24/11/1987','dd/mm/yyyy'),62)");
			s1.executeUpdate("INSERT INTO person VALUES (3,'mohan','kumar','m',to_date('24/11/1987','dd/mm/yyyy'),63)");
			s1.executeUpdate("INSERT INTO person VALUES (4,'priya','gandhi','f',to_date('24/11/1987','dd/mm/yyyy'),64)");
			s1.executeUpdate("INSERT INTO person VALUES (5,'rita','verma','f',to_date('24/11/1987','dd/mm/yyyy'),65)");
			s1.executeUpdate("INSERT INTO person VALUES (6,'diya','singh','f',to_date('24/11/1987','dd/mm/yyyy'),NULL )");
			s1.executeUpdate("INSERT INTO person VALUES (65,'miya','khlifa','f',to_date('24/11/1987','dd/mm/yyyy'),NULL )");

			s1.execute("COMMIT");

			rs = s1.executeQuery("SELECT * FROM person");
			while (rs.next()) {
				System.out.println(rs.getString(2) + " " + rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
