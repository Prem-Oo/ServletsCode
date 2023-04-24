package in.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(
		urlPatterns = { "/test" }, 
		initParams = { 
				@WebInitParam(name = "jdbcURL", value = "jdbc:mysql:///localdb"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "mysql@123")
		})
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request Processing for GET request type....");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body align='center'>");
		out.println("<table border='1'");
		out.println("<tr><th>ParameterName</th><th>ParamterValue</th></tr>");

		javax.servlet.ServletConfig config = getServletConfig();

		Enumeration<String> parameterNames = config.getInitParameterNames();

		// Parameter data which is static
		while (parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			String parameterValue = config.getInitParameter(parameterName);

			out.println("<tr>");
			out.println("<td>" + parameterName + "</td><td>" + parameterValue + "</td>");
			out.println("</tr>");
		}
		// below line accessing other config object (which is not possible)
		out.println("<tr><th>Company</th><th>" + config.getInitParameter("company") + "</th></tr>");
		out.println("</table>");

		out.println("</body>");
		out.println("</html>");

		out.close();

	}

	@Override
	public void destroy() {
		System.out.println("DemoServlet DeInstantiation....");
	}


}
