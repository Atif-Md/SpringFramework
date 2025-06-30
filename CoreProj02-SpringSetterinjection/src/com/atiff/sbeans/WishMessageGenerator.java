package com.atiff.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")	// To cfg java class as spring bean
public class WishMessageGenerator {
	
	// HAS-A property
//	@Autowired	//Field Injection
	private LocalDateTime ldt;
	
	
	//Setter Injection
	@Autowired
	public void setLdt(LocalDateTime ldt) {
		System.out.println("WishMessageGenerator.setLdt()");
		this.ldt = ldt;
	}
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator:0-param constructor");
	}
	
	//b.method
	public String generateWishMsg(String user) {
		System.out.println("WishMessageGenerator.generateWishMsg()"+ldt);
		int hour = ldt.getHour();
		if(hour < 12)
			return "Good Morning:: "+user;
		else if(hour < 16)
			return "Good Afternoon:: "+user;
		else if(hour < 20)
			return "Good Evening:: "+user;
		else
			return "Good Night:: "+user;
	}

}
