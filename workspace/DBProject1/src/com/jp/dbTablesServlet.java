package com.jp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dbTablesServlet
 */
@WebServlet("/dbTablesServlet")
public class dbTablesServlet extends HttpServlet {
	
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
			
			response.setContentType("text/html");					
			PrintWriter out = response.getWriter();
			dbDAO db = new dbDAO();
			String tablename = request.getParameter("tablename");
			ResultSet rss = db.getTableData(tablename);
			ResultSetMetaData rsmd = rss.getMetaData();
			int colcount = rsmd.getColumnCount();
			out.println("<table border=2>");
			while(rss.next()){
				out.println("<tr>");
				for(int i=1; i<=colcount;i++){
					
					out.println("<td>");
					out.println(rss.getString(i));
					out.println("</td>");					
				}
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
