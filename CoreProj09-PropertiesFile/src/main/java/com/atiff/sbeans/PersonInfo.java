package com.atiff.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("per")		//cfg of java class as spring bean
@PropertySource("com/atiff/commons/info.properties")		//cfg of properties file
public class PersonInfo {
	
	@Value("${per.name}")
	private String pname;
	
	@Value("${per.addrs}")
	private String paddr;
	
	@Value("${per.age}")
	private int age;
	

	@Override
	public String toString() {
		return "PersonInfo [pname=" + pname + ", paddr=" + paddr + ", age=" + age + "]";
	}
	
	

}
