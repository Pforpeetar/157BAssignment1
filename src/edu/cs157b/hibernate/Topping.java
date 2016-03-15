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
		switch(type.toLowerCase()) {
			case "p": type = "Pepperoni";
				price = 0.5f;
				break;
			case "m": type = "Mushrooms";
				price = 0.25f;
				break;
			case "o": type = "Onions";
				price = 0.3f;
				break;
			case "s": type = "Sausage";
				price = 1f;
				break;
			case "b": type = "Bacon";
				price = 1.5f;
				break;
			case "e": type = "Extra cheese";
				price = 1f;
				break;
			case "bl": type = "Black olives";
				price = 0.5f;
				break;
			case "g": type = "Green peppers";
				price = 0.75f;
				break;
			case "pi": type = "Pineapple";
				price = 0.8f;
				break;
			case "sp": type = "Spinach";
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
