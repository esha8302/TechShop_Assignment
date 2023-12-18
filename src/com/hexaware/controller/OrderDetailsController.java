package com.hexaware.controller;

import java.util.Scanner;
import com.hexaware.entity.OrderDetail;
import com.hexaware.dao.OrderDetailsDao;

public class OrderDetailsController implements OrderDetailsInterface {
	Scanner scan = new Scanner(System.in);
	OrderDetailsDao orderDetailsDao = new OrderDetailsDao();

	public void getOrderDetailInfo() {
		System.out.print("Enter OrderDetail ID ");
		int orderDetailsId = scan.nextInt();
		orderDetailsDao.showOrderDetails(orderDetailsId);
	}

	public void calculateSubTotal() {
		System.out.print("Enter OrderDetail ID ");
		int orderDetailsId = scan.nextInt();
		orderDetailsDao.calculateSubTotal(orderDetailsId);
	}

	public void updateQuantity() {
		OrderDetail orderDetail = new OrderDetail();
		
		System.out.print("Enter OrderDetail ID ");
		int orderDetailsId = scan.nextInt();
		
		System.out.println("Enter Quantity ");
		int quantity = scan.nextInt();
		
		orderDetail.setOrderDetailID(orderDetailsId);
		orderDetail.setQuantity(quantity);
		
		orderDetailsDao.updateQuantity(orderDetail);
	}

	public void addDiscount() {
		System.out.print("Enter OrderDetail ID ");
		int orderDetailsId = scan.nextInt();
		
		System.out.println("Enter Discount Percentage ");
		int discountPercent = scan.nextInt();
		
		orderDetailsDao.addDiscount(orderDetailsId, discountPercent);
		
	}

}
