package org.jsp.lifecyclelos1App;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = "/fs",loadOnStartup = 0)
public class FirstServlet1 extends GenericServlet 
{
	   public FirstServlet1() {
	 	   System.out.println("Servlet Object is created!!");
	   }
	   @Override
	   public void init(ServletConfig config) throws ServletException {
		   System.out.println("Servlet Object is initialized");
	   }
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
		   System.out.println("Service() is executed!!");
	   }
	   @Override
	   public void destroy() {
	       System.out.println("Closed all the costly resources!!");
	   }   
}
