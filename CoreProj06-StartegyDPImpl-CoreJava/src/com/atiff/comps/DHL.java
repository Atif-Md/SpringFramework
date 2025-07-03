//dependent class2
package com.atiff.comps;

public final class DHL implements Courier {
	
	public DHL() {
		System.out.println("DHL:: 0-param Constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("DHL.deliver()");
		return oid+" order id order products are given for delivery to DHL Courier Service";
	}

}
