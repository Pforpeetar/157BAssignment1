package edu.cs157b.hibernate;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PresentationLayer {
	private static String name;
	private static String pass;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		startService(in);
		in.close();
	}
	
	static void signIn(Scanner in) {
		System.out.println("||====Sign Up Information:====||");
		System.out.print("NAME: ");
		String name = in.nextLine().toLowerCase();
		System.out.print("PASSWORD: ");
		String password = in.nextLine().toLowerCase();
		System.out.print("STREET: ");
		String street = in.nextLine().toLowerCase();
		System.out.print("STATE: ");
		String state = in.nextLine().toLowerCase();
		System.out.print("CITY: ");
		String city = in.nextLine().toLowerCase();
		System.out.print("ZIPCODE: ");
		String zipcode = in.nextLine().toLowerCase();
		ServiceLayer.signUp(name, password, street, state, city, zipcode);
		logIn(in);
	}
	
	static void logIn(Scanner in) {
		System.out.println("||====Input Login Information:====||");
		System.out.print("NAME: ");
		name = in.nextLine().toLowerCase();
		System.out.print("PASSWORD: ");
		pass = in.nextLine().toLowerCase();
		ServiceLayer.logIn(name, pass);
	}
	
	static void makeRegOrder(Scanner in) {
		System.out.println("||=================Choose Size:==================||");
		System.out.println("||[S]mall: $3.00, [M]edium: $5.00, [L]arge: $7.00||");
		String size = in.nextLine().toLowerCase();
		PizzaSize sizeEnum = null;
		if (size.equals("s")) {
			sizeEnum = PizzaSize.SMALL;
		} else if (size.equals("m")) {
			sizeEnum = PizzaSize.MEDIUM;
		} else if (size.equals("l")) {
			sizeEnum = PizzaSize.LARGE;
		}
		System.out.println("||=========================Choose 3 Toppings:==========================||");
		System.out.println("||[P]epperoni: 0.50, [M]ushrooms: 0.25, [O]nions: 0.30, [S]ausage: 1.00||");
		System.out.println("||[B]acon: 1.50, [E]xtra Cheese: 1.00, [Bl]ack Olives: 0.50||");
		System.out.println("||[G]reen Peppers: 0.75, [Pi]napple: 0.80, [Sp]inach: 2.00||");
		String top1 = in.nextLine().toLowerCase();
		System.out.println("||=========================Choose 2 Toppings:==========================||");
		System.out.println("||[P]epperoni: 0.50, [M]ushrooms: 0.25, [O]nions: 0.30, [S]ausage: 1.00||");
		System.out.println("||[B]acon: 1.50, [E]xtra Cheese: 1.00, [Bl]ack Olives: 0.50||");
		System.out.println("||[G]reen Peppers: 0.75, [Pi]napple: 0.80, [Sp]inach: 2.00||");
		String top2 = in.nextLine().toLowerCase();
		System.out.println("||=========================Choose 1 Toppings:==========================||");
		System.out.println("||[P]epperoni: 0.50, [M]ushrooms: 0.25, [O]nions: 0.30, [S]ausage: 1.00||");
		System.out.println("||[B]acon: 1.50, [E]xtra Cheese: 1.00, [Bl]ack Olives: 0.50||");
		System.out.println("||[G]reen Peppers: 0.75, [Pi]napple: 0.80, [Sp]inach: 2.00||");
		String top3 = in.nextLine().toLowerCase();
		
		ServiceLayer.makeOrder(name, pass, sizeEnum, top1, top2, top3);
		promptInput(in);
	}
	
	static void makeDiscountOrder(Scanner in) {
		//ServiceLayer.makeOrder(name, pass);
		promptInput(in);
	}
	
	static void viewOrders(Scanner in) {
		ServiceLayer.viewOrders();
		promptInput(in);
	}
	
	static void changeOrder(Scanner in) {
		ServiceLayer.changeOrder();
		promptInput(in);
	}
	
	static void cancelOrder(Scanner in) {
		ServiceLayer.cancelOrder();
		promptInput(in);
	}
	

	static void promptInput(Scanner in) {
		System.out.println("[M]ake Order, [D]iscount Order, [V]iew Orders, [E]dit Order, [C]ancel Order, [Q]uit");
		String input = in.nextLine().toLowerCase();
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
		System.out.println("||==========WELOME===========||");
		System.out.println("||[S]ign Up, [L]og In, [Q]uit||");
		System.out.println("||===========================||");
		System.out.print("INPUT: ");
		String input = in.nextLine().toLowerCase();
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
