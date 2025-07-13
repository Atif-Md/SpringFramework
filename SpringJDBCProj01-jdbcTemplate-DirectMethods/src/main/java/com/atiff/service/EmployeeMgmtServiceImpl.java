package com.atiff.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atiff.dao.IEmployeeDAO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeDAO empDAO;

	@Override
	public int showEmployeesCount() {
		//use dao
		int count = empDAO.getEmpsCount();
		return count;
	}

	@Override
	public Map<String, Object> fetchEmpById(int no) {
		//use dao
		return empDAO.getEmployeeById(no);
	}

	@Override
	public List<Map<String, Object>> fethEmpsByAddress(String add1, String add2) {
		return empDAO.getEmployeesByAddress(add1, add2);
	}

	@Override
	public int fetchEmpAgeByEid(int eid) {
		return empDAO.getEmpAgeByEid(eid);
	}

	@Override
	public String registerEmployee(String name, int age, String addrs, double esal) {
		int count = empDAO.insertEmployee(name, age, addrs, esal);
		return count == 0 ? "Employee not registered" : "Employee Registered";
	}

	@Override
	public String hikeEmployeeSalaryByEid(double percentage, int eid) {
		int count = empDAO.updateEmpSalaryByEid(percentage, eid);
		return count == 0 ? "Employee not found for salary updation" : eid+" Employee salary is hiked";
	}

	@Override
	public String fireEmployeeBySalaryRange(double startSalary, double endSalary) {
		int count = empDAO.deleteEmployeeBySalaryRange(startSalary, endSalary);
		return count == 0 ? "Employee not found for deletion" : count+" no. of Employees are found and deleted";
	}

}
