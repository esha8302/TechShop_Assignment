package com.hexaware.exceptions;

public class AuthorizationException extends Exception{
	public AuthorizationException() {
		System.out.println("AuthorizationException");
	}
	
	public String toString(){
		return "Access Denied!";
	}
}
