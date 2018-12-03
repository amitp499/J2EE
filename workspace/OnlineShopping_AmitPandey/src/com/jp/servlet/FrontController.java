package com.jp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jp.entities.Product;
import com.jp.services.ProductService;
import com.jp.services.ProductServiceImpl;

import jp.com.exception.ProductException;



@WebServlet("*.do")  //a generic URL
public class FrontController extends HttpServlet {
	
	private ProductService service;
	
	public void init() throws ServletException {
		
		try {
			
			service = new ProductServiceImpl();
			
		} catch (ProductException e) {
			
			
			throw new ServletException("Product Exception",e);
		}
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
				
			case "Welcome":{
				
				
				jspName="Welcome";
								
				
				break;
			}
			
							
			case "productList":{
					
				ArrayList<Product> pList = new ArrayList<>();
				
				
				pList = service.listOfProducts();
				
				request.setAttribute("productList", pList);
				
				jspName = "ItemList";
				
				break;
					
				}
			
			case "ProductDetail":{
				
				String idStr = request.getParameter("id");
				
				//int pId = Integer.parseInt(idStr);
				
				Product prd = service.detailsOfProducts(idStr);
				
				
				request.setAttribute("productDetail", prd);
				
				jspName = "ItemDetails";
				
				break;
					
				}
			
			case "AddToCart":{
				
				HttpSession session = request.getSession();
				String idStr = request.getParameter("id");
				Product prd = service.detailsOfProducts(idStr);
				//ArrayList<Product> cartArray = new ArrayList<>();
				
				ArrayList<Product> cartArray = (ArrayList<Product>)session.getAttribute("CartArray"); ///existing item 
				
				if (cartArray==null){
					cartArray = new ArrayList<>();
					session.setAttribute("CartArray", cartArray);
				}
				//cartArray.add(prd);
				cartArray.add(prd);
				
				
				
				
				//int pId = Integer.parseInt(idStr);
				
				
				
				jspName = "Cart";
				
				break;
					
				}
			
			case "PlaceOrder":{
				
				
				String idStr = request.getParameter("id");
				int customerId = 1026;
				
				String ff = idStr.replace(";null", "");
				String idar[] = ff.split(";");
				
				
				boolean orderSuccess=false;
				String reportFlag="";
				for(int i=0; i<idar.length;i++){
					
					orderSuccess = service.placeOrder(idar[i],customerId);
					
					if(orderSuccess==true){
						
						reportFlag=reportFlag+";true";
					}else{
						reportFlag=reportFlag+";false";
					}
				}
				
				String reportmsg[] = reportFlag.split(";");
				
				boolean sendReport = true;
				for (int j=0; j<reportmsg.length;j++){
					
					if(reportmsg[j]=="false"){
						//String message = "Order Placing Failed";
						sendReport = false;
					}
				}
				
				
				
				String message = sendReport?"Order Placed Successfully":"Order Placing Failed";
				
				request.setAttribute("message", message);
				//int pId = Integer.parseInt(idStr);
				
				
				
				jspName = "OrderStatus";
				
				HttpSession session = request.getSession();
				session.invalidate();
				
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
			
			return "Welcome";
			
		}else{
			
			return uri.substring(leftPosi+1, rtPosi);
		}
		

}
	
}
