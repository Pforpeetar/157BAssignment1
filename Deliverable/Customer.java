package edu.cs157b.hibernate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER_TABLE")
@NamedQuery(name = "Customer.findByName", query = "from Customer where name = :name")
public class Customer {
	@Id
	@GeneratedValue
	private int userId;
	
	@Column(name = "name", unique=true)
	private String name;
	private String password;
	
	private Address address;
	
	@OneToMany(mappedBy = "user", targetEntity = Order.class,
			fetch=FetchType.EAGER, cascade= CascadeType.ALL)
			private List<Order> orders;
	
	Customer() {
		name = "";
		password = "";
		address = null;
		orders = null;
	}
	
	public Customer(String name, String password, Address address) {
		this.name = name;
		this.password = password;
		this.address = address;
	}
	

	public int getID() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="pass_word")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void addOrder(Order order) {
		orders.add(order);
	}
	public void cancelOrder(int orderId) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getId() == orderId) {
				orders.remove(i);
			}
		}
	}
}
