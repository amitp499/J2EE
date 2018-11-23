package com.jp;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class dbDAO {
	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement Stmt =null;
	
	
	public  dbDAO(){
		
		try{
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");			
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	
	public boolean validateUser(String userName, String password){
		boolean fflag=false;
		String sql = "Select count(*) from Employees where First_Name=? and Last_Name=?";
		
		try{
			
			Stmt = con.prepareStatement(sql);	
			
			Stmt.setString(1,userName);
			
			Stmt.setString(2,password);
			
			rs = Stmt.executeQuery();
			
			rs.next();
			
			int rcount = rs.getInt(1);
			
			
			if (rcount==1)
		
				return  fflag=true;
								
		
			rs.close();
			con.close();
			
		}catch(SQLException ex){
			
			ex.printStackTrace();
			
		}
		
		return fflag;
			
	}
	
	
	public ArrayList<String> getDbTable(){
		
	ArrayList<String> dbTables = new ArrayList<>();
	try{
		
		DatabaseMetaData dbmd = con.getMetaData();
		rs = dbmd.getTables(null, null, null, new String[] {"TABLE","VIEW"});
		
		while (rs.next()){
			
			dbTables.add(rs.getString(3));
		}
		
		rs.close();
		con.close();
		
		
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	return dbTables;
		
	}
	
	public ResultSet getTableData(String tableName){
		
		String qry = "Select * from "+tableName;
		
		try {
			Stmt = con.prepareStatement(qry);
			
				rs = Stmt.executeQuery();
				
				//ResultSetMetaData rsMd = rs.getMetaData();
				
			
			//rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
				
		return rs;
		
		
		
	}
	

}
