package Sequence;

import java.sql.*;

/**
 * Created by Saurabh on 1/10/2016.
 */
public class MySequence {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

			Statement st = conn.createStatement();

			// st.executeUpdate("DROP SEQUENCE seq");
			// st.executeUpdate("DROP TABLE empsequence");

			// st.executeUpdate("CREATE SEQUENCE seq INCREMENT BY 5 START WITH 100 MAXVALUE 2000");
			// st.executeUpdate("CREATE TABLE empsequence(id NUMBER)");
			st.executeUpdate("INSERT INTO empsequence VALUES (seq.nextval)");

			ResultSet resultSet = st.executeQuery("SELECT * FROM empsequence");
			while (resultSet.next()) {
				System.out.println("id = " + resultSet.getString(1));
			}
			st.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
