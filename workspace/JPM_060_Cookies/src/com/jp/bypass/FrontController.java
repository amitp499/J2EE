package com.jp.bypass;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("pg");
		RequestDispatcher dispatch = null;
		Cookie cookie2 = null;
		Cookie[] cookies = null;
		
		switch(page){
											
		case "Welcome" : {
			
			dispatch = request.getRequestDispatcher("/WEB-INF/jsps/Welcome.jsp");
			 cookies = request.getCookies();
			boolean cookieFound =true;
			for(Cookie c : cookies){
				System.out.println(c.getName());
				if (c.getName().trim().equals("c3")){
			
					dispatch = request.getRequestDispatcher("/WEB-INF/jsps/MainMenu.jsp");
					
					break;
				}
				
				
			}
			
/*			if (cookieFound =true){
				dispatch = request.getRequestDispatcher("/WEB-INF/jsps/Welcome.jsp");
				dispatch.forward(request, response);
			}
*/			
			
			dispatch.forward(request, response);
			
			break;
		}
		
		case  "Menu" : {
			
			
			String isBoxVjecked = request.getParameter("ToBypass");			
			
			if(isBoxVjecked!=null){				
				cookie2 = new Cookie("c3", "test");
				cookie2.setMaxAge(120);
				response.addCookie(cookie2);
			}
			
			dispatch = request.getRequestDispatcher("/WEB-INF/jsps/MainMenu.jsp");
			dispatch.forward(request, response);
			break;
		}
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
