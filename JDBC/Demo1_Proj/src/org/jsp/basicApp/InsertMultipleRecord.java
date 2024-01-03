package org.jsp.basicApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleRecord {
	public static void main(String[] args) {
		String qry="insert into btm.student values(4,'kiran',60.45)";
		String qry1="insert into btm.student values(5,'chinna',60.45)";
		String qry2="insert into btm.student values(6,'cbn',60.45)";
	    Connection con=null;
	    Statement st=null;
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class is loaded and Registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice?user=root&password=admin");
			System.out.println("Connection Established between the Java application and the Databse Server...!!!");
			st = con.createStatement();
			System.out.println("Platform is created...!!!");
			st.executeUpdate(qry);
			st.executeUpdate(qry1);
			st.executeUpdate(qry2);
			System.out.println("Record Inserted...!!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
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
