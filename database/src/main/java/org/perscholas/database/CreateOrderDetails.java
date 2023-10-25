package org.perscholas.database;

import org.perscholas.database.dao.OrderDAO;
import org.perscholas.database.dao.OrderDetailDAO;
import org.perscholas.database.dao.ProductDAO;
import org.perscholas.database.entity.Order;
import org.perscholas.database.entity.OrderDetail;
import org.perscholas.database.entity.Product;

public class CreateOrderDetails {
	
	private OrderDAO orderDAO = new OrderDAO();
	private ProductDAO productDAO = new ProductDAO();
	private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
	
	
	public void createOrderDetails(){
		//goal is to insert record into order details table
		Product p = productDAO.findById(1);
		Order o = orderDAO.findById(10100);
		
		OrderDetail od = new OrderDetail();
		od.setProduct(p);
		od.setOrder(o);
		od.setOrderLineNumber(200);
		od.setPriceEach(5.55);
		od.setQuantityOrdered(300);
		
		orderDetailDAO.save(od);
		
	}
	
	
	public static void main(String[] args) {
		CreateOrderDetails cod = new CreateOrderDetails();
		cod.createOrderDetails();
	}

}
