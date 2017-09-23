/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package MyResultSet;

import java.sql.*;

/**
 * Created by Saurabh on 12/2/2015.
 * <p>
 * only a SCROLL_SENSITIVE ResultSet can see external changes to the underlying database and Oracle can only see the
 * changes from external UPDATE operation. [internal se hi hoga insert]
 * <p>
 * changes from external DELETE or INSERT operation are not visible in Oracle.
 */
public class SensitiveResultSet {
	public static void main(String[] args) {
		Statement st = null;
		Statement st1 = null;

		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			System.out.println("Supports Holdability?\t" +
					databaseMetaData.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));

			boolean b = databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);
			System.out.println("Supports bothdirection?\t" + b);

			//other type of createStatement()
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			//with 2 args
			st1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			st1.setFetchSize(1);


			MyThread t1 = new MyThread(st, st1);
			t1.start();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


class MyThread extends Thread {
	Statement st;
	Statement st1;
	ResultSet rs;

	public MyThread(Statement st, Statement st1) {
		this.st = st;
		this.st1 = st1;
	}

	@Override
	public void run() {
		try {
			rs = st.executeQuery("SELECT * FROM bank");
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}


			MyThread2 thread2 = new MyThread2(st1);
			thread2.start();

			try {
				thread2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			rs.beforeFirst();   //since our rs is scrollable

			System.out.println("before last changes");
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


class MyThread2 extends Thread {
	Statement st;

	MyThread2(Statement st) {
		this.st = st;
	}

	@Override
	public void run() {
		try {
			st.execute("UPDATE bank SET income=income+150");
			st.execute("COMMIT ");

			Thread.sleep(1000);
			st.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
