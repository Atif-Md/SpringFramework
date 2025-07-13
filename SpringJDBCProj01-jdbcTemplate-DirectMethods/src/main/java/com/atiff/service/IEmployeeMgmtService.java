package com.atiff.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeMgmtService {
	
	public int showEmployeesCount();
	public Map<String, Object> fetchEmpById(int eid);
	public List<Map<String, Object>> fethEmpsByAddress(String add1, String add2);
	public int fetchEmpAgeByEid(int eid);
	public String registerEmployee(String name, int age, String addrs, double esal);
	public String hikeEmployeeSalaryByEid(double percentage, int eid);
	public String fireEmployeeBySalaryRange(double startSalary, double endSalary);

}
