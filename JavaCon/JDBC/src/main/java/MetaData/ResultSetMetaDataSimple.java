/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package MetaData;

import java.sql.*;

/**
 * Created by Saurabh on 1/16/2016.
 * getColumnType return an interger which is then mapped to a type from Types class static feilds to get name
 */
public class ResultSetMetaDataSimple {
	public static void main(String[] args) throws SQLException {
		Connection conn = getOracleConnection();

		Statement st = conn.createStatement();

		// st.executeUpdate("CREATE TABLE empmeta (id NUMBER, name VARCHAR2(20), salary NUMBER)");
		ResultSet rs = st.executeQuery("SELECT * FROM empmeta");

		ResultSetMetaData rsmd = rs.getMetaData();

		int count = rsmd.getColumnCount();
		System.out.println("no of columns:" + count);

		for (int i = 1; i <= count; i++)
			System.out.println(rsmd.getColumnName(i) + "\t" + rsmd.getColumnTypeName(i));

	}

	public static Connection getOracleConnection() throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
		return c;
	}

}
