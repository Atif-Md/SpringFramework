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
	public Employee showEmpDetailsByNo(int no) {
		//use DAO
		Employee emp = empDAO.getEmployeeByNo(no);
		return emp;
	}

	@Override
	public List<Employee> fethEmployeesByDesg(String desg) {
		return empDAO.getEmployeesByDesg(desg);
	}

}
