package com.atiff.service;

import java.util.List;

import com.atiff.model.Employee;

public interface IEmployeeMgmtService {
	
	public int fetchEmpsCountBySalaryRange(float start, float end);
	public List<Employee> fethEmpsByDesg(String desg1, String desg2);
	public String registerEmployee(Employee emp);

}
