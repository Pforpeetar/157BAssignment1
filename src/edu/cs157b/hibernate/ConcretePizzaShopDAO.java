package edu.cs157b.hibernate;

import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ConcretePizzaShopDAO implements PizzaShopDAO {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@Override
	public Customer create(Customer user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.save(user);
	    session.getTransaction().commit();
	    session.close();
	    return user;
	}

	@Override
	public Order create(Order order, Customer user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// TO DO
		session.getTransaction().commit();
		session.close();
		
		return order;
	}

	@Override
	public Topping create(Topping topping) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findByPrimaryKey(Integer PrimaryKey) { 
		Session session = sessionFactory.openSession();
	    session.beginTransaction();

	    session.beginTransaction();
		Object pojo  = session.get(Order.class, PrimaryKey);
		session.getTransaction().commit();
		return (Order)pojo;
	}

	@Override
	public List findAll(Customer user) {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	   
		String queryString = "from Customer";
		// MATCH WITH ORDERS
		Query queryResult = session.createQuery(queryString);
	
		session.getTransaction().commit();
		return queryResult.list();
	}

	@Override
	public boolean update(Order order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(order);
		session.getTransaction().commit();
		session.close();
		
		return true;
	}

	@Override
	public boolean delete(Order order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//NOT RIGHT!
	    session.delete(order);
	    session.getTransaction().commit();
	    session.close();
		return true;
	}

	@Override
	public Customer findByCredentials(String name, String password) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//RIP!
		
		session.getTransaction().commit();
		session.close();
		return null;
	}

}
