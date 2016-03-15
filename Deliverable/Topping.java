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
		toppingType = null;
		orders = new ArrayList<Order>();
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
		switch(type.toLowerCase()) {
			case "p": toppingType = "Pepperoni";
				price = 0.5f;
				break;
			case "m": toppingType = "Mushrooms";
				price = 0.25f;
				break;
			case "o": toppingType = "Onions";
				price = 0.3f;
				break;
			case "s": toppingType = "Sausage";
				price = 1f;
				break;
			case "b": toppingType = "Bacon";
				price = 1.5f;
				break;
			case "e": toppingType = "Extra cheese";
				price = 1f;
				break;
			case "bl": toppingType = "Black olives";
				price = 0.5f;
				break;
			case "g": toppingType = "Green peppers";
				price = 0.75f;
				break;
			case "pi": toppingType = "Pineapple";
				price = 0.8f;
				break;
			case "sp": toppingType = "Spinach";
				price = 2f;
				break;
			default:
				price = 0;
				break;
		}
	}
	public String getTopping() {
		return toppingType;
	}
}
