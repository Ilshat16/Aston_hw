package ru.aston.pizzeria.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static final String URL = "jdbc:postgresql://localhost:5432/pizzeria";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "password";
	
	private static Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			if (connection == null)
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
