package com.hexaware.entity;

public class Product {
    private int productID;
    private String productName;
    private String description;
    private double price;

    // Constructor without parameters
    public Product() {}

	// Parameterized Constructor
    public Product(int productID, String productName, String description, double price) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    // Getter and Setter for ProductID
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    // Getter and Setter for ProductName
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter and Setter for Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for Price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + "]";
	}
}