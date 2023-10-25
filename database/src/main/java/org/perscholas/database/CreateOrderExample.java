package org.perscholas.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.perscholas.database.dao.CustomerDAO;
import org.perscholas.database.dao.OrderDAO;
import org.perscholas.database.entity.Customer;
import org.perscholas.database.entity.Order;

public class CreateOrderExample {
	private OrderDAO orderdao = new OrderDAO();
	private CustomerDAO customerdao = new CustomerDAO();

	//create a main method that will use the scanner to ask the user for a customer id,
	//then query the customer .. 
	//and create (INSERT) a new order using the customer id ... 
	//only if the customer id exists in the database
	public static void main(String[] args) throws ParseException {
		//create a main method that will use the scanner to 
		//ask the user for a customer id,
		CreateOrderExample coe = new CreateOrderExample();
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the customer ID?");
		int custId = scan.nextInt();
		//then query the customer and insert new order
		//BUT only if customer id exists in database
		coe.addOrderExample(custId);

	}
	
	public void insertOrderExample(Customer c) throws ParseException {
		Date date=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date reqDate = df.parse("2023-10-31");
		
		Order o = new Order();
		//DO NOT SET ID, THAT WILL BE SET AUTOMATICALLY
		o.setCustomer(c);
		o.setOrderDate(date);
		o.setShippedDate(null);
		o.setStatus("In Process");
		o.setRequiredDate(reqDate);

		orderdao.save(o);
		//AFTER YOU SAVE, IT CREATES ID
		System.out.println("Order id "+ o.getId() +" has been saved");
	}
	
	public void addOrderExample(int id) throws ParseException {
		Customer c = customerdao.findById(id);
		//make sure that a record with this id exists
		//that's why the if/else
		if (c!= null) {
			insertOrderExample(c);
			System.out.println("Order "+ id +" created!");
		
		} else {
			System.out.println("Customer does not exist");
		}
	}
	

}
