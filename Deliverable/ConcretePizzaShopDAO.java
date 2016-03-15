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
	public Order create(Order order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// TO DO
		session.save(order);
		session.getTransaction().commit();
		session.close();
		
		return order;
	}

	@Override
	public Topping create(Topping topping) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(topping);
		session.getTransaction().commit();
		session.close();
		return topping;
	}

	@Override
	public Order findByPrimaryKey(Integer PrimaryKey) { 
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
		Object pojo  = session.get(Order.class, PrimaryKey);
		session.getTransaction().commit();
		session.close();
		return (Order)pojo;
	}

	@Override
	public List<Order> findAll(Customer user) {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
		String queryString = "from Order where userid = :user";
		Query queryResult = session.createQuery(queryString);
		queryResult.setParameter("user", user);
		List<Order> result = queryResult.list();
		session.getTransaction().commit();
		session.close();

		return result;
	}

	@Override
	public boolean update(Order order) {
		if (order != null) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(order);
		session.getTransaction().commit();
		session.close();
		return true;
		}
		return false;
	}

	@Override
	public boolean delete(Order order) {
		if (order != null) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.delete(order);
	    session.getTransaction().commit();
	    session.close();
		return true;
		}
		return false;
	}

	@Override
	public Customer findByCredentials(String name, String password) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//RIP!
		String queryString = "from Customer where name = :name and password = :password";
		Query query = session.createQuery(queryString);
		query.setString("name", name);
		query.setString("password", password);

		Customer user = (Customer) query.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return user;
	}

}
