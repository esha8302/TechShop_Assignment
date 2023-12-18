package com.hexaware.entity;
import com.hexaware.util.Validations;

public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    
    // Constructor without parameters
    public Customer() {
    	
    }

    // Constructor with parameters to initialize values
    public Customer(int customerID, String firstName, String lastName, String email, String phone, String address) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getter and Setter for CustomerID
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    // Getter and Setter for FirstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for LastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter for Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
    	if(Validations.isValidEmail(email)) {
    		this.email = email;
    	}
    }

    // Getter and Setter for Phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter and Setter for Address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for Full Name
    public String getFullName() {
        return firstName + " " + lastName;
    }
}