package com.atiff.sbeans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("voter")
public class VotingEligibilityCheckService {
	
	//spring bean properties
	@Value("${per.name}")
	private String name;
	@Value("${per.age}")
	private int age;
	@Value("${per.addr}")
	private String addr;
	private Date dov;
	
	
	//b.method
	public String  checkVotingEligibility() {
		System.out.println("VotingEligibilityCheckService.checkVotingEligibility()(B.method)");
		if(age >= 18)
			return "Mr/Miss/Mrs. "+name+", you are eligible for voting on date:: "+dov;
		else
			return "Mr/Miss/Mrs. "+name+", you are not eligible for voting on date:: "+dov;
	}
	
	//cutom init method
	@PostConstruct
	public void myInit() {
		System.out.println("VotingEligibilityCheckService.myInit()(init life cycle method)");
		dov = new Date();	//Initializing left over property
		
		//verifying whether important properties are injected properly or not
		if(name == null || age <= 0)
			throw new IllegalArgumentException("Invalid inputs");
	}
	
	//custom destroy method
	@PreDestroy
	public void myDestroy() {
		System.out.println("VotingEligibilityCheckService.myDestroy()(custom destroy method)");
		name=null;
		age=0;
		addr=null;
		dov=null;
	}
	

}
