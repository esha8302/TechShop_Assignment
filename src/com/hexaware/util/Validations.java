package com.hexaware.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hexaware.exceptions.InvalidDataException;

public class Validations {
	
	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

		try {
			// Create a pattern object
			Pattern pattern = Pattern.compile(emailRegex);
	        
	        // Create a matcher object
	        Matcher matcher = pattern.matcher(email);
	        
	        if (matcher.matches()) {
	        	return true;
	        }else 
				throw new InvalidDataException();
		}
        catch(InvalidDataException e) {
			System.out.println("Enter a valid email");
		}
		return false;
	}
	
	public static boolean isValidPhone(String phone) {
		String phoneRegex = "^\\\\d{10}$";
		try {
			Pattern pattern = Pattern.compile(phoneRegex);
			Matcher matcher = pattern.matcher(phone);
			if (matcher.matches()) {
	        	return true;
	        }else 
				throw new InvalidDataException();
		}
        catch(InvalidDataException e) {
			System.out.println("Enter a valid phone number");
		}
				
		return false;
	}
	
	
	
	
	
}
