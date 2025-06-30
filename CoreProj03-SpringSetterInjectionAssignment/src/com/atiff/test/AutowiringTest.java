package com.atiff.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atiff.sbeans.SeasonFinder;

public class AutowiringTest {

	public static void main(String[] args) {
		
		//create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/atiff/cfgs/applicationContext.xml");
		
		//get target class bean obj
		SeasonFinder generateSeason = ctx.getBean("sf", SeasonFinder.class);
		
		//Invoke b.method
		String result = generateSeason.getSeason("Atiff");
		
		System.out.println(result);
		
		//close IOC container
		ctx.close();
		
	}

}
