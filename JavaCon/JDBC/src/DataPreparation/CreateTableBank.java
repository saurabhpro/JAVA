package DataPreparation;

import java.sql.*;

/**
 * Created by Saurabh on 12/2/2015.
 */
public class CreateTableBank {
    public static void main(String[] args) {
        Statement s1 = null;
        ResultSet rs = null;

        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
            s1 = con.createStatement();

            s1.execute("CREATE TABLE bank (" +
                    "accno NUMBER(10,0) NOT NULL PRIMARY KEY , " +
                    "holder_name VARCHAR2(20) NOT NULL," +
                    "income INTEGER NOT NULL)");

            s1.executeUpdate("INSERT INTO bank VALUES (61,'ram',40000)");
            s1.executeUpdate("INSERT INTO bank VALUES (62,'shyam',50000)");
            s1.executeUpdate("INSERT INTO bank VALUES (63,'mohan',60000)");
            s1.executeUpdate("INSERT INTO bank VALUES (64,'priyanka',70000)");
            s1.executeUpdate("INSERT INTO bank VALUES (65,'rita',35000)");
            s1.executeUpdate("INSERT INTO bank VALUES (66,'diya',45000)");

            s1.execute("COMMIT");

            rs = s1.executeQuery("SELECT * FROM bank");
            while (rs.next()) {
                System.out.println("Inside ResultSet");
                System.out.println(rs.getString(2) + " " + rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

