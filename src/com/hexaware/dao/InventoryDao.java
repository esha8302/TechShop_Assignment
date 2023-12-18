package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hexaware.entity.Inventory;
import com.hexaware.util.DbConnection;
import com.hexaware.util.ResultFormatter;

public class InventoryDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	Inventory inventory = new Inventory();
	public ResultSet showProduct(int inventoryId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT Inventory.productId, Products.productname FROM Inventory JOIN Products ON Products.productId = Inventory.productId WHERE inventoryId = ?");
			preparedStatement.setInt(1, inventoryId);
			resultSet = preparedStatement.executeQuery();
			
//			List list = ResultFormatter.convertToList(resultSet);
//			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultSet;
	}
	
	public ResultSet showStockQuantity(int productId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT SUM(quantityinstock) AS ProductStock FROM Inventory WHERE productId = ?");
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultSet;
	}
	
	public void updateAddQuantity(int productId, int quantity) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("UPDATE Inventory SET quantityinstock = quantityinstock+? WHERE productId = ?");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, productId);
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
	
	public void updateRemoveQuantity(int productId, int quantity) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("UPDATE Inventory SET quantityinstock = quantityinstock-? WHERE productId = ?");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, productId);
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
	
	public void updateStockQuantity(int inventoryId, int quantity) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("UPDATE Inventory SET quantityinstock = ? WHERE productId = ?");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, inventoryId);
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
	
	public int showAvailableQuantity(int productId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT SUM(quantityinstock) FROM Inventory WHERE productId = ?");
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	public int showInventoryValue() {
		int totalInventoryValue = 0;
		try {
			connection = DbConnection.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT SUM(quantityinstock*price) FROM Inventory JOIN Products ON Inventory.productId = Products.productId");
			if(resultSet.next()) {
				totalInventoryValue = resultSet.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalInventoryValue;
	}
	
	public ResultSet showLowStockProducts(int threshold) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT inventoryId, Inventory.productId, productname FROM Inventory JOIN Products ON Products.productId = Inventory.inventoryId WHERE quantityInStock <= ?");
			preparedStatement.setInt(1, threshold);
			resultSet = preparedStatement.executeQuery();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultSet;
	}
	
	public ResultSet showOutOfStockProdcuts() {
		try {
			connection = DbConnection.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT DISTINCT(Inventory.productId), productname FROM Inventory JOIN Products ON Products.productId = Inventory.inventoryId WHERE quantityInStock = 0");

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultSet;
	}
	
	public ResultSet showAllProducts() {
		try {
			connection = DbConnection.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT DISTINCT(Inventory.productId), productname FROM Inventory JOIN Products ON Products.productId = Inventory.inventoryId");

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultSet;
	}
	
}
