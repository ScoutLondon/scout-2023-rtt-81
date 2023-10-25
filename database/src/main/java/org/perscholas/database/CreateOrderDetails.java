package org.perscholas.database;

import java.util.List;
import java.util.Scanner;

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
		//ask user to enter product name
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a product name to add to your order");
		String productName = scan.nextLine();
		
		//looks up product by productName
		List<Product> products = productDAO.findByName(productName);
		
		if (products.size() == 0) {
			System.out.println("You did not enter a valid product name");
			System.exit(0);
		}
		
		//Query can return more than one product with same name
		//so we list products that were returned
		for (Product product : products) {
			System.out.println(product.getId() + " | " + product.getProductName());
		}
		
		//of list of product names shown, allow user to select id they want to add
		System.out.println("Select a product Id:");
		Integer productId = scan.nextInt();
		
		
		
		//goal is to insert record into order details table
		
		Product p = productDAO.findById(productId);
		//ask use what order number they want to add product to
		Order o = orderDAO.findById(10100);
		
		//if product is already part of order don't add it again
		for (OrderDetail orderDetail : o.getOrderdetails()) {
			if (orderDetail.getProduct().getId() == productId) {
				//the product is already part of the order
				System.out.println("The product "+ p.getProductName() + " is already part of the order, cannot add again.");
				System.exit(1);
			}
		}
		
		
		
		OrderDetail od = new OrderDetail();
		od.setProduct(p);
		od.setOrder(o);
		od.setOrderLineNumber(200);
		od.setPriceEach(5.55);
		od.setQuantityOrdered(300);
		
		orderDetailDAO.save(od);
		
		System.out.println("Successfully added product to order");
		
	}
	
	
	public static void main(String[] args) {
		CreateOrderDetails cod = new CreateOrderDetails();
		cod.createOrderDetails();
	}

}
