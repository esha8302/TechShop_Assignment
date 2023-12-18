package com.hexaware.view;

import java.util.Scanner;

import com.hexaware.controller.OrderDetailsController;
import com.hexaware.controller.OrderDetailsInterface;

public class OrderDetailView {
	Scanner scan = new Scanner(System.in);
	OrderDetailsInterface orderDetails = new OrderDetailsController();

	public void displayMenu() {
		String ch = null;
		
		do {
		    System.out.println("Enter your choice");
		    System.out.println("1. View Order Detail Info");
		    System.out.println("2. Calculate Order Detail Subtotal");
		    System.out.println("3. Update product quantity");
		    System.out.println("4. Add Discount");
		    
		    int choice = scan.nextInt();
		    
		    switch (choice) {
		        case 1: {
		            orderDetails.getOrderDetailInfo();
		            break;
		        }
		        case 2: {
		            orderDetails.calculateSubTotal();
		            break;
		        }
		        case 3: {
		            orderDetails.updateQuantity();
		            break;
		        }
		        case 4: {
		            orderDetails.addDiscount();
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