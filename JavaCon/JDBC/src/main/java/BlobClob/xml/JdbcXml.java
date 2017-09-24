/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package BlobClob.xml;

import oracle.jdbc.driver.OracleDriver;

import java.io.*;
import java.sql.*;

/**
 * Created by Saurabh on 1/17/2016.
 */
public class JdbcXml {
	static String path = "C:\\Users\\Saurabh\\Documents\\GitHub\\JAVA\\JavaCon\\JDBC\\src\\BlobClob\\xml";

	public static void main(String[] args) {
		try {
			Class.forName(OracleDriver.class.getName());
			System.out.println("connecting to the database...");

			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
			Statement st = conn.createStatement();

			createXmlTable(st);

			//open a FileInputStream
			File f = new File(path + "\\simple.xml");
			long fileLength = f.length();
			FileInputStream fis = new FileInputStream(f);

			String SQL = "INSERT INTO XML_Data VALUES(?,?)";

			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 200);
			pstmt.setAsciiStream(2, fis, fileLength);
			pstmt.execute();

			fis.close();

			SQL = "SELECT data FROM XML_Data WHERE id = 200";

			ResultSet rs = st.executeQuery(SQL);

			if (rs.next()) {
				InputStream xmlInputStream = rs.getAsciiStream(1);
				int c;

				ByteArrayOutputStream bos = new ByteArrayOutputStream();

				while ((c = xmlInputStream.read()) != -1)
					bos.write(c);

				System.out.println(bos.toString());
			}

			rs.close();
			pstmt.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private static void createXmlTable(Statement st) throws SQLException {
		System.out.println("Creating XML_Data Table...");
		String streamingDataSQL = "CREATE TABLE XML_Data (id NUMBER, Data LONG)";

		try {
			st.executeUpdate("DROP TABLE XML_Data");
		} catch (SQLException ignored) {
		}

		st.executeUpdate(streamingDataSQL);
	}
}
