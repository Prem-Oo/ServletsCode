package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoRequest
 */
@WebServlet(urlPatterns={"/DemoRequest"},loadOnStartup=5)
public class DemoRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("DemoRequest servlet loading...");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Demo of GET method and request::");
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		System.out.println("Client IP address ::"+request.getRemoteAddr());
		System.out.println("Client Host name ::"+request.getRemoteHost());
		System.out.println("Client Port number ::"+request.getRemotePort());
		System.out.println("Server name ::"+request.getServerName());
		System.out.println("Server port ::"+request.getServerPort());
		
	}

}
