package com.atiff.sbeans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("voter")
public class VotingEligibilityCheckService implements InitializingBean, DisposableBean {
	
	//spring bean properties
	@Value("${per.name}")
	private String name;
	@Value("${per.age}")
	private int age;
	@Value("${per.addr}")
	private String addr;
	private Date dov;
	
	
	//Setter methods for setter injection
	/*public void setName(String name) {
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
	}*/
	
	//b.method
	public String  checkVotingEligibility() {
		System.out.println("VotingEligibilityCheckService.checkVotingEligibility()(B.method)");
		if(age >= 18)
			return "Mr/Miss/Mrs. "+name+", you are eligible for voting on date:: "+dov;
		else
			return "Mr/Miss/Mrs. "+name+", you are not eligible for voting on date:: "+dov;
	}
	
	//equivalent to cutom init method
	public void afterPropertiesSet() {
		System.out.println("VotingEligibilityCheckService.afterPropertiesSet()(init life cycle method)");
		dov = new Date();	//Initializing left over property
		
		//verifying whether important properties are injected properly or not
		if(name == null || age <= 0)
			throw new IllegalArgumentException("Invalid inputs");
	}
	
	//Equivalent to custom destroy method
	public void destroy() {
		System.out.println("VotingEligibilityCheckService.destroy()(custom destroy method)");
		name=null;
		age=0;
		addr=null;
		dov=null;
	}
	

}
