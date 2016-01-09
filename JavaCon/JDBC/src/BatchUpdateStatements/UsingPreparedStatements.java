package BatchUpdateStatements;

import java.sql.*;

/**
 * Created by Saurabh on 1/10/2016.
 */
public class UsingPreparedStatements {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

            Statement s = conn.createStatement();

            preparedStatement = conn.prepareStatement("UPDATE empbatch SET salary=? WHERE id=?");

            preparedStatement.setInt(1, 60000);
            preparedStatement.setInt(2, 45);

            preparedStatement.addBatch();

            int[] count = preparedStatement.executeBatch();

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
