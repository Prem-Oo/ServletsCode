package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServletApp
 */
@WebServlet("/FirstServletApp")
public class FirstServletApp extends GenericServlet {
//	private static final long serialVersionUID = 1L;
//       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServletApp() {
       System.out.println("servlet initilization");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		 System.out.println("servlet instantiation");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("servlet deinitilization");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><head><title>Output</title></head>");
		pw.println("<body>Servlet programs are   easy...</body>");
		pw.println("</html>");
		}

	

}
