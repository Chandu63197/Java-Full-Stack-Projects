package org.jsp.basicApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchingAllRecords {
	public static void main(String[] args) {
		String qry="select * from btm.student";
	    Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice?user=root&password=admin");
			pstmt = con.prepareStatement(qry);
		    rs=pstmt.executeQuery();
		    while(rs.next()) {
               int id=rs.getInt(1);
               String name=rs.getString(2);
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
