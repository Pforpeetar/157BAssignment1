package edu.cs157b.hibernate;

public class PresentationLayer {
	public static ServiceLayer serviceLayer;
	
	public static void main(String[] args) {
		
		
		serviceLayer.closeSession();
	}
	
	void signIn() {
		System.out.println("Enter name: ");
		System.out.println("Enter password: ");
	}
	
	void logIn() {
		
	}
	
	void makeRegOrder() {
		
	}
	
	void makeDiscountOrder() {
		
	}
	
	void viewOrders() {
		
	}
	
	void changeOrder() {
		
	}
	
	void cancelOrder() {
		
	}
}
