package com.atiff.factory;

import com.atiff.comps.BlueDart;
import com.atiff.comps.Courier;
import com.atiff.comps.DHL;
import com.atiff.comps.FirstFlight;
import com.atiff.comps.Flipkart;

public class FlipkartFactory {
	
	//static factory method
	public static Flipkart getInstance(String courierType) {
		System.out.println("FlipkartFactory.getInstance()");
		
		//dependent class obj
		Courier courier = null;
		if(courierType.equalsIgnoreCase("dhl"))
			courier = new DHL();
		else if(courierType.equalsIgnoreCase("bDart"))
			courier = new BlueDart();
		else if(courierType.equalsIgnoreCase("fFlight"))
			courier = new FirstFlight();
		else
			throw new IllegalArgumentException("Invalid Courier type");
		
		//target class obj
		Flipkart flipkart = new Flipkart();
		
		//set dependent class obj to target class obj
		flipkart.setCourier(courier);
		
		return flipkart;
		
	}

}
