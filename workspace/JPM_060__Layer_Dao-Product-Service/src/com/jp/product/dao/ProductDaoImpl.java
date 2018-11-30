package com.jp.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jp.product.entities.Product;
import com.jp.product.exceptions.ProductException;
import com.jp.product.utilities.OracleConnectionFactory;

import oracle.jdbc.pool.OracleDataSource;

public class ProductDaoImpl implements ProductDao {
	
	
	private OracleConnectionFactory factory;
	private OracleDataSource dataSource;
	
	
	public ProductDaoImpl() throws ProductException{
		
		try {
			factory = OracleConnectionFactory.getInstance();
			
			dataSource = factory.getDatasource();
			
		} catch (Exception e) {
			throw new ProductException("Issue in getting connection from factory",e);
		}
		
		
	}
	
	
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
	public ArrayList<Product> getListOfProducts() throws ProductException {
		
		ArrayList<Product> prd = new ArrayList<>(); 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs= stmt.executeQuery("Select pid, pname, ptype from product");
			
			while(rs.next()){
				
				int apid =  rs.getInt("pid");
				String apname =  rs.getString("pname");
				String aptype =  rs.getString("ptype");				
				prd.add(new Product(apid, apname, aptype));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ProductException("Issue in fetching record",e);
		}finally{
			
			
				try {
					
					if(rs !=null){
					rs.close();
					}
					
					if(stmt !=null){
						stmt.close();
					}
					
					if(con !=null){
						
						con.close();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new ProductException("Issue in closing connection",e);
				}				
			}
		
		
		
		return prd;
		
	}

	@Override
	public Product getProductDetails(int pId) throws ProductException {
		
		String qry = "Select pid, pname, ptype from product where pid=?";
		 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			
			stmt = con.prepareStatement(qry);
			stmt.setInt(1, pId);
			rs= stmt.executeQuery();
			
			if(rs.next()){
				
				int apid =  rs.getInt("pid");
				String apname =  rs.getString("pname");
				String aptype =  rs.getString("ptype");				
				return new Product(apid, apname, aptype);
				
			}else{
				return null;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ProductException("Issue in fetching record",e);
		}finally{
			
			
				try {
					
					if(rs !=null){
					rs.close();
					}
					
					if(stmt !=null){
						stmt.close();
					}
					
					if(con !=null){
						con.close();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new ProductException("Issue in closing connection",e);
				}				
			}
		
		
		
		
	}

	@Override
	public boolean addProducts(Product prd) throws ProductException {
		
		String qry = "insert into product (pid,pname,ptype) values (?,?,?)";
		 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			
			stmt = con.prepareStatement(qry);
			stmt.setInt(1, prd.getProductId());
			stmt.setString(2, prd.getProductName());
			stmt.setString(3, prd.getProductType());
			
			int rscnt = stmt.executeUpdate();
			
			return rscnt==1?true:false;
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ProductException("Issue in fetching record",e);
		}finally{
			
			
				try {
					
					if(rs !=null){
					rs.close();
					}
					
					if(stmt !=null){
						stmt.close();
					}
					
					if(con !=null){
						con.close();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new ProductException("Issue in closing connection",e);
				}				
			}
		
	}

	@Override
	public boolean deleteProducts(int pId) throws ProductException {
		
		String qry = "delete from product where pid=?";
		 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			stmt = con.prepareStatement(qry);
			stmt.setInt(1, pId);
			int raffected = stmt.executeUpdate();
			
			return raffected==1?true:false;
			
						
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new ProductException("Issue in fetching record",e);
		}finally{
			
			
				try {
									
					
					if(stmt !=null){
						stmt.close();
						}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new ProductException("Issue in closing connection",e);
				}				
			}
		
	}

	@Override
	public boolean updateProducts(int pId,String pName, String pType) throws ProductException {
		
		String qry = "UPDATE product SET pname = ?, ptype= ? WHERE pid ="+pId;
		 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			
			stmt = con.prepareStatement(qry);
			stmt.setString(1, pName);
			stmt.setString(2, pType);
			//stmt.setInt(3, pId);
			
			
			int raffected = stmt.executeUpdate();
			
			return raffected==1?true:false;
			
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ProductException("Issue in fetching record",e);
		}finally{
			
			
				try {
									
					
					if(stmt !=null){
						stmt.close();
					}
					
					if(con !=null){
						con.close();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new ProductException("Issue in closing connection",e);
				}				
			}
		
	}
	
	
	

}
