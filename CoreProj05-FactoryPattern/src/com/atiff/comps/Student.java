package com.atiff.comps;

public class Student implements Person {
	
	public Student() {
		System.out.println("Student: 0-param constructor");
	}

	@Override
	public void doTask() {
		System.out.println("Student is studying engineering");
	}

}
