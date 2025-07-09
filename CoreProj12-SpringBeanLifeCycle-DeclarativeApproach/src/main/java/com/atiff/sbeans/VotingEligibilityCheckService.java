package com.atiff.sbeans;

import java.util.Date;

public class VotingEligibilityCheckService {
	
	//spring bean properties
	private String name;
	private int age;
	private String addr;
	private Date dov;
	
	
	//Setter methods for setter injection
	public void setName(String name) {
		System.out.println("VotingEligibilityCheckService.setName()");
		this.name = name;
	}
	
	public void setAge(int age) {
		System.out.println("VotingEligibilityCheckService.setAge()");
		this.age = age;
	}
	
	public void setAddr(String addr) {
		System.out.println("VotingEligibilityCheckService.setAddr()");
		this.addr = addr;
	}
	
	//b.method
	public String  checkVotingEligibility() {
		System.out.println("VotingEligibilityCheckService.checkVotingEligibility()(B.method)");
		if(age >= 18)
			return "Mr/Miss/Mrs. "+name+", you are eligible for voting on date:: "+dov;
		else
			return "Mr/Miss/Mrs. "+name+", you are not eligible for voting on date:: "+dov;
	}
	
	//cutom init method
	public void myInit() {
		System.out.println("VotingEligibilityCheckService.myInit()(init life cycle method)");
		dov = new Date();	//Initializing left over property
		
		//verifying whether important properties are injected properly or not
		if(name == null || age <= 0)
			throw new IllegalArgumentException("Invalid inputs");
	}
	
	//custom destroy method
	public void myDestroy() {
		System.out.println("VotingEligibilityCheckService.myDestroy()(custom destroy method)");
		name=null;
		age=0;
		addr=null;
		dov=null;
	}
	

}
