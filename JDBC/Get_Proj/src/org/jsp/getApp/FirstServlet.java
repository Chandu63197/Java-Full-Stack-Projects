package org.jsp.getApp;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String sid=req.getParameter("i");
       int id=Integer.parseInt(sid);
       String qry="select * from btm1.student where id=?";
       Connection con=null;
       PreparedStatement pstmt=null;
       ResultSet rs=null;
       try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		pstmt=con.prepareStatement(qry);
		pstmt.setInt(1, id);
		rs=pstmt.executeQuery();
		PrintWriter out=resp.getWriter();
		System.out.println("doget method executed");
		if(rs.next()) {
			String name=rs.getString(2);
			String dept=rs.getString(3);
			out.println("<html><body bgcolor='orange'>"+"<h1>Student name is "+name+" from "+dept+"</h1>"+"</body></html>");
			out.close();
		}
		else {
			out.println("<html><body bgcolor='orange'>"+"<h1>No data found</h1>"+"</body></html>");
		}
 	   } 
       catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	   }
       finally {
    	   if(rs!=null) {
    		   try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	   }
    	   if(pstmt!=null) {
    		   try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	   }
    	   if(con!=null) {
    		   try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	   }
       }
	}
}
