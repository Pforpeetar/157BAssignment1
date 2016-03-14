package edu.cs157b.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Topping {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "join_table",
	joinColumns = {@JoinColumn(name="project_id")},
	inverseJoinColumns = {@JoinColumn(name = "member_id")}
	)
	private List<Order> orders;
	
	public Topping() {
		orders = new ArrayList<Order>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
