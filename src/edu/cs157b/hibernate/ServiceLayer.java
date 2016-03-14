package edu.cs157b.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ServiceLayer {
	private static SessionFactory sessionFactory; 
	private PizzaShopDAO dao;
	
	public void signUp() {
		System.out.println("Sign Up");
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
	}
	
	public void logIn() {
		System.out.println("Log In");
	}
	
	public void makeOrder() {
		System.out.println("Make Order");
	}
	
	public void viewOrder() {
		System.out.println("View Order");
	}
	
	public void changeOrder() {
		System.out.println("Change Order");
	}
	
	public void cancelOrder() {
		System.out.println("Cancel Order");
	}
	
	public void closeSession() {
		sessionFactory.close();
	}
}
