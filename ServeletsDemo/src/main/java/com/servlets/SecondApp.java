package com.servlets;

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondApp
 */
@WebServlet(urlPatterns={"/test","/prem"},loadOnStartup=1)
public class SecondApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("Test servlet loading.....");
	}
	public SecondApp() {
		System.out.println("servlet instantiation");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.getWriter().println("<h1>Demo of HttpServlet ---GET--- method</h1>");
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String Name=request.getParameter("name");
		String EmailID=request.getParameter("email");
		String Number = request.getParameter("number");		
		String [] course=request.getParameterValues("course");
		
		PrintWriter	out=response.getWriter();
		out.println("<html> <head><title> Output Page</title></head>");
		out.println("<body bgcolor='cyan' >");
		out.println("<h1 align='center'>Course details of student ::</h1>");
		out.println("<table border='1' align='center'> <tr><th>Name ::</th>");
		out.println("<td>"+Name+"</td> </tr></br>");
		out.println("<tr><th>Email ::</th><td>"+EmailID+"</td></tr> </br>");
		out.println("<tr> <th>Number ::</th><td>"+Number+"</td></tr>  </br>");
		out.println("<tr> <th>Courses</th>");
		out.println("<td>");
		for (String sub : course) {
			out.println(sub+"</br>");
		}
		out.println("</td>");
		out.println("</td></tr> ");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		System.out.println("--------------------******-------------------");
		System.out.println("Request object implementation class::"+request.getClass().getName());
		System.out.println("Response object implementation class::"+response.getClass().getName());
		System.out.println("current thread HashCode::"+Thread.currentThread().hashCode());
		
		}

}
