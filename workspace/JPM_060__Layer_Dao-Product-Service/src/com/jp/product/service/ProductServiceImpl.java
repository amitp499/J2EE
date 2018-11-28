package com.jp.product.service;

import java.util.ArrayList;

import com.jp.product.dao.ProductDao;
import com.jp.product.dao.ProductDaoImpl;
import com.jp.product.entities.Product;
import com.jp.product.exceptions.ProductException;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao prdser;
	
	public ProductServiceImpl(){
		
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
	
	
	

}
