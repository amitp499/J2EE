package com.jp.hr.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jp.hr.entities.Employee;
import com.jp.hr.entities.UserMaster;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;
import com.jp.hr.services.ServiceEmployeeImpl;

@WebServlet("*.do")  //a generic URL
public class FrontController extends HttpServlet {
	
	private ServiceEmployee services;
	
	@Override
	public void init() throws ServletException {
		try{
			services = new ServiceEmployeeImpl();
			
		}catch( HrException e){
			
			throw new ServletException("Hr Exception",e);
		}
		
		
	}
	

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = getCommand(request.getRequestURI());
		
		RequestDispatcher dispatch=null;
		String jspName=null;
		String preFix = "/WEB-INF/jsps/";
		String postFix = ".jsp";
		
		try {
		
		switch (command){
		
		case "*": 
		case "Home":{
			
			jspName="Home";
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
			jspName="ThanksPage";
			break;
		}
		
		case "Authenticate":{
			boolean userfound = false;
			String userName = request.getParameter("txtUsername");
			String password = request.getParameter("txtPassword");
			
			UserMaster um = services.getUserDetails(userName,password);
			
			if(um!=null){
				
				String userFullName= um.getUserFullName();
				HttpSession session = request.getSession();
				session.setAttribute("userFullName", userFullName);
				//session.setAttribute("userFullName", userFullName);
				jspName="mainMenu";
			}else{
				
				String msg = "Inccorect Credential";
				request.setAttribute("message", msg);
				jspName="Login";
			}
			
			
			
			/*if ((userName.equals("a")) && (password.equals(password))){
				
				String userFullName= "Amit Pandey";
				HttpSession session = request.getSession();
				session.setAttribute("userFullName", userFullName);
				//session.setAttribute("userFullName", userFullName);
				jspName="mainMenu";
				
			}else{
				
				String msg = "Inccorect Credential";
				request.setAttribute("message", msg);
				jspName="Login";
				
			}*/
			
				
			
			break;
		}
		
			
		case "mainMenu":{
			
				jspName="mainMenu";
				break;
		}
		
		case "empList": {
			
				ArrayList<Employee> empList;
								
					empList = services.getEmpList();
					
					//System.out.println(empList);
					
					request.setAttribute("empList", empList);
					
					jspName = "EmpList";
					
				
				break;
			}
		
			case "empDetails": {
				
					String idStr = request.getParameter("id");  //empDetails.do?id=x
					
					int empId = Integer.parseInt(idStr);
								
					Employee emp = services.getEmpDetails(empId);
					
					//System.out.println(empList);
					
					request.setAttribute("empDetails", emp);
					
					//RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsps/EmpList.jsp");
					jspName = "empDetails";
					
				//dispatch.forward(request, response);
					break;
				
			}
			
			case "newJoining": {
				
				
				jspName = "newJoining";
						
				break;
			
			}
			
			
			case "submitJoinee": {
				
				//String empIdStr = request.getParameter("empId");
				String firstNameStr = request.getParameter("firstName");
				String lastNameStr = request.getParameter("lastName");
				//int empIdc = Integer.parseInt(empIdStr);
				
				//Employee emp = new Employee(empIdc,firstNameStr, lastNameStr );
				Employee emp = new Employee(firstNameStr, lastNameStr );
				
				boolean isSuccessFull = services.addNewEmp(emp);
				
				String msg=isSuccessFull?"Employee Added":"Insertion Failed";
				
				request.setAttribute("message", msg);								
				jspName = "newJoining";
				break;
			
				}
		
		} 
		
			}catch (HrException e) {
				
				//request.setAttribute("msg", e.getMessage()); //--another way to display error page on exception
				throw new ServletException(e);
				//jspName="Errors";
			}
		
		 dispatch = request.getRequestDispatcher(preFix+jspName+postFix);
		 dispatch.forward(request, response);
		}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	
	private String getCommand(String uri){
		
		int leftPosi = uri.lastIndexOf("/");
		int rtPosi = uri.lastIndexOf(".");
		
		if(rtPosi<=leftPosi){
			
			return "Home";
			
		}else{
			
			return uri.substring(leftPosi+1, rtPosi);
		}
		
		
	}

}
