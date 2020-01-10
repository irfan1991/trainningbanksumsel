package com.crud.aplikasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.crud.InjectViaConstructor;
import com.crud.InjectViaSetter;

@SpringBootApplication
///@ComponentScan("com.crud")
@ImportResource("classpath:/config/configSpring.xml")
public class CrudTestApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(CrudTestApplication.class, args);
		InjectViaConstructor halloSpringController = (InjectViaConstructor) context.getBean("injectViaConstructor");
		halloSpringController.getMassage();
		
		InjectViaSetter test = (InjectViaSetter) context.getBean("injectViaSetter");
		test.getMessage();
		
		
	}

}
