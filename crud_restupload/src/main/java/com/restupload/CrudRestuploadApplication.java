package com.restupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.restupload.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class CrudRestuploadApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CrudRestuploadApplication.class, args);
	}

}
