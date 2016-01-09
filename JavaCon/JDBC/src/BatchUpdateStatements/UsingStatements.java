package BatchUpdateStatements;

import java.sql.*;

/**
 * Created by Saurabh on 1/10/2016.
 */
public class UsingStatements {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

            Statement s = conn.createStatement();
            //  String s0 = "DROP table emp2";
            String s1 = "CREATE TABLE empbatch (id NUMBER,name VARCHAR2(25), salary NUMBER )";
            String s2 = "INSERT INTO empbatch VALUES (44,'ram',40000)";
            String s3 = "UPDATE empbatch SET id=45 WHERE id=44";

            //s.addBatch(s0);
            s.addBatch(s1);
            s.addBatch(s2);
            s.addBatch(s3);

            s.executeBatch();

            ResultSet resultSet = s.executeQuery("SELECT * FROM empbatch");
            while (resultSet.next()) {
                System.out.println("id = " + resultSet.getString(1) +
                        "\tname = " + resultSet.getString(2) +
                        "\tsalary = " + resultSet.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
