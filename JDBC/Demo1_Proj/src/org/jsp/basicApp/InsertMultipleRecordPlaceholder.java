package org.jsp.basicApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleRecordPlaceholder {
	public static void main(String[] args) {
		String qry="insert into btm.student values(?,?,?)";
	    Connection con=null;
	    PreparedStatement pstmt=null;
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class is loaded and Registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice?user=root&password=admin");
			System.out.println("Connection Established between the Java application and the Databse Server...!!!");
			pstmt = con.prepareStatement(qry);
			System.out.println("Platform is created...!!!");
			//set the data for the placeholder
			pstmt.setInt(1, 201);
			pstmt.setString(2, "chandu");
			pstmt.setDouble(3, 86.45);
			//execute the sql query
			pstmt.executeUpdate();
			//set the data for the placeholder
			pstmt.setInt(1, 202);
			pstmt.setString(2, "Raghu");
			pstmt.setDouble(3, 76.45);
			//execute the sql query
			pstmt.executeUpdate();
			//set the data for the placeholder
			pstmt.setInt(1, 203);
			pstmt.setString(2, "LakshmiPathi");
			pstmt.setDouble(3, 66.45);
			//execute the sql query
			pstmt.executeUpdate();
			
			System.out.println("Record Inserted...!!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
