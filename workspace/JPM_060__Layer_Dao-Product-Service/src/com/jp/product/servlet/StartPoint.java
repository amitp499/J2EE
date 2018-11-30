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
import javax.servlet.http.HttpSession;

import com.jp.product.entities.Product;
import com.jp.product.exceptions.ProductException;
import com.jp.product.service.ProductService;
import com.jp.product.service.ProductServiceImpl;


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
				
			case "Welcome":{
				
				jspName="Welcome";
				
				break;
			}
			
			case "Login":{
				
				jspName="Login";
				
				break;
			}
			
			case "Logout":{
				
				HttpSession session = request.getSession();
				request.setAttribute("userFullName", session.getAttribute("userFullName"));
				session.invalidate();
				
				jspName="Logout";
				
				break;
			}
			
			case "Authenticate":{
				
				String userName = request.getParameter("txtUsername");
				
				String passowrd = request.getParameter("txtPassword");
				
				if (userName.equals("a") && passowrd.equals("a")){
					
					String userFullName= "Amit Pandey";
					
					HttpSession session = request.getSession();
					
					session.setAttribute("userFullName", userFullName);
					
					jspName="MainMenu";
					
				}else{
					
					jspName="Login";
					
					String msg = "Invalid UserName/Password";
					request.setAttribute("message", msg);
					
					jspName="Login";
					
				}
				
								
				break;
			}
				
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
				
				jspName = "productDetails";
				
				break;
					
				}
			
			case "deleteProduct":{
				
				String idStr = request.getParameter("id");
				
				int pId = Integer.parseInt(idStr);
				
				boolean delscuccess = service.deleteProducts(pId);
				
				String msg = delscuccess?"Product Deleted Successfully":"Product Deletion Failed";
				
				request.setAttribute("message", msg);												
				
				jspName = "deleteResp";
				
				break;
					
				}
			
			case "updateProduct":{
				
				String idStr = request.getParameter("id");
				String pNameStr = request.getParameter("pName");
				String pTypeStr = request.getParameter("pType");
				
				int pId = Integer.parseInt(idStr);
				
				request.setAttribute("pIdmsg", pId );
				request.setAttribute("pNameStrmsg", pNameStr);
				request.setAttribute("pTypeStrmsg", pTypeStr);
				
				
				
				
				
				jspName = "UpdateProduct";
				
				break;
					
				}
			
			case "EditSubmit":{
				
				String idStr = request.getParameter("pId");
				String pNameStr = request.getParameter("pName");
				String pTypeStr = request.getParameter("pType");
				
				int pId = Integer.parseInt(idStr);
				
				
				boolean editscuccess = service.editProducts(pId, pNameStr, pTypeStr);
				
				String msg = editscuccess?"Product Edited Successfully":"Product Edition Failed";
				
				request.setAttribute("message", msg);
				
				
				jspName = "UpdateProduct";
			
			break;
			
		}
			
			case "AddProduct":{
				
					jspName = "addProduct";
				
				break;
				
			}
			
			case "SubmitProduct":{
				
				String idStr = request.getParameter("pId");
				String nameStr = request.getParameter("pName");
				String typeStr = request.getParameter("pType");
				
				int pId = Integer.parseInt(idStr);
				
				Product ppd = new Product(pId, nameStr, typeStr);
				boolean isCreated   = service.addNewProducts(ppd);	
											
				jspName = "addProduct";
				
				String msg = isCreated?"Product Added Successfully":"Product Addition Failed";
				
				request.setAttribute("message", msg);
				
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
