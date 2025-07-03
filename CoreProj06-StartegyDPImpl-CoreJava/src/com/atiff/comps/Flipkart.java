//target class

package com.atiff.comps;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart {
	
	//HAS-A property of interface type
	private Courier courier;
	
	public Flipkart() {
		System.out.println("Flipkart:: 0-param constructor");
	}
	
	//setter method to assign dependent class obj to target class obj
	public void setCourier(Courier courier) {
		System.out.println("Flipkart.setCourier()");
		this.courier = courier;
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
