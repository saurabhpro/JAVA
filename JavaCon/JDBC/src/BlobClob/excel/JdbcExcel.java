package BlobClob.excel;

import java.sql.*;

/**
 * Created by Saurabh on 1/17/2016.
 * For excel in jdbc we will have to use the type 1 driver which has been removed since jdk 8
 * but since it is supported till jdk 7 we will see how it works
 * <p>
 * first we have to register the Data Service Name (DSN) in
 * C:\Windows\SysWOW64\odbcad32.exe
 */
public class JdbcExcel {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        String mySql = null;
        ResultSet rs = null;

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //removed since jdk8
            conn = DriverManager.getConnection("jdbc:odbc:excel");//custom dsn


            /**
             * The ODBC Data Source Administrator menu will open
             Select the System DSN tab and click Add
             Find Driver do Microsoft Excel(*.xls) from the list and click Finish
             Give the Data Source Name = excel [which must match while getConnection() & Description

             Next, click Select Workbook and locate the spreadsheet you wish to use
             In this case, we are using worcester.xls. Select it and click OK.
             Click OK again to exit the setup. The ODBC connection is now complete.
             Now that the ODBC connection is setup, its time for the Java code.
             */

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            mySql = "SELECT * FROM [Sheet2$]";
            rs = stmt.executeQuery(mySql);

            while (rs.next()) {
                System.out.println(rs.getString("Product"));
                System.out.println(rs.getString("Customer"));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
