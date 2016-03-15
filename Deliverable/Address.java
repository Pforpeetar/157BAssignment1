package edu.cs157b.hibernate;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String streetname;
	private String city;
	private String state; 
	private String zipcode; 
	
	public Address() {
		streetname = "";
		city = "";
		state = "";
		zipcode = "";
	}
	
	public Address(String street, String city, String state, String zipcode) {
		this.streetname = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public String getStreet() {
		return streetname;
	}
	public void setStreet(String street) {
		this.streetname = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode; ;
	}
}

