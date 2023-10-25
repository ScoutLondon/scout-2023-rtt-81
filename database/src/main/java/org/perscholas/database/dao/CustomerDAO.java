package org.perscholas.database.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Customer;

public class CustomerDAO {
	
	//Desired behavior is return single customer object
	//or return null if not found
	public Customer findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Customer c WHERE c.id = :id"; // Example of HQL to get all records of user class
		
		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("id", id);
		//catches just in case of no result
		try {
		Customer result = query.getSingleResult();
		return result;
		} catch (NoResultException nre) {
			return null;
		}
	
	}
	
	//by contrast, a method that returns list
	//will ALWAYS return list, never returns null
	//if no records returns empty list
	public List<Customer> findByFirstName(String fname) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Customer c WHERE c.contactFirstName = :firstname"; // Example of HQL to get all records of user class
		
		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("firstname", fname);
		
		
		List<Customer> result = query.getResultList();
		return result;
	}
	
	public void save(Customer save) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(save);
		t.commit();
	}

}
