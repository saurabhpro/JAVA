/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package MetaData;

import java.sql.*;

import static MetaData.ResultSetMetaDataSimple.getOracleConnection;

/**
 * Created by Saurabh on 1/16/2016.
 */
public class ResultSetMetaDataFunctions {
	public static void main(String[] args) throws SQLException {
		Connection conn = getOracleConnection();

		Statement st = conn.createStatement();
		st.executeUpdate("INSERT  INTO empmeta VALUES (25,'ram',60000)");
		ResultSet rs = st.executeQuery("SELECT * FROM empmeta");

		ResultSetMetaData rsmd = rs.getMetaData();

		int columnCount = rsmd.getColumnCount();
		System.out.println("resultsetmetadata coulmun count" + columnCount);

		for (int i = 1; i <= columnCount; i++) {
			System.out.println("\nColumn Metadata");
			System.out.println("Column no: " + i);
			System.out.println("getColumnDisplaySize: " + rsmd.getColumnDisplaySize(i));
			System.out.println("getColumnLabel " + rsmd.getColumnLabel(i));
			System.out.println("getColumnName " + rsmd.getColumnName(i));
			System.out.println("getColumnType " + rsmd.getColumnType(i));
			System.out.println("getColumnClassName " + rsmd.getColumnClassName(i));
			System.out.println("getTableName " + rsmd.getTableName(i));
			System.out.println("getPrecision " + rsmd.getPrecision(i));
			System.out.println("getScale " + rsmd.getScale(i));

			System.out.println("isAutoIncrement " + rsmd.isAutoIncrement(i));

			System.out.println("isCurrency " + rsmd.isCurrency(i));
			//Indicates whether the designated column is a cash value.

			System.out.println("isWritable " + rsmd.isWritable(i));
			//Indicates whether it is possible for a write on the designated column to succeed.

			System.out.println("isDefinitelyWritable " + rsmd.isDefinitelyWritable(i));
			//Indicates whether a write on the designated column will definitely succeed.


			System.out.println("isNullable " + rsmd.isNullable(i));
			System.out.println("isReadOnly " + rsmd.isReadOnly(i));
			System.out.println("isCaseSensitive " + rsmd.isCaseSensitive(i));
			System.out.println("isSearchable " + rsmd.isSearchable(i));
			System.out.println("isSigned " + rsmd.isSigned(i));
			System.out.println("getCatalogName " + rsmd.getCatalogName(i));
			System.out.println("getSchemaName " + rsmd.getSchemaName(i));

		}
	}
}
