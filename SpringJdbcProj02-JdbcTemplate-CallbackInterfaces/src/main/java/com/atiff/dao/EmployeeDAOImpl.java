package com.atiff.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.atiff.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMP_BY_NO = "SELECT EMPNO, ENAME, JOB, SALARY FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESG = "SELECT EMPNO, ENAME, JOB, SALARY FROM EMP WHERE JOB=?";
	
	@Autowired
	private JdbcTemplate jt;
	
	//	-----------------------------------Approach 3 - getEmployeesByDesg--------------------------------------------------
	@Override
	public List<Employee> getEmployeesByDesg(String desg) {
		List<Employee> empsList = jt.query(GET_EMPS_BY_DESG,
																		new RowMapperResultSetExtractor<Employee>(new BeanPropertyRowMapper<Employee>(Employee.class))	,
																		desg);
		return empsList;
	}
	
	//	-----------------------------------Approach 2 - getEmployeesByDesg--------------------------------------------------
	/*@Override
	public List<Employee> getEmployeesByDesg(String desg) {
		List<Employee> empsList = jt.query(GET_EMPS_BY_DESG,
																			//Lambda expression based anonymous inner class
																			rs->{
																				List<Employee> empList = new ArrayList<Employee>();
																				//copy the rs obj records to list collection
																				while(rs.next()) {
																					//copy each record of rs to employee class obj
																					Employee emp = new Employee();
																					emp.setEmpno(rs.getInt(1));
																					emp.setEname(rs.getString(2));
																					emp.setJob(rs.getString(3));
																					emp.setSalary(rs.getFloat(4));
																					empList.add(emp);
																				}
																				return empList;
																			},
																				desg);
		return empsList;
	}*/
	
	//	-----------------------------------Approach 1 - getEmployeesByDesg--------------------------------------------------
	/*@Override
	public List<Employee> getEmployeesByDesg(String desg) {
		List<Employee> empsList = jt.query(GET_EMPS_BY_DESG,
																				//Anonymous inner class
																			new ResultSetExtractor<List<Employee>>() {
	
																				@Override
																				public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
																					List<Employee> empList = new ArrayList<Employee>();
																					//copy the rs obj records to list collection
																					while (rs.next()) {
																						//copy each record of RS to Employee class obj
																						Employee emp = new Employee();
																						emp.setEmpno(rs.getInt(1));
																						emp.setEname(rs.getString(2));
																						emp.setJob(rs.getString(3));
																						emp.setSalary(rs.getFloat(4));
																						//add each Employee class obj to list collection
																						empList.add(emp);
																					}
																					return empList;
																				}
																					
																			},
																				desg);
		return empsList;
	}*/
	

	//	-----------------------------------Approach 4 - getEmployeeByNo--------------------------------------------------
	@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp = jt.queryForObject(GET_EMP_BY_NO,
																			new BeanPropertyRowMapper<Employee>(Employee.class)	,
																				no);
		return emp;
	}

	//	-----------------------------------Approach 3 - getEmployeeByNo--------------------------------------------------
	/*@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp = jt.queryForObject(GET_EMP_BY_NO,
																			// Lambda Expression based anonymous inner class
																			(rs, rownum)->{
																				//copy rs object record to employee class obj
																				Employee e = new Employee();
																				e.setEmpno(rs.getInt(1));
																				e.setEname(rs.getString(2));
																				e.setJob(rs.getString(3));
																				e.setSalary(rs.getFloat(4));
																				return e;
																			},
																			no);
		return emp;
	}*/
	
	
	//	-----------------------------------Approach 2 - getEmployeeByNo--------------------------------------------------
	/*@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp = jt.queryForObject(GET_EMP_BY_NO,
																			// Anonymous inner class
																			new RowMapper<Employee>() {
	
																				@Override
																				public Employee mapRow(ResultSet rs,
																						int rowNum)
																						throws SQLException {
																					//copy rs obj record to employee obj
																					Employee e = new Employee();
																					e.setEmpno(rs.getInt(1));
																					e.setEname(rs.getString(2));
																					e.setJob(rs.getString(3));
																					e.setSalary(rs.getFloat(4));
																					return e;
																				}
																			},
																			no);
		return emp;
	}*/
	
	//	-----------------------------------Approach 1 - getEmployeeByNo--------------------------------------------------
	/*@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp = jt.queryForObject(GET_EMP_BY_NO, new EmployeeRowMapper(), no);
		return emp;
	}
	
	//static inner class(nested inner class)
	private static class EmployeeRowMapper implements RowMapper<Employee> {
	
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			//copy result set obj record to employee class obj
			Employee emp = new Employee();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setSalary(rs.getFloat(4));
			return emp;
		}
		
	}*/

}
