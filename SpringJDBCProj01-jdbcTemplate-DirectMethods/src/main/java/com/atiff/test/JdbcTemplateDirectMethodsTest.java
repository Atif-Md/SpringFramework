package com.atiff.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atiff.service.IEmployeeMgmtService;

public class JdbcTemplateDirectMethodsTest {

	public static void main(String[] args) {
		
		//create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/atiff/cfgs/applicationContext.xml");
		
		//get service class obj
		IEmployeeMgmtService service = ctx.getBean("empService", IEmployeeMgmtService.class);
		
		//invoke the b.method
		int count = service.showEmployeesCount();
		System.out.println("Employee counts are:: "+count);
		
		System.out.println("======================================");
		Map<String, Object> map = service.fetchEmpById(1);
		System.out.println("Eid 1 employee details are:: "+map);
		
		System.out.println("========================================");
		List<Map<String,Object>> list = service.fethEmpsByAddress("IND", "RCB");
		list.forEach(m->{
			System.out.println(m);
		});
		
		System.out.println("==========================================");
		int age = service.fetchEmpAgeByEid(1);
		System.out.println("Eid 1 employee age is:: "+age);
		
		/*System.out.println("==========================================");
		String msg = service.registerEmployee("Ruturaj", 25, "CSK", 1.0f);
		System.out.println(msg);*/
		
		/*System.out.println("============================================");
		String msg1 = service.hikeEmployeeSalaryByEid(8.5f, 18);
		System.out.println(msg1);*/
		
		System.out.println("============================================");
		String msg2 = service.fireEmployeeBySalaryRange(16.0, 19.0);
		System.out.println(msg2);
		
		//close the IOC container
		ctx.close();

	}

}
