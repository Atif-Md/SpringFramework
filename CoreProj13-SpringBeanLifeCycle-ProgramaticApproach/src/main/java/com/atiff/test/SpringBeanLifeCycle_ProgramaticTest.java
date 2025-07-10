package com.atiff.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atiff.sbeans.VotingEligibilityCheckService;

public class SpringBeanLifeCycle_ProgramaticTest {

	public static void main(String[] args) {
		
		//create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/atiff/cfgs/applicationContext.xml");
		
		//get spring bean class obj from IOC container
		VotingEligibilityCheckService service = ctx.getBean("voter", VotingEligibilityCheckService.class);
		
		//invoke the b.method
		String result = service.checkVotingEligibility();
		
		System.out.println(result);
		
		//Close IOC
		ctx.close();

	}

}
