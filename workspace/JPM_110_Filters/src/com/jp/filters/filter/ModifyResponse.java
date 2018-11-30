package com.jp.filters.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ModifyResponse
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					//,urlPatterns={"/Servlet1","/Servlet2"})
,urlPatterns={"*.do"})
public class ModifyResponse implements Filter {

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//befre part		
		System.out.println("before part of filters MR");
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsps/head.jsp");
		dispatch.include(request, response);
		
		
		chain.doFilter(request, response);
		
		
		RequestDispatcher dispatch1 = request.getRequestDispatcher("/WEB-INF/jsps/footer.jsp");
		dispatch1.include(request, response);
		System.out.println("after part of filters MR");
		//after pasrt
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Lifecycle method for filetr to do initilization
		
		System.out.println("In filters MR init");
	}
	
	public void destroy() {
		
		System.out.println("MR In Destroy");
	}

}
