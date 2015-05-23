package br.edu.imed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

	public static void main(String[] argv) throws SQLException {

		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");

		try {
			String driverName = "";
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
			return;
		}

		System.out.println("PostgreSQL JDBC Driver Registered!");
		Connection connection = null;

		try {

			//String connectionString = "jdbc:postgresql://127.0.0.1:5432/dbname";
			String connectionString = "";
			String user = "user";
			String password = "password";
			connection = DriverManager.getConnection(connectionString, user, password);
			connection.close();			

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	}
}
