package org.perscholas.database.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.perscholas.database.entity.Customer;

public class CustomerDAOTest {
	
	@Test
	@Order(1)
	public void findByIdTest() {
		CustomerDAO customerDao = new CustomerDAO();
		Customer actual = customerDao.findById(112);
		
		//first arg is expected value
		//second arg is actual value
		Assertions.assertEquals(112, actual.getId());
		Assertions.assertEquals("Signal Gift Stores", actual.getCustomerName());
		Assertions.assertEquals("King", actual.getContactLastname());
		
		//example of static import so you don't have to say "Assertions"
		assertEquals("Jean", actual.getContactFirstname());
	}
	
	@Test
	@Order(2)
	public void updateFirstNameTest() {
		CustomerDAO customerDao = new CustomerDAO();
		Customer actual = customerDao.updateFirstName(112, "Jessica");
		
		//first arg is expected value
		//second arg is actual value
		Assertions.assertEquals(112, actual.getId());
		Assertions.assertEquals("Signal Gift Stores", actual.getCustomerName());
		Assertions.assertEquals("Fisher", actual.getContactLastname());
		
		//example of static import so you don't have to say "Assertions"
		assertEquals("Jessica", actual.getContactFirstname());
	}

}
