package com.jp.product.service;

import java.util.ArrayList;

import com.jp.product.entities.Product;
import com.jp.product.exceptions.ProductException;

public interface ProductService {

	public ArrayList<Product> listOfProducts() throws ProductException;
	
	public Product detailsOfProducts(int pId) throws ProductException;
	
	public boolean addNewProducts(Product prd) throws ProductException;
	
	public boolean deleteProducts(int pId) throws ProductException;
	
	public boolean editProducts(int pId, String pName, String pType) throws ProductException;
	
}
