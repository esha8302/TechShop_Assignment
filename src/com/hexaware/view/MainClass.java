package com.hexaware.view;

import java.util.Scanner;

public class MainClass {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to TechShop");
		
		String input = null;
		do {
			System.out.println("Select a Module ");
			System.out.println("1. Customer Registration");
			System.out.println("2. Product Catalog Management");
			System.out.println("3. Placing Customer Orders");
			System.out.println("4. Order Details");
			System.out.println("5. Inventory");
			
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				CustomerView customerView = new CustomerView();
				customerView.displayMenu();
				break;
			}
			case 2: {
				ProductView productView = new ProductView();
				productView.displayMenu();
				break;
			}
			case 3: {
				OrderView orderView = new OrderView();
				orderView.displayMenu();
				break;
			}
			case 4: {
				OrderDetailView orderDetailView = new OrderDetailView();
				orderDetailView.displayMenu();
				break;
			}
			case 5: {
				InventoryView inventoryView = new InventoryView();
				inventoryView.displayMenu();
				break;
			}
			default: {
				System.out.println("Choose a proper choice");
				break;
			}
			}
			System.out.println("To Continue - Press 'C' | 'c'");
			input = scan.next();
			
		} while (input.equals("c") || input.equals("C"));
		
		System.out.println("Thanks for using our System!");
	}
	
}
