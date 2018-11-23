import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

public class NewLoginServlet extends HttpServlet{


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		res.setContentType("text/html");
		String name = req.getParameter("txtName");
		String password = req.getParameter("txtPassword");
		PrintWriter out = res.getWriter();
		if (name.equals("admin")){
			out.println("<h1>valid user</h1>");
		}else{
		out.println("<h1>Invalid user</h1>");
		}

		if (password.equals("admin")){
			out.println("<h1>valid password</h1>");
		}else{
		out.println("<h1>Invalid password</h1>");
		}
		
	}

}