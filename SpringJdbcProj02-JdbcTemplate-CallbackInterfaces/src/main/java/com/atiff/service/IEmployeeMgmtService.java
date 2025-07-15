package com.atiff.service;

import java.util.List;

import com.atiff.model.Employee;

public interface IEmployeeMgmtService {
	
	public Employee showEmpDetailsByNo(int no);
	public List<Employee> fethEmployeesByDesg(String desg);

}
