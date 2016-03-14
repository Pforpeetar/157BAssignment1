package edu.cs157b.hibernate;
import javax.persistence.*;

@Entity
@Table(name="CUSTOMER_TABLE")
public class Customer {
	@Column(name = "USER_ID")
	private String id;
	@Column(name = "USER_NAME", unique = true)
	private String name;
	@Column(name = "PASSWORD")
	private String password;
	
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
}
