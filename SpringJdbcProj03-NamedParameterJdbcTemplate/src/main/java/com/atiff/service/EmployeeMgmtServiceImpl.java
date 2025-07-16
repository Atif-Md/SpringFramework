package com.atiff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atiff.dao.IEmployeeDAO;
import com.atiff.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeDAO empDAO;

	@Override
	public int fetchEmpsCountBySalaryRange(float start, float end) {
		//use DAO
		int count = empDAO.getEmpsCountBySalaryRange(start, end);
		return count;
	}

	@Override
	public List<Employee> fethEmpsByDesg(String desg1, String desg2) {
		List<Employee> empsList = empDAO.getEmpsByDesg(desg1, desg2);
		return empsList;
	}

	@Override
	public String registerEmployee(Employee emp) {
		int count = empDAO.insertEmployee(emp);
		return count==0?"Employee not inserted":"Employee inserted";
	}
	
}
