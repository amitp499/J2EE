package co.jp;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletLifecycle1")
public class servletLifecycle1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletLifecycle1() {
    	
    	System.out.println("message from constructor");
    }

	@Override 
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("message from init");
	}
	
	@Override
	public void init() {
		System.out.println("message from init without param");
	}

	public void destroy() {
		System.out.println("message from destruy");
	}

	
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("message from do get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("message from do post");
		
	}

}
