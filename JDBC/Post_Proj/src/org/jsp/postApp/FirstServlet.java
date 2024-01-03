package org.jsp.postApp;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	//Fetch UI/Form Data
	    String sid=req.getParameter("i");
	    int id=Integer.parseInt(sid);
	    String name=req.getParameter("nm");
	    String dept=req.getParameter("dp");
	    String sperc=req.getParameter("pr");
	    double perc=Double.parseDouble(sperc);
	    //Presentation Logic/Servlet Technology
	    PrintWriter out=resp.getWriter();
	    out.println("<html><body bgcolor='orange'>"+"<h1>Student name is "+name+" from "+dept+"</h1>"+"</body></html>");
	    out.close();
	    //Persistence Logic/JDBC Technology
	    Connection con=null;
	    PreparedStatement pstmt=null;
	    String qry="Insert into btm1.student values(?,?,?,?)";//DML
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			//Set the Data for the placeholder
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, dept);
			pstmt.setDouble(4, perc);
			//Execute the SQL Query
			pstmt.executeUpdate();
			System.out.println("Record Inserted!!");
		} 
	    catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	    finally {
	    	if(pstmt!=null) {
	    		try {
	    			pstmt.close();
	    		}
	    		catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    	if(con!=null) {
	    		try {
	    			con.close();
	    		}
	    		catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
    }  
  
}
