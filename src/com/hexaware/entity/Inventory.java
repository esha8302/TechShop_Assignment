package com.hexaware.entity;

import java.util.Date;

public class Inventory {
    private int inventoryID;
    private Product product;
    private int quantityInStock;
    private Date lastStockUpdate;

    // Constructor
    public Inventory(int inventoryID, Product product, int quantityInStock, Date lastStockUpdate) {
        this.inventoryID = inventoryID;
        this.product = product;
        this.quantityInStock = quantityInStock;
        this.lastStockUpdate = lastStockUpdate;
    }
    
    public Inventory() {}

    // Getter and Setter for InventoryID
    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    // Getter and Setter for Product
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Getter and Setter for QuantityInStock
    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
    	if (quantityInStock >= 0) {
    		this.quantityInStock = quantityInStock;	
    	}
    }

    // Getter and Setter for LastStockUpdate
    public Date getLastStockUpdate() {
        return lastStockUpdate;
    }

    public void setLastStockUpdate(Date lastStockUpdate) {
        this.lastStockUpdate = lastStockUpdate;
    }

	@Override
	public String toString() {
		return "Inventory [inventoryID=" + inventoryID + ", product=" + product.getProductName() + ", quantityInStock=" + quantityInStock
				+ ", lastStockUpdate=" + lastStockUpdate + "]";
	}
}