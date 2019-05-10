package com.tdd.tddMockito.bs;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.ejb.Stateless;

@Stateless(name="DBConnection")
public class DBConnection {
	private static final String CADENA_CONEXION = "jdbc:mysql://localhost:3306/test_tdd";
	private static final String USER_DB = "root";
	private static final String PASSWORD_DB = "RjUvuH&9w(>A";

	public Connection getDbConnection() throws Exception {
		Connection newConnection = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		newConnection = null;
		newConnection = DriverManager.getConnection(CADENA_CONEXION, USER_DB, PASSWORD_DB);
		
		return newConnection;
	}

	public void closeConnection(Connection connectionReference) {
		try {
			connectionReference.close();
		} catch (Exception ex) {
		}
	}
}
