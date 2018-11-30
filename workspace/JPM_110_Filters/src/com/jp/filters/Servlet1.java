package com.jp.filters;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/Servlet1.do", loadOnStartup=1) //loadonstartup is used so that servlet i created as soon as filter
public class Servlet1 extends HttpServlet {
	

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in servlet");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsps/MyJSP1.jsp");
		dispatch.include(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("servlet1 in destroy");
		super.destroy();
	}


	@Override
	public void init() throws ServletException {
		
		super.init();
		System.out.println("servlet1 init");
	}



}
