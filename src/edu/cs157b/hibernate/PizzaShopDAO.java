package edu.cs157b.hibernate;

import java.util.List;

public interface PizzaShopDAO {
	   Customer create(Customer user);
	   Order create(Order order);
	   Topping create(Topping topping);
	   boolean update(Order order);
	   boolean update(Customer user);
	   boolean delete (Customer user);
	   Customer findByPrimaryKey(Integer PrimaryKey);
	   List findByExample(Customer user, boolean fuzzy);
	   List findByExample(Order order, boolean fuzzy);
	   List findAll();
	   void closeSession();
}
