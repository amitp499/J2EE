package com.jp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	
	boolean valUser=false;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("txtName");
		String userPassword = request.getParameter("txtPassword");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	//	out.write("<h1>valid userid and password, userName = </h1>");
	
	dbDAO db = new dbDAO();
	
		if (db.validateUser(userName, userPassword)){
			
			valUser=true;
			//out.write("<h1>valid userid and password </h1>");
			response.sendRedirect("/DBProject1/dbServlet");
		
		
		}else{
			valUser=false;
			out.write("<h1>Invalid userid and password</h1>");
		
		}
		
		
	
	
		
//		if (userName.equals("admin") && userPassword.equals("admin")) {
//			
//			out.write("<h1>valid userid and password, userName = </h1>");
//		}else{
//			out.write("<h1>Invalid userid and password</h1>");
//		}
	}

}
