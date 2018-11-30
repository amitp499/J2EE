package com.jp.product.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jp.product.dao.ProductDao;
import com.jp.product.dao.ProductDaoImpl;
import com.jp.product.entities.Product;
import com.jp.product.exceptions.ProductException;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao prdser;
	
	public ProductServiceImpl() throws ProductException{
		
		prdser = new ProductDaoImpl();
		
	}

	@Override
	public ArrayList<Product> listOfProducts() throws ProductException {
		return prdser.getListOfProducts();
	}

	@Override
	public Product detailsOfProducts(int pId) throws ProductException {
		
		return prdser.getProductDetails(pId);
		
	}

	@Override
	public boolean addNewProducts(Product prd) throws ProductException {
		
		return prdser.addProducts(prd);
		
	}


	public boolean deleteProducts(int pId) throws ProductException {
		
		return  prdser.deleteProducts(pId);
	}

	@Override
	public boolean editProducts(int pId, String pName, String pType) throws ProductException {
		
		return prdser.updateProducts(pId, pName, pType);
	}
	
	
	

}
