package MyRowSet.Types;

import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Saurabh on 11/28/2015. JdbcRowSet Interface is an extension of RowSet interface and is the only connected
 * Rohtak in the RowSet in the family. It basically acts as a wrapper around the ResultSet object with some additional
 * functionalities.
 * <p>
 * The primary advantage of using JDBC RowSet is that it enables ResultSet object to be used as Java Bean component
 * <p>
 * another advantage is that it as adds Scrollable and Updatable capabilities to the ResultSet object. This means we can
 * now move back and forth the list of records fetched from the database through ResultSet object.
 * You can create a JdbcRowSet object in various ways:
 * <p>
 * By using the reference implementation constructor that takes a ResultSet object
 * By using the reference implementation constructor that takes a Connection object
 * By using the reference implementation default constructor
 * By using an instance of RowSetFactory, which is created from the class RowSetProvider
 */

class ExampleListener implements RowSetListener {

    @Override
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("ExampleListener notified of rowSetChanged");
    }

    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println("Example Listener notified to rowChanged event");
        //row changed in actual database. so output for this wont be visible as program closes when actual db updated
    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("ExampleListener notified to cursor movement");
    }
}


public class JdbcRowSetDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = getOracleConnection();
        // Statement st = conn.createStatement();

        JdbcRowSet jdbcRowSet;
        jdbcRowSet = new JdbcRowSetImpl(conn);
        /*
        jdbcRowSet = new JdbcRowSetImpl();
        jdbcRowSet.setUsername("system");
        jdbcRowSet.setPassword("98989");
        jdbcRowSet.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        jdbcRowSet.setCommand("select * from bank");
        jdbcRowSet.execute();
        */
        jdbcRowSet.setType(ResultSet.TYPE_SCROLL_SENSITIVE);
        jdbcRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);

        //  jdbcRowSet.setCommand("insert into emp values (25,'sam','smith',to_date('24/11/1987','dd/mm/yyyy'),6400)");
        // jdbcRowSet.execute();

        jdbcRowSet.setCommand("update emp set emp_fname='kevin' where emp_fname='sam'");
        jdbcRowSet.execute();

        String sql = "Select * from emp";
        jdbcRowSet.setCommand(sql);
        jdbcRowSet.execute();

        //this line needs to be after execute of jdbc rowset else error
        jdbcRowSet.addRowSetListener(new ExampleListener());

        while (jdbcRowSet.next()) {
            //each call to next, gerenrates a Cursor Movement event
            System.out.print("name: " + jdbcRowSet.getString("emp_fname"));
            System.out.println("\tSalary: " + jdbcRowSet.getInt("emp_salary"));
        }
        conn.close();
    }

    public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String password = "98989";
        String username = "system";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}
