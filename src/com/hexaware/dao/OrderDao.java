package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Order;
import com.hexaware.util.DbConnection;
import com.hexaware.util.ResultFormatter;

public class OrderDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public void showOrderDetails(int orderId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT Orders.*, firstname, lastname, email FROM Orders JOIN Customers ON Customers.customerID = Orders.customerID WHERE orderID = ?");
			preparedStatement.setInt(1, orderId);
			resultSet = preparedStatement.executeQuery();
			ResultFormatter.printRows(resultSet);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
		        if (connection != null) connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	}
	
	public void updateOrderStatus(Order order) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("UPDATE Orders SET orderStatus = ? WHERE orderID = ?");
			preparedStatement.setString(1, order.getOrderStatus());
			preparedStatement.setInt(2, order.getOrderID());
			int totalRows = preparedStatement.executeUpdate();
			System.out.println(totalRows+" rows affected!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
		        if (connection != null) connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	}
	
	public void calculateTotalAmount(int orderId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT SUM(Price * Quantity) AS TotalAmount FROM OrderDetails D JOIN Products P ON D.productID = P.productID WHERE D.orderID = ?");
			preparedStatement.setInt(1, orderId);
			resultSet = preparedStatement.executeQuery();
			ResultFormatter.printRows(resultSet);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
		        if (connection != null) connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	}	
}
