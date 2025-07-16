package com.atiff.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atiff.model.Employee;
import com.atiff.service.IEmployeeMgmtService;

public class JdbcTemplate_CallbackInterfacesTest {

	public static void main(String[] args) {
		
//		CreateCollectionOptions iOCollectionOptions container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/atiff/cfgs/applicationContext.xml");
		
		//get service class obj
		IEmployeeMgmtService service = ctx.getBean("empService", IEmployeeMgmtService.class);
		
		//invoke the method
		float start=900, end = 5000;
		int count = service.fetchEmpsCountBySalaryRange(start, end);
		System.out.println("Employees Count by salary range from "+start+" to "+end+" is:: "+count	);
		
		System.out.println("==============================================");
		List<Employee> empsByDesg = service.fethEmpsByDesg("clerk", "supervisor");
		empsByDesg.forEach(e->{
			System.out.println(e);
		});
		
		/*		System.out.println("==============================================");
				Employee emp = new Employee();
				emp.setEname("twinkle");emp.setJob("supervisor");emp.setSalary(2600.0f);
				String registerEmployee = service.registerEmployee(emp);
				System.out.println(registerEmployee);
				*/
		//close container
		ctx.close();
		
	}

}
