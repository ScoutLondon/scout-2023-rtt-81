package org.perscholas.database.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Product;

public class ProductDAO {
	
	public Product findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Product p WHERE p.id = :id"; // Example of HQL to get all records of user class
		
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("id", id);
		
		Product result = query.getSingleResult();
		return result;
		
	
	}
	
	//adding a findByName method so I can run CreateOrderDetails
	//THERE IS AN ISSUE IN FINDBYNAME
	//CANNOT RESOLVE PROPERTY: PRODUCT_NAME
	public List<Product> findByName(String name) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//ISSUE RESOLVED: p.productName as named in entity vs p.product_name
		String hql = "FROM Product p WHERE p.productName = :name"; // Example of HQL to get all records of product class
		
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("name", name);
		
		//setParameter Guide:
		
		//"name": This is the parameter name you're specifying in the query. 
		//When you use query.setParameter("name", name), you're telling Hibernate 
		//that you want to bind the value of the Java variable name to the named 
		//parameter "name" in the HQL query.

		//name: This is the Java variable that holds the actual value you want to 
		//use in the query. You're passing this value as an argument to the 
		//findByName method.
		
		
		List<Product> result = query.getResultList();
		return result;
		
	
	}

}
