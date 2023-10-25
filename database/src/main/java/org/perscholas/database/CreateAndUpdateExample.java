package org.perscholas.database;

import java.util.List;

import org.perscholas.database.dao.CustomerDAO;
import org.perscholas.database.entity.Customer;

public class CreateAndUpdateExample {
	
	private CustomerDAO customerDAO = new CustomerDAO();

	public void insertCustomerExample() {
		Customer c = new Customer();
		
		//DO NOT SET ID, THAT WILL BE SET AUTOMATICALLY
		c.setCustomerName("Series Reminder LLC");
		c.setContactFirstname("Eric");
		c.setContactLastname("Heilig");
		c.setAddressLine1("Address Line 1");
		c.setAddressLine2("Address Line 2");
		c.setCity("Denver");
		c.setState("Colorado");
		c.setPostalCode("80203");
		c.setCountry("USA");
		c.setCreditLimit(10000.00);
		c.setPhone("555-555-1212");
		
		System.out.println("Customer id before save "+ c.getId());
		customerDAO.save(c);
		//AFTER YOU SAVE, IT CREATES ID
		System.out.println("Customer id after save "+ c.getId());
		
	}
	
	public void updateCustomerExample() {
		Customer c = customerDAO.findById(525);
		//make sure that a record with this id exists
		//that's why the if/else
		if (c!= null) {
		System.out.println("Customer Name: "+ c.getCustomerName());
		
		c.setContactFirstname("Bat");
		c.setContactLastname("Man");
		c.setCreditLimit(44444.44);
		
		customerDAO.save(c);
		} else {
			System.out.println("Customer does not exist");
		}
	}
	
	public void listQuery() {
		List<Customer> customers = customerDAO.findByFirstName("Eric");
		System.out.println("We found " + customers.size() + " records in the database");
	}
	
	public static void main(String[] args) {
		
		CreateAndUpdateExample caue = new CreateAndUpdateExample();
		//TO ADD
		//caue.insertCustomerExample();
		//TO UPDATE
		//caue.updateCustomerExample();
		caue.listQuery();
		
		
		

	}

}
