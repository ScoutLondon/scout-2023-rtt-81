package org.perscholas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class PreparedStatementExample {
	
	
	//1. expand output inside the while loop to also print last name
	//2. use scanner to also ask for last name and mod query to search for first and last name
	

	public static void main(String[] args) throws SQLException {
		String dburl = "jdbc:mysql://localhost:3306/classic_models";
		String user = "root";
		String password = "Whatisthis0601!";
		Connection connection = null;
		Scanner scanner = new Scanner (System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // optional
			connection = DriverManager.getConnection(dburl, user, password);
			
			
			System.out.println("Enter an employee first name :");
			String firstname = scanner.nextLine();
			System.out.println("Enter an employee last name");
			String lastname = scanner.nextLine();
			
			//String sql = "Select * FROM employees where firstname = '" + firstname + "'";
			String sql = "SELECT * FROM employees WHERE firstname = ? AND lastname = ?";
			
			
			//Secure way of creating a query
			PreparedStatement stmt = connection.prepareStatement(sql);
			//first ? in the query is position 1
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			
			System.out.println(sql);
			
			//we don't pass in the sql bc we already passed it into prepared statement
			ResultSet result = stmt.executeQuery();
			
			while (result.next()) {
				Integer id = result.getInt("id");
				String name = result.getString("firstname");
				String last = result.getString("lastname");
				String email = result.getString("email");
				System.out.println(id + " | " + name + " | " + last + " | " + email);
			}
			
			result.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}


}
