/**
 * Created by Saurabh on 11/28/2015. RowSet is basically an extension of JDBC ResultSet and is part of javax.sql.package
 * built on the standard contextual structure of the JavaBeans component model, the core design structure is inherently
 * reflected in the subjectivity of the RowSet interface
 * <p>
 * It makes sense that RowSet has set up JavaBeans properties, which can be set and received with the available getter
 * and setter methods.
 * <p>
 * In addition to that, the ResultSet implements the JavaBeans mechanism of event notification that allow the components
 * registered to the interface to receive notification when a certain event is triggered
 * <p>
 * Types of RowSet: there are two types of RowSet objects 1. connected connect RowSet are those which establishes a
 * connection with the database and retain it until the application terminates. 2. disconnected disconnected RowSet on
 * the other hand establishes a connection, executes a query such as retrieving data from database and close the
 * connection
 * <p>
 * NOTE: RowSet and its extended family are all interfaces; that means we need a reference of implementation class of
 * the specific RowSet extension to create an instance
 * <p>
 * RowSet it is built on top of JDBC driver as a layered software, its implementation is open to any including all JDBC
 * vendors They generally package them in jar file and supply them along with JDBC driver
 * <p>
 * there are several third party vendors who provide the implementation package of RowSet along with JDBC driver, Oracle
 * being one of them Oracle JDBC support all five type of RowSet, through the interfaces and classes present in the
 * oracle.jdbc.rowset package.
 * <p>
 * Type of Implementation According to the implemnetation there are 5 different categories of RowSet JdbcRowSet,
 * CachedRowSet, WebRowSet, FilteredRowSet, JoinRowSet
 */

package MyRowSet;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class RowSetDemo {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String password = "98989";
        String username = "system";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //first create a factory of object for RowSet
            RowSetFactory rowSetFactory = RowSetProvider.newFactory();

            //create a JDBC rowSet from the factory
            JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();

            //set connection properties
            rowSet.setUrl(url);
            rowSet.setUsername(username);
            rowSet.setPassword(password);

            //set sql query to execute
            rowSet.setCommand("Select * from bank");
            rowSet.execute();

            //iterate over rowset
            System.out.println("Accno\tName");
            while (rowSet.next())
                System.out.println(rowSet.getString(1) + "\t\t" + rowSet.getString(2));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
