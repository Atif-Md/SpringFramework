package com.atiff.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atiff.sbeans.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		
		//create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/atiff/cfgs/applicationContext.xml");
		
		System.out.println("IOC container created");
		
		Flipkart fpkt = ctx.getBean("fpkt", Flipkart.class);
		
		String msg=fpkt.shopping(new String [] {"Shirt", "Shoe", "Slipper"}, new double[] {2500.0, 5000.0, 1200.0});
		
		System.out.println(msg);
		
		
//		Flipkart fpkt1 = ctx.getBean("fpkt", Flipkart.class);
//		Flipkart fpkt2 = ctx.getBean("f1", Flipkart.class);
//		Flipkart fpkt3 = ctx.getBean("f2", Flipkart.class);
//		
//		System.out.println(fpkt1.hashCode()+" "+fpkt2.hashCode()+" "+fpkt3.hashCode());
		
		
		
		//close container
		ctx.close();

	}

}
