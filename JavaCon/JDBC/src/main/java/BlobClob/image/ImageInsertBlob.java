/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package BlobClob.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Saurabh on 1/17/2016.
 */
public class ImageInsertBlob {
	static String path = "C:\\Users\\Saurabh\\Documents\\GitHub\\JAVA\\JavaCon\\JDBC\\src\\BlobClob\\image";

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
		Statement st = conn.createStatement();

		// st.executeUpdate("CREATE TABLE empimage ( name VARCHAR2(20), img BLOB)");

		File file = new File(path + "\\baby.jpg");
		FileInputStream fis = new FileInputStream(file);
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO empimage VALUES (?,?)");
		pstmt.setString(1, "babyRaj");

		pstmt.setBinaryStream(2, fis, (int) file.length());
		pstmt.execute();
		fis.close();

	}
}
