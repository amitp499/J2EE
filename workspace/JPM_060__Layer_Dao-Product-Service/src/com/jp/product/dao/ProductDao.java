package com.jp.product.dao;

import java.util.ArrayList;

import com.jp.product.entities.Product;
import com.jp.product.exceptions.ProductException;

public interface ProductDao {
	
	public ArrayList<Product> getListOfProducts() throws ProductException;
	
	public Product getProductDetails(int pId) throws ProductException;
	

}
