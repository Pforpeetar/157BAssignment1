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
		ServiceLayer.makeOrder(name, pass);
		promptInput(in);
	}
	
	static void makeDiscountOrder(Scanner in) {
		ServiceLayer.makeOrder(name, pass);
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
