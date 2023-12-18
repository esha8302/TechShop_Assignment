package com.hexaware.view;

import java.util.Scanner;

import com.hexaware.controller.OrderController;
import com.hexaware.controller.OrderInterface;

public class OrderView {
	Scanner scan = new Scanner(System.in);
	OrderInterface order = new OrderController();
	
	public void displayMenu() {
		String ch = null;
		
		do {
		    System.out.println("Enter your choice");
		    System.out.println("1. View Order Details");
		    System.out.println("2. Update Order Status");
		    System.out.println("3. Calculate Total Amount For an Order");
		    
		    
		    int choice = scan.nextInt();
		    
		    switch (choice) {
		        case 1: {
		            order.getOrderDetails();
		            break;
		        }
		        case 2: {
		            order.updateOrderStatus();
		            break;
		        }
		        case 3: {
		        	order.calculateTotalAmount();
		        	break;
		        }
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