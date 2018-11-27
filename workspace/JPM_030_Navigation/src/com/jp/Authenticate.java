package com.jp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String uName = request.getParameter("txtUsername");
			String uPassword = request.getParameter("txtPassword");
			
			RequestDispatcher dispatch = null;
			
			if ((uName.equals("a")) && (uPassword.equals("b"))){
				
				dispatch = request.getRequestDispatcher("WEB-INF/jsps/MainMenu.jsp");
				
			}else{
				
				String message = "Invalid Username and Password, Please try again";
				request.setAttribute("message", message);
				dispatch = request.getRequestDispatcher("/WEB-INF/jsps/Login.jsp");
			}
			
			dispatch.forward(request, response);
	}

}
