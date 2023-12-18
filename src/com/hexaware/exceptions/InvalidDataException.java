package com.hexaware.exceptions;

public class InvalidDataException extends Exception{
	public InvalidDataException() {
		System.out.println("InvalidDataException");
	}
	
	public InvalidDataException(String message) {
		System.out.println(message);
	}

	public String toString(){
		return "Invalid Data!";
	}
}