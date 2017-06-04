package a_creational.a_singleton.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {

	private static DbSingleton instance;

	private Connection conn = null;

	private DbSingleton() {
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static DbSingleton getInstance() {
		//this check if not thread safe, simply return instqnce if its not null for every thread
		if (instance == null) {
			synchronized (DbSingleton.class) {
				//if outer null is not there it slows system as every null/not null will wait
				if (instance == null) {
					instance = new DbSingleton();
				}
			}
		}

		return instance;
	}

	Connection getConnection() {
		if (conn == null) {
			synchronized (DbSingleton.class) {
				if (conn == null) {
					try {
						String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";

						conn = DriverManager.getConnection(dbUrl);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return conn;
	}

}
