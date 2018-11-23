import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

public class LoginServlet extends HttpServlet{


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>Hello Amit, Welcome to J2EE for HTTP Servlet</h1>");
		out.flush();
	}

}