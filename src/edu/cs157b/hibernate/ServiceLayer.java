package edu.cs157b.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ServiceLayer {
	public static void signUp(String name, String password, String street, String city, String state, String zipcode) {
		System.out.println("Sign Up");
		Address address = new Address(street, city, state, zipcode);
		Customer user = new Customer(name, password, address);
		ConcretePizzaShopDAO dao = new ConcretePizzaShopDAO();
		dao.create(user);
	}
		
	public static void logIn(String name, String password) {
		System.out.println("Log In");
		ConcretePizzaShopDAO dao = new ConcretePizzaShopDAO();
		dao.findByCredentials(name, password);
	}
	
	public static void makeOrder(String name, String password, PizzaSize size, String top1, String top2, String top3) {
		System.out.println("Make Order");
		ConcretePizzaShopDAO dao = new ConcretePizzaShopDAO();
		Customer user = dao.findByCredentials(name, password);
		Order order = new Order();
		order.setDeliveryTime();
		order.setCustomer(user);
		order.setSize(size);
		dao.create(order);
	}
	
	public static void viewOrders() {
		System.out.println("View Order");
		ConcretePizzaShopDAO dao = new ConcretePizzaShopDAO();

	}
	
	public static void changeOrder() {
		System.out.println("Change Order");
		ConcretePizzaShopDAO dao = new ConcretePizzaShopDAO();
	}
	
	public static void cancelOrder() {
		System.out.println("Cancel Order");
		ConcretePizzaShopDAO dao = new ConcretePizzaShopDAO();
	}
}
