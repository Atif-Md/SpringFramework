package com.atiff.test;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringI18nTest {

	public static void main(String[] args) {
		
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/atiff/cfgs/applicationContext.xml");
		//read inputs
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter language code:: ");
		String langCode = sc.next();
		System.out.print("Enter country code:: ");
		String countryCode = sc.next();
		
		//prepare Locale obj having language and country
		Locale locale = new Locale(langCode, countryCode);
		
		//get msg from locale specific properties file
		String msg = ctx.getMessage("wish.message", new Object[] {}, locale);
		System.out.println("Wish Message is:: "+msg);
		
		
		//close Scanner class
		sc.close();		
		//close container
		ctx.close();

	}

}
