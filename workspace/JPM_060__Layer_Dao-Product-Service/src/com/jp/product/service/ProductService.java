package com.jp.product.service;

import java.util.ArrayList;

import com.jp.product.entities.Product;
import com.jp.product.exceptions.ProductException;

public interface ProductService {

	public ArrayList<Product> listOfProducts() throws ProductException;
	
	public Product detailsOfProducts(int pId) throws ProductException;
	
}
