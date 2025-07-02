package com.atiff.comps;

public class Employee implements Person {
	
	public Employee() {
		System.out.println("Employee: 0-param constructor");
	}

	@Override
	public void doTask() {
		System.out.println("Employee is doing job");
	}

}
