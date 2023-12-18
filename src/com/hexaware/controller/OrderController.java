package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.entity.Order;
import com.hexaware.dao.OrderDao;

public class OrderController implements OrderInterface {
	Scanner scan = new Scanner(System.in);
	OrderDao orderDao = new OrderDao();
	
	public void getOrderDetails() {
		System.out.print("Enter Order ID ");
		int orderId = scan.nextInt();
		orderDao.showOrderDetails(orderId);
	}

	public void updateOrderStatus() {
		Order order = new Order();
		
		System.out.print("Enter Order ID ");
		int orderId = scan.nextInt();
		order.setOrderID(orderId);
		
		System.out.print("Select Status: \n1. Processing \n2. Shipped \n3. Cancelled");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (choice == 1) order.setOrderStatus("PROCESSING");
		if (choice == 2) order.setOrderStatus("SHIPPED");
		if (choice == 3) order.setOrderStatus("CANCELLED");
		orderDao.updateOrderStatus(order);
	}

	public void calculateTotalAmount() {
		System.out.print("Enter Order ID ");
		int orderId = scan.nextInt();
		orderDao.calculateTotalAmount(orderId);
	}

}
