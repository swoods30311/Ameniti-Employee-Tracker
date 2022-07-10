package com.sandywoods.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestAmenEmployeeJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/amen_employee_tracker?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String user = "amenemployee";
		String pass = "amenemployee";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
