package com.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Controller 

public class InjectViaConstructor {

	
	HalloSpringService halloSpringService;
	
	
	//@Autowired
	public InjectViaConstructor(HalloSpringService halloSpringService) {
		this.halloSpringService = halloSpringService;
	}
	
	
	public void getMassage() {
		
		halloSpringService.sayHello();
	}
	
	
}
