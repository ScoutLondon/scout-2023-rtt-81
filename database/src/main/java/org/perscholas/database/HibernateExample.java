package org.perscholas.database;

import org.perscholas.database.dao.CustomerDAO;
import org.perscholas.database.dao.OrderDAO;
import org.perscholas.database.entity.Customer;
import org.perscholas.database.entity.Order;

public class HibernateExample {
	
	public static void main(String[] args) {
		CustomerDAO customerDao = new CustomerDAO();
		
		Customer customer = customerDao.findById(103);
		
		System.out.println(customer.getId() + " | " + customer.getCustomerName());
	
		//-------------------------------------------------------------------
	
		
		//--------------------------------------------------------------------
		
		
	
	
	
	}

}
