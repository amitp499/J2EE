package com.jp.product.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;


public class OracleConnectionFactory {

	private static OracleConnectionFactory factory = null;
	
	private OracleDataSource dataSource;
	
	private OracleConnectionFactory() throws ClassNotFoundException, SQLException{
		
		dataSource = new OracleDataSource();
		
		dataSource.setDriverType("thin");
		dataSource.setPortNumber(1521);
		dataSource.setPassword("hr");		
		dataSource.setUser("hr");
		dataSource.setServerName("localhost");
		dataSource.setServiceName("orcl");
		
	}
	
	
	public static OracleConnectionFactory getInstance() throws ClassNotFoundException, SQLException{

		if(factory != null){
			
			factory = new OracleConnectionFactory();
		}
		
		return factory;
		
		
	}
	
	public OracleDataSource getDatasource(){
		
		return dataSource;
	}
	
	
}
