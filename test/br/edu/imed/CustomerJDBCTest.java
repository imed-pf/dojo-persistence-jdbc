package br.edu.imed;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.imed.exception.DeleteJDBCException;
import br.edu.imed.model.Customer;

public class CustomerJDBCTest {

	private JdbcExample jdbcManager;

	@Before
	public void setup() throws ClassNotFoundException, SQLException {
		this.jdbcManager = new JdbcExample();
	}
	
	@Test
	public void shouldRetrieveOneCustomer() throws ClassNotFoundException, SQLException{
		List<Customer> customers = jdbcManager.findAllCustomer();
		assertEquals(1, customers.size());
	}
	
	@Test
	public void shouldRetrieveCustomerWithID5() throws SQLException, ClassNotFoundException {
		List<Customer> customers = jdbcManager.findAllCustomer();
		Customer customer = customers.get(0);
		assertEquals(Long.valueOf(5), customer.getId());
	}
	
	@Test
	public void shouldRetrieveCustomerById() throws ClassNotFoundException, SQLException {
		Customer customer = jdbcManager.findById(5L);
		assertEquals(Long.valueOf(5), customer.getId());
	}
	
	@Test
	public void shouldDeleteCustomerWithId10() throws SQLException{
		Customer customer = new Customer();
		customer.setId(10L);
		assertTrue(jdbcManager.delete(customer.getId()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
