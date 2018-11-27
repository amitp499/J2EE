package com.jp.hr.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

public class DaoEmployeeImpl implements DaoEmployee{
	
	

	private Connection getConnection() 
			throws ClassNotFoundException, SQLException {
		
		String driverName= "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userName="hr";
		String userPassword = "hr";
		
		Class.forName(driverName);
		return DriverManager.getConnection(url,userName,userPassword);			
		
	}
	
	private void closeConnection(Connection connect) throws SQLException{
		
		connect.close();
	}
	
	
	
	@Override
	public ArrayList<Employee> getEmpList() throws HrException {
		
		ArrayList<Employee> empList = new ArrayList<>();
		Connection connect = null;
		Statement stmt=null;
		ResultSet rs =null;
		
		try {
			
			 connect = getConnection();
			 stmt =connect.createStatement();
			 rs = stmt.executeQuery("Select employee_id,first_name, last_name from Employees");
			
			while(rs.next()){
				
				int empId = rs.getInt("employee_id");
				String firstNm = rs.getString("first_name");
				String lastNm = rs.getString("last_name");
				
				empList.add(new Employee(empId, firstNm, lastNm));
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new HrException("Issue with fetching.", e);
		}
			
			
			
		finally{
			
			try {
				
				rs.close();
				stmt.close();
				closeConnection(connect);
				
			} catch (SQLException e) {
				
				throw new HrException("Issue with closing connetions.", e);
			
			}
		}
		
				
		return empList;
	}

	
	
}
