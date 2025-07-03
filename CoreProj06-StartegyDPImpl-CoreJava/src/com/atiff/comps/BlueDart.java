//dependent class1
package com.atiff.comps;

public final class BlueDart implements Courier {
	
	public BlueDart() {
		System.out.println("BlueDart:: 0-param Constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("BlueDart.deliver()");
		return oid+" order id order products are given for delivery to BlueDart Courier Service";
	}

}
