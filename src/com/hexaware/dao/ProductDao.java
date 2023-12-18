package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Product;
import com.hexaware.util.DbConnection;
import com.hexaware.util.ResultFormatter;

public class ProductDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public void insertProduct(Product product) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement(
					"INSERT INTO products(productID, productName, description, price) VALUES (?, ?, ?, ?)");

			preparedStatement.setInt(1, product.getProductID());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setDouble(4, product.getPrice());

			int totalRows = preparedStatement.executeUpdate();
			System.out.println(totalRows + " rows affected!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void showProductDetails(int productID) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE productID = ?");
			preparedStatement.setInt(1, productID);
			resultSet = preparedStatement.executeQuery();
			ResultFormatter.printRows(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateProduct(Product product) {
		try {
			connection = DbConnection.getDbConnection();
			// Initialize StringBuilder to dynamically build the update query
			StringBuilder updateQuery = new StringBuilder("UPDATE products SET ");

			// Check each field and add it to the update query if it's not null
			if (product.getDescription() != null) {
				updateQuery.append("description = ?, ");
			}

			if (product.getPrice() != 0) {
				updateQuery.append("price = ?, ");
			}

			// Remove the trailing comma and space from the query
			updateQuery.setLength(updateQuery.length() - 2);

			// Add the WHERE clause to identify the product to update
			updateQuery.append(" WHERE productID = ?");

			// Prepare the statement using the dynamically built query
			preparedStatement = connection.prepareStatement(updateQuery.toString());

			// Set parameters based on the provided values
			int parameterIndex = 1;
			if (product.getDescription() != null) {
				preparedStatement.setString(parameterIndex++, product.getDescription());
			}

			if (product.getPrice() != 0) {
				preparedStatement.setDouble(parameterIndex++, product.getPrice());
			}

			// Set the WHERE clause parameter
			preparedStatement.setInt(parameterIndex, product.getProductID());

			int totalRows = preparedStatement.executeUpdate();
			System.out.println(totalRows + " rows affected!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close resources in the finally block
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Product> showProductList() {
		List<Product> productList = new ArrayList<Product>();
		try {
			connection = DbConnection.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from products");
//			ResultFormatter.printRows(resultSet);

			while (resultSet.next()) {
				Product product = new Product();
				int productId = resultSet.getInt(1);
				int categoryId = resultSet.getInt(2);
				String productName = resultSet.getString("productname");
				double price = resultSet.getDouble(4);
				
				product.setProductID(productId);
				product.setProductName(productName);
				product.setPrice(price);
				productList.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}
}
