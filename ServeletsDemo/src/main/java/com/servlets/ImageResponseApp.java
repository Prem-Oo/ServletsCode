package com.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageResponseApp
 */
@WebServlet("/ImageResponseApp")
public class ImageResponseApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("ImageResponse servlet loading...");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		ServletOutputStream	os=response.getOutputStream();
		
		String path=getServletContext().getRealPath("bc.jpeg");
		
//		File f=new File("/Users/PR20385670/eclipse-workspace-new/ServeletsDemo/bc.jpeg");   //  OR
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		
		byte[] b=new byte[(int)f.length()];
		fis.read(b);    //  reading img data into byte array
		os.write(b); 	// writting data out from byte array
		os.flush();
		
		fis.close();
		os.close();
	}

}
