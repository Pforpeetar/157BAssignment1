package edu.cs157b.hibernate;

import java.util.List;

public interface PizzaShopDAO {
	   Customer create(Customer user);
	   Order create(Order order);
	   Topping create(Topping topping);
	   boolean update(Order order);
	   boolean delete(Order order);
	   Customer findByCredentials(String name, String password);
	   Order findByPrimaryKey(Integer PrimaryKey);
	   List findAll(Customer user);
}
