package com.jp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AfterLogin
 * cookie :JSESSION
 * URL reqriting
 * Hidden Field
 */
@WebServlet("/afterLogin")
public class AfterLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//create a session
		
		HttpSession session = request.getSession(); //doest not create session if already exist
		
		System.out.println("After Login : "+session.getId());
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsps/MainMenu.jsp");
		dispatch.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
