package com.atiff.dao;

import java.util.List;

import com.atiff.model.Employee;

public interface IEmployeeDAO {
	
	public Employee getEmployeeByNo(int no);
	public List<Employee> getEmployeesByDesg(String desg);

}
