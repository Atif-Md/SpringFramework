//dependent class3

package com.atiff.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("fFlight")
@Lazy(true)
public final class FirstFlight implements Courier {
	
	public FirstFlight() {
		System.out.println("FirstFlight:: 0-param Constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("FirstFlight.deliver()");
		return oid+" order id order products are given for delivery to FirstFlight Courier Service";
	}

}
