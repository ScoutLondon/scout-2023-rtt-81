package org.perscholas.database.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Order;
import org.perscholas.database.entity.OrderDetail;

public class OrderDetailDAO {
	
	public OrderDetail findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM OrderDetail od WHERE od.id = :id"; // Example of HQL to get all records of user class
		
		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		query.setParameter("id", id);
		
	//MUST TRY/CATCH NoResultException
		try {
			OrderDetail result = query.getSingleResult();
			return result;	
		} catch (NoResultException nre) {
			return null;
		}
	}
	
public OrderDetail findByOrderIdAndProductId(Integer orderId, Integer productId) {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();
	
	String hql = "FROM OrderDetail od WHERE od.order_id = :orderId AND od.product_id = :productId";
	TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
	query.setParameter("orderId", orderId);
	query.setParameter("productId", productId);
	
	//MUST ADD TRY/CATCH NORESULTEXCEPTION AS FOLLOWS
	try {
		OrderDetail result = query.getSingleResult();
		return result;	
	} catch(NoResultException nre) {
		return null;
	}
}
	
	public void save(OrderDetail save) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(save);
		t.commit();
	}

}
