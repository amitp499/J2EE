package com.jp.services;

import java.util.ArrayList;

import com.jp.daos.ProductDao;
import com.jp.daos.ProductDaoImpl;
import com.jp.entities.Product;

import jp.com.exception.ProductException;


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
	public Product detailsOfProducts(String pId) throws ProductException {
		
		return prdser.getProductDetails(pId);
		
	}

	@Override
	public boolean placeOrder(String pId, int ustomerId) throws ProductException {
		
		return prdser.placeOrder(pId, ustomerId);
	}
}
