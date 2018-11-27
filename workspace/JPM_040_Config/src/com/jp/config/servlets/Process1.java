package com.jp.config.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns={"/process1", "/process2"},
initParams={@WebInitParam(name="pageHead", value="Employee List"), @WebInitParam(name="footHead", value="Contact Details")}
)
public class Process1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Withing Process1");
		
		ServletConfig sc = super.getServletConfig();
		System.out.println(sc.getInitParameter("pageHead"));
		System.out.println(sc.getInitParameter("footHead"));
		
		
		
		
		
	}

}
