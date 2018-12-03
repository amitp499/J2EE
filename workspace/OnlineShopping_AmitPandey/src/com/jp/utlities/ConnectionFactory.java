package com.jp.utlities;

import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class ConnectionFactory {
	
private static ConnectionFactory factory = null;
	
	private OracleDataSource dataSource;
	
	private ConnectionFactory() throws ClassNotFoundException, SQLException{
		
		dataSource = new OracleDataSource();
		
		dataSource.setDriverType("thin");
		dataSource.setPortNumber(1521);
		dataSource.setPassword("hr");		
		dataSource.setUser("hr");
		dataSource.setServerName("localhost");
		dataSource.setServiceName("orcl");
		
	}
	
	
	public static ConnectionFactory getInstance() throws ClassNotFoundException, SQLException{

		if(factory == null){
			
			factory = new ConnectionFactory();
		}
		
		return factory;
		
		
	}
	
	public OracleDataSource getDatasource(){
		
		return dataSource;
	}
	

}
