package br.edu.imed;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.edu.imed.model.Customer;

public class CustomerJDBCTest {

	@Test
	public void shouldRetrieveOneCustomer() throws ClassNotFoundException, SQLException{
		JdbcExample jdbcManager = new JdbcExample();
		List<Customer> customers = jdbcManager.findAllCustomer();
		assertEquals(1, customers.size());
	}
}
