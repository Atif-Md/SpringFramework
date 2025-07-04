//target class

package com.atiff.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fpkt")
public final class Flipkart {
	
	//HAS-A property of interface type
	@Autowired
	@Qualifier("fFlight")
	private Courier courier;
	
	public Flipkart() {
		System.out.println("Flipkart:: 0-param constructor");
	}
	
	//b.method
	public String shopping(String items[], double prices[]) {
		//calc bill amount
		double billAmt = 0.0;
		for(double price: prices) {
			billAmt += price;
		}
		
		//generate the order id
		int oid = new Random().nextInt(1000);
		
		//set the courier for delivery
		String deliveryMsg = courier.deliver(oid);
		
		//display shopping details
		return Arrays.toString(items)+" are purchased having delivery amount "+billAmt+"..."+deliveryMsg;
	}

}
