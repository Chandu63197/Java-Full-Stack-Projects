package org.jsp.ui1App;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/fs")
public class FirstServlet1 extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException
	{
		        //Fetch UI/Form Data
				String name=req.getParameter("nm");
				String place=req.getParameter("pl");
				//Presentation Logic
				PrintWriter out=resp.getWriter();
				out.println("<html><body bgcolor='orange'>"
				+"<h1>Student name is "+name+" from "+place+"</h1>"
						+"</body></html>");
				out.close();
	}
}
