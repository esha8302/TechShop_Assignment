package com.hexaware.view;

import java.util.Scanner;

import com.hexaware.controller.CustomerController;
import com.hexaware.controller.CustomerInterface;
import com.hexaware.entity.Customer;

public class CustomerView {
	Scanner scan = new Scanner(System.in);
	CustomerInterface customerController = new CustomerController();

	public void displayMenu() {
		String ch = null;
		
		do {
			System.out.println("Enter your choice");
			System.out.println("1. Register");
			System.out.println("2. View Customer Details");
			System.out.println("3. Update Customer");
//			System.out.println("4. View All Customers");
			int choice = scan.nextInt();
			switch (choice) {
			
			case 1: {
				customerController.addCustomer();
				break;
			}
			
			case 2: {
				customerController.getCustomerDetails();
				break;
			}
			
			case 3: {
				
				customerController.updateCustomerInfo();
				break;
			}
//			case 4: {
//				customerController.getCustomerList();
//				break;
//			}
			default: {
				System.out.println("Choose a proper choice");
				break;
			}
			}
			System.out.println("Do you want to continue? Y | y");
			ch = scan.next();

		} while (ch.equals("Y") || ch.equals("y"));
	}
}
