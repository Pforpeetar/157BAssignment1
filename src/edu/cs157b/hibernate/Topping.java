package edu.cs157b.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TOPPING_TABLE")
public class Topping {
	@Id
	@GeneratedValue
	private int id;
	private float price;
	private String toppingType;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "join_table",
	joinColumns = {@JoinColumn(name="topping_id")},
	inverseJoinColumns = {@JoinColumn(name = "order_id")}
	)
	private List<Order> orders;
	
	Topping() {
		orders = null;
	}
	
	public Topping(String type) {
		orders = new ArrayList<Order>();
		setTopping(type);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setTopping(String type) {
		switch(type) {
			case "p": type = "Pepperoni";
				price = 0.5f;
			case "m": type = "Mushrooms";
				price = 0.25f;
			case "o": type = "Onions";
				price = 0.3f;
			case "s": type = "Sausage";
				price = 1f;
			case "b": type = "Bacon";
				price = 1.5f;
			case "e": type = "Extra cheese";
				price = 1f;
			case "bl": type = "Black olives";
				price = 0.5f;
			case "g": type = "Green peppers";
				price = 0.75f;
			case "pi": type = "Pineapple";
				price = 0.8f;
			case "sp": type = "Spinach";
				price = 2f;
		}
	}
	public String getTopping() {
		return toppingType;
	}
}
