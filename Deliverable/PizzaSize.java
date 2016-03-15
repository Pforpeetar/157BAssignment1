package edu.cs157b.hibernate;

public enum PizzaSize {
	SMALL(3), MEDIUM(5), LARGE(7);
	
	private int price;
	private PizzaSize(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
}
