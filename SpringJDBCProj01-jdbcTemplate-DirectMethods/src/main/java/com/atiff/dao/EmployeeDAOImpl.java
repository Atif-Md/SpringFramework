package com.atiff.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMPS_COUNT = "SELECT COUNT(*) FROM EMPLOYEE";
	private static final String GET_EMP_BY_NO = "SELECT  EID, ENAME, EAGE, EADDRESS FROM EMPLOYEE WHERE EID=?";
	private static final String GET_EMP_BY_ADD = "SELECT EID, ENAME, EAGE, EADDRESS FROM EMPLOYEE WHERE EADDRESS IN(?, ?)";
	private static final String GET_EMP_AGE_BY_EID = "SELECT EAGE FROM EMPLOYEE WHERE EID=?";
	private static final String EMP_INSERT_QUERY = "INSERT INTO EMPLOYEE(ENAME, EAGE, EADDRESS, SALARY) VALUES(?, ?, ?, ?)";
	private static final String EMP_UPDATE_QUERY = "UPDATE EMPLOYEE SET SALARY=SALARY+SALARY*? WHERE EID=?";
	private static final String EMP_DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE SALARY>=? AND SALARY<=?";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int getEmpsCount() {
		int count = jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		return count;
	}

	@Override
	public Map<String, Object> getEmployeeById(int no) {
		Map<String, Object> map = jt.queryForMap(GET_EMP_BY_NO, no);
		return map;
	}

	@Override
	public List<Map<String, Object>> getEmployeesByAddress(String desg1, String desg2) {
		List<Map<String, Object>> list = jt.queryForList(GET_EMP_BY_ADD, desg1, desg2);
		return list;
	}

	@Override
	public int getEmpAgeByEid(int eid) {
		Integer age = jt.queryForObject(GET_EMP_AGE_BY_EID,Integer.class, eid);
		return age;
	}

	@Override
	public int insertEmployee(String name, int age, String addrs, double esal) {
		int count = jt.update(EMP_INSERT_QUERY, name, age, addrs, esal);
		return count;
	}

	@Override
	public int updateEmpSalaryByEid(double percentage, int eid) {
		double percentageValue = percentage / 100.0;
		int count = jt.update(EMP_UPDATE_QUERY, percentageValue, eid);
		return count;
	}

	@Override
	public int deleteEmployeeBySalaryRange(double startSalary, double endSalary) {
		int count = jt.update(EMP_DELETE_QUERY, startSalary, endSalary);
		return count;
	}

}
