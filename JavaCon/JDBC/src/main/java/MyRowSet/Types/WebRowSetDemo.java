/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package MyRowSet.Types;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

/**
 * Created by Saurabh on 11/28/2015. This class extends CachedRowSet class which lets you use the same properties and
 * methods as well as operate in disconnected mode.
 * <p>
 * However the WebRowSet object can generate XML document representing itself. You can create thess documents to create
 * copies of the WebRowSet object which makes it easy for you to distribute the information across the web and through
 * firewalls using http
 *
 * <p><b>Migration note (ojdbc11 23.x):</b> {@code OracleWebRowSet} was removed with the
 * {@code oracle.jdbc.rowset} package. Replaced with
 * {@link RowSetProvider#newFactory()}{@code .createWebRowSet()} — JDK-bundled, vendor-neutral.
 */
public class WebRowSetDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		WebRowSet webRowSet = RowSetProvider.newFactory().createWebRowSet();

		webRowSet.setUrl("jdbc:oracle:thin:@localhost:1521/FREE");
		webRowSet.setUsername("system");
		webRowSet.setPassword("98989");
		webRowSet.setCommand("select * from emp");
		webRowSet.execute();

		while (webRowSet.next()) {
			System.out.println(webRowSet.getInt(1) + "\t" + webRowSet.getString(2));
		}

		Path outputPath = Paths.get(System.getProperty("java.io.tmpdir"), "emp.xml");
		FileWriter fileWriter = new FileWriter(outputPath.toFile());
		webRowSet.writeXml(fileWriter);
	}
}
