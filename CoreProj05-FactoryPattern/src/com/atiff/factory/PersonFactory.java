package com.atiff.factory;

import com.atiff.comps.Customer;
import com.atiff.comps.Employee;
import com.atiff.comps.Person;
import com.atiff.comps.Student;

public class PersonFactory {
	
	//static factory method having factory pattern logic (creating and returning one of the several related classes objects)
	public static Person getPerson(String type) {
		Person per = null;
		if(type.equalsIgnoreCase("stud"))
			per = new Student();
		else if(type.equalsIgnoreCase("emp"))
			per = new Employee();
		else if(type.equalsIgnoreCase("cust"))
			per = new Customer();
		else
			throw new IllegalArgumentException("Invalid Person type");
		
		return per;
	}

}
