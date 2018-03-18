/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by saurabhkumar on 28/05/17.
 */
public class DBFacade {
	public static final String DRIVER = org.apache.derby.jdbc.EmbeddedDriver.class.getName();

	private static final String PROTOCOL = "jdbc:derby:memory:";
	private static final String LOCAL_PATH = "JDBC/src/main/java/derby/";
	private static final String JDBC_DB_URL = PROTOCOL + LOCAL_PATH + "sktest;create=true";

	private static DBFacade instance;

	private Connection conn = null;

	private DBFacade() {
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static DBFacade getInstance() {
		//this check if not thread safe, simply return instqnce if its not null for every thread
		if (instance == null) {
			synchronized (DBFacade.class) {
				//if outer null is not there it slows system as every null/not null will wait
				if (instance == null) {
					instance = new DBFacade();
				}
			}
		}

		return instance;
	}

	Connection getConnection() {
		if (conn == null) {
			synchronized (DBFacade.class) {
				if (conn == null) {
					try {
						//or Class.forName(DRIVER).newInstance();
						conn = DriverManager.getConnection(JDBC_DB_URL);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return conn;
	}

	public void createTable(Statement statement) throws SQLException {
		statement.execute("CREATE TABLE Address2 (ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
	}

	public void insertRows(Statement statement) throws SQLException {
		statement.execute("INSERT INTO Address2 VALUES (34, 'ram', 'shir')");
		statement.execute("INSERT INTO Address2 VALUES (35, 'ram', 'shir')");
		statement.execute("INSERT INTO Address2 VALUES (36, 'ram', 'shir')");
		statement.execute("INSERT INTO Address2 VALUES (37, 'ram', 'shir')");

	}
}


