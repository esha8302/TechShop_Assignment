package com.hexaware.view;

import java.util.Scanner;

import com.hexaware.controller.ProductController;
import com.hexaware.controller.ProductInterface;

public class ProductView {
	Scanner scan = new Scanner(System.in);
	ProductInterface product = new ProductController();
	
	public void displayMenu() {
		String ch = null;
		
		do {
		    System.out.println("Enter your choice");
		    System.out.println("1. Add Product");
		    System.out.println("2. View Product Details");
		    System.out.println("3. Update Product");
		    System.out.println("4. View All Products");
		    int choice = scan.nextInt();
		    
		    switch (choice) {
		        case 1: {
		            product.addProduct(); 
		            break;
		        }
		        case 2: {
		            product.getProductDetails();
		            break;
		        }
		        case 3: {
		            product.updateProductInfo();
		            break;
		        }
		        case 4: {
		            product.getProductList();
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
