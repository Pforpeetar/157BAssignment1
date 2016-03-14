package edu.cs157b.hibernate;

import javax.persistence.*;

@Entity
public class DiscountedOrder extends Order{
	private int discountRate;
	
	public int getDiscount() {
		return discountRate;
	}
	public void setDiscount(int discountRate) {
		this.discountRate = discountRate;
	}
}
