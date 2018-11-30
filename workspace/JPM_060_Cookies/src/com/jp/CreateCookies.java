package com.jp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCookies
 */
@WebServlet("/CreateCookies")
public class CreateCookies extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("c1", "Itsasessioncookie");
		Cookie cookie2 = new Cookie("c2", "Itsapersistenetcookie");
		
		cookie2.setMaxAge(120);  //in seconds
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		response.sendRedirect("ShowCookies");
	}

}
