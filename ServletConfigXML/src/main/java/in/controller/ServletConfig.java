package in.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet(/demo)
 */
public class ServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("DemoServlet loading.....");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("DemoServlet Initialization...");
	}

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
