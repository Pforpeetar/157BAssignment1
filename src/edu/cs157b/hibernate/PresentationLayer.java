package edu.cs157b.hibernate;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PresentationLayer {
	public static ServiceLayer serviceLayer;
	
	public static void main(String[] args) {
		serviceLayer = new ServiceLayer();
		Scanner in = new Scanner(System.in);
		startService(in);
		in.close();
		serviceLayer.closeSession();
	}
	
	static void signIn(Scanner in) {
		Customer user = new Customer();
		serviceLayer.signUp(user);
	}
	
	static void logIn(Scanner in) {
		serviceLayer.logIn();
	}
	
	static void makeRegOrder(Scanner in) {
		serviceLayer.makeOrder();
		promptInput(in);
	}
	
	static void makeDiscountOrder(Scanner in) {
		serviceLayer.makeOrder();
		promptInput(in);
	}
	
	static void viewOrders(Scanner in) {
		serviceLayer.viewOrders();
		promptInput(in);
	}
	
	static void changeOrder(Scanner in) {
		serviceLayer.changeOrder();
		promptInput(in);
	}
	
	static void cancelOrder(Scanner in) {
		serviceLayer.cancelOrder();
		promptInput(in);
	}
	
	static void test() {
		
	}
	

	static void promptInput(Scanner in) {
		System.out.println("[M]ake Order, [D]iscount Order, [V]iew Orders, [E]dit Order, [C]ancel Order, [Q]uit");
		String input = in.next().toLowerCase();
		if (input.equals("m")) {
			makeRegOrder(in);
		} else if (input.equals("d")) {
			makeDiscountOrder(in);
		} else if (input.equals("v")) {
			viewOrders(in);
		} else if (input.equals("e")) {
			changeOrder(in);
		} else if (input.equals("c")) {
			cancelOrder(in);
		} else if (input.equals("q")){
			System.exit(0);
		} else {
			promptInput(in);
		}
	}
	
	static void startService(Scanner in) {
		System.out.println("[S]ign Up, [L]og In, [Q]uit");
		String input = in.next().toLowerCase();
		if (input.equals("s")) {
			signIn(in);
			promptInput(in);
		} else if (input.equals("l")) {
			logIn(in);
			promptInput(in);
		} else if (input.equals("q")){
			System.exit(0);
		} else {
			startService(in);
		}
	}
	
}
