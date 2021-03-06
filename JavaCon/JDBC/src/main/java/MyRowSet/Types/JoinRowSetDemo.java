/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package MyRowSet.Types;


//import com.sun.rowset.CachedRowSetImpl;
//import com.sun.rowset.JoinRowSetImpl;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJoinRowSet;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import java.sql.SQLException;

/**
 * Created by Saurabh on 11/28/2015.
 * <p>
 * A JoinRowSet object serves as the holder of a SQL JOIN.
 * <p>Is used to hold data coming from two or more tables. It can be achieved by using the join in SQL.
 * JoinRowSet has equivalent of SQL JOIN without having to connect to a
 * data source. In parts to get the joined data one column in both tables should be common.
 * This common column is known as the Match column.
 * There are two ways to set the match column for a RowSet object.
 * <p>
 * The first way is to pass the match column to the JoinRowSet method addRowSet, as shown:
 * <p>
 * jrs.addRowSet(coffees, 2);
 * This line of code adds the coffees CachedRowSet to the jrs object and sets the second column of coffees (SUP_ID) as
 * the match column.
 * <p>
 * The line of code could also have used the column name rather that the column number.
 * jrs.addRowSet(coffees,"SUP_ID");
 * <p>
 * The match column is set by calling addRowSet() method for each RowSet object with the column index and the RowSet
 * objects witch you want to join.
 */
public class JoinRowSetDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		CachedRowSet emp = new OracleCachedRowSet();
		emp.setUsername("system");
		emp.setPassword("98989");
		emp.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		emp.setCommand("select * from person");
		emp.execute();


		CachedRowSet dept = new OracleCachedRowSet();
		dept.setUsername("system");
		dept.setPassword("98989");
		dept.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		dept.setCommand("select * from bank");
		dept.execute();

		JoinRowSet joinRowSet = new OracleJoinRowSet();

        /*
        Each RowSet object added to a JoinRowSet object must have a match column,
        the column on which the JOIN is based.


         */
		joinRowSet.addRowSet(dept, "accno"); //BANK RECORD MUST COME FIRST THEN PERSON
		joinRowSet.addRowSet(emp, "accno");  //IF WE WRITE THIS LINE BEFORE ERROR!!!

		while (joinRowSet.next()) {
			System.out.println("Name " + joinRowSet.getString("p_fname") + " " + joinRowSet.getString("p_lname"));
			System.out.println("\tIncome " + joinRowSet.getString("income"));
		}
	}
}

/*
  select p_fname, p_dob, person.accno, income from person,bank where person.accno=bank.accno;
 */
