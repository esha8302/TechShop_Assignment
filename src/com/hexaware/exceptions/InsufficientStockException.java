package com.hexaware.exceptions;

public class InsufficientStockException extends Exception{
	public InsufficientStockException() {
		System.out.println("InsufficientStockException: The product is out of stock!");
	}
	
	public String toString(){
		return "Out of Stock!";
	}
}
