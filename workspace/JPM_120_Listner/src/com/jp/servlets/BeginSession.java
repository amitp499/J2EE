package com.jp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BeginSession
 */
@WebServlet("/BeginSession")
public class BeginSession extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		/*
		 * getSession(): if session exist: bring the reference of the session.
		 * getSession(t) : otherwise create a new session
		 * getSession(f) : if the session exist get the reference otherwise return null
		 */
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsps/MyServlet.jsp");
		
		dispatch.forward(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
