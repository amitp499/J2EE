package com.jp.hr.daos;

import java.util.ArrayList;

import com.jp.hr.entities.Employee;
import com.jp.hr.entities.UserMaster;
import com.jp.hr.exceptions.HrException;

public interface DaoUserMaster {
	
	public UserMaster getUserDetails(String userId) throws HrException;

}
