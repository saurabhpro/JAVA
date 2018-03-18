/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package MyRowSet.Types;

//import com.sun.rowset.WebRowSetImpl; - expired

import oracle.jdbc.rowset.OracleWebRowSet;

import javax.sql.rowset.WebRowSet;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Saurabh on 11/28/2015. This class extends CachedRowSet class which lets you use the same properties and
 * methods as well as operate in disconnected mode.
 * <p>
 * However the WebRowSet object can generate XML document representing itself. You can create thess documents to create
 * copies of the WebRowSet object which makes it easy for you to distribute the information across the web and through
 * firewalls using http
 */
public class WebRowSetDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		WebRowSet webRowSet = new OracleWebRowSet();

		webRowSet.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		webRowSet.setUsername("system");
		webRowSet.setPassword("98989");
		webRowSet.setCommand("select * from emp");
		webRowSet.execute();

		while (webRowSet.next()) {
			System.out.println(webRowSet.getInt(1) + "\t" + webRowSet.getString(2));
		}

		FileWriter fileWriter = new FileWriter("C:\\Users\\Saurabh\\Documents\\GitHub\\JAVA\\" +
				"JavaCon\\JDBC\\src\\MyRowSet\\Types\\emp.xml");
		webRowSet.writeXml(fileWriter);
	}
}
