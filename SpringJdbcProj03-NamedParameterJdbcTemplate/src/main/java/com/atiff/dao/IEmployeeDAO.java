package com.atiff.dao;

import java.util.List;

import com.atiff.model.Employee;

public interface IEmployeeDAO {
	public int getEmpsCountBySalaryRange(float start, float end);
	public List<Employee> getEmpsByDesg(String desg1, String desg2);
	public int insertEmployee(Employee emp);
}
