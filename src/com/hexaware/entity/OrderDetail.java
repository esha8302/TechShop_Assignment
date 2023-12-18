package com.hexaware.entity;

public class OrderDetail{

	private int orderDetailID;
    private Order order;
    private Product product;
    private int quantity;

    // Constructor
    public OrderDetail(int orderDetailID, Order order, Product product, int quantity) {
        this.orderDetailID = orderDetailID;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderDetail() {}

	// Getter and Setter for OrderDetailID
    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    // Getter and Setter for Order
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // Getter and Setter for Product
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Getter and Setter for Quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
        	this.quantity = quantity;        	
        }
    }
    
    @Override
	public String toString() {
		return "OrderDetail [orderDetailID=" + orderDetailID + ", order=" + order + ", product=" + product
				+ ", quantity=" + quantity + "]";
	}
}