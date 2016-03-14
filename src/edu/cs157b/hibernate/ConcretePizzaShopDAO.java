package edu.cs157b.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ConcretePizzaShopDAO implements PizzaShopDAO {
	private static SessionFactory sessionFactory; 
	@Override
	public Customer create(Customer user) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction= null;
		try
		{
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
		
			transaction.commit();
		}
		catch (HibernateException he)
		{
			transaction.rollback();
			System.out.println("Transaction is rolled back.");
		}
		finally
		{
			sessionFactory.close();
		}
		
		return null;
	}

	@Override
	public Order create(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Topping create(Topping topping) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Customer user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customer user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findByPrimaryKey(Integer PrimaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByExample(Customer user, boolean fuzzy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction= null;
		
		try
		{
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			   
			List<Order> allStudents;
			Query queryResult = session.createQuery("FROM Order");
			allStudents = queryResult.list(); // contains Order instances
			for (Order o: allStudents)
			System.out.println(o);
		
			transaction.commit();
		}
		catch (HibernateException he)
		{
			transaction.rollback();
			System.out.println("Transaction is rolled back.");
		}
		finally
		{
			sessionFactory.close();
		}
		
		return null;
	}

	@Override
	public boolean update(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List findByExample(Order order, boolean fuzzy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeSession() {
		// TODO Auto-generated method stub
		sessionFactory.close();
	}

}
