package MyStatement;

import java.sql.*;

/**
 * Created by Saurabh on 12/1/2015.
 * If you want to use statement object many times, it usually reduces execution time to
 * use preparedstatement object instead.
 * <p>
 * The main feature of preparedstatement is that unlike the statement object it is given SQL statement when it is
 * created. The advantage of this is that in most cases this SQL statement is sent to the DBMS right away, where it is
 * compiled. As a result prepairedstatement object contains not just a SQL statement, but a SQL statemet that has been
 * pre-compiled. This means that when the preparedstatement is executed, the DBMS can just run the preparedstatement SQL
 * statement without having to compile first.
 * <p>
 * A preparedstatement is a special kind of statement object with some special features. Remember you need a statement
 * in order to execute query or update. You can use the prepared statement instead of statement and benefits from the
 * features of preparedstatement.
 * <p>
 * The prepared statement primary features are:- Easy to insert parameters into SQL statement statement Easy to reuse
 * the prepared statement with new parameters. Enable easier batch update
 */
public class PrepareStatement {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

            int t1 = 123;
            String t2 = "ram";

            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            s.executeUpdate("CREATE TABLE emp66 (id NUMBER, name VARCHAR2(20))");
            s.close();


            PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO emp66 VALUES (?,?)",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            //PreparedStatement ps = conn.prepareStatement("insert into emp66 values(?,?)");
            prepareStatement.setInt(1, t1);
            prepareStatement.setString(2, t2);

            prepareStatement.executeUpdate();
            prepareStatement.close();

            prepareStatement = conn.prepareStatement("SELECT * FROM emp66 WHERE id=?");
            prepareStatement.setInt(1, t1);

            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
