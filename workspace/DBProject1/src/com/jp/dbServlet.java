package com.jp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dbServlet")
public class dbServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		dbDAO db = new dbDAO();
		ArrayList<String> table = db.getDbTable();
		System.out.println(table.size());
		out.write("<html>");	
			for (int i=0;i<table.size(); i++){
			
				out.write("<a href=dbTablesServlet?tablename="+table.get(i)+">"+table.get(i)+"<a></br>");
						
			
			}
			
			out.write("</html>");
		}
	}


