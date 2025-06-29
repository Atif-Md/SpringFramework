package com.atiff.test;

import java.time.LocalDateTime;

import com.atiff.comps.WishMessageGenerator;

public class DependencyManagementTest {
	
	public static void main(String[] args) {
		
		//create dependent and target class objs
		LocalDateTime sysDateTime = LocalDateTime.now();	//obj for dependent class
		
		WishMessageGenerator generator = new WishMessageGenerator();	//obj for target class 
		
		//assign dependent class obj to target class obj
		generator.setLdt(sysDateTime);
		
		//invoke the b.method on target class obj
		String result = generator.generateWishMsg("Atiff");
		
		System.out.println("Result:: "+result);		
		
	}

}
