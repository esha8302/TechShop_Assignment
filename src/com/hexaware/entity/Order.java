package com.hexaware.entity;

import java.util.Date;

public class Order {
    private int orderID;
    private Customer customer;
    private Date orderDate;
    private double totalAmount;
    private String orderStatus;
    
    // Constructor
    public Order() {}

    // Parameterized Constructor
    public Order(int orderID, Customer customer, Date orderDate, double totalAmount, String orderStatus) {
        this.orderID = orderID;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

	// Getter and Setter for OrderID
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		if (orderStatus.equals("PROCESSING") || orderStatus.equals("SHIPPED") || orderStatus.equals("CANCELLED")){
			this.orderStatus = orderStatus;			
		}
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customer=" + customer + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + "]";
	}
}