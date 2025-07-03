package com.atiff.test;

import com.atiff.comps.Flipkart;
import com.atiff.factory.FlipkartFactory;

public class StrategyDPTest {

	public static void main(String[] args) {
		
		//get target class obj
		Flipkart fpkt = FlipkartFactory.getInstance("fFlight");
		
		//invoke the method
		String msg = fpkt.shopping(new String[] {"shirt", "shoe", "dhoti"}, new double[] {1200.0, 5000.0, 1000.0});
		
		System.out.println(msg);

	}

}
