package com.jp.entities;

public class Product {
	
	private String ItemId;
	private String Name;
	private String Category;
	
	private double Price;
	private int ItemInStock;
	
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	@Override
	public String toString() {
		return "Product [ItemId=" + ItemId + ", Name=" + Name + ", Category=" + Category + ", Price=" + Price
				+ ", ItemInStock=" + ItemInStock + "]";
	}



	public Product(String itemId, String name, String category, double price, int itemInStock) {
		super();
		ItemId = itemId;
		Name = name;
		Category = category;
		Price = price;
		ItemInStock = itemInStock;
	}



	public String getItemId() {
		return ItemId;
	}
	public void setItemId(String itemId) {
		ItemId = itemId;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getItemInStock() {
		return ItemInStock;
	}
	public void setItemInStock(int itemInStock) {
		ItemInStock = itemInStock;
	}
	
	
	

}
