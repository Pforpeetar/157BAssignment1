package edu.cs157b.hibernate;
import javax.persistence.*;

@Entity
@Table(name="CUSTOMER_TABLE")
@NamedQuery(name = "Customer.findByName", query = "from Customer where name = :name")
public class Customer {
	private String id;
	private String name;
	private String password;
	
	private Address address;
	
	@Id
	@GeneratedValue
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
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
}
