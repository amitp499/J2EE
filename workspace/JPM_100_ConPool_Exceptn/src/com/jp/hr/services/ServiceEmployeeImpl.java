package com.jp.hr.services;

import java.util.ArrayList;

import com.jp.hr.daos.DaoEmployee;
import com.jp.hr.daos.DaoEmployeeImpl;
import com.jp.hr.daos.DaoUserMaster;
import com.jp.hr.daos.DaoUserMasterImpl;
import com.jp.hr.entities.Employee;
import com.jp.hr.entities.UserMaster;
import com.jp.hr.exceptions.HrException;

/*
 * One Layer refers to another layer through interface only
 * Implementation of business rule should be done here in absence of busness layer
 * This layer will also ensure only custom exceptions to come out
 * 
 */

public class ServiceEmployeeImpl implements ServiceEmployee, Role1 {

	private DaoEmployee daoEmp;
	private DaoUserMaster daoUserMaster;
	private UserMaster um;
	
	
	//Resolving Dependence
	public ServiceEmployeeImpl() throws HrException{
		
		daoEmp = new DaoEmployeeImpl();
		daoUserMaster = new DaoUserMasterImpl();
		//um = new UserMaster();
	}
	
	
	

	@Override
	public ArrayList<Employee> getEmpList() throws HrException {
				
		return daoEmp.getEmpList();
	}


	@Override
	public Employee getEmpDetails(int empId) throws HrException {
		
		return daoEmp.getEmpDetails(empId);
		
	}

	@Override
	public boolean addNewEmp(Employee emp) throws HrException {
		
		return daoEmp.insertNewRecord(emp);
	}




	
	public UserMaster getUserDetails(String ausr, String apwd) throws HrException {
		
		um = daoUserMaster.getUserDetails(ausr);
				
		if (um != null){
			
			
			
			if(apwd.equals(um.getPassword())){
				
				return daoUserMaster.getUserDetails(ausr);
				
			}
		}
		
		return null;
		
			
			
		
		
	}

	
	
}
