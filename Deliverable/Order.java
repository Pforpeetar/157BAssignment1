package edu.cs157b.hibernate;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_TABLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Order {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int orderId;
	float price;
	Timestamp deliveryTime;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private Customer user;
	
	@Enumerated(EnumType.STRING)
	private PizzaSize size;
	@Enumerated(EnumType.STRING)
	private PaymentMethod payment;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "join_table",
	joinColumns = {@JoinColumn(name="order_id")},
	inverseJoinColumns = {@JoinColumn(name = "topping_id")})
	private List<Topping> toppings;
	
	public Order() {
		this.toppings = new ArrayList<Topping>();
	}
	
	public int getId() { 
		return orderId; 
	}
	public void setId(int orderId) {
		this.orderId = orderId;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Timestamp getTime() {
		return deliveryTime;
	}
	public void setDeliveryTime() {
		Calendar c = new GregorianCalendar();
		c.add(Calendar.MINUTE, 60);
		deliveryTime = new Timestamp(c.getTime().getTime());
	}
	
	public PizzaSize getSize() {
		return size;
	}
	public void setSize(PizzaSize size) {
		this.size = size;
		price += size.getPrice();
	}
	
	public PaymentMethod getPayment() {
		return payment;
	}
	public void setPayment(PaymentMethod payment) {
		this.payment = payment;
	}
	
	public List<Topping> getToppings() {
		return this.toppings;
	}
	
	public void addTopping(Topping topping) {
		toppings.add(topping);
		price += topping.getPrice();
	}
	
	public Customer getCustomer() {
		return user;
	}
	
	public void setCustomer(Customer user) {
		this.user = user;
	}
	
}
