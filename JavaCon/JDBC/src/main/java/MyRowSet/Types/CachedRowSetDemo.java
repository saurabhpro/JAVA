/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package MyRowSet.Types;

/*This import causes maven to fail hence excluding it*/

import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.rowset.OracleCachedRowSet;

import java.io.*;
import java.sql.SQLException;

/**
 * Created by Saurabh on 11/28/2015. CachedRowSet also extends rowset interface and is a disconnected rowset. It acts as
 * a container for database records and caches them in memory.In a sense we may think of it as a subject of actual
 * record maintained in memory. This reminds us somewhat of the concept of "View" we can we create from actual table
 * through SQL.
 * <p>
 * Being disconnected, cachedRowSet is more lightweight.
 * <p>
 * This connection is established for a brief period of time only when certain changes is needed to be reflected on
 * cached data and ultimately propagated back to the actual database. However, this does not mean it lacks capability of
 * jdbcrowset; on the contrary it is equipped with additional capability of caching.
 * <p>
 * On the downside, connection has to be established every time to reflect any changes, performance may be slower than
 * jdbcrowset but on the upside it is lightweight and we can get a better efficiency when working with large amount of
 * data
 */
public class CachedRowSetDemo {
	private final static String fileName = "exceptions.try_with_resources.C:\\Users\\Saurabh\\Documents\\GitHub\\JAVA\\JavaCon\\JDBC\\src\\MyRowSet\\Types\\xyz.txt";

	public static void writeCatchedRowSet() throws SQLException, ClassNotFoundException, IOException {
		OracleCachedRowSet rowSet = new OracleCachedRowSet();

		Class.forName(OracleDriver.class.getName());
		rowSet.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		rowSet.setUsername("system");
		rowSet.setPassword("98989");

		String sql = "select * from emp";
		rowSet.setCommand(sql);
		rowSet.execute();

		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeObject(rowSet);
		out.close();
		rowSet.close();
	}

	public static OracleCachedRowSet readOracleCatchedRowSet() throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream(fileName);
		ObjectInputStream in = new ObjectInputStream(fin);

		OracleCachedRowSet oracleCachedRowSet = (OracleCachedRowSet) in.readObject();
		fin.close();
		in.close();

		return oracleCachedRowSet;

	}

	public static void main(String[] args) {
		try {
			writeCatchedRowSet();

			OracleCachedRowSet oracleCachedRowSet = readOracleCatchedRowSet();
			while (oracleCachedRowSet.next()) {
				System.out.print("ID " + oracleCachedRowSet.getString(1));
				System.out.print("\tName " + oracleCachedRowSet.getString(2));
				System.out.println("\tSalary " + oracleCachedRowSet.getString(5));
			}

			oracleCachedRowSet.close();
		} catch (IOException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
