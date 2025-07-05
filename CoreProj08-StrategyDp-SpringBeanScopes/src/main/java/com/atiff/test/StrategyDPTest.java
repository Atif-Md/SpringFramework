package com.atiff.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atiff.sbeans.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		
		//create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/atiff/cfgs/applicationContext.xml");
		
		System.out.println("IOC container created");
		
		//get target spring bean class obj
		Flipkart fpkt1 = ctx.getBean("fpkt",Flipkart.class);
		Flipkart fpkt2 = ctx.getBean("fpkt",Flipkart.class);
		
		System.out.println("fpkt1 == fpkt2 ? "+(fpkt1 == fpkt2));
		System.out.println(fpkt1.hashCode());
		System.out.println(fpkt2.hashCode());
		
//		//invoke the b.method
//		String result = bean.shopping(new String[] {"shirt", "shoe", "trouser" }, new double[] {2000.0, 6000.0, 3000.0} );
//		
//		System.out.println(result);
		
		//close container
		ctx.close();

	}

}
