package com.atiff.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atiff.cfgs.AppConfig;
import com.atiff.sbeans.WishMessageGenerator;

public class JavaConfigAppTest {

	public static void main(String[] args) {
		
		//create IOC container
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//get terget spring bean class obj
		WishMessageGenerator generator = ctx.getBean("wmg", WishMessageGenerator.class);
		
		//invoke the b.method
		String msg = generator.generateWishMsg("Atiff");
		
		//display the result
		System.out.println(msg);
		
		//close container
		ctx.close();
		

	}

}
