package edu.cs157b.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ServiceLayer {
	private PizzaShopDAO dao;
	
	public void signUp(Customer user) {
		System.out.println("Sign Up");
		dao.create(user);
	}
		
	public void logIn() {
		System.out.println("Log In");
	}
	
	public void makeOrder() {
		System.out.println("Make Order");
	}
	
	public void viewOrders() {
		System.out.println("View Order");
		

	}
	
	public void changeOrder() {
		System.out.println("Change Order");
	}
	
	public void cancelOrder() {
		System.out.println("Cancel Order");
	}
	
	public void closeSession() {
		dao.closeSession();
	}
}
