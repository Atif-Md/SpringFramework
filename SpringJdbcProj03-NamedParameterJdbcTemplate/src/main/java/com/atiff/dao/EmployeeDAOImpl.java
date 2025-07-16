package com.atiff.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.atiff.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMPS_COUNT_BY_SAL_RANGE = "SELECT COUNT(*) FROM EMP WHERE SALARY>:min AND SALARY<=:max";
	private static final String GET_EMPS_BY_DESG = "SELECT EMPNO,ENAME,JOB,SALARY FROM EMP WHERE JOB IN(:dsg1, :dsg2) ORDER BY JOB";
	private static final String INSERT_EMP_QUERY = "INSERT INTO EMP(ENAME, JOB, SALARY) VALUES (:ename,:job,:salary)";
	
	@Autowired
	private NamedParameterJdbcTemplate njt;
	
	@Override
	public List<Employee> getEmpsByDesg(String desg1, String desg2) {
		//bind values to named params using MapSqlParameterSource Obj
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("dsg1", desg1);
		source.addValue("dsg2", desg2);
		//execute the sql query
		List<Employee> list = njt.query(GET_EMPS_BY_DESG, source,
								// Lambda Expression based Anonymous inner class
								rs->{
									List<Employee> empsList = new ArrayList<Employee>();
									while (rs.next()) {
										Employee emp = new Employee();
										emp.setEmpno(rs.getInt(1));
										emp.setEname(rs.getString(2));
										emp.setJob(rs.getString(3));
										emp.setSalary(rs.getFloat(4));
										empsList.add(emp);
									}
									return empsList;
								});
		return list;
	}


	@Override
	public int getEmpsCountBySalaryRange(float start, float end) {
		//create map obj having the names and values of named params
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("min", start);
		paramsMap.put("max", end);
		int count = njt.queryForObject(GET_EMPS_COUNT_BY_SAL_RANGE, paramsMap, Integer.class);
		return count;
	}


	@Override
	public int insertEmployee(Employee emp) {
		//create BeanPropertySqlParameterSource obj having model class obj name
		BeanPropertySqlParameterSource bpsps = new BeanPropertySqlParameterSource(emp);
		int count = njt.update(INSERT_EMP_QUERY, bpsps);
		return count;
	}
	
}
