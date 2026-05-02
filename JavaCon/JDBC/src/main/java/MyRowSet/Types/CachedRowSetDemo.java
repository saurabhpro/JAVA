/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package MyRowSet.Types;

import oracle.jdbc.driver.OracleDriver;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
 *
 * <p><b>Migration note (ojdbc11 23.x):</b> ojdbc11 23.x removed the {@code oracle.jdbc.rowset}
 * package, so {@code OracleCachedRowSet} no longer exists. Replaced with the JDK-bundled
 * {@link javax.sql.rowset.RowSetProvider#newFactory()} +
 * {@link javax.sql.rowset.RowSetFactory#createCachedRowSet()}. Variable + return types now use
 * the {@link CachedRowSet} interface — vendor-neutral and stable across driver upgrades.
 */
public class CachedRowSetDemo {
	private final static String fileName = "exceptions.try_with_resources.C:\\Users\\Saurabh\\Documents\\GitHub\\JAVA\\JavaCon\\JDBC\\src\\MyRowSet\\Types\\xyz.txt";

	public static void writeCatchedRowSet() throws SQLException, ClassNotFoundException, IOException {
		CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();

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

	public static CachedRowSet readOracleCatchedRowSet() throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream(fileName);
		ObjectInputStream in = new ObjectInputStream(fin);

		CachedRowSet cachedRowSet = (CachedRowSet) in.readObject();
		fin.close();
		in.close();

		return cachedRowSet;

	}

	public static void main(String[] args) {
		try {
			writeCatchedRowSet();

			CachedRowSet cachedRowSet = readOracleCatchedRowSet();
			while (cachedRowSet.next()) {
				System.out.print("ID " + cachedRowSet.getString(1));
				System.out.print("\tName " + cachedRowSet.getString(2));
				System.out.println("\tSalary " + cachedRowSet.getString(5));
			}

			cachedRowSet.close();
		} catch (IOException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
