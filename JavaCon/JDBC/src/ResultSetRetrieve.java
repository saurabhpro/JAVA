import java.sql.*;

/**
 * Created by Saurabh on 11/15/2015. my first jdbc program steps: 1. install oracle [any version] if you have express
 * edition database name is "xe" and on full version its "orcl" 2. if you want to run your jdbc program from ide, add
 * the library containing ojdbcX.jar into the project settings and for cmd set environment variable
 * classpath=C:\app\saurabhk\product\12.1.0\dbhome_1\jdbc\lib\ojdbc7.jar;.
 * <p>
 * 3. since oracle already gives you a database to work with you dont need to make the connection to that database and
 * you can directly perform CURD operations like creating a table etc.
 */
public class ResultSetRetrieve {
    public static void main(String[] args) {
        Statement s1 = null;
        ResultSet rs = null;

        try {
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
            System.out.println("connection succesful");

            s1 = con.createStatement();
       /*     s1.execute("CREATE TABLE bank (" +
                    "accno NUMBER(10,0) NOT NULL PRIMARY KEY , " +
                    "holder_name VARCHAR2(20) NOT NULL," +
                    "income INTEGER NOT NULL )");*/
            //  s1.executeUpdate("INSERT INTO person VALUES (65,'ram','mohan','m',to_date('24/11/1987','dd/mm/yyyy'),45555)");
            // s1.executeUpdate("INSERT INTO bank VALUES (65,'ram',50000)");

            s1.executeUpdate("UPDATE person SET first_name='gurmeet', last_name='singh' WHERE person_id=6");
            s1.execute("DELETE FROM person WHERE person_id=65");
            s1.execute("COMMIT");

            rs = s1.executeQuery("SELECT * FROM person");
            while (rs.next()) {
                System.out.println("Inside ResultSet");
                System.out.println(rs.getString(2) + " " + rs.getString(3));
            }

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
