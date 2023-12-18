package com.hexaware.util;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultFormatter {
	public static void printRows(ResultSet resultSet) {
		try {
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			if(resultSet.next()) {
				do {
					for (int i = 1; i <= columnCount; i++) {
				        String columnName = metaData.getColumnName(i);
				        Object value = resultSet.getObject(i);
				        System.out.println(columnName + ": " + value);
				    }
				    System.out.println();  // Add a newline between rows for better readability
				} while(resultSet.next());
			}
			else {
				System.out.println("No Data Returned");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}