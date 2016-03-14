package edu.cs157b.hibernate;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Order {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	int orderId;
	float price;
	Timestamp deliveryTime;
	
	@Enumerated(EnumType.ORDINAL)
	private PizzaSize size;
	@Enumerated(EnumType.ORDINAL)
	private PaymentMethod payment;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "join_table",
	joinColumns = {@JoinColumn(name="member_id")},
	inverseJoinColumns = {@JoinColumn(name = "project_id")})
	private List<Topping> toppings;
	
	public Order() {
		toppings = new ArrayList<Topping>();
	}
	
	public int getId() { 
		return orderId; 
	}
	public void setId(int orderId) {
		this.orderId = orderId;
	}
	
}
