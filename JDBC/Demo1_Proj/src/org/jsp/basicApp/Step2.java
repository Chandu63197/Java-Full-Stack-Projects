package org.jsp.basicApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Step2 {
	public static void main(String[] args) {
	    Connection con=null;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class is loaded and Registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice?user=root&password=admin");
			System.out.println("Connection Established between the Java application and the Databse Server...!!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Closed all costly resources");
		}
	}

}
