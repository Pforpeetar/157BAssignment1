package edu.cs157b.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ServiceLayer {
	public static void signUp(String name, String password, String street, String city, String state, String zipcode) {
		Address address = new Address(street, city, state, zipcode);
		Customer user = new Customer(name, password, address);
		ConcretePizzaShopDAO dao = new ConcretePizzaShopDAO();
		dao.create(user);
	}
		
	public static boolean logIn(String name, String password) {
		ConcretePizzaShopDAO dao = new ConcretePizzaShopDAO();
		if (dao.findByCredentials(name, password) != null) {
			return true;
		}
		return false;
	}
	
	public static void makeOrder(String name, String password, PizzaSize size, String top1, String top2, String top3, PaymentMethod payment, boolean discount) {
		System.out.println("Make Order");
		ConcretePizzaShopDAO dao = new ConcretePizzaShopDAO();
		if (discount) {
			DiscountedOrder order = new DiscountedOrder();
			
			order.setDeliveryTime();
			order.setCustomer(dao.findByCredentials(name, password));
			
			order.setSize(size);
			Topping t1 = new Topping();
			t1.setTopping(top1);
			order.addTopping(t1);
			
			Topping t2 = new Topping();
			t2.setTopping(top2);
			order.addTopping(t2);
			
			Topping t3 = new Topping();
			t3.setTopping(top3);
			order.addTopping(t3);
			
			order.setPayment(payment);
			order.setDiscount();
			System.out.println("Discounted Price: " + order.price);
			
			dao.create(order);
		} else {
			Order order = new Order();
			
			order.setDeliveryTime();
			order.setCustomer(dao.findByCredentials(name, password));
			order.setSize(size);
			
			Topping t1 = new Topping();
			t1.setTopping(top1);
			order.addTopping(t1);
			
			Topping t2 = new Topping();
			t2.setTopping(top2);
			order.addTopping(t2);
			
			Topping t3 = new Topping();
			t3.setTopping(top3);
			order.addTopping(t3);
			
			order.setPayment(payment);
			System.out.println("Reg Price: " + order.price);

			dao.create(order);
		}
	}
	
	public static void viewOrders(String name, String password) {
		ConcretePizzaShopDAO dao = new ConcretePizzaShopDAO();
		List<Order> orders = dao.findAll(dao.findByCredentials(name, password));
		for (Order o : orders) {
			System.out.println();
			System.out.println("Order ID: " + o.getId() + ", Size: " + o.getSize() + ", Delivery Time: " + o.getTime() + ", Payment: " + o.getPayment() + ", Price: " + o.getPrice());
			System.out.println("Toppings: ");
			for (Topping t : o.getToppings()) {
				System.out.print(t.getTopping() + ", ");
			}
		}
	}
	
	public static void changeOrder(PizzaSize size, String top1, String top2, String top3, PaymentMethod payment, int orderId) {
		ConcretePizzaShopDAO dao = new ConcretePizzaShopDAO();
		Order newOrder = (dao.findByPrimaryKey(orderId));
		newOrder.setDeliveryTime();
		newOrder.setPrice(0);
		newOrder.setSize(size);
		
		Topping t1 = new Topping();
		t1.setTopping(top1);
		newOrder.addTopping(t1);
		
		Topping t2 = new Topping();
		t2.setTopping(top2);
		newOrder.addTopping(t2);
		
		Topping t3 = new Topping();
		t3.setTopping(top3);
		newOrder.addTopping(t3);

		newOrder.setPayment(payment);
		dao.update(newOrder);
	}
	
	public static void cancelOrder(String name, String password, int orderId) {
		ConcretePizzaShopDAO dao = new ConcretePizzaShopDAO();
		List<Order> orders = dao.findAll(dao.findByCredentials(name, password));
		for (Order o : orders) {
			dao.delete(dao.findByPrimaryKey(orderId));
		}
	}
}
