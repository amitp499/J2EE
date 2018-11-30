package com.jp.hr.daos;

import java.util.ArrayList;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

public interface DaoEmployee {
	
	public ArrayList<Employee> getEmpList() throws HrException;
	
	public Employee getEmpDetails(int empId) throws HrException;
	
	public boolean insertNewRecord(Employee emp) throws HrException;
	

}
