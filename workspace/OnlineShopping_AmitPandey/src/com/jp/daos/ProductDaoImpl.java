package com.jp.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jp.entities.Product;
import com.jp.utlities.ConnectionFactory;

import jp.com.exception.ProductException;
import oracle.jdbc.pool.OracleDataSource;

public class ProductDaoImpl implements ProductDao{
	
	private ConnectionFactory factory;
	private OracleDataSource dataSource;
	
	
	public ProductDaoImpl() throws ProductException{
		
		try {
			factory = ConnectionFactory.getInstance();
			
			dataSource = factory.getDatasource();
			
		} catch (Exception e) {
			throw new ProductException("Issue in getting connection from factory",e);
		}
		
		
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
			rs= stmt.executeQuery("Select ItemId, Name, Category, Price, ItemInStock from ItemMaster");
			
			while(rs.next()){
				
				String apid =  	rs.getString("ItemId");
				String apname =  rs.getString("Name");
				String apcat =  rs.getString("Category");
				double apprice =  	rs.getDouble("Price");
				int apstock =  	rs.getInt("ItemInStock");
				prd.add(new Product(apid,apname,apcat, apprice,apstock));
				
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
	public Product getProductDetails(String pId) throws ProductException {
		
		String qry = "Select ItemId, Name, Category, Price, ItemInStock from ItemMaster where ItemId=?";
		 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			
			stmt = con.prepareStatement(qry);
			stmt.setString(1, pId);
			rs= stmt.executeQuery();
			
			if(rs.next()){
				
				String apid =  	rs.getString("ItemId");
				String apname =  rs.getString("Name");
				String apcat =  rs.getString("Category");
				double apprice =  	rs.getDouble("Price");
				int apstock =  	rs.getInt("ItemInStock");	
				
				return new Product(apid,apname,apcat, apprice,apstock);
				
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
	public boolean placeOrder(String pId, int ustomerId) throws ProductException {
	
		String qry = "insert into ordermaster (CustomerId, OrderId ,ItemId) values (?,Order_seq.nextval,?)";
		 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			
			stmt = con.prepareStatement(qry);
			stmt.setInt(1, ustomerId);			
			stmt.setString(2, pId);
			
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

}
