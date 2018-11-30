package com.jp.listener.listen;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class CountForLiveSessions implements HttpSessionListener {

    
    public CountForLiveSessions() {
       
    	System.out.println("Listner Created");
    }

	
    public void sessionCreated(HttpSessionEvent arg0)  {
    	
    	System.out.println("Session Created");
    	
    	HttpSession session = arg0.getSession();
    	session.setAttribute("cart", "cart");
       
    }

	
    public void sessionDestroyed(HttpSessionEvent arg0)  {
    	
    	System.out.println("Session Destroyed");
       
    }
	
}
