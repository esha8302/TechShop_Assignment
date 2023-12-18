package com.hexaware.exceptions;

public class AuthenticationException extends Exception{
	public AuthenticationException() {
		System.out.println("AuthenticationException");
	}
	
	public String toString(){
		return "Invalid User Credentials!";
	}
}
