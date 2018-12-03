package com.jp.services;

import java.util.ArrayList;

import com.jp.entities.Product;

import jp.com.exception.ProductException;



public interface ProductService {
	
public ArrayList<Product> listOfProducts() throws ProductException;
	
public Product detailsOfProducts(String pId) throws ProductException;

public boolean placeOrder(String pId, int ustomerId) throws ProductException;

}
