package com.jp.hr.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.jp.hr.entities.Employee;
import com.jp.hr.entities.UserMaster;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.utilities.ConnectionFactory;
import com.jp.hr.utilities.ConnectionFactoryTomCat;

import oracle.jdbc.pool.OracleDataSource;

public class DaoUserMasterImpl implements  DaoUserMaster{
	
	
	private ConnectionFactory factory;
	private OracleDataSource dataSource;  
	
	
	

	@Override
	public UserMaster getUserDetails(String userId) throws HrException {
		// TODO Auto-generated method stub
		UserMaster umr =null;
		//ArrayList<UserMaster> userList = new ArrayList<>();
		Connection connect = null;
		Statement stmt=null;
		ResultSet rs =null;
		
		try {
			
			 //connect = getConnection();
			factory = ConnectionFactory.getInstance();
			dataSource = factory.getDatasource(); 
			connect = dataSource.getConnection();
			 stmt =connect.createStatement();
			 rs = stmt.executeQuery("Select userid, password, userfullname, userrole from usermaster");
			
			while(rs.next()){
				
				String userid = rs.getString("userid");
				
				if(userId.equals(userid)){
				
					String password = rs.getString("password");					
					String userfullname = rs.getString("userfullname");
					String userrole = rs.getString("userrole");
					
					umr = new UserMaster(userid, password, userfullname,userrole);
					break;
				}
				
				
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new HrException("Issue with fetching user master details", e);
		}
			
			
			
		finally{
			
			try {
				
				if (rs !=null){
				
					rs.close();
				}
				
				if (stmt !=null){
					
					stmt.close();
				}
				
				
				if (connect!=null){
					
					connect.close();
				}
				//factory.closeConnection();
				
			} catch (SQLException e) {
				
				throw new HrException("Issue with closing connetions.", e);
			
			}
		}
		
				
		return umr;
		
	}

}
