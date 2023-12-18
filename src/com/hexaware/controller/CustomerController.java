package com.hexaware.controller;
import java.util.Scanner;

import com.hexaware.util.Validations;
import com.hexaware.dao.CustomerDao;
import com.hexaware.entity.Customer;

public class CustomerController implements CustomerInterface {
	Scanner scan = new Scanner(System.in);
	CustomerDao customerDao = new CustomerDao();
	
	public void addCustomer() {
		System.out.print("Enter Customer ID ");
		int customerId = scan.nextInt();
		
		System.out.print("Enter First Name ");
		String firstName = scan.next();
		
		System.out.print("Enter Last Name ");
		String lastName = scan.next();
		
		System.out.print("Enter Email Address ");
		String email = scan.next();
		
		System.out.print("Enter Phone Number");
		String phone = scan.next();
		
		scan.nextLine(); // To avoid breaking input due to /n character
		
		System.out.print("Enter Address ");
		String address = scan.nextLine();
				
		if ( (Validations.isValidEmail(email)) && (Validations.isValidPhone(phone)) ) {
			Customer customer = new Customer(customerId, firstName, lastName, email, phone, address);
			customerDao.insertCustomer(customer);
		}	
	}
	
	
	public void getCustomerDetails() {
		System.out.print("Enter Customer ID ");
		int customerId = scan.nextInt();
		customerDao.showCustomerDetails(customerId);
	}
	
	public void updateCustomerInfo() {
		Customer customer = new Customer();
		
		System.out.print("Enter Customer ID ");
		int customerId = scan.nextInt();
		customer.setCustomerID(customerId);
		
		scan.nextLine();
		
		System.out.print("Enter Email Address ");
		String email = scan.nextLine().trim();
		if (!email.isEmpty()) {
			customer.setEmail(email);
		}
		
		scan.nextLine();
		
		System.out.print("Enter Phone ");
		String phone = scan.nextLine().trim();
		if (!phone.isEmpty()) {
			customer.setPhone(phone);
		}
		
		scan.nextLine();
		
		System.out.print("Enter address ");
		String address = scan.nextLine();
		if (!address.isEmpty()) {
			customer.setAddress(address);
		}
	
		customerDao.updateCustomer(customer);
		
	}
	
	public void getCustomerList() {
		customerDao.showCustomer();
	}
}
