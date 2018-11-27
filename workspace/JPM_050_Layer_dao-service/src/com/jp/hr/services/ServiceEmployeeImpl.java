package com.jp.hr.services;

import java.util.ArrayList;

import com.jp.hr.daos.DaoEmployee;
import com.jp.hr.daos.DaoEmployeeImpl;
import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

/*
 * One Layer refers to another layer through interface only
 * Implementation of business rule should be done here in absence of busness layer
 * This layer will also ensure only custom exceptions to come out
 * 
 */

public class ServiceEmployeeImpl implements ServiceEmployee {

	private DaoEmployee daoEmp;
	
	
	//Resolving Dependence
	public ServiceEmployeeImpl(){
		
		daoEmp = new DaoEmployeeImpl();
		
	}
	

	@Override
	public ArrayList<Employee> getEmpList() throws HrException {
				
		return daoEmp.getEmpList();
	}

}
