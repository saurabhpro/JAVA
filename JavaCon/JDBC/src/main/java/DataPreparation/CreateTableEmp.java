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

/**
 * Created by Saurabh on 12/2/2015.
 */
public class CreateTableEmp {
	public static void main(String[] args) {
		Statement s1 = null;
		ResultSet rs = null;

		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
			s1 = con.createStatement();

			s1.execute("CREATE TABLE emp (" +
					"emp_id NUMBER(10,0) NOT NULL PRIMARY KEY , " +
					"emp_fname VARCHAR2(20) NOT NULL," +
					"emp_lname VARCHAR2(20)," +
					"emp_joindate DATE," +
					"emp_salary INTEGER)");

			s1.executeUpdate("INSERT INTO emp VALUES (101,'ram','singh',to_date('24/11/1987','dd/mm/yyyy'),6100)");
			s1.executeUpdate("INSERT INTO emp VALUES (102,'shyam','rai',to_date('24/11/1987','dd/mm/yyyy'),6200)");
			s1.executeUpdate("INSERT INTO emp VALUES (103,'mohan','kumar',to_date('24/11/1987','dd/mm/yyyy'),6300)");
			s1.executeUpdate("INSERT INTO emp VALUES (104,'priya','gandhi',to_date('24/11/1987','dd/mm/yyyy'),6400)");

			s1.execute("COMMIT");

			rs = s1.executeQuery("SELECT * FROM emp");
			while (rs.next()) {
				System.out.println(rs.getString(2) + " " + rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
