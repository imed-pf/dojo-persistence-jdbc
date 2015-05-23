package br.edu.imed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.imed.model.Customer;

public class JdbcExample {
	private Connection connection;

	public JdbcExample() throws ClassNotFoundException, SQLException {

		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");

		try {
			String driverName = "org.postgresql.Driver";
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			throw e;
		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		try {
			String connectionString = "jdbc:postgresql://127.0.0.1:5432/dojo_persistence_jdbc";
			String user = "postgres";
			String password = "postgres";
			connection = DriverManager.getConnection(connectionString, user, password);
			checkConnection();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			throw e;
		}
	}

	private void checkConnection() throws SQLException {
		if(connection == null || connection.isClosed()){
			System.out.println("Connection failed!!");
		}
	}

	public List<Customer> findAllCustomer() {
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer());
		return customers;
	}
}
