package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BrowserResponseApp
 */
@WebServlet(urlPatterns={"/test2"},loadOnStartup=5)
public class BrowserResponseApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Test2 servlet loading.....");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Enumeration<String> headerNames=request.getHeaderNames();
		out.println("<html><head><title>Output</title> </head>");
		out.println("<body>");
		out.println("<table border='1' align='center'>");
		out.println("<tr> <th>Header Name</th><th>Header Value</th>  </tr>");
		while(headerNames.hasMoreElements()) {
			out.println("<tr>");
			String headerName=(String)headerNames.nextElement();
			String headerValue=request.getHeader(headerName);
			out.println("<td>" +headerName+ "</td><td>"+ headerValue+ "</td>");
			out.println("</tr>");
		}
		out.println("<tr> <th></th><td></td>   </tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();		
		}

}
