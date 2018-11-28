package com.jp.product.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp.product.entities.Product;
import com.jp.product.exceptions.ProductException;
import com.jp.product.service.ProductService;
import com.jp.product.service.ProductServiceImpl;

/**
 * Servlet implementation class StartPoint
 */
@WebServlet("*.net")  //a generic URL
public class StartPoint extends HttpServlet {
	
	private ProductService service;
	
	public void init() throws ServletException {
		
		service = new ProductServiceImpl();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = getCommand(request.getRequestURI());
		RequestDispatcher dispatcher = null;
		String jspName = null;
		String prefixU = "/WEB-INF/jsps/";
		String postfixU = ".jsp";
		
		try {
			switch(command){
			
			case "*":
				
			case "mainMenu":{
			
				jspName="MainMenu";
				
				break;
			}
			
			case "productList":{
					
				ArrayList<Product> pList = new ArrayList<>();
				
				
				pList = service.listOfProducts();
				
				request.setAttribute("productList", pList);
				
				jspName = "productList";
				
				break;
					
				}
			
			case "ProductDetail":{
				
				String idStr = request.getParameter("id");
				
				int pId = Integer.parseInt(idStr);
				
				Product prd = service.detailsOfProducts(pId);
				
				
				request.setAttribute("productDetail", prd);
				
				jspName = "productDetail";
				
				break;
					
				}
		
			
			}
			
			
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dispatcher = request.getRequestDispatcher(prefixU+jspName+postfixU);
		dispatcher.forward(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
private String getCommand(String uri){
		
		int leftPosi = uri.lastIndexOf("/");
		int rtPosi = uri.lastIndexOf(".");
		
		if(rtPosi<=leftPosi){
			
			return "mainMenu";
			
		}else{
			
			return uri.substring(leftPosi+1, rtPosi);
		}
		
		
	}

}
