package com.atiff.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atiff.sbeans.WishMessageGenerator;

public class AutowiringTest {
	
	public static void main(String[] args) {
		
		// Create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/atiff/cfgs/applicationContext.xml");
		
		//  Get target spring bean class obj
		Object obj = ctx.getBean("wmg");
		
		// TypeCasting
		WishMessageGenerator generator = (WishMessageGenerator) obj;
		
		//invoke the b.method
		String result = generator.generateWishMsg("Atiff");
		
		System.out.println(result);
		
		// Close IOC container
		ctx.close();
		
	}

}
