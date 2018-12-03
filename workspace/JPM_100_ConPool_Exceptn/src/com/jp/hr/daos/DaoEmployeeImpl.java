package com.jp.hr.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

/*
 * The database specific entities must not come out of the class (like exception)
 * Each and every resource (Connection, Statement, Resultset) must be closed properly before comming out
 */

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.utilities.ConnectionFactory;
import com.jp.hr.utilities.ConnectionFactoryTomCat;

public class DaoEmployeeImpl implements DaoEmployee{
	
	private ConnectionFactory factory;    //oracle data source
	//private ConnectionFactoryTomCat factory;
	private DataSource dataSource;   //DataSource is an interface , Connection pool example
	
	
	public DaoEmployeeImpl() throws HrException{
		
		try {
			
			factory = ConnectionFactory.getInstance(); //oracle data source
			
			//factory = ConnectionFactoryTomCat.getInstance();
			
			dataSource = factory.getDatasource();
			
						
		} catch (Exception e) {
			
			throw new HrException("Issue in getting connection from Factory.", e);
		} 
	}
	

	/*private Connection getConnection() 
			throws ClassNotFoundException, SQLException {
		
		String driverName= "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userName="hr";
		String userPassword = "hr";
		
		Class.forName(driverName);
		return DriverManager.getConnection(url,userName,userPassword);		
		
		
		
	}*/
	
	
	
	public Employee getEmpDetails(int empId) throws HrException{
		
		
		Connection connect = null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		try {
			
				String qry = "Select empid,firstname, lastname from emp where empid = ?";
			// connect = getConnection();
				//connect = factory.getConnection();
				connect = dataSource.getConnection();
			 
			 stmt =connect.prepareStatement(qry);
			 stmt.setInt(1, empId);
			 rs = stmt.executeQuery();
			
			if(rs.next()){
				
				
				String firstNm = rs.getString("firstname");
				String lastNm = rs.getString("lastname");
				
				return new Employee(empId, firstNm, lastNm);
			}else{
				//Id is wrong
				
				return null;
			}
			
			
		} catch (SQLException e) {
			
			throw new HrException("Issue with fetching.", e);
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
				}connect.close();
				//factory.closeConnection();
				
			} catch (SQLException e) {
				
				throw new HrException("Issue with closing connetions.", e);
			
			}
		}
		
				
		
		
		
	}
	
	
	
	@Override
	public ArrayList<Employee> getEmpList() throws HrException {
		
		ArrayList<Employee> empList = new ArrayList<>();
		Connection connect = null;
		Statement stmt=null;
		ResultSet rs =null;
		
		try {
			
			 //connect = getConnection();
			connect = dataSource.getConnection();
			 stmt = connect.createStatement();
			 rs = stmt.executeQuery("Select empid,firstname, lastname from emp");
			
			while(rs.next()){
				
				int empId = rs.getInt("empid");
				String firstNm = rs.getString("firstname");
				String lastNm = rs.getString("lastname");
				
				empList.add(new Employee(empId, firstNm, lastNm));
			}
			
			
		} catch (SQLException e) {
			
			throw new HrException("Issue with fetching.", e);
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
		
				
		return empList;
	}

	@Override
	public boolean insertNewRecord(Employee emp) throws HrException {
		Connection connect = null;
		PreparedStatement stmt=null;
		
		
		try {
			
				String qry = "Insert into  emp(empid, firstname, lastname) values (seqPID.nextval,?,?) "; //oracle squence
				//String qry = "Insert into  emp(empid, firstname, lastname) values (?,?,?) ";   //without oracle sequence
			 //connect = getConnection();
				connect = dataSource.getConnection();
			 
			 stmt =connect.prepareStatement(qry);
			 //stmt.setInt(1, emp.getEmpId()); //implementation of oracle sequence
			 stmt.setString(1, emp.getFirstName());
			 stmt.setString(2, emp.getLastName());
			 
			 int recInserted = stmt.executeUpdate();
			 return recInserted==1?true:false;
			 				
			
		} catch (SQLException e) {
			
			throw new HrException("Issue with fetching.", e);
		}
			
			
			
		finally{
			
			try {
				
				
				
				if (stmt !=null){
					
					stmt.close();
				}
				
				
				//factory.closeConnection();
				
				if (connect!=null){
					
					connect.close();
				}
				
				
			} catch (SQLException e) {
				
				throw new HrException("Issue with closing connetions.", e);
			
			}
		}
		
				
		
		
		
		
	}

	

	/*@Override -- no more need post implementing connection pool
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		//factory.closeConnection();
		super.finalize();
	}*/

	
	
}
