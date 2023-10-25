package org.perscholas.database;

import java.sql.*;
import java.util.Scanner;

public class OrderProductsExample {

	/*public static void main(String[] args) throws SQLException {
		
		//1 Create a connection to database classic_models
		//2 Use scanner to take input of order number
		//3 Write query using a prepared statement to print
		// product id, product name, quant ordered, msrp, buyprice, margin (msrp-buyprice), total margin (margin * quant)
		// make output look nice
		//4 use variable to calc the total margin for total order
		
		String dburl = "jdbc:mysql://localhost:3306/classic_models";
		String user = "root";
		String password = "Whatisthis0601!";
		Connection connection = null;
		Scanner scan = new Scanner (System.in);
		
		try {
			connection = DriverManager.getConnection(dburl, user, password);
			System.out.println("What order number do you want to see?");
			Integer num = scan.nextInt();
			
			String sql = //sql statement
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}*/

}
