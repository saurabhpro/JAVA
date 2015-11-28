import java.sql.*;

/**
 * Created by Saurabh on 11/28/2015. By default, when Oracle JDBC executes a query, it receives the result set 10 rows
 * at a time from the database cursor. This is the default row pre-fetch value.
 * <p>
 * JDBC 2.0 also allows you to specify the number of row fetched with each database round-trip for a query, and this
 * number is referred to as the FETCH SIZE.
 * <p>
 * In Oracle JDBC, the row pre-fetch value is used as the default size in a statement object. Setting the fetch size
 * overrides the row pre-fetch setting and affects the subsequent queries executed through the statement object.
 * <p>
 * Fetch size is also used in result set. When the statement object executes a query, the fetch size of the statement
 * object is passed as to the result object produced by the query. However, you can also set the fetch size in the
 * result set object to override the statement fetch size that was passed to it. (Also note that changes made to a
 * statement objects fetch size after a result set is produced will have no effect on that result set).
 * <p>
 * The result set fetch size, either set explicitly or by default equal to the statement fetch size that was passed to
 * it, determines the number of rows that are retrieved in any subsequent trips to the database for that result set.
 * <p>
 * This includes any trips that are still required to complete the original query, as well as any re-fetching of data
 * into the result set. (Data can be re-fetched, either explicitly or implicitly to update a SCROLL-SENSITIVE or
 * SCROLL-INSENSITIVE-UPDATABLE result set.
 */

public class FetchSize {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

            //get fetch size of the statement
            Statement statement = conn.createStatement();
            int fetchSize = statement.getFetchSize();
            System.out.println("Fetch size of statement(default) = " + fetchSize);

            //fetch size of the statement after resizing
            statement.setFetchSize(100);
            fetchSize = statement.getFetchSize();
            System.out.println("Fetch size after resizing = " + fetchSize);

            //create a result set
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bank");
            fetchSize = resultSet.getFetchSize();
            System.out.println("Fetch Size via ResultSet = " + fetchSize);

            //change the fetch size of the result set
            resultSet.setFetchSize(200);
            fetchSize = resultSet.getFetchSize();
            System.out.println("Fetch size via result set resizing = " + fetchSize);

            statement.setFetchSize(500);
            fetchSize = resultSet.getFetchSize();
            System.out.println("Fetch size via result set after changing from the statement = " + fetchSize);

        } catch (ClassNotFoundException e) {
            System.out.println("Exception in Class.forName");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Exception in conn.getConnection");
            e.printStackTrace();

        }
    }

}
