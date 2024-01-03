package org.jsp.basicApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchPlaceholderName {
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter name:");
	    String name=sc.next();
	    String qry="select * from btm.student where name=?";
	    Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice?user=root&password=admin");
			pstmt = con.prepareStatement(qry);
			//only consider one for all the fields
			pstmt.setString(1, name);
		    rs=pstmt.executeQuery();
		    while(rs.next()) {
               int  id=rs.getInt(1);
               double perc=rs.getDouble(3);
               System.out.println(id);
               System.out.println(name);
               System.out.println(perc);
               System.out.println("-----*****-----");
		    }
			System.out.println("Fetched all the records...!!!");
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
