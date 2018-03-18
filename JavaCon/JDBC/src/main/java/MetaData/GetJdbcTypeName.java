/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package MetaData;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

/**
 * Created by Saurabh on 1/18/2016.
 */
public class GetJdbcTypeName {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(OracleDriver.class.getName());
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
		Statement st = conn.createStatement();

		DatabaseMetaData dbmd = conn.getMetaData();

		System.out.println("URL in use: " + dbmd.getURL());
		System.out.println("UserName: " + dbmd.getUserName());
		System.out.println("DBMS name: " + dbmd.getDatabaseProductName());
		System.out.println("DBMS version: " + dbmd.getDatabaseProductVersion());
		System.out.println("Driver Name: " + dbmd.getDriverName());
		System.out.println("Supported SQL Keywords: " + dbmd.getSQLKeywords());


		ResultSet rs = dbmd.getTypeInfo();

		while (rs.next()) {
			String typeName = rs.getString("TYPE_NAME");

			short dataType = rs.getShort("DATA_TYPE");
			System.out.println(typeName + " " + dataType);
		}


	}
}
/**
 * OUTPUT
 * URL in use: jdbc:oracle:thin:@localhost:1521:orcl
 * UserName: SYSTEM
 * DBMS name: Oracle
 * DBMS version: Oracle Database 12c Standard Edition Release 12.1.0.2.0 - 64bit Production
 * Driver Name: Oracle JDBC driver
 * Supported SQL Keywords: ACCESS, ADD, ALTER, AUDIT, CLUSTER, COLUMN, COMMENT, COMPRESS, CONNECT,
 * DATE, DROP, EXCLUSIVE, FILE, IDENTIFIED, IMMEDIATE, INCREMENT, INDEX, INITIAL, INTERSECT, LEVEL,
 * LOCK, LONG, MAXEXTENTS, MINUS, MODE, NOAUDIT, NOCOMPRESS, NOWAIT, NUMBER, OFFLINE, ONLINE, PCTFREE,
 * PRIOR, all_PL_SQL_reserved_ words
 * <p>
 * INTERVALDS -104
 * INTERVALYM -103
 * TIMESTAMP WITH LOCAL TIME ZONE -102
 * TIMESTAMP WITH TIME ZONE -101
 * NCHAR -15
 * NVARCHAR2 -9
 * NUMBER -7
 * NUMBER -6
 * NUMBER -5
 * LONG RAW -4
 * RAW -3
 * LONG -1
 * CHAR 1
 * NUMBER 2
 * NUMBER 4
 * NUMBER 5
 * FLOAT 6
 * REAL 7
 * VARCHAR2 12
 * DATE 92
 * DATE 93
 * TIMESTAMP 93
 * STRUCT 2002
 * ARRAY 2003
 * BLOB 2004
 * CLOB 2005
 * REF 2006
 * NCLOB 2011
 */