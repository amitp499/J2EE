package com.jp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowCookies
 */
@WebServlet("/ShowCookies")
public class ShowCookies extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c : cookies){
			
			System.out.println(c.getName()+ " "+c.getValue()+" "+c.getMaxAge() );
			
			
		}
	}

}
