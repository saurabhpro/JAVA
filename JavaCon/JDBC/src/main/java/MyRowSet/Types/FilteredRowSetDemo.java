package MyRowSet.Types;

import com.sun.rowset.FilteredRowSetImpl;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import java.sql.SQLException;

/**
 * Created by Saurabh on 11/29/2015. A filtered RowSet object contains only the filtered rows of the database. The
 * filter criteria is set in the RowSet object and the RowSet only get the filtered data from database to the object.
 * The filters can be created by implementing Predicate interface
 */

public class FilteredRowSetDemo implements Predicate {

	private String colName;

	public FilteredRowSetDemo(String colName) {
		this.colName = colName;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		FilteredRowSet filteredRowSet = new FilteredRowSetImpl();
		filteredRowSet.setUsername("system");
		filteredRowSet.setPassword("98989");
		filteredRowSet.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		filteredRowSet.setCommand("select * from emp");

		//Filter
		// filteredRowSet.setFilter(new FilteredRowSetDemo("emp_fname"));
		filteredRowSet.setFilter(new FilteredRowSetDemo("emp_salary"));
		filteredRowSet.execute();

		while (filteredRowSet.next()) {
			System.out.println("Employee Name " + filteredRowSet.getString(2));
			System.out.println("Employee Salary " + filteredRowSet.getString(5) + "\n");
		}
	}

	/**
	 * This is the the only one we need to consider as here we can pass any coloumn type as arg when the filter comes
	 * here it checks one of all three based on setFilter argument and evaluates to true is any one of them are true
	 *
	 * @param rs
	 * @return
	 */
	@Override
	public boolean evaluate(RowSet rs) {
		try {
			System.out.println("Inside evaluate");
			CachedRowSet cachedRowSet = (CachedRowSet) rs; //downcasting

			// String ob = cachedRowSet.getString(colName);    //throws SQLException
			// return ob != null && (ob.charAt(0) == 's' || ob.charAt(0) == 'r');

			int ob = cachedRowSet.getInt(colName);    //throws SQLException
			return ob > 6100;

		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		System.out.println("Inside evaluate2");
		return false;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		System.out.println("Inside evaluate3");
		return false;
	}
}
