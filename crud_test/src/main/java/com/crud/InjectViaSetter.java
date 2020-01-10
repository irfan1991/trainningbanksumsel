package com.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Controller
public class InjectViaSetter {
	
	
	private HalloSpringService halloSpringService;
	
	
	//setter
	//@Autowired
	public void setHalloSpringService(HalloSpringService halloSpringService) {
		this.halloSpringService = halloSpringService;
	}
	
	public void getMessage() {
		halloSpringService.sayHello();
	}

}
