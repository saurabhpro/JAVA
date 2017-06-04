package a_creational.a_singleton.singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {

	public static void main(String arg[]) {

		long timeBefore;
		long timeAfter;

		DbSingleton instance = DbSingleton.getInstance();

		timeBefore = System.currentTimeMillis();
		Connection conn = instance.getConnection();
		timeAfter = System.currentTimeMillis();

		System.out.println(timeAfter - timeBefore);


		Statement sta;
		try {
			sta = conn.createStatement();
			int count = sta
					.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20),"
							+ " City VARCHAR(20))");
			System.out.println("Table created with " + count + " rows.");
			boolean i = sta.execute("INSERT INTO Address VALUES (34, 'ram', 'shir')");
			ResultSet in = sta.executeQuery("SELECT * FROM Address");

			sta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		timeBefore = System.currentTimeMillis();
		conn = instance.getConnection();
		timeAfter = System.currentTimeMillis();

		System.out.println(timeAfter - timeBefore);

	}

}
