package com.atiff.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atiff.sbeans.PersonInfo;

public class PropertiesFileTest {

	public static void main(String[] args) {
		
		//create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/atiff/cfgs/applicationContext.xml");
		
		//get spring bean class object
		PersonInfo info = ctx.getBean("per", PersonInfo.class);
		
		//diplay spring bean object data
		System.out.println(info);
		
		
		//close IOC
		ctx.close();

	}

}
