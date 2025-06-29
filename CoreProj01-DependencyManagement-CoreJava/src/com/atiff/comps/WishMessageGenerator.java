package com.atiff.comps;

import java.time.LocalDateTime;

public class WishMessageGenerator {
	
	//HAS-A property
	private LocalDateTime ldt;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator:: 0-param constructor");
	}
	
	// Setter method in support of dependency management
	public void setLdt(LocalDateTime ldt) {
		System.out.println("WishMessageGenerator.setLdt()");
		this.ldt = ldt;
	}
	
	//b.method using the injected/assigned dependent class obj
	public String generateWishMsg(String user) {
		System.out.println("WishMessageGenerator.generateWishMsg()");
		//get current hour of the day
		int hour = ldt.getHour();
		
		//generate wish message
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
