package edu.cs157b.hibernate;

import javax.persistence.*;

@Entity
public class DiscountedOrder extends Order{
	private float discountRate = 0.9f;
	
	public DiscountedOrder() {
		super.setPrice(super.getPrice()*discountRate);
	}
	
	public float getDiscount() {
		return discountRate;
	}
	public void setDiscount(int discountRate) {
		this.discountRate = discountRate;
	}
}
