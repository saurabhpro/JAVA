package MetaData;

import java.sql.*;

/**
 * Created by Saurabh on 1/18/2016.
 */
public class GetTableViewDatabaseMetaData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
        Statement st = conn.createStatement();

        getTables(conn);

        st.close();
        conn.close();
    }

    private static void getTables(Connection conn) throws SQLException {
        String TABLE_NAME = "TABLE_NAME";
        String TABLE_SCHEMA = "TABLE_SCHEMA";
        String[] TABLE_AND_VIEWS_TYPES = {"TABLE"};
        //  String[] TABLE_AND_VIEWS_TYPES = {"VIEWS"};

        DatabaseMetaData dbmd = conn.getMetaData();

        ResultSet rs = dbmd.getTables(null, null, null, TABLE_AND_VIEWS_TYPES);

        while (rs.next()) {
            System.out.println(rs.getString(3));
        }
    }
}
