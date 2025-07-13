package com.atiff.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {
	
	public int getEmpsCount();
	public Map<String, Object> getEmployeeById(int eid);
	public List<Map<String, Object>> getEmployeesByAddress(String add1, String add2);
	public int getEmpAgeByEid(int eid);
	public int insertEmployee(String name, int age, String addrs, double esal);
	public int updateEmpSalaryByEid(double percentage, int eid);
	public int deleteEmployeeBySalaryRange(double startSalary, double endSalary);

}
