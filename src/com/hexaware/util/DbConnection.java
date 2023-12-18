package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	static Connection connection;

	public static Connection getDbConnection() {
		String fileName = "db.properties";
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(fileName);
			properties.load(fileInputStream);

			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
