package org.jsp.basicApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginPassword {
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter name:");
	    String name=sc.next();
	    System.out.println("Enter password:");
	    String password=sc.next();
	    String qry="select username from btm.student1 where username=? and password=?";
	    Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice?user=root&password=admin");
			pstmt = con.prepareStatement(qry);
			//set the data for the placeholder
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			//execute
		    rs=pstmt.executeQuery();
		    if(rs.next()) {
		       String username=rs.getString(1);
		       System.out.println("Welcome..."+username);
            }
		    else {
		    	System.out.println("Invalid name/password");
		    }
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		}
   }
}
