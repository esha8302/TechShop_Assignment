package com.hexaware.controller;

public interface InventoryInterface {

	public void getProduct();
	
//	A method to get the current quantity of the product in stock.
	public void getStockQuantity();
	
//	A method to add a specified quantity of the product to the inventory
	public void addToInventory();
	
//	A method to remove a specified quantity of the product from the inventory.
	public void removeFromInventory();
	
//	A method to update the stock quantity to a new value.
	public void updateStockQuantity();
	
//	A method to check if a specified quantity of the product is available in the inventory.
	public void isProductAvailable();
	
//	A method to calculate the total value of the products in the inventory based on their prices and quantities.
	public void getInventoryValue();
	
//	A method to list products with quantities below a specified threshold, indicating low stock.
	public void listLowStockProducts();
	
//	A method to list products that are out of stock.
	public void listOutOfStockProducts();

//	A method to list all products in the inventory, along with their quantities.
	public void listAllProducts();
	
}
