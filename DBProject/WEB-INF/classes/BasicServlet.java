import javax.servlet.*;
import java.io.*;

public class BasicServlet extends GenericServlet{


	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{

		res.setContentType("text/html");
		res.getWriter().write("<h1>Hello Amit, Welcome to J2EE</h1>");
		res.getWriter().flush();
	}

}