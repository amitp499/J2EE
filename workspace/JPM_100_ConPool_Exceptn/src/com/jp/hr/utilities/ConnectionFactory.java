package com.jp.hr.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class ConnectionFactory {

	private Connection connect;
	private static ConnectionFactory connectionfactory=null;
	private OracleDataSource dataSource;
	
	private ConnectionFactory()
	throws ClassNotFoundException, SQLException{
		
		dataSource = new OracleDataSource();
		
		dataSource.setDriverType("thin");
		dataSource.setPortNumber(1521);
		dataSource.setUser("hr");
		dataSource.setPassword("hr");
		dataSource.setServerName("localhost");
		dataSource.setServiceName("orcl");
		
		
		/*String driverName= "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userName="hr";
		String userPassword = "hr";
		
		Class.forName(driverName);
		connect = DriverManager.getConnection(url,userName,userPassword);
		*/	
	}
	
	
	
	public static ConnectionFactory getInstance() throws ClassNotFoundException, SQLException{
		
		if(connectionfactory==null){
						
			connectionfactory = new ConnectionFactory();
		}
		
		return connectionfactory;
	}
	
	
	
	/*public Connection getConnection(){
		
		return connect;
	}*/
	
	public OracleDataSource getDatasource(){
		
		return dataSource;
	}
	
	
	
	/*public void closeConnection() throws SQLException{
		
		connect.close();
	}*/
}
