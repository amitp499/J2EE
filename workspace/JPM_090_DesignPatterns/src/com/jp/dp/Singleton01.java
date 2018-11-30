package com.jp.dp;

/*
 * Declare self reference as static and pivate
 * create private constructor
 * A static method to created restricted number of instance
 */
public class Singleton01 {
	
	private static Singleton01 singleton =null;
	
	private Singleton01(){
		
		System.out.println("Constructor Created");
	}
	
	
	public static Singleton01 getInstance(){
		
		if (singleton==null){
			
			System.out.println("Object created of Singleton class");
			
			singleton = new Singleton01();
		}
		
		return singleton;  //if singleton is not null then the existing refernece is returned
		
	}

}
