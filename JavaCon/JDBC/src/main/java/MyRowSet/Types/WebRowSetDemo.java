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
