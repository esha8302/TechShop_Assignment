package com.hexaware.dao;

import com.hexaware.entity.Customer;
import com.hexaware.util.DbConnection;
import com.hexaware.util.ResultFormatter;
import java.sql.*;

public class CustomerDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	
	public void insertCustomer(Customer customer) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("insert into customers(customerID, firstname, lastname, email, phone, address) values(?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, customer.getCustomerID());
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setString(3, customer.getLastName());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5, customer.getPhone());
			preparedStatement.setString(6, customer.getAddress());
			int totalRows = preparedStatement.executeUpdate();
			System.out.println(totalRows+" rows affected!");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void showCustomerDetails(int customerID) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE customerID = ?");
			System.out.println(customerID);
			preparedStatement.setInt(1, customerID);
			resultSet = preparedStatement.executeQuery();
			ResultFormatter.printRows(resultSet);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateCustomer(Customer customer) {
		try {
			connection = DbConnection.getDbConnection();
			// Initialize StringBuilder to dynamically build the update query
	        StringBuilder updateQuery = new StringBuilder("UPDATE customers SET ");
	        
	        // Check each field and add it to the update query if it's not null
	        if (customer.getEmail() != null) {
	            updateQuery.append("email = ?, ");
	        }
	        if (customer.getPhone() != null) {
	            updateQuery.append("phone = ?, ");
	        }
	        if (customer.getAddress() != null) {
	            updateQuery.append("address = ?, ");
	        }
	        
	        // Remove the trailing comma and space from the query
	        updateQuery.setLength(updateQuery.length() - 2);
	        
	        // Add the WHERE clause to identify the customer to update
	        updateQuery.append(" WHERE customerID = ?");
	        
	        // Prepare the statement using the dynamically built query
	        preparedStatement = connection.prepareStatement(updateQuery.toString());
	        
	        // Set parameters based on the provided values
	        int parameterIndex = 1;
	        if (customer.getEmail() != null) {
	            preparedStatement.setString(parameterIndex++, customer.getEmail());
	        }
	        if (customer.getPhone() != null) {
	            preparedStatement.setString(parameterIndex++, customer.getPhone());
	        }
	        if (customer.getAddress() != null) {
	            preparedStatement.setString(parameterIndex++, customer.getAddress());
	        }
	        
	        // Set the WHERE clause parameter
	        preparedStatement.setInt(parameterIndex, customer.getCustomerID());

			
			int totalRows = preparedStatement.executeUpdate();
			System.out.println(totalRows+" rows affected!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void showCustomer() {
		try {
			connection = DbConnection.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from customers");
//			while(resultSet.next()) {
//				System.out.println("Customer ID : "+ resultSet.getInt(1));
//				System.out.println("First Name : "+ resultSet.getString(2));
//				System.out.println("Last Name : "+ resultSet.getString(3));
//				System.out.println("Email: "+resultSet.getString(4));
//				System.out.println("Phone: "+resultSet.getString(5));
//				System.out.println("Address: "+resultSet.getString(6));
//			}
			ResultFormatter.printRows(resultSet);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

