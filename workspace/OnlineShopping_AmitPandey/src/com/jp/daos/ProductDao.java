package com.jp.daos;

import java.util.ArrayList;

import com.jp.entities.Product;

import jp.com.exception.ProductException;



public interface ProductDao {

public ArrayList<Product> getListOfProducts() throws ProductException;
	
public Product getProductDetails(String pId) throws ProductException;

public boolean placeOrder(String pId, int ustomerId) throws ProductException;
}
