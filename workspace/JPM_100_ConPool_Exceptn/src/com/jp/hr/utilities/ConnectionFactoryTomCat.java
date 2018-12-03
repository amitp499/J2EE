package com.jp.hr.utilities;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.jp.hr.exceptions.HrException;



public class ConnectionFactoryTomCat {

	
	private static ConnectionFactoryTomCat connectionfactory=null;
	private DataSource ds = null;
	
	
	private ConnectionFactoryTomCat() throws HrException{
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			 ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException e) {
			
			throw new HrException("Problem in connecting to JNDI",e);
		}
		
	}
	
	
	public static ConnectionFactoryTomCat getInstance() throws HrException {
		
		if(connectionfactory==null){
						
			connectionfactory = new ConnectionFactoryTomCat();
		}
		
		return connectionfactory;
	}
	
	public DataSource getDatasource(){
		
		return ds;
	}
	
	/*public Connection getConnection(){
		
		return connect;
	}*/
}


