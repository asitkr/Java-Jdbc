package com.manage;

import java.sql.*;

public class ConnectionProvider {
	
	static Connection conn;

	public static Connection createConnection() {
		try {
			
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create the Connection
			String url = "jdbc:mysql://localhost:3306/ashitprac";
			String user = "root";
			String password = "root";
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
