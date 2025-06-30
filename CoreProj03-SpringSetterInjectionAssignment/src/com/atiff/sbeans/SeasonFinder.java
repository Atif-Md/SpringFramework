package com.atiff.sbeans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {
	
	//field Injection
//	@Autowired
	private Calendar cal;
	
	public SeasonFinder() {
		System.out.println("SeasonFinder: 0-param constructor");
	}
	
	//setter Injection
	@Autowired
	public void setCal(Calendar cal) {
		System.out.println("SeasonFinder.setCal()");
		this.cal = cal;
	}
	
	//b.method
	public String getSeason(String user) {
		System.out.println("SeasonFinder.getSeason()");
		int month = cal.get(Calendar.MONTH) + 1;
		
		if(10 < month && month < 3)
			return "Welcome to winter season:: "+user;
		else if(month < 7)
			return "Welcome to summer season:: "+user;
		else
			return "Welcome to rainy season:: "+user;
		
	}

}
