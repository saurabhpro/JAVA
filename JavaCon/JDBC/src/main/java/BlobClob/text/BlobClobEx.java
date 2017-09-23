/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package BlobClob.text;

import java.io.*;
import java.sql.*;

/**
 * Created by Saurabh on 1/17/2016.
 */
public class BlobClobEx {

	static String path = "C:\\Users\\Saurabh\\Documents\\GitHub\\JAVA\\JavaCon\\JDBC\\src\\BlobClob\\text";

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
		Statement st = conn.createStatement();

		createBlobClobTables(st);

		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BlobClob VALUES (40,?,?)");

		File file = new File(path + "\\Blob.txt");
		FileInputStream fis = new FileInputStream(file);
		pstmt.setBinaryStream(1, fis, (int) file.length());

		file = new File(path + "\\Clob.txt");
		fis = new FileInputStream(file);
		pstmt.setAsciiStream(2, fis, (int) file.length());

		fis.close();
		pstmt.execute();

		ResultSet rs = st.executeQuery("SELECT * FROM BlobClob");

		rs.next();  //since we only intend to add 1 row of record so only this will suffice

		java.sql.Blob blob = rs.getBlob(2);
		java.sql.Clob clob = rs.getClob(3);


		byte[] blobVal = new byte[(int) blob.length()];
		InputStream blobIs = blob.getBinaryStream();
		blobIs.read(blobVal);

		String s = new String(blobVal);
		System.out.println(s);
		blobIs.close();


		char[] clobVal = new char[(int) clob.length()];
		Reader reader = clob.getCharacterStream();
		reader.read(clobVal);

		String sw = new String(clobVal);
		System.out.println(sw);
		reader.close();

		conn.close();

	}

	private static void createBlobClobTables(Statement st) throws SQLException {
		String Sql = "CREATE TABLE BlobClob (id NUMBER(3), b BLOB, c CLOB)";

		try {
			st.executeUpdate("DROP TABLE BlobClob");

		} catch (SQLException e) {
			if (e.getErrorCode() == 942) {
				System.out.println("Error dropping BlobClob Table" + e.getMessage());
			}
		}

		if (st.executeUpdate(Sql) == 0) {
			System.out.println("BlobClob table Created");
		}
	}
}
