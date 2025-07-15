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
		int empno = 1;
		Employee emp = service.showEmpDetailsByNo(empno);
		System.out.println(empno+" empno employee detail is:: "+emp);
		
		System.out.println("============================================");
		List<Employee> list = service.fethEmployeesByDesg("manager");
		list.forEach(e->{
			System.out.println(e);
		});
		
		//close container
		ctx.close();
		
	}

}
