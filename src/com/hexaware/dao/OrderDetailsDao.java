package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.util.DbConnection;
import com.hexaware.entity.OrderDetail;
import com.hexaware.util.ResultFormatter;

public class OrderDetailsDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public void showOrderDetails(int orderDetailId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT OrderDetails.*, productname FROM OrderDetails JOIN Products ON OrderDetails.productID = Products.productID WHERE orderDetailId = ?");
			preparedStatement.setInt(1, orderDetailId);
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
	
	public void calculateSubTotal(int orderDetailId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT (price*quantity) AS SubTotal FROM OrderDetails JOIN Products ON OrderDetails.productID = Products.productID WHERE orderDetailId = ?");
			preparedStatement.setInt(1, orderDetailId);
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

	public void updateQuantity(OrderDetail orderDetail) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("UPDATE OrderDetails SET quantity = ? WHERE orderDetailId = ?");
			preparedStatement.setInt(1, orderDetail.getQuantity());
			preparedStatement.setInt(2, orderDetail.getOrderDetailID());
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
	
	public void addDiscount(int orderDetailId, int discountPercent) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT (price*quantity)* ? AS DiscountedSubTotal FROM OrderDetails JOIN Products ON OrderDetails.productID = Products.productID WHERE orderDetailId = ?");
			
			double discount = discountPercent/100.00;
			System.out.println(discount);
			preparedStatement.setDouble(1, 1-discount);
			preparedStatement.setInt(2, orderDetailId);
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
}
