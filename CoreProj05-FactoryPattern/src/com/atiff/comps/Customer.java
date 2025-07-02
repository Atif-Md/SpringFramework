package com.atiff.comps;

import java.util.Random;

public class Customer implements Person {
	
	public Customer() {
		System.out.println("Customer: 0-param constructor");
	}

	@Override
	public void doTask() {
		System.out.println("Customer is purchasing products of price:: "+new Random().nextInt(1000));
	}

}
